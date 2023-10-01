package com.bastex.codelearninghub.spring.data.repositories.impl;

import com.bastex.codelearninghub.spring.data.domain.projections.BookProjection;
import com.bastex.codelearninghub.spring.data.domain.projections.BookProjectionImpl;
import com.bastex.codelearninghub.spring.data.domain.query.BookSearchDTO;
import com.bastex.codelearninghub.spring.data.repositories.BookRepositoryCustom;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@RequiredArgsConstructor
class BookRepositoryCustomImpl implements BookRepositoryCustom {
    private final EntityManager entityManager;

    @Override
    public List<BookProjection> searchBooks(@NonNull final BookSearchDTO bookSearchDTO) {
        final StringBuilder queryBuilder = new StringBuilder("SELECT new com.bastex.codelearninghub.spring.data.domain.projections.BookProjectionImpl(b.id, b.createdTimestamp, b.lastUpdatedTimestamp, b.title, b.isbn, b.publicationDate, b.publisher.name) FROM Book b ");

        final List<Consumer<TypedQuery<BookProjectionImpl>>> consumers = new ArrayList<>();

        final StringBuilder conditionsBuilder = new StringBuilder();
        if (bookSearchDTO.getTitle() != null && !bookSearchDTO.getTitle().isBlank()) {
            conditionsBuilder.append("b.title = :title ");
            consumers.add(query -> query.setParameter("title", bookSearchDTO.getTitle()));
        }

        if (bookSearchDTO.getIsbn() != null && !bookSearchDTO.getIsbn().isBlank()) {
            conditionsBuilder.append("b.isbn = :isbn ");
            consumers.add(query -> query.setParameter("isbn", bookSearchDTO.getIsbn()));
        }

        if (bookSearchDTO.getPublicationDate() != null) {
            conditionsBuilder.append("b.publicationDate = :publicationDate ");
            consumers.add(query -> query.setParameter("publicationDate", bookSearchDTO.getPublicationDate()));
        }

        if (!conditionsBuilder.isEmpty()) {
            queryBuilder.append("WHERE ").append(conditionsBuilder);
        }

        final TypedQuery<BookProjectionImpl> query = entityManager.createQuery(queryBuilder.toString(), BookProjectionImpl.class);
        consumers.forEach(queryConsumer -> queryConsumer.accept(query));

        return new ArrayList<>(query.getResultList());
    }
}
