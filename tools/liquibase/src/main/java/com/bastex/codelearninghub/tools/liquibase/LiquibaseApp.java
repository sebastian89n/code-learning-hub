package com.bastex.codelearninghub.tools.liquibase;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.stream.Collectors;

@EntityScan("com.bastex.codelearninghub.spring.data.domain")
@EnableJpaRepositories(basePackages = "com.bastex.codelearninghub.spring.data.repositories")
@SpringBootApplication(scanBasePackages = {"com.bastex.codelearninghub.spring.data.services"})
public class LiquibaseApp {
    public static void main(final String[] args) {
        final CommandLine commandLine = new CommandLine(new DbUpgradeCommand());
        System.exit(commandLine.execute(args));
    }

    @Command(name = "dbUpgrade", version = {"${COMMAND-FULL-NAME}: ${app.version}"})
    public static class DbUpgradeCommand implements Callable<Integer> {

        @Option(names = {"-h", "--help"}, usageHelp = true, description = "Prints help")
        private boolean help;

        @Option(names = {"-v", "--version"}, versionHelp = true, description = "Prints version")
        private boolean version;

        @Parameters(paramLabel = "contexts",
                arity = "0..",
                description = "Migration contexts to execute. Valid values are: ${COMPLETION-CANDIDATES}",
                completionCandidates = ContextCompletionCandidates.class,
                type = Context.class, converter = ContextTypeConverter.class)
        private final Set<Context> contexts = Collections.emptySet();

        @Override
        public Integer call() throws Exception {
            final ConfigurableApplicationContext applicationContext = SpringApplication.run(LiquibaseApp.class);
            AppContextHolder.INSTANCE.setContext(applicationContext);


            return 0;
        }
    }

    @Getter
    @RequiredArgsConstructor
    private enum Context {
        INIT_DATA_SCRIPT("initDataScript", "Initializes data using Liquibase scripts"), INIT_DATA_CODE("initDataCode", "Initializes data using Spring Data classes");

        private final String contextName;

        private final String description;
    }

    private static class ContextCompletionCandidates extends LinkedHashSet<String> {
        public ContextCompletionCandidates() {
            super(Arrays.stream(Context.values()).map(context -> String.format("%s : %s", context.getContextName(), context.getDescription())).collect(Collectors.toCollection(LinkedHashSet::new)));
        }
    }

    private static class ContextTypeConverter implements CommandLine.ITypeConverter<Context> {
        private static final Map<String, Context> CONTEXT_PER_NAME;

        static {
            CONTEXT_PER_NAME = Arrays.stream(Context.values())
                    .collect(Collectors.toMap(Context::getContextName, Function.identity(), (x, y) -> y, LinkedHashMap::new));
        }

        @Override
        public Context convert(final String param) {
            final Context context = CONTEXT_PER_NAME.get(param);

            if (context == null) {
                throw new IllegalArgumentException("Context not found. Available contexts: " + CONTEXT_PER_NAME.keySet());
            }

            return context;
        }
    }
}
