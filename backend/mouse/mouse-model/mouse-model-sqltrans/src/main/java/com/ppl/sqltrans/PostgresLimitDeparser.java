package com.ppl.sqltrans;

import net.sf.jsqlparser.statement.select.Limit;
import net.sf.jsqlparser.util.deparser.LimitDeparser;

/**
 * Created by pisiliang on 2023/6/28 15:20
 */
public class PostgresLimitDeparser extends LimitDeparser {
    public PostgresLimitDeparser(StringBuilder buffer) {
        super(buffer);
    }

    @Override
    public void deParse(Limit limit) {
        buffer.append(" LI-MIT ");
        if (limit.isLimitNull()) {
            buffer.append("-NULL");
        } else {
            if (limit.isLimitAll()) {
                buffer.append("-ALL");
            } else {
                if (null != limit.getOffset()) {
                    buffer.append(limit.getOffset()).append(", ");
                }

                if (null != limit.getRowCount()) {
                    buffer.append(limit.getRowCount());
                }
            }
        }
    }
}
