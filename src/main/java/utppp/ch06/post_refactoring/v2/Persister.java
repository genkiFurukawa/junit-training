package utppp.ch06.post_refactoring.v2;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Persister {

    /**
     * ファイル名の一覧と中身を返す
     *
     * @param directoryName
     * @return List<FileContent>
     */
    public List<FileContent> readDirectory(String directoryName) throws IOException {
        var fileContentList = new ArrayList<FileContent>();

        var paths = Files.list(Paths.get(directoryName)).collect(Collectors.toList());
        for (var path : paths) {
            List<String> lines = Files.readAllLines(path);
            fileContentList.add(new FileContent(path.getFileName().toString(), lines));
        }

        return fileContentList;
    }

    /**
     * 更新内容をファイルに適用する
     *
     * @param directoryName directoryName
     * @param update        update
     * @throws IOException IOException
     */
    public void applyUpdate(String directoryName, FileUpdate update) throws IOException {
        Path filePath = Paths.get(directoryName, update.getFileName());

        FileWriter filewriter = new FileWriter(filePath.toFile());
        filewriter.write(update.getNewContent());
        filewriter.close();
    }
}
