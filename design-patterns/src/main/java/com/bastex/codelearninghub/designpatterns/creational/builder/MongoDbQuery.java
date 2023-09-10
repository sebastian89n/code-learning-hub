package com.bastex.codelearninghub.designpatterns.creational.builder;

public class MongoDbQuery implements Query {

    private String from;

    private String where;

    @Override
    public void execute() {
        System.out.println("Executing mongoDbQuery from: " + from + " where " + where);
    }

    public void setFrom(final String from) {
        this.from = from;
    }

    public void setWhere(final String where) {
        this.where = where;
    }


}
