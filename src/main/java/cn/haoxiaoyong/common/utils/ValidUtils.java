package cn.haoxiaoyong.common.utils;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by haoxiaoyong on 2020/3/3 上午 9:15
 * e-mail: hxyHelloWorld@163.com
 * github:https://github.com/haoxiaoyong1014
 * Blog: www.haoxiaoyong.cn
 *
 * 检查一个对象中的参数值是否为空
 */
public class ValidUtils {

    public static <T> JSONObject paramIsNull(T t, String requireParams) {
        JSONObject jsonResult = new JSONObject();
        jsonResult.put("code", OperationPlatformBizEnum.CHECK_VALID.value());
        String jsonString = JSONObject.toJSONString(t);
        JSONObject jsonObject = JSONObject.parseObject(jsonString);
        String[] params = requireParams.split(",");
        for (String param : params) {
            if (jsonObject.getString(param) == null || jsonObject.getString(param).isEmpty()) {
                jsonResult.put("code", OperationPlatformBizEnum.CHECK_VALID_ERROR.value());
                jsonResult.put("msg", String.format(OperationPlatformBizEnum.CHECK_VALID_ERROR.message(), param));
                break;
            }
        }
        return jsonResult;
    }
}
