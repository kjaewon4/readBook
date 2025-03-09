package com.book.book.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
//@Table(name = "")
public class TbBookStore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String offName;  // 중고 매장

    private String link;  // 중고 책 링크

    @ManyToOne
    @JoinColumn(name = "books_isbn")
    private TbBook book;
}
