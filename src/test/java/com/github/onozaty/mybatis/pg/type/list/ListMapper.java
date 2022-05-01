package com.github.onozaty.mybatis.pg.type.list;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author onozaty
 */
public interface ListMapper {

    @Update("CREATE TEMP TABLE list_records ("
            + "id integer, "
            + "booleans boolean[], "
            + "shorts smallint[], "
            + "integers integer[], "
            + "longs bigint[], "
            + "floats real[], "
            + "doubles double precision[], "
            + "strings text[])")
    void createTable();

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

    @Update("DROP TABLE list_records")
    void dropTable();
}
