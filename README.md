maven依赖第三方jar包引用的几种方式

1.上传到maven私服

2. install到本地

3. 使用localrepository

```
mvn deploy:deploy-file -Durl=file://${basedir}/lib/ -Dfile=C:\Users\22696\Desktop\demo-0.0.1
-SNAPSHOT.jar -DartifactId=demo -Dpackaging=jar -Dversion=0.0.1-SNAPSHOT -DgroupId=com.example

```

* pom.xml中引用

```xml

<repositories>
    <repository>
        <id>my-local-repo</id>
        <name>My Repository</name>
        <url>file://${basedir}/lib/</url>
        <releases>
            <enabled>true</enabled>
            <updatePolicy>always</updatePolicy>
            <checksumPolicy>warn</checksumPolicy>
        </releases>
    </repository>
</repositories>
```

* 依赖

```xml

<dependency>
    <groupId>com.example</groupId>
    <artifactId>demo</artifactId>
    <version>1.0</version>
</dependency>
```

4 jar包放入lib目录下,工程中直接添加依赖

```xml

<dependency>
    <groupId>com.example</groupId>
    <artifactId>demo</artifactId>
    <version>1.0</version>
    <systemPath>${basedir}/lib/demo-0.0.1-SNAPSHOT.jar</systemPath>
    <scope>system</scope>
</dependency>
```

5 可以使用site-maven-plugin在github上搭建公有仓库

* 参考 https://segmentfault.com/a/1190000022756193