package com.bastex.codelearninghub.spring.context.properties.datasource;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FakeDataSource {
    private String username;

    private String password;

    private String jdbcUrl;
}
