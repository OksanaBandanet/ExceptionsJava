package ru.netology.exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    @Test
    public void TestRemoveThenProductExist() {
        ShopRepository shopRepository = new ShopRepository();
        Product product1 = new Product(1, "Футболка", 1_000);
        Product product2 = new Product(2, "Джинсы", 5_000);
        Product product3 = new Product(3, "Велосипед", 50_000);
        shopRepository.add(product1);
        shopRepository.add(product2);
        shopRepository.add(product3);
        shopRepository.remove(1);
        Product[] actual = shopRepository.findAll();
        Product[] expected = {product2, product3};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void TestRemoveThenProductNotExist() {
        ShopRepository shopRepository = new ShopRepository();
        Product product1 = new Product(1, "Футболка", 1_000);
        Product product2 = new Product(2, "Джинсы", 5_000);
        Product product3 = new Product(3, "Велосипед", 50_000);
        shopRepository.add(product1);
        shopRepository.add(product2);
        shopRepository.add(product3);
        Assertions.assertThrows(NotFoundException.class,
                () -> shopRepository.remove(5)
        );
    }
}
