# MyBatis PostgreSQL TypeHandlers

[![GitHub license](https://img.shields.io/github/license/onozaty/mybatis-postgresql-typehandlers)](https://github.com/onozaty/mybatis-postgresql-typehandlers/blob/master/LICENSE)
[![Test](https://github.com/onozaty/mybatis-postgresql-typehandlers/actions/workflows/test.yaml/badge.svg)](https://github.com/onozaty/mybatis-postgresql-typehandlers/actions/workflows/test.yaml)
[![Maven Central](https://img.shields.io/maven-central/v/com.github.onozaty/mybatis-postgresql-typehandlers?logo=apachemaven&logoColor=red)](https://maven-badges.herokuapp.com/maven-central/com.github.onozaty/mybatis-postgresql-typehandlers)

MyBatis PostgreSQL TypeHandlers は、PostgreSQL向けのTypeHandlerを追加するライブラリです。  
下記のTypeHandlerを提供します。

|TypeHandler                                                     |Javaでの型     |PostgreSQLでのカラム型|
|----------------------------------------------------------------|---------------|----------------------|
|`com.github.onozaty.mybatis.pg.type.pgenum.PgEnumTypeHandler`   |`enum`         |`enum`                |
|`com.github.onozaty.mybatis.pg.type.json.JsonTypeHandler`       |`Object`       |`jsonb`               |
|`com.github.onozaty.mybatis.pg.type.list.StringListTypeHandler` |`List<String>` |`text[]`              |
|`com.github.onozaty.mybatis.pg.type.list.BooleanListTypeHandler`|`List<Boolean>`|`boolean[]`           |
|`com.github.onozaty.mybatis.pg.type.list.ShortListTypeHandler`  |`List<Short>`  |`smallint[]`          |
|`com.github.onozaty.mybatis.pg.type.list.IntegerListTypeHandler`|`List<Integer>`|`integer[]`           |
|`com.github.onozaty.mybatis.pg.type.list.LongListTypeHandler`   |`List<Long>`   |`bigint[]`            |
|`com.github.onozaty.mybatis.pg.type.list.FloatListTypeHandler`  |`List<Float>`  |`real[]`              |
|`com.github.onozaty.mybatis.pg.type.list.DoubleListTypeHandler` |`List<Double>` |`double precision[]`  |

## セットアップ

MyBatis PostgreSQL TypeHandlers は Maven Central で公開しています。  
依存関係に追加するだけで利用可能です。

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

## 利用方法

### PgEnumTypeHandler

`defaultEnumTypeHandler`として指定することで、Javaのenumで`PgEnumTypeHandler`が利用されるようになります。

`mybatis-config.xml`で設定する場合、下記のように書きます。

```xml
  <settings>
    <setting name="defaultEnumTypeHandler" value="com.github.onozaty.mybatis.pg.type.pgenum.PgEnumTypeHandler"/>
  </settings>
```

Spring Boot で利用する場合、`application.properties` の `mybatis.configuration.default-enum-type-handler` で指定します。

```
mybatis.configuration.default-enum-type-handler=com.github.onozaty.mybatis.pg.type.pgenum.PgEnumTypeHandler
```

### JsonTypeHandler

JSONとして格納したいクラスとのマッピングを`typeHandler`として定義します。

`mybatis-config.xml`で設定する場合、下記のように書きます。

```xml
  <typeHandlers>
    <typeHandler handler="com.github.onozaty.mybatis.pg.type.json.JsonTypeHandler" javaType="com.github.onozaty.mybatis.pg.type.json.JsonData" />
  </typeHandlers>
```

Spring Boot で利用する場合、`org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer` を利用して設定します。

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

ListTypeHandlerの各サブクラスは、ジェネリクス型を扱うため、型情報からのマッピングが定義できません。  
エイリアスを定義しておき、SQLで明示的にマッピングを記載することになります。

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

エイリアスを`mybatis-config.xml`で設定する場合、下記のように書きます。

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

Spring Boot で利用する場合、`application.properties` の `mybatis.type-aliases-package` で指定パッケージ配下のクラスのエイリアスを定義できます。

```
mybatis.type-aliases-package=com.github.onozaty.mybatis.pg.type.list
```

## ライセンス

[Apache License, Version 2\.0](https://www.apache.org/licenses/LICENSE-2.0)

## 作者

[onozaty](https://github.com/onozaty)
