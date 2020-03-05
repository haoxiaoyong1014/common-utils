package cn.haoxiaoyong.common.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haoxiaoyong on 2020/3/5 上午 8:35
 * e-mail: hxyHelloWorld@163.com
 * github:https://github.com/haoxiaoyong1014
 * Blog: www.haoxiaoyong.cn
 * Bean以及集合之间浅拷贝
 */

public class ConverterUtils {

    public static <V, C> C convert(V v, Class<C> beanClass) {
        if (ObjectUtils.isEmpty(v)) {
            return null;
        } else {
            C instance = null;
            try {
                instance = beanClass.newInstance();
                BeanUtils.copyProperties(v, instance);
            } catch (Exception var4) {
                var4.printStackTrace();
            }

            return instance;
        }
    }

    public static <V, C> List<C> convertList(List<V> vList, Class<C> beanClass) {
        List<C> cList = new ArrayList();
        if (CollectionUtils.isEmpty(vList)) {
            return cList;
        } else {
            vList.stream().forEach((v) -> {
                cList.add(convert(v, beanClass));
            });
            return cList;
        }
    }
}
