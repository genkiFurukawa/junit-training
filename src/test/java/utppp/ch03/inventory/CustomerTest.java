package utppp.ch03.inventory;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 5.1.4 モックとスタブの両方の性質を持ったテストダブルのサンプル
 */
class CustomerTest {
    @Test
    void purchase_fails_when_not_enough_inventory() {
        var storeMock = mock(Store.class);
        // 指定されたメソッドが呼び出された時に返さなくてはならない結果を事前に設定する
        when(storeMock.hasEnoughInventory(Product.SHAMPOO, 5)).thenReturn(false);
        var sut = new Customer();

        var success = sut.purchase(storeMock, Product.SHAMPOO, 5);

        assertEquals(false, success);
        // NOTE: テスト対象が期待通りに依存のメソッドを呼び出したか確認する
        // 注目ポイント 異なるメソッドに対してテストが行われていること
        // 単体テストのアンチパターンである、スタブとのやりとりを検証しているわけではない
        verify(storeMock, never()).removeInventory(Product.SHAMPOO, 5);
    }
}