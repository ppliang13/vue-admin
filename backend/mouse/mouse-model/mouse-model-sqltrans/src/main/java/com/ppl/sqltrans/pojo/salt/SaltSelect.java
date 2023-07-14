package com.ppl.sqltrans.pojo.salt;


import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.experimental.Accessors;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;

/**
 * salt select 查询
 * Created by pisiliang on 2023/7/10 9:25
 */
@Data
@Accessors(chain = true)
public class SaltSelect {
    private boolean encrypt;

    private String selectColumn;

    private String fromTable;

    private String whereCondition;


    private String groupBy;

    private String havingCondition;

    private String orderBy;

    private Integer limit;

    private Integer offset;

    /**
     * 对象加密
     * @return SaltSelect
     */
    public SaltSelect encrypt() {
        if (encrypt) {
            return this;
        }
        this.selectColumn = EncryptionSelectSql.encrypt(this.selectColumn);
        this.fromTable = EncryptionSelectSql.encrypt(this.fromTable);
        this.whereCondition = EncryptionSelectSql.encrypt(this.whereCondition);
        this.groupBy = EncryptionSelectSql.encrypt(this.groupBy);
        this.havingCondition = EncryptionSelectSql.encrypt(this.havingCondition);
        this.orderBy = EncryptionSelectSql.encrypt(this.orderBy);
        this.encrypt = true;
        return this;
    }



    /**
     * 对象解密
     * @return SaltSelect
     */
    public SaltSelect decrypt() {
        if (!encrypt) {
            return this;
        }
        this.selectColumn = EncryptionSelectSql.decrypt(this.selectColumn);
        this.fromTable = EncryptionSelectSql.decrypt(this.fromTable);
        this.whereCondition = EncryptionSelectSql.decrypt(this.whereCondition);
        this.groupBy = EncryptionSelectSql.decrypt(this.groupBy);
        this.havingCondition = EncryptionSelectSql.decrypt(this.havingCondition);
        this.orderBy = EncryptionSelectSql.decrypt(this.orderBy);
        this.encrypt = false;
        return this;
    }

    /**
     * 获取解密后的sql
     * @return SaltSelect
     */
    public String sql() {
        if (encrypt) {
            decrypt();
        }
        if (StrUtil.isBlank(this.selectColumn)) {
            this.selectColumn = "*";
        }
        String sql = "SELECT " + this.selectColumn + " FROM " + this.fromTable;

        if (StrUtil.isNotBlank(this.whereCondition)) {
            sql += " WHERE " + this.whereCondition;
        }
        if (StrUtil.isNotBlank(this.groupBy)) {
            sql += " GROUP BY " + this.groupBy;
        }
        if (StrUtil.isNotBlank(this.havingCondition)) {
            sql += " HAVING " + this.havingCondition;
        }
        if (StrUtil.isNotBlank(this.orderBy)) {
            sql += " ORDER BY " + this.orderBy;
        }
        if (this.limit>0) {
            sql += " LIMIT " + this.limit;
        }
        if (this.offset>0) {
            sql += " OFFSET " + this.offset;
        }

        if (!checkSql(sql)) {
            return "sql error: "+sql;
        }
        return sql;
    }

    /**
     * 检查sql是否合法 符合查询
     * @param sql sql
     * @return boolean
     */
    private boolean checkSql(String sql) {
        if (StrUtil.isBlank(sql)) {
            return false;
        }
        String[] NOT_ALLOW = {"DELETE", "UPDATE", "DROP", "INSERT", "ALTER", "CREATE", "TRUNCATE"};

        sql = sql.toUpperCase();
        String[] split = sql.split(" ");
        for (String s : split) {
            for (String s1 : NOT_ALLOW) {
                if (s1.equals(s)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkValidSQL() {
        String sql = sql();
        try {
            Statement statement = CCJSqlParserUtil.parse(sql);
            return true;
        } catch (JSQLParserException e) {
            System.out.println("sql error: "+sql);
            return false;
        }
    }

    /**
     * 分页 页码从1开始
     * @param pageNo 页码 默认值  1
     * @param pageSize 每页条数 默认值 10
     */
    public void pageInfo(Integer pageNo, Integer pageSize) {
        if(pageNo == null || pageNo < 1) {
            pageNo = 1;
        }
        if(pageSize == null || pageSize < 1) {
            pageSize = 10;
        }
        this.limit = pageSize;
        this.offset = (pageNo - 1) * pageSize;
    }

    public static void main(String[] args) {
        SaltSelect saltSelect = new SaltSelect().setFromTable("select_keyword_view");

        String jsonString = JSON.toJSONString(saltSelect.encrypt());
        System.out.println("jsonString = " + jsonString);
    }
}
