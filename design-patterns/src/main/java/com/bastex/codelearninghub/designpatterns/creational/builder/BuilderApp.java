package com.bastex.codelearninghub.designpatterns.creational.builder;

public class BuilderApp {

    public static void main(final String[] args) {
        // setup the director
        final QueryBuildDirector director = new QueryBuildDirector();
        final String from = "client table";
        final String where = "client name = ...";

        QueryBuilder builder = new SqlQueryBuilder();
        Query query = director.buildQuery(from, where, builder);
        query.execute();

        builder = new MongoDbQueryBuilder();
        query = director.buildQuery(from, where, builder);
        query.execute();
    }
}
