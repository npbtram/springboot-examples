package com.hellokoding.springboot.jpa.book;

import lombok.NoArgsConstructor;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

@NoArgsConstructor

@RunWith(SpringRunner.class)
@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class QueringDataTest {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Before
    public void createTestData(){
        categoryRepository.save(new Category("A", new Book("A1"), new Book("A2")));
    }

    @Test
    public void testQueryData_whenEM_thenSuccess() {
        bookRepository.findById(1);
    }
}
