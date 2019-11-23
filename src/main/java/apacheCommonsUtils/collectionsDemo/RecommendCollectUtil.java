package apacheCommonsUtils.collectionsDemo;

import com.jd.jr.cupid.base.RecommendItem;

import java.util.List;
import java.util.Set;

/**
 * 集合运算
 *
 * @author: liuning11
 * @date: 2019-10-31
 */
public final class RecommendCollectUtil extends BaseRecommendCollectUtil {
    private static RecommendCollectUtil instance = new RecommendCollectUtil();

    private RecommendCollectUtil() {

    }

    public static RecommendCollectUtil getInstance() {
        return instance;
    }

    public List<RecommendItem> intersection(List<RecommendItem> list1, List<RecommendItem> list2) {
        return intersection(list1, list2, RecommendConstant.FILED_SEPARATOR);
    }

    public List<RecommendItem> intersection(List<RecommendItem> list1, Set<String> set2) {
        return intersection(list1, set2, RecommendConstant.FILED_SEPARATOR);
    }

    public List<RecommendItem> diff(List<RecommendItem> list1, List<RecommendItem> list2) {
        return diff(list1, list2, RecommendConstant.FILED_SEPARATOR);
    }

    public List<RecommendItem> diff(List<RecommendItem> list1, Set<String> set2) {
        return diff(list1, set2, RecommendConstant.FILED_SEPARATOR);
    }

    public List<RecommendItem> union(List<RecommendItem> list1, List<RecommendItem> list2) {
        return union(list1, list2, RecommendConstant.FILED_SEPARATOR);
    }

    public List<RecommendItem> union(List<RecommendItem> list1, Set<String> set2) {
        return union(list1, set2, RecommendConstant.FILED_SEPARATOR, RecommendConstant.WEIGHT_DEFAULT);
    }

    public List<RecommendItem> runion(List<RecommendItem> list1, List<RecommendItem> list2,
                                      int num, RMODE rmode_get, RMODE rmode_put, boolean isRightDiff) {
        return runion(list1, list2, RecommendConstant.FILED_SEPARATOR, num, rmode_get, rmode_put, isRightDiff);
    }

    public List<RecommendItem> top(List<RecommendItem> list1, List<RecommendItem> list2,
                                   int num) {
        return runion(list1, list2, num, RMODE.FIRST, RMODE.FIRST, false);
    }

    public List<RecommendItem> runion(List<RecommendItem> list1, Set<String> set2,
                                      int num, RMODE rmode_get, RMODE rmode_put, boolean isRightDiff) {
        return runion(list1, set2, RecommendConstant.FILED_SEPARATOR, RecommendConstant.WEIGHT_DEFAULT,
                num, rmode_get, rmode_put, isRightDiff);
    }

    public List<RecommendItem> top(List<RecommendItem> list1, Set<String> set2, int num) {
        return runion(list1, set2, num, RMODE.FIRST, RMODE.FIRST, false);
    }


    public List<RecommendItem> funion(List<RecommendItem> list1, List<RecommendItem> list2,
                                      int num, int interval) {
        return funion(list1, list2, RecommendConstant.FILED_SEPARATOR, num, interval);
    }

    public List<RecommendItem> funion(List<RecommendItem> list1, Set<String> set2,
                                      int num, int interval) {
        return funion(list1, set2, RecommendConstant.FILED_SEPARATOR, RecommendConstant.WEIGHT_DEFAULT, num, interval);
    }
}

