package com.hellokoding.springboot.jpa.book;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookPublisher)) return false;
        BookPublisher that = (BookPublisher) o;
        return Objects.equals(book.getName(), that.book.getName()) &&
                Objects.equals(publisher.getName(), that.publisher.getName()) &&
                Objects.equals(publishedDate, that.publishedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(book.getName(), publisher.getName(), publishedDate);
    }
}
