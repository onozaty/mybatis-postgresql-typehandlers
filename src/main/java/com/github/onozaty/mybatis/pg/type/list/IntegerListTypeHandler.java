package com.github.onozaty.mybatis.pg.type.list;

/**
 * @author onozaty
 */
public class IntegerListTypeHandler extends ListTypeHandler<Integer> {

    public IntegerListTypeHandler() {
        super("int4");
    }
}
