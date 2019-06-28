    Para gerar o repositorio local 
    mvn install:install-file -Dfile=../Projeto/jilib/dist/jilib.jar -DgroupId=alerario -DartifactId=javainterfaces -Dversion=1.0 -Dpackaging=jar -DgeneratePom=true -DlocalRepositoryPath=. -DcreateChecksum=true
    
    Após efetuar o push, o pom.xml deve incluir:

   <repositories>
    <repository>
        <id>alerario-repo</id>
        <url>https:///raw.githubusercontent.com/alerario/javainterfaces/master/repositorio</url>
    </repository>
</repositories>

e nas dependencias:

<dependency>
      <groupId>alerario</groupId>
      <artifactId>javainterfaces</artifactId>
      <version>1.0</version>           
 </dependency>
   
   
   
   
   
   
   
   
https://raw.githubusercontent.com/alerario/javainterfaces/master/Projeto/jilib/dist/jilib.jar
