package com.geekster.hibernateMapping.dao;

import com.geekster.hibernateMapping.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
