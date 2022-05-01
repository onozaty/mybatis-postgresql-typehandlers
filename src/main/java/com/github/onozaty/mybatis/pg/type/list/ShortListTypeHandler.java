package com.github.onozaty.mybatis.pg.type.list;

/**
 * @author onozaty
 */
public class ShortListTypeHandler extends ListTypeHandler<Short> {

    public ShortListTypeHandler() {
        super("int2");
    }
}
