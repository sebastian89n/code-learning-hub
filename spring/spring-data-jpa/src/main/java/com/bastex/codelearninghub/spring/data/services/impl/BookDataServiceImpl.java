package com.bastex.codelearninghub.spring.data.services.impl;

import com.bastex.codelearninghub.spring.data.domain.Book;
import com.bastex.codelearninghub.spring.data.domain.projections.BookIdIsbnProjection;
import com.bastex.codelearninghub.spring.data.domain.projections.BookNoteProjection;
import com.bastex.codelearninghub.spring.data.domain.projections.BookProjection;
import com.bastex.codelearninghub.spring.data.domain.query.BookSearchQuery;
import com.bastex.codelearninghub.spring.data.domain.query.BookSort;
import com.bastex.codelearninghub.spring.data.repositories.BookRepository;
import com.bastex.codelearninghub.spring.data.services.BookDataService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
class BookDataServiceImpl implements BookDataService {
    private final BookRepository bookRepository;

    @Override
    @Transactional(readOnly = false)
    public long save(@NonNull final Book book) {
        return bookRepository.save(book).getId();
    }

    @Override
    @Transactional(readOnly = false)
    public int updatePublicationDateByBookIds(@NonNull final LocalDate newPublicationDate, @NonNull final Set<Long> bookIds) {
        if (bookIds.isEmpty()) {
            throw new IllegalArgumentException("Book ids cannot be empty");
        }

        return bookRepository.updatePublicationDateByBookIds(newPublicationDate, bookIds);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BookProjection> searchBooks(@NonNull final BookSearchQuery bookSearchQuery) {
        return bookRepository.searchBooks(bookSearchQuery);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<BookProjection> findById(final long bookId) {
        return bookRepository.findBookById(bookId);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<BookProjection> findAll(final int page, final int size, @NonNull final BookSort bookSort) {
        return bookRepository.findAllBooks(PageRequest.of(page, size, bookSort.getSort()));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<BookProjection> findAllBooksByTitleContains(@NonNull final String title, final int page, final int size, @NonNull final BookSort bookSort) {
        return bookRepository.findAllBooksByTitleContains(title, PageRequest.of(page, size, bookSort.getSort()));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<BookProjection> findAllBooksByPublisherName(@NonNull final String publisherName, final int page, final int size, @NonNull final BookSort bookSort) {
        return bookRepository.findAllBooksByPublisherName(publisherName, PageRequest.of(page, size, bookSort.getSort()));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<BookProjection> findAllBooksByAuthor(@NonNull final String firstName, @NonNull final String lastName, final int page, final int size, @NonNull final BookSort bookSort) {
        return bookRepository.findAllBooksByAuthor(firstName, lastName, PageRequest.of(page, size, bookSort.getSort()));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<BookNoteProjection> findBookNoteById(final long bookId) {
        return bookRepository.findBookNoteById(bookId);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<BookIdIsbnProjection> findBookIdIsbnByTitle(@NonNull final String title) {
        return bookRepository.findBookIdIsbnByTitle(title);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<BookIdIsbnProjection> findAllBookIdIsbnByTitleLike(@NonNull final String title, final int page, final int size, @NonNull final BookSort bookSort) {
        return bookRepository.findAllBookIdIsbnByTitleLike(title, PageRequest.of(page, size, bookSort.getSort()));
    }

    @Override
    @Transactional(readOnly = true)
    public List<BookIdIsbnProjection> findAllBookIdIsbnByTitleContainsAndPublicationDateAfter(@NonNull final String title, @NonNull final LocalDate publicationDate) {
        return bookRepository.findAllBookIdIsbnByTitleContainsAndPublicationDateGreaterThan(title, publicationDate);
    }

    @Override
    @Transactional(readOnly = true)
    public long count() {
        return bookRepository.count();
    }
}
