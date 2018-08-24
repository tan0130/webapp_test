package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * create by 1311230692@qq.com on 2018/8/17 10:18
 * 用户实体类
 **/
@Entity
public class User implements Serializable {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id; // 用户 id
    private String nickname; // 用户昵称
    private String username; // 用户名称
    private String password; // 用户密码
    private String tel; // 用户电话
    private String sex;
//    private int page;
//    private int limit;

    public User() {
    }

    public User(int id, String nickname, String username, String password, String tel, String sex) {
        this.id = id;
        this.nickname = nickname;
        this.username = username;
        this.password = password;
        this.tel = tel;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", tel='" + tel + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
