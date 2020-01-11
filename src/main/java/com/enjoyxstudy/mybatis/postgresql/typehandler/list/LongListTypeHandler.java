package com.enjoyxstudy.mybatis.postgresql.typehandler.list;

/**
 * @author onozaty
 */
public class LongListTypeHandler extends ListTypeHandler<Long> {

    public LongListTypeHandler() {
        super("int8");
    }
}
