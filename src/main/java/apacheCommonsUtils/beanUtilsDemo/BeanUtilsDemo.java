package apacheCommonsUtils.beanUtilsDemo;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @program ThinkingInJava
 * @description:
 * @author: liuning11
 * @create: 2019/11/21
 */
public class BeanUtilsDemo {


    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        User user = new User();
        BeanUtils.setProperty(user, "username", "li");
        BeanUtils.getProperty(user, "username");
        System.out.println(user.toString());

        // bean->map
        Map<String, String> map = BeanUtils.describe(user);
        // map->bean
        BeanUtils.populate(user, map);
    }
}



