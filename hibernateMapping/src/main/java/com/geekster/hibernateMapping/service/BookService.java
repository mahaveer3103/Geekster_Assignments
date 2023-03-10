package com.geekster.hibernateMapping.service;

import com.geekster.hibernateMapping.dao.BookRepository;
import com.geekster.hibernateMapping.dao.StudentRepository;
import com.geekster.hibernateMapping.model.Book;
import com.geekster.hibernateMapping.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    StudentService studentService;
    public Integer saveBook(Book book) {
        return bookRepository.save(book).getID();
    }

    public List<Book> getBook(Integer bookId) {
        List<Book> books = new ArrayList<>();
        if(bookId!=null){
            books.add(bookRepository.findById(bookId).get()) ;
        }else {
            books = bookRepository.findAll();
        }
        return books;
    }

    public void deleteBook(Integer bookId) {
        bookRepository.deleteById(bookId);
    }
}
