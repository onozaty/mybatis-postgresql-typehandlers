package com.github.onozaty.mybatis.pg.type.list;

/**
 * @author onozaty
 */
public class LongListTypeHandler extends ListTypeHandler<Long> {

    public LongListTypeHandler() {
        super("int8");
    }
}
