package com.enjoyxstudy.mybatis.postgresql.typehandler.list;

/**
 * @author onozaty
 */
public class FloatListTypeHandler extends ListTypeHandler<Float> {

    public FloatListTypeHandler() {
        super("float4");
    }
}
