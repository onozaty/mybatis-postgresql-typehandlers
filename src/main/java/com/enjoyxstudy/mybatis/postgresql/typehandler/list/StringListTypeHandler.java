package com.enjoyxstudy.mybatis.postgresql.typehandler.list;

/**
 * @author onozaty
 */
public class StringListTypeHandler extends ListTypeHandler<String> {

    public StringListTypeHandler() {
        super("text");
    }
}
