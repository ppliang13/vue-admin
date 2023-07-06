package com.ppl.sqltrans.pojo.ps;

import lombok.Data;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.OracleHierarchicalExpression;
import net.sf.jsqlparser.expression.OracleHint;
import net.sf.jsqlparser.expression.WindowDefinition;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.select.*;

import java.util.List;

/**
 * Created by pisiliang on 2023/7/5 11:02
 */
public class MyPlainSelect extends PlainSelect{

    private Distinct distinct = null;
    private List<SelectItem> selectItems;
    private List<Table> intoTables;
    private FromItem fromItem;
    private List<Join> joins;
    private Expression where;
    private GroupByElement groupBy;
    private List<OrderByElement> orderByElements;
    private Expression having;
    private Limit limit;
    private Offset offset;
    private Fetch fetch;
    private OptimizeFor optimizeFor;
    private Skip skip;
    private boolean mySqlHintStraightJoin;
    private First first;
    private Top top;
    private OracleHierarchicalExpression oracleHierarchical = null;
    private OracleHint oracleHint = null;
    private boolean oracleSiblings = false;
    private boolean forUpdate = false;
    private Table forUpdateTable = null;
    private boolean skipLocked;
    private boolean useBrackets = false;
    private Wait wait;
    private boolean mySqlSqlCalcFoundRows = false;
    private MySqlSqlCacheFlags mySqlCacheFlag = null;
    private String forXmlPath;
    private KSQLWindow ksqlWindow = null;
    private boolean noWait = false;
    private boolean emitChanges = false;
    private WithIsolation withIsolation;
    private List<WindowDefinition> windowDefinitions;

    public Distinct getDistinct() {
        return distinct;
    }

    public void setDistinct(Distinct distinct) {
        this.distinct = distinct;
    }

    public List<SelectItem> getSelectItems() {
        return selectItems;
    }

    public void setSelectItems(List<SelectItem> selectItems) {
        this.selectItems = selectItems;
    }

    public List<Table> getIntoTables() {
        return intoTables;
    }

    public void setIntoTables(List<Table> intoTables) {
        this.intoTables = intoTables;
    }

    public FromItem getFromItem() {
        return fromItem;
    }

    public void setFromItem(Object fromItem) {

        this.fromItem = (FromItem)fromItem;
    }

    public List<Join> getJoins() {
        return joins;
    }

    public void setJoins(List<Join> joins) {
        this.joins = joins;
    }

    public Expression getWhere() {
        return where;
    }

    public void setWhere(Expression where) {
        this.where = where;
    }

    public GroupByElement getGroupBy() {
        return groupBy;
    }

    public void setGroupBy(GroupByElement groupBy) {
        this.groupBy = groupBy;
    }

    public List<OrderByElement> getOrderByElements() {
        return orderByElements;
    }

    public void setOrderByElements(List<OrderByElement> orderByElements) {
        this.orderByElements = orderByElements;
    }

    public Expression getHaving() {
        return having;
    }

    public void setHaving(Expression having) {
        this.having = having;
    }

    public Limit getLimit() {
        return limit;
    }

    public void setLimit(Limit limit) {
        this.limit = limit;
    }

    public Offset getOffset() {
        return offset;
    }

    public void setOffset(Offset offset) {
        this.offset = offset;
    }

    public Fetch getFetch() {
        return fetch;
    }

    public void setFetch(Fetch fetch) {
        this.fetch = fetch;
    }

    public OptimizeFor getOptimizeFor() {
        return optimizeFor;
    }

    public void setOptimizeFor(OptimizeFor optimizeFor) {
        this.optimizeFor = optimizeFor;
    }

    public Skip getSkip() {
        return skip;
    }

    public void setSkip(Skip skip) {
        this.skip = skip;
    }

    public boolean isMySqlHintStraightJoin() {
        return mySqlHintStraightJoin;
    }

    public void setMySqlHintStraightJoin(boolean mySqlHintStraightJoin) {
        this.mySqlHintStraightJoin = mySqlHintStraightJoin;
    }

    public First getFirst() {
        return first;
    }

    public void setFirst(First first) {
        this.first = first;
    }

    public Top getTop() {
        return top;
    }

    public void setTop(Top top) {
        this.top = top;
    }

    public OracleHierarchicalExpression getOracleHierarchical() {
        return oracleHierarchical;
    }

    public void setOracleHierarchical(OracleHierarchicalExpression oracleHierarchical) {
        this.oracleHierarchical = oracleHierarchical;
    }

    public OracleHint getOracleHint() {
        return oracleHint;
    }

    public void setOracleHint(OracleHint oracleHint) {
        this.oracleHint = oracleHint;
    }

    public boolean isOracleSiblings() {
        return oracleSiblings;
    }

    public void setOracleSiblings(boolean oracleSiblings) {
        this.oracleSiblings = oracleSiblings;
    }

    public boolean isForUpdate() {
        return forUpdate;
    }

    public void setForUpdate(boolean forUpdate) {
        this.forUpdate = forUpdate;
    }

    public Table getForUpdateTable() {
        return forUpdateTable;
    }

    public void setForUpdateTable(Table forUpdateTable) {
        this.forUpdateTable = forUpdateTable;
    }

    public boolean isSkipLocked() {
        return skipLocked;
    }

    public void setSkipLocked(boolean skipLocked) {
        this.skipLocked = skipLocked;
    }

    public boolean isUseBrackets() {
        return useBrackets;
    }

    public void setUseBrackets(boolean useBrackets) {
        this.useBrackets = useBrackets;
    }

    public Wait getWait() {
        return wait;
    }

    public void setWait(Wait wait) {
        this.wait = wait;
    }

    public boolean isMySqlSqlCalcFoundRows() {
        return mySqlSqlCalcFoundRows;
    }

    public void setMySqlSqlCalcFoundRows(boolean mySqlSqlCalcFoundRows) {
        this.mySqlSqlCalcFoundRows = mySqlSqlCalcFoundRows;
    }

    public MySqlSqlCacheFlags getMySqlCacheFlag() {
        return mySqlCacheFlag;
    }

    public void setMySqlCacheFlag(MySqlSqlCacheFlags mySqlCacheFlag) {
        this.mySqlCacheFlag = mySqlCacheFlag;
    }

    public String getForXmlPath() {
        return forXmlPath;
    }

    public void setForXmlPath(String forXmlPath) {
        this.forXmlPath = forXmlPath;
    }

    public KSQLWindow getKsqlWindow() {
        return ksqlWindow;
    }

    public void setKsqlWindow(KSQLWindow ksqlWindow) {
        this.ksqlWindow = ksqlWindow;
    }

    public boolean isNoWait() {
        return noWait;
    }

    public void setNoWait(boolean noWait) {
        this.noWait = noWait;
    }

    public boolean isEmitChanges() {
        return emitChanges;
    }

    public void setEmitChanges(boolean emitChanges) {
        this.emitChanges = emitChanges;
    }

    public WithIsolation getWithIsolation() {
        return withIsolation;
    }

    public void setWithIsolation(WithIsolation withIsolation) {
        this.withIsolation = withIsolation;
    }

    public List<WindowDefinition> getWindowDefinitions() {
        return windowDefinitions;
    }

    public void setWindowDefinitions(List<WindowDefinition> windowDefinitions) {
        this.windowDefinitions = windowDefinitions;
    }
}
