package cn.haoxiaoyong.common.utils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author haoxiaoyong on 2020/3/13 下午 2:22
 * e-mail: hxyHelloWorld@163.com
 * github: https://github.com/haoxiaoyong1014
 * Blog: www.haoxiaoyong.cn
 * List去重
 */
public class UniqueUtils {

    public static <T> List<T> distinctByKeys(List<T> t, String... fields) {
        Stream<T> tStream = t.stream().filter(new Predicate<T>() {
            Map<Object, Boolean> seen = new ConcurrentHashMap<>(10);

            @Override
            public boolean test(T t) {
                boolean flag = false;
                try {
                    for (String field : fields) {
                        Field declaredField = t.getClass().getDeclaredField(field);
                        declaredField.setAccessible(true);
                        flag = seen.putIfAbsent(declaredField.get(t), Boolean.TRUE) == null;
                    }
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }
                return flag;
            }
        });
        return tStream.collect(Collectors.toList());
    }
}