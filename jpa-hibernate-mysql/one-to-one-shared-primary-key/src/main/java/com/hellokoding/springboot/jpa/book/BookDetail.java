package com.hellokoding.springboot.jpa.book;

import lombok.*;

import javax.persistence.*;

@Entity

@Data
@ToString(exclude = "book")
@EqualsAndHashCode(exclude = "book")
@RequiredArgsConstructor
@NoArgsConstructor
public class BookDetail {
    @Id
    private int id;

    @OneToOne
    @JoinColumn(name = "book_id")
    @MapsId
    private @NonNull Book book;

    private int numberOfPages;
}
