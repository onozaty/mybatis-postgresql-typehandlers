package com.enjoyxstudy.mybatis.postgresql.typehandler.json;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author onozaty
 */
public interface JsonMapper {

    @Update("CREATE TEMP TABLE users (id integer, name text, other JSONB)")
    void createTable();

    @Insert("INSERT INTO users (id, name, other) VALUES (#{id}, #{name}, #{other})")
    void insert(User user);

    @Select("SELECT * FROM users")
    User select();

    @Update("DROP TABLE users")
    void dropTable();
}
