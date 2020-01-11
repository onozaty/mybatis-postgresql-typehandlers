package com.enjoyxstudy.mybatis.postgresql.typehandler.list;

/**
 * @author onozaty
 */
public class DoubleListTypeHandler extends ListTypeHandler<Double> {

    public DoubleListTypeHandler() {
        super("float8");
    }
}
