package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;
import ru.netology.exception.NotFoundException;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private final ProductRepository repository = new ProductRepository();
    private final ProductManager productManager = new ProductManager(repository);

    private final Book firstBook = new Book(1, "book1", 1200, "author1");
    private final Book thirdBook = new Book(3, "book3", 750, "author3");
    private final TShirt firstTShirt = new TShirt(4, "tShirt1", 900, "green", "L");
    private final TShirt secondTShirt = new TShirt(5, "tShirt2", 1400, "red", "M");

    @BeforeEach
    public void setUp() {
        productManager.add(firstBook);
        productManager.add(thirdBook);
        productManager.add(firstTShirt);
        productManager.add(secondTShirt);
    }

    @Test
    public void shouldRemoveById1() {
        int id = 1;
        productManager.removeById(id);
        Product[] expected = new Product[] {thirdBook, firstTShirt, secondTShirt};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveNonExistentElement() {

     assertThrows(NotFoundException.class, () -> {productManager.removeById(2);});
    }
}