package com.bastex.codelearninghub.spring.data.services;


import com.bastex.codelearninghub.spring.data.domain.Publisher;

public interface PublisherService {
    long save(Publisher publisher);

    long count();
}
