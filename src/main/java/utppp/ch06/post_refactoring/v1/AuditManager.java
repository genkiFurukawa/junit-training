package utppp.ch06.post_refactoring.v1;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

/**
 * リスト6.8のコードだとファイルシステムにアクセスしていてテストすることが難しくなっている。
 * 単体テストの条件のうち、「実行時間が短いこと」と「隔離された状態で実行されること」を満たしていない
 */
public class AuditManager {
    private final int maxEntriesPerFile;
    private final String directoryName;
    private final IFileSystem fileSystem;

    public AuditManager(int maxEntriesPerFile, String directoryName, IFileSystem fileSystem) {
        this.maxEntriesPerFile = maxEntriesPerFile;
        this.directoryName = directoryName;
        this.fileSystem = fileSystem;
    }

    /**
     * 訪問者記録を追加する。簡単のためファイルの最大数は99とする。
     *
     * @param visitorName 訪問者の名前
     * @param timeOfVisit 訪問時刻
     */
    public void addRecord(String visitorName, LocalDateTime timeOfVisit) {
        var filePaths = fileSystem.getFiles(directoryName);
        var sorted = filePaths.stream().sorted().toList();

        String newRecord = visitorName + ";" + timeOfVisit;

        // NOTE: ファイルがない時はaudit_01.txtファイルに訪問者と日時のレコードを追加する
        if (filePaths.size() == 0) {
            Path path = Paths.get(directoryName, "audit_01.txt");
            fileSystem.writeAllText(path, newRecord);
            return;
        }

        // NOTE: 最後のファイルを取得して中身をチェックし、書き込み上限行数を超えていないか確認する。
        // NOTE: 書き込み上限行数を超えている場合は新しいファイルを作成し、新しいファイルにレコードを追加する
        Path path = sorted.get(sorted.size() - 1);
        List<String> lines = fileSystem.readAllLines(path);

        if (lines.size() < maxEntriesPerFile) {
            fileSystem.writeAllText(path, newRecord);
        } else {
            String newFileName = "audit_" + String.format("%02d", filePaths.size() + 1) + ".txt";
            Path newFilepath = Paths.get(directoryName, newFileName);
            fileSystem.writeAllText(path, newRecord);
        }
    }
}
