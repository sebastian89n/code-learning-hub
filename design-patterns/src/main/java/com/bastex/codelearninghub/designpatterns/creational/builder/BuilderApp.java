package com.bastex.codelearninghub.designpatterns.creational.builder;

public class BuilderApp {
    public static void main(final String[] args) {
        final String from = "client table";
        final String where = "client name = ...";

        final Query sqlQuery = SqlQueryBuilder.newBuilder()
                .from(from)
                .where(where)
                .buildQuery();
        sqlQuery.execute();

        final Query mongoQuery = MongoDbQueryBuilder.newBuilder()
                .from(from)
                .where(where)
                .buildQuery();
        mongoQuery.execute();
    }
}
