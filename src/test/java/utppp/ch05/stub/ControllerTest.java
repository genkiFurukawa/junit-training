package utppp.ch05.stub;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
    @Test
    void creating_a_report() {
        var stub = mock(IDatabase.class); // <- スタブを生成
        when(stub.getNumberOfUsers()).thenReturn(10);
        var sut = new Controller(stub);

        var numberOfUsers = sut.createReport();

        assertEquals(10, numberOfUsers);
        // NOTE: スタブとのコミュニケーションのテストをすることはアンチパターン
        // 過剰検証と呼ぶ
        // verify(stub, atMostOnce()).getNumberOfUsers();
    }
}