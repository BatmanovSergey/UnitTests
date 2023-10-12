package seminars.first.HW.Shop;


import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class Shop implements Iterator<Product> {
    private List<Product> products;
    private int index;

    public Shop(List<Product> products) {
        this.products = products;
        this.index = 0;
    }

    // Метод должен вернуть отсортированный по возрастанию по цене список продуктов
    public List<Product> sortProductsByPrice(List<Product> products) {
        // Допишите реализацию метода самостоятельно
        Collections.sort(products);
        return products;
    }

    // Метод должен вернуть самый дорогой продукт
    public Product getMostExpensiveProduct(List<Product> products) {
        // Допишите реализацию метода самостоятельно
        int maxx = 0;
        Product p = null;
        for (Product product : products) {
             if (product.getCost() > maxx) {
                 maxx = product.getCost();
                 p = product;
             }

        }
        return p;
    }

    // Геттеры, сеттеры:
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public boolean hasNext() {
        return index < products.size();
    }

    @Override
    public Product next() {
        return products.get(index++);
    }
}