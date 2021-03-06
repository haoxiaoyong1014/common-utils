package cn.haoxiaoyong.common.domain;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

/**
 * Created by haoxiaoyong on 2020/3/3 上午 9:45
 * e-mail: hxyHelloWorld@163.com
 * github:https://github.com/haoxiaoyong1014
 * Blog: www.haoxiaoyong.cn
 */
@Data
@Builder
public class User {

    private String username;

    private String password;

    private Integer age;

    private String gender;

    private String hobby;

    //添加无参构造,@Data和@Builder结合使用无参构造会失效
    @Tolerate
    public User(){}
}
