package apacheCommonsUtils.langDemo;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;
import org.junit.Assert;

/**
 * @program ThinkingInJava
 * @description:
 * @author: liuning11
 * @create: 2019/11/21
 */
public class LangDemo {
    public static void main(String[] args) {

        Assert.assertTrue(StringUtils.isEmpty(""));

        Assert.assertTrue(StringUtils.isBlank(null));

        Assert.assertTrue(StringUtils.isBlank(""));

        Assert.assertTrue(StringUtils.isBlank(" "));

        //
        Pair<Integer, Integer> pair = new ImmutablePair<>(1, 2);
        Triple<Integer, Integer, Integer> triple = new ImmutableTriple<>(1, 2, 3);
        System.out.println(pair.getLeft() + "#" + pair.getRight());
        System.out.println(triple.getLeft() + "#" + triple.getMiddle() + "#" + triple.getRight());

    }
}
