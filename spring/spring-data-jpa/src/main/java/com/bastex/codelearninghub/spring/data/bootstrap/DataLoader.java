package com.bastex.codelearninghub.spring.data.bootstrap;

import com.bastex.codelearninghub.spring.data.domain.Author;
import com.bastex.codelearninghub.spring.data.domain.Book;
import com.bastex.codelearninghub.spring.data.domain.Publisher;
import com.bastex.codelearninghub.spring.data.services.AuthorService;
import com.bastex.codelearninghub.spring.data.services.BookService;
import com.bastex.codelearninghub.spring.data.services.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final AuthorService authorService;

    private final BookService bookService;

    private final PublisherService publisherService;

    @Override
    public void run(final String... args) {
        final Author robertSedgewickAuthor = new Author();
        robertSedgewickAuthor.setFirstName("Robert");
        robertSedgewickAuthor.setLastName("Sedgewick");
        robertSedgewickAuthor.setEmail("robert.sedgewick@gmail.com");
        authorService.save(robertSedgewickAuthor);

        final Author kevinWayneAuthor = new Author();
        kevinWayneAuthor.setFirstName("Kevin");
        kevinWayneAuthor.setLastName("Wayne");
        kevinWayneAuthor.setEmail("kevin.wayne@gmail.com");
        authorService.save(kevinWayneAuthor);

        final Author robertDonderoAuthor = new Author();
        robertDonderoAuthor.setFirstName("Robert");
        robertDonderoAuthor.setLastName("Dondero");
        robertDonderoAuthor.setEmail("robert.dondero@gmail.com");
        authorService.save(robertDonderoAuthor);

        final Publisher addisonWesleyPub = new Publisher();
        addisonWesleyPub.setName("Addison Wesley");
        publisherService.save(addisonWesleyPub);

        final Book algorithmsBook = new Book();
        algorithmsBook.setTitle("Algorithms, 4th Edition");
        algorithmsBook.setIsbn("032157351X");
        algorithmsBook.setPublicationDate(LocalDate.of(2018, 10, 1));
        algorithmsBook.getAuthors().add(robertSedgewickAuthor);
        algorithmsBook.getAuthors().add(kevinWayneAuthor);
        algorithmsBook.setPublisher(addisonWesleyPub);
        bookService.save(algorithmsBook);

        final Book pythonBook = new Book();
        pythonBook.setTitle("Introduction to Programming in Python: An Interdisciplinary Approach");
        pythonBook.setIsbn("0134076435");
        pythonBook.setPublicationDate(LocalDate.of(2015, 5, 8));
        pythonBook.getAuthors().add(robertSedgewickAuthor);
        pythonBook.getAuthors().add(kevinWayneAuthor);
        pythonBook.getAuthors().add(robertDonderoAuthor);
        pythonBook.setPublisher(addisonWesleyPub);
        bookService.save(pythonBook);

    }
}
