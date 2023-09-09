package com.bastex.codelearninghub.spring5boot.beans;

import com.bastex.spring5learning.springboot.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Another alias for @Component annotation. It can be used for marking Spring Data JPA repositories. However, it also causes exception translation:
 * --
 * From Spring documentation:
 * Common data access exceptions. Spring can wrap exceptions from your O/R mapping tool of choice, converting them from proprietary (potentially checked) exceptions
 * to a common runtime DataAccessException hierarchy. This allows you to handle most persistence exceptions, which are non-recoverable, only in the appropriate layers,
 * without annoying boilerplate catches/throws, and exception declarations. You can still trap and handle exceptions anywhere you need to.
 * Remember that JDBC exceptions (including DB specific dialects) are also converted to the same hierarchy, meaning that you can perform some operations with
 * JDBC within a consistent programming model.
 */
@Repository
public interface RepositoryBeanSample extends JpaRepository<UserEntity, Long> {
}
