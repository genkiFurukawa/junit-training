package utppp.ch03.inventory;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * リスト3.3.3のテストコード(3.7の改善)
 * ファクトリメソッドを用意して、テスト・フィクスチャの柔軟性をあげる
 * ただし、このコードレベルであればファクトリメソッドを導入するまでもない。あくまで練習
 */
public class CustomerTestV2 {
    @Test
    void purchase_succeeds_when_enough_inventory() {
        Customer sut = createCustomer();
        Store store = createStoreWithInventory(Product.SHAMPOO, 10);

        boolean success = sut.purchase(store, Product.SHAMPOO, 5);

        assertEquals(true, success);
        assertEquals(5, store.getInventory(Product.SHAMPOO));
    }

    @Test
    void purchase_fails_when_not_enough_inventory() {
        Customer sut = createCustomer();
        Store store = createStoreWithInventory(Product.SHAMPOO, 10);

        boolean success = sut.purchase(store, Product.SHAMPOO, 15);

        // assertEquals(false, success);
        assertThat(success).isEqualTo(false); // NOTE: SVOの形になっていた読みやすくないかという提案(3.6)
        // assertEquals(10, store.getInventory(Product.SHAMPOO));
        assertThat(store.getInventory(Product.SHAMPOO)).isEqualTo(10);// NOTE: SVOの形になっていた読みやすくないかという提案(3.6)
    }

    /**
     * storeのテストフィクスチャを生成する
     *
     * @param product  product
     * @param quantity quantity
     * @return storeのインスタンス
     */
    private Store createStoreWithInventory(Product product, int quantity) {
        Store store = new Store();
        store.addInventory(product, quantity);
        return store;
    }

    /**
     * customerのテストフィクスチャを生成する
     *
     * @return customerのインスタンス
     */
    private Customer createCustomer() {
        return new Customer();
    }
}
