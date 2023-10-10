package com.bastex.codelearninghub.designpatterns.creational.builder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MongoDbQuery implements Query {
    private String from;

    private String where;

    @Override
    public void execute() {
        log.info("Executing mongoDbQuery from: {} where {}", from, where);
    }

    public void setFrom(final String from) {
        this.from = from;
    }

    public void setWhere(final String where) {
        this.where = where;
    }
}
