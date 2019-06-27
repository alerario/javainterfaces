https://dzone.com/articles/using-github-as-maven-repository


inserir no pom.xml do projeto
<repositories>
    <repository>
        <id>mvn-repo</id>
        <url>https://github.com/alerario/javainterfaces</url>
        <releases>
            <enabled>true</enabled>
        </releases>
        <snapshots>
            <enabled>true</enabled>
        </snapshots>
    </repository>
</repositories>

  <dependencies>
        <dependency>
            <groupId>${project.groupId}</groupId>
            <artifactId>javainterfaces</artifactId>
            <version>${project.version}</version>
        </dependency>
    </dependencies>
