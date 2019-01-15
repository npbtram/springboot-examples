package com.hellokoding.springboot.jpa_hibernate_mysql.book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDetailRepository extends JpaRepository<BookDetail, Integer>{
}
