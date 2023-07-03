package com.ppl.sqltrans.service;

import net.sf.jsqlparser.statement.select.PlainSelect;

/**
 * Created by pisiliang on 2023/6/30 10:37
 */
public interface TransToSqlService {


    String toSql(PlainSelect plainSelect);


    String toSql2();
}
