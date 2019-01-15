package com.hellokoding.springboot.jpa.book;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@IdClass(Book.IdClass.class)

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    private String name;

    @Id
    private Date publishedDate;

    @Builder.Default
    private Date updatedDate = new Date();

    @Data
    static class IdClass implements Serializable {
        private String name;
        private Date publishedDate;
    }
}
