package utppp.ch06.post_refactoring.v1;

import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Arrays;

import static org.mockito.Mockito.*;

class AuditManagerTest {
    @Test
    void a_new_file_is_created_when_the_current_file_overflows() {
        var fileSystemMock = mock(IFileSystem.class);
        when(fileSystemMock.getFiles("audits")).thenReturn(
                Arrays.asList(
                        Paths.get("audits/audits_01.txt"),
                        Paths.get("audits/audits_02.txt")
                ));
        when(fileSystemMock.readAllLines(Paths.get("audits/audits_02.txt"))).thenReturn(
                Arrays.asList(
                        "Peter;2019-04-06T16:30:00",
                        "Jane;2019-04-06T16:40:00",
                        "Jack;2019-04-06T17:00:00"
                ));
        var sut = new AuditManager(3, "audits", fileSystemMock);

        sut.addRecord("Alice", LocalDateTime.of(2019, 4, 6, 18, 0, 0));
        verify(fileSystemMock, atMostOnce()).writeAllText(Paths.get("audits/audits_03.txt"), "Alice;2019-04-06T18:00:00");
    }
}