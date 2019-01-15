package com.hellokoding.springboot.jpa_hibernate_mysql.book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer>{
}
