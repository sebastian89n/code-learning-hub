package com.bastex.codelearninghub.designpatterns.creational.builder;

public interface QueryBuilder {
    void from(String from);

    void where(String where);

    Query getQuery();

}
