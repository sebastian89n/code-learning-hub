package com.bastex.codelearninghub.jakartaee.jaxws.server.services;

import com.bastex.codelearninghub.jakartaee.jaxws.server.domain.DailyQuote;
import com.bastex.codelearninghub.jakartaee.jaxws.server.exceptions.InputValidationException;

import java.time.Instant;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

class DailyQuoteInMemoryService implements DailyQuoteService {
    private final Map<Long, DailyQuote> dailyQuotesById = new LinkedHashMap<>();

    @Override
    public long createDailyQuote(final String quote, final String author, final String userId) throws InputValidationException {
        validateField(quote, "quote");
        validateField(userId, "userId");

        final DailyQuote dailyQuote = new DailyQuote(getNextId(), quote, getAuthorOrDefault(author), userId, Instant.now());
        dailyQuotesById.put(dailyQuote.getId(), dailyQuote);

        return dailyQuote.getId();
    }

    @Override
    public boolean deleteDailyQuoteById(final long quoteId) {
        final DailyQuote removedQuote = dailyQuotesById.remove(quoteId);
        return removedQuote != null;
    }

    @Override
    public List<DailyQuote> findAllDailyQuotes() {
        return List.copyOf(dailyQuotesById.values());
    }

    @Override
    public Optional<DailyQuote> findDailyQuoteById(final long quoteId) {
        final DailyQuote dailyQuote = dailyQuotesById.get(quoteId);
        return Optional.ofNullable(dailyQuote);
    }

    private Long getNextId() {
        return dailyQuotesById.isEmpty() ? 1 : Collections.max(dailyQuotesById.keySet()) + 1;
    }

    private static void validateField(final String userId, final String fieldName) throws InputValidationException {
        if (userId == null || userId.isBlank()) {
            throw new InputValidationException(fieldName + " cannot be empty");
        }
    }

    private static String getAuthorOrDefault(final String author) {
        return (author == null || author.isBlank()) ? "unknown" : author;
    }
}
