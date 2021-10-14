package com.book.booktransactions.service.impl;

import com.book.booktransactions.dto.BookDto;
import com.book.booktransactions.dto.BookInfoDto;
import com.book.booktransactions.entity.Book;
import com.book.booktransactions.enums.BookStatus;
import com.book.booktransactions.repository.BookRepository;
import com.book.booktransactions.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookServiceImpl implements BookService {
    private static final Logger log = LoggerFactory.getLogger(BookServiceImpl.class);

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<BookInfoDto> getAllBooks(Optional<Integer> pageNumber, Optional<Integer> pageAmount) {
        log.info("Getting Books Details from DB");

        Pageable page = PageRequest.of(pageNumber.orElse(0), Integer.MAX_VALUE);

        if(pageNumber.isPresent() && pageAmount.isPresent())
            page = PageRequest.of(pageNumber.get(), pageAmount.get());


        return bookRepository.findAllBooks(page).getContent();
    }

    @Override
    @Transactional
    public Book createBook(BookDto bookDto) {
        log.info("Create Book : {}", bookDto);

        //Generate UUID for Operation
        UUID uuid = UUID.randomUUID();
        Book book = createStudentFromStudentDto(bookDto);
        book.setIsbn(uuid.toString());

        book = saveBook(book);
        return book;
    }

    private Book createStudentFromStudentDto(BookDto bookDto) {
        Book book = new Book();
        book.setName(bookDto.getName());
        book.setAuthor(bookDto.getAuthor());
        book.setIsbn(bookDto.getIsbn());
        book.setStatus(BookStatus.IN_STOCK.getName());

        return book;
    }

    @Override
    @Transactional
    public Book saveBook(Book book) {
        book = bookRepository.save(book);
        log.info("Book is saved id {}", book.getId());
        return book;
    }
}
