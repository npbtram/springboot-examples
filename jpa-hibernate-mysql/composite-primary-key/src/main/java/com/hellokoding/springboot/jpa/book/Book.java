package com.hellokoding.springboot.jpa.book;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data

@Entity
@IdClass(Book.IdClass.class)
public class Book {
    @Id
    private String name;

    @Id
    private Date publishedDate;

    private Date updatedDate = new Date();

    @Data
    static class IdClass implements Serializable {
        private String name;
        private Date publishedDate;
    }
}
