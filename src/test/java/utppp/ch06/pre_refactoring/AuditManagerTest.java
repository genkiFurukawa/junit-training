package utppp.ch06.pre_refactoring;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AuditManagerTest {
    @Test
    void ファイルの件数が0件のときにファイルが生成され_訪問者のレコードが記録されていること() throws IOException {
        var sut = new AuditManager(10, "/hoge/fuga");

        // sut.addRecord("Test", new Date());

        // ※ audit_o1.txtに記録が追加されていることを確認する
        // ※ 一旦省略
    }
}