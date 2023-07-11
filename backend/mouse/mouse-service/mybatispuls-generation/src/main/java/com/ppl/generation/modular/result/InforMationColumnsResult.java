
package th.lmoc.generate.modular.result;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * 数据库表中返回对象
 *
 * @author laifuxing
 * @date 2020年12月17日20:00:31
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class InforMationColumnsResult {

    /**
     * 字段名
     */
    public String columnName;

    /**
     * 数据库中类型
     */
    public String dataType;

    /**
     * 字段描述
     */
    public String columnComment;

    /**
     * 主外键
     */
    public String columnKey;

}
