package com.bastex.codelearninghub.spring.data.repositories;

import com.bastex.codelearninghub.spring.data.domain.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Defines custom Spring Data JPA Repository. It can be used as a template for other repositories.
 * By the default Spring Data JPA will create implementation for every repository extending Repository(and related interfaces).
 * In this example BaseEntity is not an actual entity so the implementation would fail during startup.
 * In this case @NoRepositoryBean instructs Spring Data JPA to not implement this interface, and therefore it can be
 * extended in other repositories and provide common custom methods.
 */
@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T, Long> {
    boolean deleteEntityById(long entityId);
}
