package com.bastex.codelearninghub.spring.data.bootstrap;

import com.bastex.codelearninghub.spring.data.domain.Address;
import com.bastex.codelearninghub.spring.data.domain.Author;
import com.bastex.codelearninghub.spring.data.domain.Book;
import com.bastex.codelearninghub.spring.data.domain.BookNote;
import com.bastex.codelearninghub.spring.data.domain.BookType;
import com.bastex.codelearninghub.spring.data.domain.Publisher;
import com.bastex.codelearninghub.spring.data.services.AuthorDataService;
import com.bastex.codelearninghub.spring.data.services.BookDataService;
import com.bastex.codelearninghub.spring.data.services.PublisherDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final AuthorDataService authorDataService;

    private final BookDataService bookDataService;

    private final PublisherDataService publisherDataService;

    @Override
    public void run(final String... args) {
        initializeDbData();

    }

    private void initializeDbData() {
        final Author robertSedgewickAuthor = new Author();
        robertSedgewickAuthor.setFirstName("Robert");
        robertSedgewickAuthor.setLastName("Sedgewick");
        robertSedgewickAuthor.setEmail("robert.sedgewick@gmail.com");
        authorDataService.save(robertSedgewickAuthor);

        final Author kevinWayneAuthor = new Author();
        kevinWayneAuthor.setFirstName("Kevin");
        kevinWayneAuthor.setLastName("Wayne");
        kevinWayneAuthor.setEmail("kevin.wayne@gmail.com");
        authorDataService.save(kevinWayneAuthor);

        final Author robertDonderoAuthor = new Author();
        robertDonderoAuthor.setFirstName("Robert");
        robertDonderoAuthor.setLastName("Dondero");
        robertDonderoAuthor.setEmail("robert.dondero@gmail.com");
        authorDataService.save(robertDonderoAuthor);

        final Publisher addisonWesleyPub = new Publisher();
        addisonWesleyPub.setName("Addison Wesley");

        final Address address = new Address();
        address.setAddressLocal("501 Boylston St.");
        address.setCity("Boston");
        address.setState("Massachusetts");
        address.setZip("02216");
        address.setCountry("US");

        addisonWesleyPub.setAddress(address);
        publisherDataService.save(addisonWesleyPub);

        final Book algorithmsBook = new Book();
        algorithmsBook.setTitle("Algorithms, 4th Edition");
        algorithmsBook.setIsbn("032157351X");
        algorithmsBook.setType(BookType.IT);
        algorithmsBook.setPublicationDate(LocalDate.of(2018, 10, 1));
        algorithmsBook.getAuthors().add(robertSedgewickAuthor);
        algorithmsBook.getAuthors().add(kevinWayneAuthor);
        algorithmsBook.setPublisher(addisonWesleyPub);

        final BookNote bookNote = new BookNote();
        bookNote.setNote("Very good introduction for Algorithms. Examples based on Java.");
        algorithmsBook.setNote(bookNote);

        bookDataService.save(algorithmsBook);

        final Book pythonBook = new Book();
        pythonBook.setTitle("Introduction to Programming in Python: An Interdisciplinary Approach");
        pythonBook.setIsbn("0134076435");
        pythonBook.setType(BookType.IT);
        pythonBook.setPublicationDate(LocalDate.of(2015, 5, 8));
        pythonBook.getAuthors().add(robertSedgewickAuthor);
        pythonBook.getAuthors().add(kevinWayneAuthor);
        pythonBook.getAuthors().add(robertDonderoAuthor);
        pythonBook.setPublisher(addisonWesleyPub);
        bookDataService.save(pythonBook);
    }
}
