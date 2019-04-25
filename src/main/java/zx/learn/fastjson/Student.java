package zx.learn.fastjson;

/**
 * @Auther: 胡志新
 * @Date: 2019/3/23 14:08
 * @Description:
 */


public class Student {

    String name;
    String nickName;
    int age;
    String studentId;

    public Student() {
    }

    public Student(String name, String nickName, int age, String studentId) {
        this.name = name;
        this.nickName = nickName;
        this.age = age;
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}
