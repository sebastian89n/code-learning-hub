package com.bastex.codelearninghub.spring5.boot.datasource;

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
