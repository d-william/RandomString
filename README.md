# RandomString
Generate random String in Java

## Usage
Generate String of length 8 containing a-z, A-Z and 0-9 character :
```java
RandomString random = new RandomString();
String string = random.nextString();
```

Generate String of length 16 containing a, b , c and d character :
```java
RandomString random = new RandomString(16, "abcd");
String string = random.nextString();
```
