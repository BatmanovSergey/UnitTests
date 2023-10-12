package seminars.first.HW.Shop;


import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;

public class ShopTest {
    public static void main(String[] args) {
        /*
   1. Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов (правильное количество продуктов, верное содержимое корзины).
   2. Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.
   3. Напишите тесты для проверки корректности работы метода sortProductsByPrice (проверьте правильность сортировки).
   */
        Product apple = new Product(50, "Яблоко");
        Product lemon = new Product(100, "Лимон");
        Product milk = new Product(60, "Молоко");
        Product bread = new Product(20, "Хлеб");
        Product meat = new Product(100, "Мясо");
        Product nuts = new Product(1000, "Орехи");

        Shop shop = new Shop(new ArrayList<>());

        shop.getProducts().add(apple);
        shop.getProducts().add(lemon);
        shop.getProducts().add(meat);
        shop.getProducts().add(milk);
        shop.getProducts().add(bread);

//        System.out.println(shop.getProducts());
//        System.out.println(shop.sortProductsByPrice(shop.getProducts()));
//        System.out.printf("Самый дорогой в списке %s\n", shop.getMostExpensiveProduct(shop.getProducts()));

        assertThat(shop.getProducts()).hasSize(5).contains(lemon, bread, meat, milk, apple);
        assertThat(shop.getMostExpensiveProduct(shop.getProducts())).isEqualTo(meat);
        assertThat(shop.sortProductsByPrice(shop.getProducts())).containsSequence(bread, apple, lemon, milk, meat);

    }

}