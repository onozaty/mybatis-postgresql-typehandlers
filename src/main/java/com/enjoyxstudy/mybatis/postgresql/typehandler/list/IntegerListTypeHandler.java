package com.enjoyxstudy.mybatis.postgresql.typehandler.list;

/**
 * @author onozaty
 */
public class IntegerListTypeHandler extends ListTypeHandler<Integer> {

    public IntegerListTypeHandler() {
        super("int4");
    }
}
