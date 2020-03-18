package cn.haoxiaoyong.common.utils;

import cn.haoxiaoyong.common.enums.CommonResultEnum;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by haoxiaoyong on 2020/3/3 上午 9:15
 * e-mail: hxyHelloWorld@163.com
 * github:https://github.com/haoxiaoyong1014
 * Blog: www.haoxiaoyong.cn
 * <p>
 * 检查一个对象中的参数值是否为空
 */
@Slf4j
public class ValidUtils {

    public static <T> JSONObject inspect(T t, String requireParams) {
        JSONObject jsonResult = new JSONObject();
        jsonResult.put("code", CommonResultEnum.CHECK_VALID.code());
        String jsonString = JSONObject.toJSONString(t);
        JSONObject jsonObject = JSONObject.parseObject(jsonString);
        String[] params = requireParams.split(",");
        for (String param : params) {
        log.info("patams: {}", param);
            if (jsonObject.getString(param) == null || jsonObject.getString(param).isEmpty()) {
                jsonResult.put("code", CommonResultEnum.CHECK_VALID_ERROR.code());
                jsonResult.put("msg", String.format(CommonResultEnum.CHECK_VALID_ERROR.message(), param));
                break;
            }
        }
        return jsonResult;
    }
}
