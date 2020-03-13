package cn.haoxiaoyong.common;

import cn.haoxiaoyong.common.domain.Persion;
import cn.haoxiaoyong.common.utils.UniqueUtils;
import javafx.util.converter.PercentageStringConverter;
import org.junit.Test;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author haoxiaoyong on 2020/3/13 下午 2:27
 * e-mail: hxyHelloWorld@163.com
 * github: https://github.com/haoxiaoyong1014
 * Blog: www.haoxiaoyong.cn
 */
public class UniqueUtilsTest {

    private static List<Persion> list = new ArrayList<>();

    private static List<Persion> list2 = new ArrayList<>();

    static {
        list.add(new Persion("张思睿", 23));
        list.add(new Persion("里斯", 24));
        list.add(new Persion("王武", 25));
        list.add(new Persion("张思睿", 26));
    }

    static {
        list2.add(new Persion("张思睿", 26));
        list2.add(new Persion("里斯", 24));
        list2.add(new Persion("王武", 25));
        list2.add(new Persion("张思睿", 26));
    }

    /**
     * 测试根据一个属性去重
     */
    @Test
    public void distinctByKeyTest() {
        UniqueUtils.distinctByKeys(list, "username").forEach(
                l -> System.out.println(l.getUsername() + "," + l.getAge()));
    }

    /**
     * 测试根据多个属性去重
     */
    @Test
    public void distinctByKeyTests() {
        UniqueUtils.distinctByKeys(list2, "username","age").forEach(
                l -> System.out.println(l.getUsername() + "," + l.getAge()));
    }
}
