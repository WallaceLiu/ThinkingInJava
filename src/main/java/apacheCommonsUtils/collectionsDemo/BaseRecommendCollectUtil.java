package apacheCommonsUtils.collectionsDemo;

import com.google.common.collect.Sets;
import com.jd.jr.cupid.base.RecommendItem;
import com.jd.jr.cupid.engine.rechub.base.RecommendItemExt;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.maxBy;

/**
 * list collect operation
 *
 * @author: liuning11
 * @date: 2019-10-31
 */
public class BaseRecommendCollectUtil {
    private static Random random_get;
    private static Random random_put;

    static {
        random_get = new Random();
        random_put = new Random();
    }

    /**
     * 交集
     *
     * @param list1
     * @param list2
     * @return
     */
    public static List<RecommendItem> intersection(List<RecommendItem> list1, List<RecommendItem> list2, String separator) {
        if (!CollectionUtils.isEmpty(list1) && !CollectionUtils.isEmpty(list2)) {
            return list1.stream().filter(item -> RecommendItemExt.anyMatch(list2, item, separator))
                    .collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    /**
     *  增加非交集
     */
    /**
     * 交集
     *
     * @param list1
     * @param set2
     * @return
     */
    public static List<RecommendItem> intersection(List<RecommendItem> list1, Set<String> set2, String separator) {
        if (!CollectionUtils.isEmpty(list1) && !CollectionUtils.isEmpty(set2)) {
            return list1.stream().filter(item -> set2.contains(RecommendItemExt.getUniqueId(item, separator)))
                    .collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    /**
     * 差集
     *
     * @param list1
     * @param list2
     * @return
     */
    public static List<RecommendItem> diff(List<RecommendItem> list1, List<RecommendItem> list2, String separator) {
        if (!CollectionUtils.isEmpty(list1) && !CollectionUtils.isEmpty(list2)) {
            return list1.stream().filter(item -> !RecommendItemExt.anyMatch(list2, item, separator))
                    .collect(Collectors.toList());
        } else if (!CollectionUtils.isEmpty(list1) && CollectionUtils.isEmpty(list2)) {
            return list1;
        } else {
            return new ArrayList<>();
        }
    }

    /**
     * 差集
     *
     * @param list1
     * @param set2
     * @return
     */
    public static List<RecommendItem> diff(List<RecommendItem> list1, Set<String> set2, String separator) {
        if (!CollectionUtils.isEmpty(list1) && !CollectionUtils.isEmpty(set2)) {
            return list1.stream().filter(item -> !set2.contains(RecommendItemExt.getUniqueId(item, separator)))
                    .collect(Collectors.toList());
        } else if (!CollectionUtils.isEmpty(list1) && CollectionUtils.isEmpty(set2)) {
            return list1;
        } else {
            return new ArrayList<>();
        }
    }

    /**
     * 差集
     *
     * @param set1
     * @param set2
     * @param separator
     * @param weight
     * @param weight_default
     * @return
     */
    public static List<RecommendItem> diff(Set<String> set1, Set<String> set2,
                                           String separator, double weight, double weight_default) {
        if (!CollectionUtils.isEmpty(set1) && !CollectionUtils.isEmpty(set2)) {
            return strConverToItem(Sets.difference(set1, set2), separator, weight, weight_default);
        } else if (!CollectionUtils.isEmpty(set1) && CollectionUtils.isEmpty(set2)) {
            return strConverToItem(set1, separator, weight, weight_default);
        } else {
            return new ArrayList<>();
        }
    }

    /**
     * 并集
     * <p>
     * 合并list1和list2
     *
     * @param list1
     * @param list2
     * @return
     */
    public static List<RecommendItem> union(List<RecommendItem> list1, List<RecommendItem> list2, String separator) {
        if (CollectionUtils.isEmpty(list1) && !CollectionUtils.isEmpty(list2)) {
            return list2;
        } else if (!CollectionUtils.isEmpty(list1) && CollectionUtils.isEmpty(list2)) {
            return list1;
        } else if (!CollectionUtils.isEmpty(list1) && !CollectionUtils.isEmpty(list2)) {
            List<RecommendItem> l2 = diff(list2, intersection(list1, list2, separator), separator);
            list1.addAll(l2);
            return list1;
        } else {
            return new ArrayList<>();
        }
    }

    /**
     * 并集
     * <p>
     * 合并list1和list2
     *
     * @param list1
     * @param set2
     * @param separator
     * @param weight_default
     * @return
     */
    public static List<RecommendItem> union(List<RecommendItem> list1, Set<String> set2,
                                            String separator, double weight_default) {
        if (CollectionUtils.isEmpty(list1) && !CollectionUtils.isEmpty(set2)) {
            // 0.0d 有问题
            return strConverToItem(set2, separator, 0.0d, weight_default);
        } else if (!CollectionUtils.isEmpty(list1) && CollectionUtils.isEmpty(set2)) {
            return list1;
        } else if (!CollectionUtils.isEmpty(list1) && !CollectionUtils.isEmpty(set2)) {

            Optional<RecommendItem> maxItem = list1.stream().collect(maxBy(Comparator.comparingDouble(RecommendItem::getWeight)));
            double wMax = !maxItem.isPresent() ? 0.0 : maxItem.get().getWeight();

            set2.stream().forEach(st -> {
                if (!list1.stream().anyMatch(i -> RecommendItemExt.getUniqueId(i, separator).equals(st))) {
                    list1.add(strConverToItem(st, separator, wMax, weight_default));
                }
            });
            return list1;
        } else {
            return new ArrayList<>();
        }
    }

    /**
     * 并集
     * <p>
     * 从list2随机取cnt个插入到list1
     *
     * @param list1
     * @param list2
     * @param num
     * @param rmode_get 获取list2的方式
     * @param rmode_put 插入list1的方式
     * @return
     */
    public static List<RecommendItem> runion(List<RecommendItem> list1, List<RecommendItem> list2,
                                             String separator, int num, RMODE rmode_get, RMODE rmode_put, boolean isRightDiff) {
        if (list1 == null) {
            return new ArrayList<>();
        } else {
            if (CollectionUtils.isEmpty(list2) || num <= 0) {
                return list1;
            } else {
                int min_num = list2.size() <= num ? list2.size() : num;

                List<RecommendItem> lIntersection = intersection(list1, list2, separator);

                List<RecommendItem> l1 = null;
                List<RecommendItem> l2 = null;

                if (isRightDiff) {
                    l1 = list1;
                    l2 = diff(list2, lIntersection, separator);
                } else {
                    l1 = diff(list1, lIntersection, separator);
                    l2 = list2;
                }


                if (CollectionUtils.isEmpty(l1) && CollectionUtils.isEmpty(l2)) {
                    return new ArrayList<>();
                } else if (CollectionUtils.isEmpty(l1) && !CollectionUtils.isEmpty(l2)) {
                    return l2;
                } else if (!CollectionUtils.isEmpty(l1) && CollectionUtils.isEmpty(l2)) {
                    return l1;
                } else {
                    switch (rmode_get) {
                        case R:
                        case FIRST:
                            if (rmode_get == RMODE.R) {
                                Collections.shuffle(l2);
                            }
//                        l2.subList(0, min_num).stream().forEach(item ->
//                                put(l1, item, random_put.nextInt(list1.size()), rmode_put)
//                        );
                            put(l1, l2.subList(0, min_num), rmode_put);
                            break;
                        case LAST:
//                        l2.subList(list2.size() - min_num, l2.size()).stream().forEach(item ->
//                                put(list1, item, random_put.nextInt(list1.size()), rmode_put)
//                        );
                            put(l1, l2.subList(list2.size() - min_num, l2.size()), rmode_put);
                            break;
                        default:
                            break;
                    }
                    return l1;
                }
            }
        }
    }

    /**
     * 并集
     * <p>
     * 从list2随机取cnt个插入到list1
     *
     * @param list1
     * @param set2
     * @param separator
     * @param weight_default
     * @param num
     * @param rmode_get
     * @param rmode_put
     * @return
     */
    public static List<RecommendItem> runion(List<RecommendItem> list1, Set<String> set2,
                                             String separator, double weight_default,
                                             int num, RMODE rmode_get, RMODE rmode_put, boolean isRightDiff) {

        Optional<RecommendItem> maxItem = list1.stream().collect(maxBy(Comparator.comparingDouble(RecommendItem::getWeight)));
        double wMax = !maxItem.isPresent() ? 0.0 : maxItem.get().getWeight();
        List<RecommendItem> list2 = strConverToItem(set2, separator, wMax, weight_default);
        return runion(list1, list2, separator, num, rmode_get, rmode_put, isRightDiff);
    }

    /**
     * @param list
     * @param t
     * @param rmode
     */
    private static void put(List<RecommendItem> list, RecommendItem t, int i, RMODE rmode) {
        switch (rmode) {
            case R:
                list.add(i <= 0 ? i : i, t);
                break;
            case FIRST:
                list.add(0, t);
                break;
            case LAST:
                list.add(t);
                break;
        }
    }

    /**
     * @param list
     * @param t
     * @param rmode
     */
    private static void put(List<RecommendItem> list, List<RecommendItem> t, RMODE rmode) {
        switch (rmode) {
            case R:
                t.stream().forEach(item -> {
                            int i = random_put.nextInt(list.size());
                            list.add(i <= 0 ? i : i, item);
                        }
                );
                break;
            case FIRST:
                list.addAll(0, t);
                break;
            case LAST:
                list.addAll(t);
                break;
        }
    }

    /**
     * 并集
     * <p>
     * 从list2提取出num个插入list1每页固定位置
     * <p>
     * 从list2每取num个，在list1中相隔interval插入
     *
     * @param list1
     * @param list2
     * @param num      每取list2个数
     * @param interval list1间隔
     * @return
     */
    public static List<RecommendItem> funion(List<RecommendItem> list1, List<RecommendItem> list2,
                                             String separator, int num, int interval) {
        if (CollectionUtils.isEmpty(list1) && !CollectionUtils.isEmpty(list2)) {
            return list2;
        } else if (!CollectionUtils.isEmpty(list1) && CollectionUtils.isEmpty(list2)) {
            return list1;
        } else if (!CollectionUtils.isEmpty(list1) && !CollectionUtils.isEmpty(list2)) {
            List<RecommendItem> l2 = diff(list2, intersection(list1, list2, separator), separator);
            int minSize = list1.size() <= l2.size() ? list1.size() : l2.size();
            int i = 0;
            int n = minSize / num;
            int index = 0, start = 0, end = 0;

            for (; i < n; i++) {
                index = i <= 0 ? 0 : i * interval + num + i - 1;
                start = i * num;
                end = start + num;
                List<RecommendItem> t = l2.subList(start, end);
                list1.addAll(index, t);
            }

            if (end < l2.size()) {
                List<RecommendItem> t = l2.subList(end, l2.size());
                if (index + interval + num > list1.size()) {
                    list1.addAll(t);
                } else {
                    list1.addAll(index + interval + num, t);
                }
                t = null;
            }

            return list1;
        } else {
            return new ArrayList<>();
        }
    }

    /**
     * 并集
     * <p>
     * 从list2提取出num个插入list1每页固定位置
     * <p>
     * 从list2每取num个，在list1中相隔interval插入
     *
     * @param list1
     * @param set2
     * @param separator
     * @param weight_default
     * @param num
     * @param interval
     * @return
     */
    public static List<RecommendItem> funion(List<RecommendItem> list1, Set<String> set2,
                                             String separator, double weight_default,
                                             int num, int interval) {
        Optional<RecommendItem> maxItem = list1.stream().collect(maxBy(Comparator.comparingDouble(RecommendItem::getWeight)));
        double wMax = !maxItem.isPresent() ? 0.0 : maxItem.get().getWeight();
        List<RecommendItem> list2 = strConverToItem(set2, separator, wMax, weight_default);
        return funion(list1, list2, separator, num, interval);
    }

    /**
     * 并集
     * <p>
     * 若list1大于num，则返回list1中前num个元素
     * 否则，从list2中随机取补齐num个，返回
     *
     * @param list1
     * @param list2
     * @return
     */
    public static List<RecommendItem> fill(List<RecommendItem> list1, List<RecommendItem> list2, int num) {
        if (CollectionUtils.isEmpty(list1)) {
            return new ArrayList<>();
        } else {
            if (list1.size() >= num) {
                return list1.subList(0, num);
            } else {
                return runion(list1, list2, RecommendConstant.FILED_SEPARATOR, num, RMODE.R, RMODE.LAST, true);
            }
        }
    }

    /**
     * 并集
     * <p>
     * 若list1大于num，则返回list1中前num个元素
     * 否则，从list2中随机取补齐num个，返回
     *
     * @param list1
     * @param set2
     * @param separator
     * @param weight
     * @param weight_default
     * @param num
     * @return
     */
    public static List<RecommendItem> fill(List<RecommendItem> list1, Set<String> set2,
                                           String separator, double weight, double weight_default, int num) {
        List<RecommendItem> list2 = strConverToItem(set2, separator, weight, weight_default);
        return fill(list1, list2, num);
    }

    /**
     * @param st
     * @param separator
     * @param weight
     * @param weight_default
     * @return
     */
    public static List<RecommendItem> strConverToItem(Set<String> st, String separator, double weight, double weight_default) {
        return st.stream().filter(v -> !StringUtils.isEmpty(v) &&
                Sets.newHashSet(2, 3).contains(v.split(separator).length)).map(v -> {
            return strConverToItem(v, separator, weight, weight_default);
        }).collect(Collectors.toList());
    }

    /**
     * @param st
     * @param separator
     * @param weight
     * @param weight_default
     * @return
     */
    public static RecommendItem strConverToItem(String st, String separator, double weight, double weight_default) {
        String[] split = st.split(separator);
        RecommendItem item = new RecommendItem();
        switch (split.length) {
            case 2:
                item.setItemId(split[0]);
                item.setItemDesc(split[1]);
                item.setWeight(weight + weight_default);
                break;
            case 3:
                item.setItemId(split[0]);
                item.setItemDesc(split[1]);
                item.setWeight(Double.valueOf(split[2]) + weight_default);
                break;
        }
        return item;
    }

    /**
     * @param list
     * @param separator
     * @return
     */
    public static Set<String> itemConverToStr(List<RecommendItem> list, String separator) {
        return list.stream().map(item -> itemConverToStr(item, separator)).collect(Collectors.toSet());
    }

    /**
     * @param item
     * @param separator
     * @return
     */
    public static String itemConverToStr(RecommendItem item, String separator) {
        StringBuilder sb = new StringBuilder();
        if (!StringUtils.isEmpty(item.getItemId())) {
            sb.append(item.getItemId()).append(separator);
        }
        if (!StringUtils.isEmpty(item.getItemDesc())) {
            sb.append(item.getItemDesc()).append(separator);
        }
        sb.append(item.getWeight());
        return sb.toString();
    }
}
