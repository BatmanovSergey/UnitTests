package seminars.first.HW.Shop;

import java.util.Objects;

public class Product implements Comparable<Product> {
    private Integer cost; // Стоимость продукта
    private String title; // Название

    public Product(Integer cost, String title) {
        this.cost = cost;
        this.title = title;
    }

    // Геттеры, сеттеры:
    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int compareTo(Product o) {
        if (this.getCost() > o.getCost()) {
            return 1;
        }
        if (this.getCost() < o.getCost()) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "продукт: " + title + ", цена: " + cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(cost, product.cost) && Objects.equals(title, product.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cost, title);
    }
}