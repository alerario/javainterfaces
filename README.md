https://gist.github.com/fernandezpablo85/03cf8b0cd2e7d8527063



Skip to content
All gists
Back to GitHub
@alerario
@fernandezpablo85 fernandezpablo85/git-maven-howto.md
Last active 8 days ago •

80

    18

Code
Revisions 2
Stars 80
Forks 18
how to create your own maven repository on github
git-maven-howto.md
How to create a maven repository for your github project step by step
Clone your project in a separate folder

(note: replace ORGANIZATION and PROJECT)

git clone git clone git@github.com:ORGANIZATION/PROJECT.git my-repository
Cd into it

cd my-repository
Create a new branch (here named repository)

git branch repository
Switch to that branch

git checkout repository
Remove all files

rm -rf file1 file2 file3 .. etc
Install your jar in that directory

(note: replace YOUR_GROUP, YOUR_ARTIFACT, YOUR_VERSION and YOUR_JAR_FILE)

mvn install:install-file -DgroupId=YOUR_GROUP -DartifactId=YOUR_ARTIFACT -Dversion=YOUR_VERSION -Dfile=YOUR_JAR_FILE -Dpackaging=jar -DgeneratePom=true -DlocalRepositoryPath=.  -DcreateChecksum=true

YOUR_JAR_FILE should point to an existent jar file, this is why it's best to create your repository branch in a different folder, so you can reference the existing jar in /your/project/path/target/artifact-x.y.z.jar
Add all generated files, commit and push

git add -A . && git commit -m "released version X.Y.Z"

git push origin repository
Reference your jar from a different project

The repository url you just created is https://raw.github.com/YOUR_ORGANIZATION/YOUR_ARTIFACT/repository/
@EsikAntony
EsikAntony commented on 12 Oct 2017

Thank you for your instruction.
But in present time at last step you should use URL: https://github.com/YOUR_ORGANIZATION/YOUR_PROJECT/raw/repository.
And it's more correct to use existing POM (if you have it) instead of generated, just set -DpomFile=YOUR_POM_FILE_FULL_NAME in install:install-file params instead of -DgeneratePom=true.
@lubosek
lubosek commented on 8 Nov 2017

This is great! Thanks for the howto.
@jjpe
jjpe commented on 19 Nov 2017

This explanation is short, to the point, and most of all, it works. So thanks for this +1 +1
@kuzeko
kuzeko commented on 28 Nov 2017

Thanks a lot! Great tutorial!

@EsikAntony where can I read more about why use ' -DpomFile=YOUR_POM_FILE_FULL_NAME' and what exactly is POM_FILE_FULL_NAME'?

Also, how do I update the pom of another project in order to use this repository?
@hervinhio
hervinhio commented on 14 Dec 2017

Thank you very much for this useful post.
However, I got one question, how do I define dependencies on other artifacts ?
@cap5lut
cap5lut commented on 28 Dec 2017 •

Thanks for the small, but on point, tutorial!

@kuzeko

    And it's more correct to use existing POM (if you have it) instead of generated

Basically your artifact will have it's own pom.xml, there you set up the specific details for it. With the -DgeneratePom=true you would let maven generate one for you, which can't totally configure your artifact by itself.

@hervinhio
Dependencies for other artifacts are defined in the pom.xml of your artifact. For further information, read the maven manual.
@Tianhao25
Tianhao25 commented on 17 Jan 2018 •

Thanks!
This is a perfect howto I am always expecting.

It's clear and it works!
@n0mer
n0mer commented on 19 Feb 2018 •

@fernandezpablo85 will it work with private repositories?

Here are some options how to achieve this: https://stackoverflow.com/questions/18126559/how-can-i-download-a-single-raw-file-from-a-private-github-repo-using-the-comman
@crearo
crearo commented on 11 Jul 2018

How do I create the pom.xml? The one generated after ./gradlew assembleRelease isn't being accepted by mvn.
@bvandenbon
bvandenbon commented on 28 Jul 2018

worked the first time, but there was a mistake in my release, and I re-released the same version. Now the pom fill that uses/downloads this repository no longer finds it. (although it worked fine the first time).
@Pythonic-Rainbow
Pythonic-Rainbow commented on 3 Aug 2018 •

@bvandenbon how do u make it work

EDIT: I figured it out
Maven URL should be http://raw.github.com/ORGANIZATION/REPO/BRANCH
@sreenivasb1988
sreenivasb1988 commented 21 days ago •

For accessing the private repository during maven build, add the following in the maven settings.xml

<servers>
    <server>
      <id>private-repo</id>
	   <configuration>
        <httpHeaders>
          <property>
            <name>Authorization</name>
            <!-- Base64-encoded username:access_token -->
            <value>Basic {Place the token here}</value>
          </property>
        </httpHeaders>
      </configuration>
    </server>
</server>

<repositories>
      <repository>
                    <id>private-repo</id>
                    `<name>Private` Repository</name>
                    <url>{Place the RAW github url here}</url>
                    <releases>
                        <enabled>true</enabled>
                        <updatePolicy>never</updatePolicy>
                    </releases>
                    <snapshots>
                        <enabled>false</enabled>
                    </snapshots>
       </repository>
</repositories>

@alerario

Attach files by dragging & dropping, selecting or pasting them.

    © 2019 GitHub, Inc.
    Terms
    Privacy
    Security
    Status
    Help

    Contact GitHub
    Pricing
    API
    Training
    Blog
    About

