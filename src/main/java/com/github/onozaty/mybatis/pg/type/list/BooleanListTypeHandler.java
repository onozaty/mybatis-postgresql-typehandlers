package com.github.onozaty.mybatis.pg.type.list;

/**
 * @author onozaty
 */
public class BooleanListTypeHandler extends ListTypeHandler<Boolean> {

    public BooleanListTypeHandler() {
        super("boolean");
    }
}
