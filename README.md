# MyBatis PostgreSQL TypeHandlers

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.onozaty/mybatis-postgresql-typehandlers/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.onozaty/mybatis-postgresql-typehandlers)

MyBatis PostgreSQL TypeHandlers is a library for adding TypeHandlers for PostgreSQL.  
It provides the following TypeHandlers.

|TypeHandler                                                     |Java type      |PostgreSQL column type |
|----------------------------------------------------------------|---------------|-----------------------|
|`com.github.onozaty.mybatis.pg.type.pgenum.PgEnumTypeHandler`   |`enum`         |`enum`                 |
|`com.github.onozaty.mybatis.pg.type.json.JsonTypeHandler`       |`Object`       |`jsonb`                |
|`com.github.onozaty.mybatis.pg.type.list.StringListTypeHandler` |`List<String>` |`text[]`               |
|`com.github.onozaty.mybatis.pg.type.list.BooleanListTypeHandler`|`List<Boolean>`|`boolean[]`            |
|`com.github.onozaty.mybatis.pg.type.list.ShortListTypeHandler`  |`List<Short>`  |`smallint[]`           |
|`com.github.onozaty.mybatis.pg.type.list.IntegerListTypeHandler`|`List<Integer>`|`integer[]`            |
|`com.github.onozaty.mybatis.pg.type.list.LongListTypeHandler`   |`List<Long>`   |`bigint[]`             |
|`com.github.onozaty.mybatis.pg.type.list.FloatListTypeHandler`  |`List<Float>`  |`real[]`               |
|`com.github.onozaty.mybatis.pg.type.list.DoubleListTypeHandler` |`List<Double>` |`double precision[]`   |

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

