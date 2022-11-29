package com.zkb.springredisstudy.mysql.mvcc;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Table {

    private int row_id;

    private int delete_bit;

    private int trx_id;

    private String roll_ptr;
}
