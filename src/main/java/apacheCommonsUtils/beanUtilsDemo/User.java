package apacheCommonsUtils.beanUtilsDemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program ThinkingInJava
 * @description:
 * @author: liuning11
 * @create: 2019/11/21
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String username;

    private String password;

    public String toString() {
        return String.format("%s:%s", this.getUsername(), this.getPassword());
    }
}
