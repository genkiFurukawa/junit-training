package utppp.ch03.inventory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * リスト3.7のテストコード(@BeforeEachで難ありの状態)
 */
class CustomerTestV1 {
    Customer sut;
    Store store;

    /**
     * NOTE: テスト前の決められた状態となったオブジェクトをテスト・フィクスチャと呼ぶ。
     * NOTE: 冪等性を持たせるために、各テストが実行される前に決められた(fixed)状態になるようになっている必要がある。
     * NOTE: @BeforeEach でテストフィクスチャの準備をできれば、
     * NOTE: 各テストのarrangeで実行するコード量を減らすことができ、テストケースが増えるほど相対的にコードの行数を減らせる。
     */
    @BeforeEach
    void arrange() {
        // MEMO: あるテストケースのために修正をすると、他のテストケースへ影響が出てしまう(3.3.1)
        // MEMO: @Testのメソッドのなかにarrangeの箇所がなくなってしまい、可読性が落ちる
        store = new Store();
        store.addInventory(Product.SHAMPOO, 10);
        sut = new Customer();
    }

    @Test
    void purchase_succeeds_when_enough_inventory() {
        // NOTE: arrangeは@BeforeEachのメソッドで実行

        boolean success = sut.purchase(store, Product.SHAMPOO, 5);

        assertEquals(true, success);
        assertEquals(5, store.getInventory(Product.SHAMPOO));
    }

    @Test
    void purchase_fails_when_not_enough_inventory() {
        // NOTE: arrangeは@BeforeEachのメソッドで実行

        boolean success = sut.purchase(store, Product.SHAMPOO, 15);

        assertEquals(false, success);
        assertEquals(10, store.getInventory(Product.SHAMPOO));
    }

}