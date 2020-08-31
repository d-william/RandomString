# RandomString
Generate random String in Java

## Usage
Generate String objects of length 8 containing a-z, A-Z and 0-9 character :
```java
RandomString random = new RandomString();
String string = random.nextString();
```

Generate String objects of length 16 containing a, b , c and d character :
```java
RandomString random = new RandomString(16, "abcd");
String string = random.nextString();
```

## Maven
### Repository
File: <i>pom.xml</i>
```Xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```
### Dependency
File: <i>pom.xml</i>
```Xml
<dependency>
    <groupId>com.github.d-william</groupId>
    <artifactId>commons-string-generator</artifactId>
    <version>2.0.0</version>
</dependency>
```
