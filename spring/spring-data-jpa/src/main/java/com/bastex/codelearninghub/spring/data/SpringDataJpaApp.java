package com.bastex.codelearninghub.spring.data;

import com.bastex.codelearninghub.spring.data.domain.dto.BookDTO;
import com.bastex.codelearninghub.spring.data.services.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@SpringBootApplication
@Slf4j
public class SpringDataJpaApp {
    public static void main(final String[] args) {
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringDataJpaApp.class, args);
        final BookService bookService = applicationContext.getBean(BookService.class);
        final Sort sortBy = Sort.by("lastUpdatedTimestamp").descending().and(Sort.by("title"));
        final Page<BookDTO> books = bookService.findAll(PageRequest.of(0, 10, sortBy));
        books.forEach(book -> log.info("Title: {}, isbn: {}, publication date: {}, publisher name: {}", book.getTitle(), book.getIsbn(), book.getPublicationDate(), book.getPublisherName()));
    }
}
