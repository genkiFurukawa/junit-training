package utppp.ch06.post_refactoring.v2;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AuditManagerV2Test {
    @Test
    void a_new_file_is_created_when_the_current_file_overflows() {
        var sut = new AuditManagerV2(3);
        List<FileContent> files = new ArrayList<>();
        files.add(new FileContent("audit_01.txt",
                new ArrayList<>()
        ));
        files.add(new FileContent("audit_01.txt",
                Arrays.asList(
                        "Peter;2019-04-06T16:30:00",
                        "Jane;2019-04-06T16:40:00",
                        "Jack;2019-04-06T17:00:00"
                )
        ));

        FileUpdate update = sut.addRecord(files, "Alice", LocalDateTime.of(2019, 4, 6, 18, 0, 0));

        assertEquals("audit_03.txt", update.getFileName());
        assertEquals("Alice;2019-04-06T18:00:00", update.getNewContent());
    }
}