package com.book.booktransactions.repository;

import com.book.booktransactions.dto.BookInfoDto;
import com.book.booktransactions.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value = "SELECT b.id as id, b.name as name,b.author as author, b.isbn as isbn, "
            + " b.status as status,"
            + " b.created_date as createdDate, b.modified_date as modifiedDate"
            + " FROM book_data b"
            + " ORDER BY b.id DESC",
            countQuery = "SELECT count(*) FROM book_data", nativeQuery = true)
    Page<BookInfoDto> findAllBooks(Pageable pageable);
}
