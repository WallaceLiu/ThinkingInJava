package bdata.cap.com.chapter5;

/**
 * Create by Intellij Idea.
 *
 * @Auhtor George
 * @Create on 2018/2/20
 */
public class ExplicitStatic {
    public static void main(String[] args) {
        System.out.println("Inside main()");
        // 静态初始化仅执行一次，当首次生成这个类的一个对象时，
        // 或者首次访问属于那个类的静态数据成员时（即便从未生成过那个类的对象）
        Cups.cup1.f(99);
    }

    /*output
    Inside main()
    Cup(1)
    Cup(2)
    f(99)
     */
}
