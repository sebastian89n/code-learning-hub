package com.bastex.codelearninghub.spring.data.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@MappedSuperclass
@Setter
@Getter
@ToString
public abstract class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "oid", updatable = false, nullable = false)
    public Long id;

    @Column(name = "createdtimestamp", nullable = false)
    @CreationTimestamp
    public Instant createdTimestamp;

    @Column(name = "lastupdatedtimestamp")
    @UpdateTimestamp
    public Instant lastUpdatedTimestamp;
}
