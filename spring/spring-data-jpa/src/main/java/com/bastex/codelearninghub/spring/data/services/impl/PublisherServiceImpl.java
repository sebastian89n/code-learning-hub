package com.bastex.codelearninghub.spring.data.services.impl;

import com.bastex.codelearninghub.spring.data.domain.Publisher;
import com.bastex.codelearninghub.spring.data.repositories.PublisherRepository;
import com.bastex.codelearninghub.spring.data.services.PublisherService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
class PublisherServiceImpl implements PublisherService {
    private final PublisherRepository publisherRepository;

    @Override
    @Transactional(readOnly = false)
    public long save(@NonNull final Publisher publisher) {
        return publisherRepository.save(publisher).getId();
    }

    @Override
    @Transactional(readOnly = true)
    public long count() {
        return publisherRepository.count();
    }
}
