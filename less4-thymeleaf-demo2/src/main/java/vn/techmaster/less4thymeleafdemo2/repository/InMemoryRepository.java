package vn.techmaster.less4thymeleafdemo2.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.Getter;
import vn.techmaster.less4thymeleafdemo2.model.Country;
import vn.techmaster.less4thymeleafdemo2.model.Product;

@Getter
@Repository
public class InMemoryRepository {
    private ArrayList<Product> products;
    private ArrayList<Country> countries;

    public InMemoryRepository() {
        products = new ArrayList<>(List.of(new Product("Sony WX", "Sony", 10000000),
                new Product("Nike Air", "Nile", 2500000),
                new Product("Lenovo Legion 7", "Lenovo", 40000000),
                new Product("Macbook M1", "Apple", 40000000)));

        countries = new ArrayList<>(List.of(
            new Country("Vietnam", "vi"),
            new Country("China", "cn"),
            new Country("USA", "us"),
            new Country("France", "fr"),
            new Country("Singapore", "sg"),
            new Country("Japan", "jp")
        ));
    }
}
