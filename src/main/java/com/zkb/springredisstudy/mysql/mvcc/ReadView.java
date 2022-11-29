package com.zkb.springredisstudy.mysql.mvcc;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@AllArgsConstructor
@Data
public class ReadView {

    private int creator_trx_id;

    private Set<Integer> trx_ids;

    private int up_limit_id;

    private int low_limit_id;
}
