package com.bastex.codelearninghub.spring.data.domain.dto;

public interface PublisherDTO extends BaseEntityDTO {
    String getName();

    String getAddressLocal();

    String getCity();

    String getState();

    String getZip();
}
