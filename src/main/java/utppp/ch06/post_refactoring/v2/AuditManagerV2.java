package utppp.ch06.post_refactoring.v2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AuditManagerV2 {
    private final int maxEntriesPerFile;

    public AuditManagerV2(int maxEntriesPerFile) {
        this.maxEntriesPerFile = maxEntriesPerFile;
    }

    /**
     * レコードを追加する。訪問者記録を追加する。簡単のためファイルの最大数は99とする。
     *
     * @param files       files
     * @param visitorName visitorName
     * @param timeOfVisit timeOfVisit
     * @return FileUpdate
     */
    public FileUpdate addRecord(List<FileContent> files, String visitorName, LocalDateTime timeOfVisit) {
        Comparator<FileContent> comparator = Comparator.comparing(FileContent::getFileName);
        List<FileContent> sorted = files.stream().sorted(comparator).collect(Collectors.toList());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        String newRecord = visitorName + ";" + timeOfVisit.format(formatter);

        // NOTE: ファイルがない時はaudit_01.txtファイルに訪問者と日時のレコードを追加する
        if (files.size() == 0) {
            return new FileUpdate("audit_01.txt", newRecord);
        }

        // NOTE: 最後のファイルを取得して中身をチェックし、書き込み上限行数を超えていないか確認する。
        // NOTE: 書き込み上限行数を超えている場合は新しいファイルを作成し、新しいファイルにレコードを追加する
        FileContent currentFileContent = sorted.get(sorted.size() - 1);
        List<String> lines = currentFileContent.getLines();

        if (lines.size() < maxEntriesPerFile) {
            lines.add(newRecord);
            String newContent = String.join("\r\n", lines);;
            System.out.println(newContent);
            return new FileUpdate(currentFileContent.getFileName(), newContent);
        } else {
            String newFileName = "audit_" + String.format("%02d", files.size() + 1) + ".txt";
            return new FileUpdate(newFileName, newRecord);
        }
    }
}
