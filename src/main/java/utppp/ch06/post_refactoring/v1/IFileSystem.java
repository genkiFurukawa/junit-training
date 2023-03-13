package utppp.ch06.post_refactoring.v1;

import java.nio.file.Path;
import java.util.List;

public interface IFileSystem {
    /**
     * ファイルの一覧を取得する
     *
     * @param directoryName 　directoryName
     * @return ファイルの一覧
     */
    List<Path> getFiles(String directoryName);

    /**
     * ファイルに内容を書き込む
     *
     * @param filePath filePath
     * @param content  content
     */
    void writeAllText(Path filePath, String content);

    /**
     * ファイルの全行を取得する
     *
     * @param filePath filePath
     * @return 全行
     */
    List<String> readAllLines(Path filePath);
}
