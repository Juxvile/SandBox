package com.example.CachingData.repository;

import com.example.CachingData.model.Book;

public interface BookRepository {
    Book getByIsbn (String isbn);
}
