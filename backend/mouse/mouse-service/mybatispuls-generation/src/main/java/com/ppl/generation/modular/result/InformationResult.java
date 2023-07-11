
package th.lmoc.generate.modular.result;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * 数据表返回对象
 *
 * @author laifuxing
 * @date 2020年12月17日20:01:56
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class InformationResult {

    /**
     * 表名（字母形式的）
     */
    public String tableName;

    /**
     * 创建时间
     */
    public String createTime;

    /**
     * 更新时间
     */
    public String updateTime;

    /**
     * 表名称描述（注释）（功能名）
     */
    public String tableComment;

}
