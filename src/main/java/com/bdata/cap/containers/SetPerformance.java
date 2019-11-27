package com.bdata.cap.containers;

//: containers/SetPerformance.java
// Demonstrates performance differences in Sets.
// {Args: 100 5000} Small to keep build testing short

import java.util.*;

public class SetPerformance {
    static List<Test<Set<Integer>>> tests = new ArrayList<>();

    static {
        tests.add(new Test<Set<Integer>>("add") {
            int test(Set<Integer> set, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    set.clear();
                    for (int j = 0; j < size; j++)
                        set.add(j);
                }
                return loops * size;
            }
        });
        tests.add(new Test<Set<Integer>>("contains") {
            int test(Set<Integer> set, TestParam tp) {
                int loops = tp.loops;
                int span = tp.size * 2;
                for (int i = 0; i < loops; i++)
                    for (int j = 0; j < span; j++)
                        set.contains(j);
                return loops * span;
            }
        });
        tests.add(new Test<Set<Integer>>("iterate") {
            int test(Set<Integer> set, TestParam tp) {
                int loops = tp.loops * 10;
                for (int i = 0; i < loops; i++) {
                    Iterator<Integer> it = set.iterator();
                    while (it.hasNext())
                        it.next();
                }
                return loops * set.size();
            }
        });
    }

    public static void main(String[] args) {
        if (args.length > 0)
            Tester.defaultParams = TestParam.array(args);
        Tester.fieldWidth = 10;
        // three map
        Tester.run(new TreeSet<Integer>(), tests);
        Tester.run(new HashSet<Integer>(), tests);
        Tester.run(new LinkedHashSet<Integer>(), tests);
    }
}
/* Output: (Sample)
------------- TreeSet -------------
 size       add  contains   iterate
   10       315        80        85
  100       104        55         6
 1000        55        46         4
10000        69        49         5
------------- HashSet -------------
 size       add  contains   iterate
   10        87        57        45
  100        13         3         5
 1000        11         6         4
10000        11         3         5
---------- LinkedHashSet ----------
 size       add  contains   iterate
   10        60        23        13
  100        16         7         5
 1000        21         7         4
10000        16         7         4
*///:~
