package apacheCommonsUtils.collectionsDemo;

import apacheCommonsUtils.beanUtilsDemo.User;
import org.apache.commons.collections.CollectionUtils;

import java.util.*;
import java.util.stream.IntStream;

/**
 * @program ThinkingInJava
 * @description:
 * @author: liuning11
 * @create: 2019/11/21
 */
public class CollectionsDemo2 {

    public static void main(String[] args) {
        List<User> usersA = new ArrayList<>();

        IntStream.range(1, 11).forEach(i -> {
            usersA.add(new User("user" + i, "user" + i));
        });

        Map cardinalityMap = getCardinalityMap(usersA);

        System.out.println(cardinalityMap);

    }

    private static Integer INTEGER_ONE = new Integer(1);

    public static Map getCardinalityMap(Collection coll) {
        Map count = new HashMap();
        Iterator it = coll.iterator();

        while (it.hasNext()) {
            Object obj = it.next();
            Integer c = (Integer) count.get(obj);
            if (c == null) {
                count.put(obj, INTEGER_ONE);
            } else {
                count.put(obj, new Integer(c + 1));
            }
        }

        return count;
    }
}
/* output:

 */
