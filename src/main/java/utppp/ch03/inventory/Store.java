package utppp.ch03.inventory;

import java.util.HashMap;
import java.util.Map;

public class Store {
    // inventory = 全商品
    private Map<Product, Integer> inventory;

    public Store() {
        inventory = new HashMap<>();
    }

    /**
     * 全表品の管理表に追加または更新する
     *
     * @param product  product
     * @param quantity 追加する商品数
     */
    public void addInventory(Product product, int quantity) {
        if (inventory.containsKey(product)) {
            var nowQuantity = inventory.get(product);
            var newQuantity = nowQuantity + quantity;
            inventory.replace(product, newQuantity);
        } else {
            inventory.put(product, quantity);
        }
    }

    /**
     * 商品の在庫数を取得する
     *
     * @param product 商品
     * @return 在庫数
     */
    public Integer getInventory(Product product) {
        if (inventory.containsKey(product)) {
            return inventory.get(product);
        } else {
            return null;
        }
    }

    /**
     * 在庫があるか確認する
     *
     * @param product
     * @param quantity 購入したい個数
     * @return 在庫が購入したい個数以上かどうか
     */
    public boolean hasEnoughInventory(Product product, int quantity) {
        if (inventory.containsKey(product)) {
            return inventory.get(product) >= quantity;
        }
        // NOTE: 商品がない場合はfalseを返す
        return false;
    }

    /**
     * 商品を購入し、在庫数を更新する
     *
     * @param product  product
     * @param quantity quantity
     */
    public void removeInventory(Product product, int quantity) {
        if (inventory.containsKey(product) || inventory.get(product) >= quantity) {
            var nowQuantity = inventory.get(product);
            var newQuantity = nowQuantity - quantity;
            inventory.replace(product, newQuantity);
            return;
        }

        throw new IllegalArgumentException();
    }
}
