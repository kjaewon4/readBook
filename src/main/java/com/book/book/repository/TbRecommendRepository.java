package com.book.book.repository;

import com.book.book.entity.TbRecommend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TbRecommendRepository extends JpaRepository<TbRecommend, Long> {
}
