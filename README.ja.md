# MyBatis PostgreSQL TypeHandlers

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.onozaty/mybatis-postgresql-typehandlers/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.onozaty/mybatis-postgresql-typehandlers)

MyBatis PostgreSQL TypeHandlers は、PostgreSQL向けのTypeHandlerを追加するライブラリです。  
下記のTypeHandlerを提供します。

|TypeHandler           |Javaでの型     |PostgreSQLでの型    |
|----------------------|---------------|--------------------|
|PgEnumTypeHandler     |`enum`         |`enum`              |
|JsonTypeHandler       |`Object`       |`jsonb`             |
|StringListTypeHandler |`List<String>` |`text[]`            |
|BooleanListTypeHandler|`List<Boolean>`|`boolean[]`         |
|ShortListTypeHandler  |`List<Short>`  |`smallint[]`        |
|IntegerListTypeHandler|`List<Integer>`|`integer[]`         |
|LongListTypeHandler   |`List<Long>`   |`bigint[]`          |
|FloatListTypeHandler  |`List<Float>`  |`real[]`            |
|DoubleListTypeHandler |`List<Double>` |`double precision[]`|

## セットアップ

MyBatis PostgreSQL TypeHandlers は Maven Central で公開しています。  
依存関係に追加するだけで利用可能です。

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

## ライセンス

[Apache License, Version 2\.0](https://www.apache.org/licenses/LICENSE-2.0)

## 作者

[onozaty](https://github.com/onozaty)
