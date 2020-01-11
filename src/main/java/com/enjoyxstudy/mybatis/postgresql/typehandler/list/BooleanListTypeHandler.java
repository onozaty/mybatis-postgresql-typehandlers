package com.enjoyxstudy.mybatis.postgresql.typehandler.list;

/**
 * @author onozaty
 */
public class BooleanListTypeHandler extends ListTypeHandler<Boolean> {

    public BooleanListTypeHandler() {
        super("bool");
    }
}
