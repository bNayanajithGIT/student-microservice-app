package com.book.booktransactions.service;

import com.book.booktransactions.dto.BookDto;
import com.book.booktransactions.dto.BookInfoDto;
import com.book.booktransactions.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<BookInfoDto> getAllBooks(Optional<Integer> pageNumber, Optional<Integer> pageAmount);

    Book createBook(BookDto bookDto);

    Book saveBook(Book book);
}
