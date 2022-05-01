package com.github.onozaty.mybatis.pg.type.pgenum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author onozaty
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PgEnumRecord {

    private int id;

    private Day day;
}
