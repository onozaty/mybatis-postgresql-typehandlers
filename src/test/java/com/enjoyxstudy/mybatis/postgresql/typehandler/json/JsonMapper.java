package com.enjoyxstudy.mybatis.postgresql.typehandler.json;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author onozaty
 */
public interface JsonMapper {

    @Update("CREATE TEMP TABLE json_records (id integer, json JSONB)")
    void createTable();

    @Insert("INSERT INTO json_records (id, json) VALUES (#{id}, #{json})")
    void insert(JsonRecord user);

    @Select("SELECT * FROM json_records")
    JsonRecord select();

    @Update("DROP TABLE json_records")
    void dropTable();
}
