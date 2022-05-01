# MyBatis PostgreSQL TypeHandlers

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.onozaty/mybatis-postgresql-typehandlers/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.onozaty/mybatis-postgresql-typehandlers)

MyBatis PostgreSQL TypeHandlers is a library for adding TypeHandlers for PostgreSQL.  
It provides the following TypeHandlers.

|TypeHandler           |Java type      |PostgreSQL column type |
|----------------------|---------------|-----------------------|
|PgEnumTypeHandler     |`enum`         |`enum`                 |
|JsonTypeHandler       |`Object`       |`jsonb`                |
|StringListTypeHandler |`List<String>` |`text[]`               |
|BooleanListTypeHandler|`List<Boolean>`|`boolean[]`            |
|ShortListTypeHandler  |`List<Short>`  |`smallint[]`           |
|IntegerListTypeHandler|`List<Integer>`|`integer[]`            |
|LongListTypeHandler   |`List<Long>`   |`bigint[]`             |
|FloatListTypeHandler  |`List<Float>`  |`real[]`               |
|DoubleListTypeHandler |`List<Double>` |`double precision[]`   |

## Setup

MyBatis PostgreSQL TypeHandlers is published on Maven Central.  
It is available simply by adding it to a dependency.

### maven

```xml
<dependency>
    <groupId>com.github.onozaty</groupId>
    <artifactId>mybatis-postgresql-typehandlers</artifactId>
    <version>1.0.0</version>
</dependency>
```

### Gradle

```groovy
implementation 'com.github.onozaty:mybatis-postgresql-typehandlers:1.0.0'
```

## License

[Apache License, Version 2\.0](https://www.apache.org/licenses/LICENSE-2.0)

## Author

[onozaty](https://github.com/onozaty)

