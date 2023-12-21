# Maven

Maven is a build automation and project management tool primarily used for Java projects. It simplifies the build
process, manages dependencies, and can automate many aspects of your project.

## Installing Maven

You can download and install it from [Maven's official website](https://maven.apache.org/download.cgi).

## Project Structure

Maven follows a specific project structure. Typically, your project should have the following directories:

```plaintext
project-root/
    ├─ src/
    │    ├─ main/
    │    │     ├─ java/
    │    │     └─ resources/
    │    └─ test/
    │         ├─ java/
    │         └─ resources/
    └─ pom.xml
```

This structure supports also different languages, like Kotlin etc.

```plaintext
project-root/
    ├─ src/
    │    ├─ main/
    │    │     ├─ kotlin/
    │    │     └─ resources/
    │    └─ test/
    │         ├─ kotlin/
    │         └─ resources/
    └─ pom.xml
```

## The `pom.xml` File

The heart of Maven project is the `pom.xml` file (Project Object Model). It contains project metadata,
dependencies, and build instructions.

## Dependency

In Maven, a **dependency** represents an external library or artifact that your project relies on. Dependencies are
declared in the project's `pom.xml` file, and Maven fetches these libraries from repositories to build and run your
project. Here's how you work with dependencies:

## Declaring Dependencies

To declare a dependency, you include a `<dependency>` element within the `<dependencies>` section of your `pom.xml`. A
typical dependency declaration includes the `groupId`, `artifactId`, and `version` of the library:

```xml

<dependencies>
    <dependency>
        <groupId>com.example</groupId>
        <artifactId>my-library</artifactId>
        <version>1.0.0</version>
    </dependency>
</dependencies>
```

## Dependency Scopes

Dependencies can have different scopes, each with a specific purpose. Here are some commonly used dependency scopes:

- **compile**: This is the default scope. Dependencies with this scope are available during compile, test, and runtime
  phases.
- **provided**: Dependencies with this scope are available during compile and test phases but are expected to be
  provided by the runtime environment (e.g., servlet containers).
- **runtime**: Dependencies with this scope are not needed for compilation but are required for runtime. They are
  available during test and runtime phases.
- **test**: Dependencies with this scope are only needed during testing and are not part of the runtime classpath.
- **system**: This scope allows you to specify system path dependencies. Use it sparingly, as it can lead to portability
  issues.
- **import**: This scope is used in Maven's "dependencyManagement" section to manage the dependencies from other
  projects.

Examples:

```xml

<dependencies>
    <dependency>
        <groupId>org.apache.commons</groupId>
        <artifactId>commons-lang3</artifactId>
        <version>3.13.0</version>
        <scope>compile</scope>
    </dependency>
</dependencies>
```

```xml

<dependency>
    <groupId>com.bastex</groupId>
    <artifactId>code-learning-hub-bom</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <type>pom</type>
    <scope>import</scope>
</dependency>
```

## Transitive Dependencies

Maven resolves dependencies transitively, meaning it automatically fetches all the transitive dependencies needed by
your declared dependencies. This simplifies your project configuration and ensures that your project works seamlessly
with all required libraries.

```
- My Project
  - Direct Dependency A
    - Transitive Dependency X
    - Transitive Dependency Y
  - Direct Dependency B
    - Transitive Dependency Y
    - Transitive Dependency Z
```

In this representation:

- "My Project" is your main project.
- "Direct Dependency A" and "Direct Dependency B" are dependencies explicitly declared in your project's pom.xml.
- "Transitive Dependency X," "Transitive Dependency Y," and "Transitive Dependency Z" are dependencies pulled in
  automatically due to the direct dependencies.

## Exclusions

In some cases, you may need to exclude specific transitive dependencies to prevent conflicts. You can do this by
adding <exclusions> within the <dependency> declaration.

For example, to exclude a problematic dependency:

```xml

<dependencies>
    <dependency>
        <groupId>com.example</groupId>
        <artifactId>my-library</artifactId>
        <version>2.0.0</version>
        <exclusions>
            <exclusion>
                <groupId>problematic-group</groupId>
                <artifactId>problematic-artifact</artifactId>
            </exclusion>
        </exclusions>
    </dependency>
</dependencies>
```

## Understanding Dependency Conflicts

Dependency conflicts occur when different parts of your project require different versions of the same library. For
example, suppose your project depends on "Library X" with version 1.0, and a plugin you're using relies on "Library X"
version 2.0. This is a typical scenario for a conflict.

## Resolution Strategy

Maven follows a specific resolution strategy to handle these conflicts:

1. **Nearest Definition**: Maven selects the version of the library that is nearest to your project in the dependency
   tree. It means the version specified in your project's `pom.xml` or in its parent `pom.xml`.

2. **Version Order**: If there are multiple dependencies at the same level in the hierarchy (at the same distance from
   your project), Maven selects the version that appears first in the list of dependencies.

## Investigating Dependency Conflicts

Maven provides a useful tool, `dependency:tree`, to visualize the dependency tree of your project. Run the following
command to generate a tree structure:

```bash
mvn dependency:tree
```

It can be also visualized using IDE plugins like `Maven Helper` in IntelliJ.

## Dependency and Plugins Management

In Maven, `dependencyManagement` and `pluginsManagement` are sections in your project's `pom.xml` file that allow you to
centralize and manage dependencies and plugins across multiple modules. They serve the following purposes:

- **`dependencyManagement`**: This section is used to define versions and configurations of dependencies that multiple
  modules within your project might use. It ensures consistency and simplifies dependency declarations.

- **`pluginsManagement`**: Similar to `dependencyManagement`, this section centralizes the configurations and versions
  of plugins. It's beneficial when your project employs the same set of plugins across various modules.

By using these sections, you can maintain consistency, manage versions, and simplify the configuration of dependencies
and plugins throughout your project.

It's important to note that dependencies specified in the `dependencyManagement` and plugins in the `pluginsManagement`
sections are not automatically inherited by your project's modules. In other words, they serve as templates or central
configurations. Their primary role is to provide consistent versions for dependencies and plugins used across
your project. This centralization simplifies version management and ensures uniformity.

To utilize a dependency or plugin defined in these sections, you must explicitly declare it in your
module's `dependencies` or `build/plugins` section, specifying the `<groupId>` and `<artifactId>`. If the version is not
specified here, Maven will automatically use the version provided in `dependencyManagement` or `pluginsManagement`. This
approach allows you to avoid specifying versions repeatedly in your project's POM, promoting maintainability and
consistency.

## Maven BOM

**BOM (Bill of Materials)**: In Maven, a BOM is a special type of POM (Project Object Model) that centralizes and
manages version information for a set of related dependencies. It simplifies dependency management by providing a single
place to define and update versions, ensuring consistency across projects that use those dependencies.

## Defining Properties

Maven properties are defined in the project's `pom.xml` or in external property files. To define a property in
your `pom.xml`, use the `<properties>` section:

```xml

<properties>
    <jackson.version>2.15.2</jackson.version>
    <java.version>21</java.version>
</properties>
```

You can also define properties externally in a `.properties` file or in the `<build><plugins>` section if needed.

## Using Properties

Properties can be used throughout your project's configuration, such as in the pom.xml, plugin configurations, or even
within your application code. For example:

```xml

<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-core</artifactId>
    <version>${jackson.version}</version>
</dependency>
```

```xml

<plugins>
    <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>${maven.compiler.plugin.version}</version>
        <configuration>
            <source>${java.version}</source>
            <target>${java.version}</target>
        </configuration>
    </plugin>
</plugins>
```

## Overriding Properties

Maven properties can be overridden at different levels. The order of precedence is:

1. System properties (`-Dproperty=value`).
2. User settings (`settings.xml`).
3. Project properties (`pom.xml`).
4. Profiles defined in `settings.xml` or `pom.xml` .

You can override properties when running Maven commands, which can be useful for customizing builds.

## Benefits of Properties

Maven properties offer several benefits:

- **Reusability**: You can use the same property in multiple places within your project.
- **Customization**: Properties allow for customization based on profiles, environments, or specific requirements.
- **Centralization**: Common values are centralized, making it easier to manage and update them consistently.
- **Clean Configuration**: It keeps your pom.xml clean and focused on project structure and not hardcoded values.

## Maven Lifecycles

Maven defines build lifecycles that dictate the build phases. Common Maven lifecycles include:

- `clean`: Cleans the project.
- `validate`: Validates the project.
- `compile`: Compiles the source code.
- `test`: Runs tests.
- `package`: Packages the project.
- `install`: Installs the project to the local repository.
- `deploy`: Deploys the project to a remote repository.
- `verify`: Runs checks on the results of integration tests. (e.g., `maven-failsafe-plugin`)
- `site`: Generates project documentation, reports, and websites. (e.g., `maven-site-plugin`)

## Goals

In Maven, a **goal** is a specific task or action performed by a plugin during a build process. Goals are the individual
operations that a plugin can execute. They are defined within a plugin and correspond to specific functionalities that
the plugin provides.

For example, the `maven-compiler-plugin` offers several goals, including `compile`, `testCompile`, and `install`.
The `compile` goal is responsible for compiling the project's source code, `testCompile` compiles test source code,
and `install` installs the project's JAR file in the local repository.

Goals are an integral part of Maven's build process, and you can configure them in your project's POM file. You can
specify which goals a plugin should execute and when they should run by attaching the plugin to specific build phases.

Each plugin typically documents its available goals and how to configure them. Goals are powerful tools that allow you
to customize and extend your build process to meet your project's specific requirements.

## Attaching Plugins to Specific Phases

You can configure your plugins to execute at specific phases in the `pom.xml`. For example:

```xml

<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.8.1</version>
            <executions>
                <execution>
                    <phase>compile</phase>
                    <goals>
                        <goal>compile</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```

## The `.m2` Folder and `settings.xml` in Maven

In Maven, the `.m2` folder and the `settings.xml` file play important roles in configuring and managing your Maven
environment.

The `.m2` folder is a directory that Maven uses to store local repository data and configuration settings. By default,
it is located in the user's home directory and contains the following important subdirectories:

- `repository`: This directory stores all the downloaded project dependencies, plugins, and artifacts. It serves as the
  local repository where Maven caches and retrieves dependencies.

- `settings.xml` file, which configures Maven settings

The `.m2` folder is a crucial part of your Maven environment and should not be modified manually except for
the `settings.xml` file.

## The `settings.xml` File

The `settings.xml` file is a configuration file used to customize and configure Maven settings. It is stored in
the `.m2` folder and plays a pivotal role in specifying various aspects of your Maven build process. Here are some of
its key uses:

- **Local Repository Path**: Specify the location of the local repository.

- **Repository Mirrors**: Define mirrors for improving download speed or using organization-specific repositories.

- **Proxy Settings**: Configure proxy settings for accessing external repositories when behind a firewall.

- **Server Credentials**: Store server-specific credentials for secure authentication.

- **Active Profiles**: Enable or disable profiles for specific build configurations.

- **Remote Repositories**: Specify additional remote repositories for dependencies.

## Conclusion

Maven is a powerful tool that can simplify the build and dependency management process for Java projects. By
understanding its core concepts, you can effectively manage your project's dependencies, plugins, and build process.