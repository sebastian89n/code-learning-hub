package com.bastex.codelearninghub.spring.data.domain.projections;

public interface PublisherProjection extends BaseEntityProjection {
    String getName();

    String getEmailAddress();

    String getPhoneNumber();
}
