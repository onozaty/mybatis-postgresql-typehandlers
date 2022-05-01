package com.github.onozaty.mybatis.pg.type.list;

/**
 * @author onozaty
 */
public class FloatListTypeHandler extends ListTypeHandler<Float> {

    public FloatListTypeHandler() {
        super("float4");
    }
}
