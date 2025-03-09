package com.book.book.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_booksMark")
public class TbBookMark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookmarkId;

    @ManyToOne
    @JoinColumn(name = "books_isbn")
    private TbBook book;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private TbUser user;
}
