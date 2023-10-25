# code-learning-hub-bom

BOM stands for Bill Of Materials. A BOM is a special kind of POM that is used to control the versions of a project’s
dependencies and provide a central place to define and update those versions.

BOM provides the flexibility to add a dependency to our module without worrying about the version that we should depend
on.

BOM can be inherited as a parent, in this case we inherit both dependencyManagement and pluginManagement sections.

e.g.

    <parent>
        <groupId>com.bastex</groupId>
        <artifactId>code-learning-hub-bom</artifactId>
        <version>0.0.1-SNAPSHOT</version>
        <relativePath>code-learning-hub-bom/pom.xml</relativePath>
    </parent>

Or it can be imported, in which case we transfer only dependencyManagement section:

    <dependency>
        <groupId>com.bastex</groupId>
        <artifactId>code-learning-hub-bom</artifactId>
        <version>0.0.1-SNAPSHOT</version>
        <type>pom</type>
        <scope>import</scope>
    </dependency>>