package com.hellokoding.springboot.jpa.book;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity

@Data
@ToString(exclude = "bookPublishers")
@EqualsAndHashCode(exclude = "bookPublishers")
@NoArgsConstructor
@RequiredArgsConstructor
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private @NonNull String name;

    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<BookPublisher> bookPublishers = new HashSet<>();
}
