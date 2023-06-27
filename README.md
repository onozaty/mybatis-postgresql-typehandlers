# MyBatis PostgreSQL TypeHandlers

[![GitHub license](https://img.shields.io/github/license/onozaty/mybatis-postgresql-typehandlers)](https://github.com/onozaty/mybatis-postgresql-typehandlers/blob/master/LICENSE)
[![Test](https://github.com/onozaty/mybatis-postgresql-typehandlers/actions/workflows/test.yaml/badge.svg)](https://github.com/onozaty/mybatis-postgresql-typehandlers/actions/workflows/test.yaml)
[![Maven Central](https://img.shields.io/maven-central/v/com.github.onozaty/mybatis-postgresql-typehandlers?logo=apachemaven&logoColor=red)](https://maven-badges.herokuapp.com/maven-central/com.github.onozaty/mybatis-postgresql-typehandlers)

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
    <version>1.0.2</version>
</dependency>
```

### Gradle

```groovy
implementation 'com.github.onozaty:mybatis-postgresql-typehandlers:1.0.2'
```

## Usage

### PgEnumTypeHandler

By specifying it in `defaultEnumTypeHandler`, `PgEnumTypeHandler` will be used in Java enum.

To set it in `mybatis-config.xml`, write as follows.

```xml
  <settings>
    <setting name="defaultEnumTypeHandler" value="com.github.onozaty.mybatis.pg.type.pgenum.PgEnumTypeHandler"/>
  </settings>
```

When used with Spring Boot, this is specified in `mybatis.configuration.default-enum-type-handler` in `application.properties`.

```
mybatis.configuration.default-enum-type-handler=com.github.onozaty.mybatis.pg.type.pgenum.PgEnumTypeHandler
```

### JsonTypeHandler

Define a mapping to the class you want to store as JSON as a `typeHandler`.

To set it in `mybatis-config.xml`, write as follows.

```xml
  <typeHandlers>
    <typeHandler handler="com.github.onozaty.mybatis.pg.type.json.JsonTypeHandler" javaType="com.github.onozaty.mybatis.pg.type.json.JsonData" />
  </typeHandlers>
```

When used with Spring Boot, it is configured using `org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer`.

```java
package com.github.onozaty.mybatis.pg.example;

import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.onozaty.mybatis.pg.example.domain.JsonData;
import com.github.onozaty.mybatis.pg.type.json.JsonTypeHandler;

@Configuration
public class MyBatisConfiguration {

    @Bean
    ConfigurationCustomizer mybatisConfigurationCustomizer() {
        return (configuration) -> {
            configuration.getTypeHandlerRegistry().register(JsonData.class, JsonTypeHandler.class);
        };
    }
}
```

### ListTypeHandler

Each subclass of ListTypeHandler handles generics types, so mapping from type information cannot be defined.  
You will have to define an alias and explicitly describe the mapping in SQL.

```java
public interface ListMapper {

    @Insert("INSERT INTO list_records (id, booleans, shorts, integers, longs, floats, doubles, strings)"
            + " VALUES ("
            + "#{id}, "
            + "#{booleans, typeHandler=booleanListTypeHandler}, "
            + "#{shorts, typeHandler=shortListTypeHandler}, "
            + "#{integers, typeHandler=integerListTypeHandler}, "
            + "#{longs, typeHandler=longListTypeHandler}, "
            + "#{floats, typeHandler=floatListTypeHandler}, "
            + "#{doubles, typeHandler=doubleListTypeHandler}, "
            + "#{strings, typeHandler=stringListTypeHandler})")
    void insert(ListRecord record);

    @Results({
            @Result(property = "booleans", column = "booleans", typeHandler = BooleanListTypeHandler.class),
            @Result(property = "shorts", column = "shorts", typeHandler = ShortListTypeHandler.class),
            @Result(property = "integers", column = "integers", typeHandler = IntegerListTypeHandler.class),
            @Result(property = "longs", column = "longs", typeHandler = LongListTypeHandler.class),
            @Result(property = "floats", column = "floats", typeHandler = FloatListTypeHandler.class),
            @Result(property = "doubles", column = "doubles", typeHandler = DoubleListTypeHandler.class),
            @Result(property = "strings", column = "strings", typeHandler = StringListTypeHandler.class)
    })
    @Select("SELECT * FROM list_records")
    ListRecord select();
}
```

To set the alias in `mybatis-config.xml`, write as follows.

```xml
  <typeAliases>
    <typeAlias alias="booleanListTypeHandler" type="com.github.onozaty.mybatis.pg.type.list.BooleanListTypeHandler" />
    <typeAlias alias="shortListTypeHandler" type="com.github.onozaty.mybatis.pg.type.list.ShortListTypeHandler" />
    <typeAlias alias="integerListTypeHandler" type="com.github.onozaty.mybatis.pg.type.list.IntegerListTypeHandler" />
    <typeAlias alias="longListTypeHandler" type="com.github.onozaty.mybatis.pg.type.list.LongListTypeHandler" />
    <typeAlias alias="floatListTypeHandler" type="com.github.onozaty.mybatis.pg.type.list.FloatListTypeHandler" />
    <typeAlias alias="doubleListTypeHandler" type="com.github.onozaty.mybatis.pg.type.list.DoubleListTypeHandler" />
    <typeAlias alias="stringListTypeHandler" type="com.github.onozaty.mybatis.pg.type.list.StringListTypeHandler" />
  </typeAliases>
```

When using Spring Boot, you can define aliases for classes under the specified package in `mybatis.type-aliases-package` in `application.properties`.

```
mybatis.type-aliases-package=com.github.onozaty.mybatis.pg.type.list
```

## License

[Apache License, Version 2\.0](https://www.apache.org/licenses/LICENSE-2.0)

## Author

[onozaty](https://github.com/onozaty)

