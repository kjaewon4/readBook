package com.book.book.repository;

import com.book.book.entity.TbBookStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TbBookStoreRepository extends JpaRepository<TbBookStore, Long> {

}
