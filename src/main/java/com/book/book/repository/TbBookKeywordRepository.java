package com.book.book.repository;

import com.book.book.entity.TbBookKeyword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TbBookKeywordRepository extends JpaRepository<TbBookKeyword, Long> {
}
