package utppp.ch06.post_refactoring.v2;

import java.io.IOException;
import java.time.LocalDateTime;

public class ApplicationService {
    private final String directoryName;
    private final AuditManagerV2 auditManagerV2;
    private final Persister persister;

    public ApplicationService(String directoryName, int maxEntriesPerFile, Persister persister) {
        this.directoryName = directoryName;
        this.auditManagerV2 = new AuditManagerV2(maxEntriesPerFile);
        this.persister = persister;
    }

    /**
     * レコードを訪問管理ファイルに追加する
     *
     * @param visitorName visitorName
     * @param timeOfVisit timeOfVisit
     * @throws IOException
     */
    public void addRecord(String visitorName, LocalDateTime timeOfVisit) throws IOException {
        var files = persister.readDirectory(directoryName);
        var update = auditManagerV2.addRecord(files, visitorName, timeOfVisit);
        persister.applyUpdate(directoryName, update);
    }
}
