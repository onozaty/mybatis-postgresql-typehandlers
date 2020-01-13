package com.enjoyxstudy.mybatis.postgresql.typehandler.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author onozaty
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonRecord {

    private int id;

    private JsonData json;
}
