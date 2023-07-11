
package th.lmoc.generate.modular.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import th.lmoc.generate.modular.result.InforMationColumnsResult;
import th.lmoc.generate.modular.result.InformationResult;
import th.lmoc.generate.modular.entity.CodeGenerate;

import java.util.List;

/**
 * 代码生成基础配置
 *
 * @author laifuxing
 * @date 2020年12月16日21:07:28
 */
public interface CodeGenerateMapper extends BaseMapper<CodeGenerate> {

    /**
     * 查询指定库中所有表
     *
     * @author laifuxing
     * @date 2020年12月17日20:06:05
     */
    List<InformationResult> selectInformationTable(@Param("dbName") String dbName);

    /**
     * 查询指定表中所有字段
     *
     * @author laifuxing
     * @date 2020年12月17日20:06:05
     */
    List<InforMationColumnsResult> selectInformationColumns(@Param("dbName") String dbName, @Param("tableName") String tableName);
}
