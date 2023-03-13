package utppp.ch06.post_refactoring;

public class FileUpdate {
    private final String fileName;
    private final String newContent;

    public FileUpdate(String fileName, String newContent) {
        this.fileName = fileName;
        this.newContent = newContent;
    }
}
