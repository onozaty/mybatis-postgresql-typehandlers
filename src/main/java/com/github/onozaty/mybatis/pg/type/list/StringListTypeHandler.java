package com.github.onozaty.mybatis.pg.type.list;

/**
 * @author onozaty
 */
public class StringListTypeHandler extends ListTypeHandler<String> {

    public StringListTypeHandler() {
        super("text");
    }
}
