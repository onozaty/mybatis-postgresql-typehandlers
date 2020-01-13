package com.enjoyxstudy.mybatis.postgresql.typehandler.list;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author onozaty
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ListRecord {

    private int id;

    private List<Boolean> booleans;

    private List<Short> shorts;

    private List<Integer> integers;

    private List<Long> longs;

    private List<Float> floats;

    private List<Double> doubles;

    private List<String> strings;
}
