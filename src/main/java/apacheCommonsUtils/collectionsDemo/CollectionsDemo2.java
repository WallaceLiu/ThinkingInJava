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
usersA
user1=user1
user2=user2
user3=user3
user4=user4
user5=user5
user6=user6
user7=user7
user8=user8
user9=user9
user10=user10
usersB
user10=user10
user11=user11
user12=user12
user13=user13
user14=user14
user15=user15
retain
user10=user10
union
user7=user7
user15=user15
user6=user6
user1=user1
user9=user9
user8=user8
user10=user10
user3=user3
user11=user11
user2=user2
user12=user12
user5=user5
user13=user13
user4=user4
user14=user14
subtract
user1=user1
user2=user2
user3=user3
user4=user4
user5=user5
user6=user6
user7=user7
user8=user8
user9=user9
 */
