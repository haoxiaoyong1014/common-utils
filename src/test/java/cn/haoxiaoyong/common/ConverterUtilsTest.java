package cn.haoxiaoyong.common;

import cn.haoxiaoyong.common.domain.Persion;
import cn.haoxiaoyong.common.domain.User;
import cn.haoxiaoyong.common.utils.ConverterUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haoxiaoyong on 2020/3/5 上午 8:45
 * e-mail: hxyHelloWorld@163.com
 * github:https://github.com/haoxiaoyong1014
 * Blog: www.haoxiaoyong.cn
 */
public class ConverterUtilsTest {

    /**
     * 测试 converter方法
     * 具体实现 {@link ConverterUtils}
     */
    @Test
    public void testConverterByConverterUtils() {
        User user = User.builder()
                .username("张思睿").password("123456")
                .age(25).gender("男").hobby("女")
                .build();
        Persion persion = ConverterUtils.convert(user, Persion.class);
        System.out.println(persion);
    }

    private static List<User> users = new ArrayList<>();

    static {
        User user = User.builder()
                .username("张兔").password("123456")
                .age(25).gender("女").hobby("男")
                .build();
        User user2 = User.builder()
                .username("张思睿").password("123456")
                .age(25).gender("男").hobby("女")
                .build();
        users.add(user);
        users.add(user2);
    }

    /**
     * 测试 converterList方法
     * 具体实现 {@link ConverterUtils}
     */
    @Test
    public void testConverterListByConverterUtils() {
        List<Persion> persions = ConverterUtils.convertList(users, Persion.class);
        persions.stream().forEach((persion) -> {
            System.out.println(persion);
        });
    }
}
