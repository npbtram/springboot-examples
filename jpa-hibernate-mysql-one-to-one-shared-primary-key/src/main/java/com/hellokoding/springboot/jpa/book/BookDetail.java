package com.hellokoding.springboot.jpa.book;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity

@Data
@ToString(exclude = "book")
@EqualsAndHashCode(exclude = "book")
@RequiredArgsConstructor
@NoArgsConstructor
public class BookDetail implements Serializable {
    @Id
    private int id;

    @OneToOne
    @JoinColumn(name = "book_id")
    @MapsId
    private @NonNull Book book;

    private int numberOfPages;
}
