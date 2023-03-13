package utppp.ch06.post_refactoring.v2;

import java.nio.file.Path;
import java.util.List;

public class FileContent {
    private final String fileName;
    private final List<String> lines;

    public FileContent(String fileName, List<String> lines) {
        this.fileName = fileName;
        this.lines = lines;
    }

    public String getFileName() {
        return this.fileName;
    }

    public List<String> getLines() {
        return this.lines;
    }
}
