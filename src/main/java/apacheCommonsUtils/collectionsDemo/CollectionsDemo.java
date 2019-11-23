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
public class CollectionsDemo {

    public static void main(String[] args) {
        List<User> usersA = new ArrayList<>();
        List<User> usersB = new ArrayList<>();

        // 判空
        boolean isEmptyUsersA = CollectionUtils.isEmpty(usersA);

        // 判等
        boolean isEqual = CollectionUtils.isEqualCollection(usersA, usersB);

        IntStream.range(1, 11).forEach(i -> {
            usersA.add(new User("user" + i, "user" + i));
        });

        IntStream.range(10, 16).forEach(i -> {
            usersB.add(new User("user" + i, "user" + i));
        });

        System.out.println("usersA");
        usersA.stream().forEach(item -> System.out.println(item.toString()));
        System.out.println("usersB");
        usersB.stream().forEach(item -> System.out.println(item.toString()));

        // 交集
        Collection retain = CollectionUtils.retainAll(usersA, usersB);
        System.out.println("retain");
        retain.stream().forEach(item -> System.out.println(item.toString()));

        // 并集
        Collection union = CollectionUtils.union(usersA, usersB);
        System.out.println("union");
        union.stream().forEach(item -> System.out.println(item.toString()));

        // 差集
        Collection subtract = CollectionUtils.subtract(usersA, usersB);
        System.out.println("subtract");
        subtract.stream().forEach(item -> System.out.println(item.toString()));
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
