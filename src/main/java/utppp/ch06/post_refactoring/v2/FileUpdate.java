package utppp.ch06.post_refactoring.v2;

import java.nio.file.Path;

public class FileUpdate {
    private final String fileName;
    private final String newContent;

    public FileUpdate(String fileName, String newContent) {
        this.fileName = fileName;
        this.newContent = newContent;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getNewContent() {
        return this.newContent;
    }
}
