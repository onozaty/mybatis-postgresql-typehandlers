package com.enjoyxstudy.mybatis.postgresql.typehandler.list;

/**
 * @author onozaty
 */
public class ShortListTypeHandler extends ListTypeHandler<Short> {

    public ShortListTypeHandler() {
        super("int2");
    }
}
