# MyBatis PostgreSQL TypeHandlers

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.onozaty/mybatis-postgresql-typehandlers/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.onozaty/mybatis-postgresql-typehandlers)

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
    <version>1.0.1</version>
</dependency>
```

### Gradle

```groovy
implementation 'com.github.onozaty:mybatis-postgresql-typehandlers:1.0.1'
```

## ライセンス

[Apache License, Version 2\.0](https://www.apache.org/licenses/LICENSE-2.0)

## 作者

[onozaty](https://github.com/onozaty)
