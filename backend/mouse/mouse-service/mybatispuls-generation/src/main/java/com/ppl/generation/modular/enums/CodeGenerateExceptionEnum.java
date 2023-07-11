
package th.lmoc.generate.modular.enums;

import th.lmoc.common.annotion.ExpEnumType;
import th.lmoc.common.exception.enums.abs.AbstractBaseExceptionEnum;
import th.lmoc.common.factory.ExpEnumCodeFactory;
import th.lmoc.generate.core.consts.GenExpEnumConstant;

/**
 * 代码生成基础配置相关异常枚举
 *
 * @author laifuxing
 * @date 2020年12月16日21:21:14
 */
@ExpEnumType(module = GenExpEnumConstant.SNOWY_GEN_MODULE_EXP_CODE, kind = GenExpEnumConstant.GEN_CODE_EXCEPTION_ENUM)
public enum CodeGenerateExceptionEnum implements AbstractBaseExceptionEnum {

    /**
     * 代码生成基础配置不存在
     */
    CODE_GEN_NOT_EXIST(1, "代码生成基础配置不存在"),

    /**
     * 本地生成代码输出路径错误
     */
    CODE_GEN_NOT_PATH(2,"本地生成代码输出路径错误"),

    /**
     * 请检查此数据表中主键的定义
     */
    CODE_GEN_TABLE_NOT_PRI(3,"请检查此数据表中主键的定义");

    private final Integer code;

    private final String message;

    CodeGenerateExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return ExpEnumCodeFactory.getExpEnumCode(this.getClass(), code);
    }

    @Override
    public String getMessage() {
        return message;
    }

}
