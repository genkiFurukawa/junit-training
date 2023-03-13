package utppp.ch06.pre_refactoring;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * リスト6.8をJavaに移植したもの
 */
public class AuditManager {
    private final int maxEntriesPerFile;
    private final String directoryName;

    public AuditManager(int maxEntriesPerFile, String directoryName) {
        this.maxEntriesPerFile = maxEntriesPerFile;
        this.directoryName = directoryName;
    }

    /**
     * 訪問者記録を追加する。簡単のためファイルの最大数は99とする。
     *
     * @param visitorName 訪問者の名前
     * @param timeOfVisit 訪問時刻
     */
    public void addRecord(String visitorName, Date timeOfVisit) throws IOException {
        var filePaths = Files.list(Paths.get(directoryName)).toList();
        var sorted = filePaths.stream().sorted().toList();

        String newRecord = visitorName + ";" + timeOfVisit;

        // NOTE: ファイルがない時はaudit_01.txtファイルに訪問者と日時のレコードを追加する
        if (filePaths.size() == 0) {
            Path path = Paths.get(directoryName, "audit_01.txt");
            FileWriter filewriter = new FileWriter(path.toFile());
            filewriter.write(newRecord + "\r\n");
            filewriter.close();
            return;
        }

        // NOTE: 最後のファイルを取得して中身をチェックし、書き込み上限行数を超えていないか確認する。
        // NOTE: 書き込み上限行数を超えている場合は新しいファイルを作成し、新しいファイルにレコードを追加する
        Path path = sorted.get(sorted.size() - 1);
        List<String> lines = Files.readAllLines(path);

        if (lines.size() < maxEntriesPerFile) {
            FileWriter filewriter = new FileWriter(path.toFile(), true);
            filewriter.write(newRecord + "\r\n");
            filewriter.close();
        } else {
            String newFileName = "audit_" + String.format("%02d", filePaths.size() + 1) + ".txt";
            Path newFilepath = Paths.get(directoryName, newFileName);
            FileWriter filewriter = new FileWriter(newFilepath.toFile());
            filewriter.write(newRecord + "\r\n");
            filewriter.close();
        }
    }
}
