package utppp.ch03.inventory;

public class Customer {
    /**
     * 商品を購入する
     *
     * @param store    store
     * @param product  product
     * @param quantity quantity
     * @return 購入に成功したかどうか
     */
    public boolean purchase(Store store, Product product, int quantity) {
        if (store.hasEnoughInventory(product, quantity)) {
            store.removeInventory(product, quantity);
            return true;
        }

        return false;
    }
}
