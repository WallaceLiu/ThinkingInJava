//: annotations/database/Member.java
package bdata.cap.com.annotations.database;

@DBTable(name = "MEMBER")
public class Member {
    @bdata.cap.com.annotations.database.SQLString(30)
    String firstName;
    @bdata.cap.com.annotations.database.SQLString(50)
    String lastName;
    @bdata.cap.com.annotations.database.SQLInteger
    Integer age;
    @bdata.cap.com.annotations.database.SQLString(value = 30,
            constraints = @Constraints(primaryKey = true))
    String handle;
    static int memberCount;

    public String getHandle() {
        return handle;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String toString() {
        return handle;
    }

    public Integer getAge() {
        return age;
    }
} ///:~
