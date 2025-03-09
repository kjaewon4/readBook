package com.book.book.repository;

import com.book.book.entity.TbBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TbBookRepository extends JpaRepository<TbBook, Integer> {
}
