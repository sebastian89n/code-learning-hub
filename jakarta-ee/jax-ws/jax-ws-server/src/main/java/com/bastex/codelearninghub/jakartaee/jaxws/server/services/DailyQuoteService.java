package com.bastex.codelearninghub.jakartaee.jaxws.server.services;

import com.bastex.codelearninghub.jakartaee.jaxws.server.domain.DailyQuote;
import com.bastex.codelearninghub.jakartaee.jaxws.server.exceptions.InputValidationException;

import java.util.List;
import java.util.Optional;

public interface DailyQuoteService {
    static DailyQuoteService newInMemoryInstance() {
        return new DailyQuoteInMemoryService();
    }

    long createDailyQuote(final String quote, String author, final String userId) throws InputValidationException;

    boolean deleteDailyQuoteById(final long quoteId);

    List<DailyQuote> findAllDailyQuotes();

    Optional<DailyQuote> findDailyQuoteById(final long quoteId);
}
