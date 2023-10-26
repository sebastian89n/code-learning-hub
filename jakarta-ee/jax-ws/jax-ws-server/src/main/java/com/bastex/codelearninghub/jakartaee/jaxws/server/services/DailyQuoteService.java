package com.bastex.codelearninghub.jakartaee.jaxws.server.services;

import com.bastex.codelearninghub.jakartaee.jaxws.server.domain.DailyQuote;
import com.bastex.codelearninghub.jakartaee.jaxws.server.exceptions.DailyQuoteValidationException;

import java.util.List;
import java.util.Optional;

public interface DailyQuoteService {
    static DailyQuoteService newInMemoryInstance() {
        return new DailyQuoteInMemoryService();
    }

    long createDailyQuote(final String quote, final String userId) throws DailyQuoteValidationException;

    boolean deleteDailyQuoteById(final long quoteId);

    List<DailyQuote> findAllDailyQuotes();

    Optional<DailyQuote> findDailyQuoteById(final long quoteId);
}
