package com.enjoyxstudy.mybatis.postgresql.typehandler.json;

import lombok.Value;

/**
 * @author onozaty
 */
@Value
public class User {

    private final int id;

    private final String name;

    private final Other other;
}
