package com.hellokoding.springboot.jpa.book;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;

@Entity

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class BookPublisher implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "book_id")
    private @NonNull Book book;

    @Id
    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private @NonNull Publisher publisher;


    private @NonNull Date publishedDate;
}
