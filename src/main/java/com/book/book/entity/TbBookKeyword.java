package com.book.book.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_booksKeyword")
public class TbBookKeyword {
    @Id
    @Column(name = "booksKeyword_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookKeywordId;

    @Column(name = "booksKeyword_keyword")
    private String bookKeyword;


    // 근데 왜 2개지
//    @Column(name = "books_isbn", insertable = false, updatable = false) // 읽기 전용 설정
//    private String bookIsbn;

    @ManyToOne
    @JoinColumn(name = "books_isbn")
    private TbBook book; // isbn
}
