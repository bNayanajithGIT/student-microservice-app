package com.book.booktransactions.controller;

import com.book.booktransactions.dto.BookDto;
import com.book.booktransactions.dto.BookInfoDto;
import com.book.booktransactions.entity.Book;
import com.book.booktransactions.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Validated
public class BookController {
    public static final Logger log = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    /**
     *Endpoint for book creation
     * @param
     * @return saved Book
     */
    @ResponseBody
    @PostMapping
    public Book createBook(@RequestBody BookDto bookDto) {
        log.info("POST Create book");
        return bookService.createBook(bookDto);
    }

    /**
     *Endpoint for get all book details
     * @param pageAmount
     * @param pageNumber
     * @return valid book list
     */
    @GetMapping(value = "/getAllBooks")
    public @ResponseBody
    List<BookInfoDto> getAllBooks(@RequestParam(value = "page-number") Optional<Integer> pageNumber,
                                     @RequestParam(value = "page-amount") Optional<Integer> pageAmount) {
        log.info("GET request init book details");
        return bookService.getAllBooks(pageNumber,pageAmount);
    }

}
