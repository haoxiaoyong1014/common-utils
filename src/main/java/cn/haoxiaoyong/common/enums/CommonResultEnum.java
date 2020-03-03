package cn.haoxiaoyong.common.enums;

import lombok.Getter;

/**
 * Created by haoxiaoyong on 2020/3/3 上午 9:20
 * e-mail: hxyHelloWorld@163.com
 * github:https://github.com/haoxiaoyong1014
 * Blog: www.haoxiaoyong.cn
 */
@Getter
public enum CommonResultEnum {

    /**操作成功**/
    CHECK_VALID(20200, "参数校验成功"),
    /**检查参数为空**/
    CHECK_VALID_ERROR(20201, "%s参数为空");




    /**
     * 返回码
     */
    protected Integer code;
    /**
     * 描述信息
     */
    protected String message;

    /**
     * 构造方法
     * @param code
     * @param message
     */
    CommonResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public String message() {
        return message;
    }


    public Integer code() {
        return code;
    }

}
