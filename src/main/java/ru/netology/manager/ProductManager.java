package ru.netology.manager;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void add(Product item) {
        repository.save(item);
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product: repository.findAll()) {
            if (matches (product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product.getName().equalsIgnoreCase(search)) {
            return true;
        }
        if (product instanceof Book) {
            Book book = (Book) product;
            if (book.getAuthor().equalsIgnoreCase(search)) {
                return true;
            }
        }
        if (product instanceof TShirt) {
            TShirt tShirt = (TShirt) product;
            if (tShirt.getColor().equalsIgnoreCase(search)) {
                return true;
            }
        }
        if (product instanceof TShirt) {
            TShirt tShirt = (TShirt) product;
            if (tShirt.getSize().equalsIgnoreCase(search)) {
                return true;
            }
        }
        return false;
    }
}
