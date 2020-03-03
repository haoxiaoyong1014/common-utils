package cn.haoxiaoyong.common;

import cn.haoxiaoyong.common.domain.User;
import cn.haoxiaoyong.common.utils.ValidUtils;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * Created by haoxiaoyong on 2020/3/2 下午 10:42
 * e-mail: hxyHelloWorld@163.com
 * github:https://github.com/haoxiaoyong1014
 * Blog: www.haoxiaoyong.cn
 */
public class ValidUtilsTest {

    /**
     * 测试 ValidUtils {@link ValidUtils}
     */
    @Test
    public void testValidUtils() {
        User user = new User();
        user.setUsername("张思睿");
        user.setPassword("123456");
        //user.setAge(23);
        JSONObject jsonResult = ValidUtils.inspect(user, "username,password,age");
        System.out.println(jsonResult.get("code") + ": " + jsonResult.get("msg"));

    }
}
