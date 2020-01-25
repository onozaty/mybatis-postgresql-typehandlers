package com.enjoyxstudy.mybatis.postgresql.typehandler.pgenum;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author onozaty
 */
public interface PgEnumMapper {

    @Update({
            "CREATE TYPE day AS ENUM ('SUNDAY', 'MONDAY', 'TUESDAY', 'WEDNESDAY', 'THURSDAY', 'FRIDAY', 'SATURDAY');",
            "CREATE TEMP TABLE pgenum_records (id integer, day day);"
    })
    void createTable();

    @Insert("INSERT INTO pgenum_records (id, day) VALUES (#{id}, #{day})")
    void insert(PgEnumRecord record);

    @Select("SELECT * FROM pgenum_records")
    PgEnumRecord select();

    @Update({
            "DROP TABLE pgenum_records;",
            "DROP TYPE day;"
    })
    void dropTable();
}
