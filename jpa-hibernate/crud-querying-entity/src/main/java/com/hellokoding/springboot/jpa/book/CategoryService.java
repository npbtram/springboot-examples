package com.hellokoding.springboot.jpa.book;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    public void findByEntityManager() {
        Category category = categoryRepository.findById(1).get();
        Assert.assertEquals(10, category.getBooks().size());
        Assert.assertEquals("A9", category.getBooks().iterator().next().getName());
    }

    public void create() {
        Book[] books = new Book[10];
        for (int i = 0; i < 10; i++) {
            books[i] = new Book("A" + i);
        }

        categoryRepository.save(new Category("A", books));
    }
}
