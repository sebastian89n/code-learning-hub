package com.bastex.codelearninghub.spring.data.services;


import com.bastex.codelearninghub.spring.data.domain.Publisher;

public interface PublisherDataService {
    long save(Publisher publisher);

    long count();
}
