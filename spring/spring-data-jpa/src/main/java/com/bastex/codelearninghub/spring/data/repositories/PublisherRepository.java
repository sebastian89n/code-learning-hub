package com.bastex.codelearninghub.spring.data.repositories;

import com.bastex.codelearninghub.spring.data.domain.Publisher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
