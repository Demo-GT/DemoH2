package com.example.DemoH2.demoH2.repository;

import com.example.DemoH2.demoH2.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface bookRepository extends JpaRepository<Book, Integer> {

    List<Object> findAllById(Integer integer);

    Optional<Book> findByName(String name);
}
