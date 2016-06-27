package com.is.see.entity;

import com.orm.SugarRecord;

import java.io.Serializable;

/**
 * Created by George on 2016/5/22.
 */
public class User extends SugarRecord implements Serializable{

    public Integer uid; // 编号
    public String name; //
    public String mobile; //
    public String password; //
    public String gender; //
    public String remark; //

    public User() {
    }

    public User(Integer uid, String name, String mobile, String password, String gender, String remark) {
        this.uid = uid;
        this.name = name;
        this.mobile = mobile;
        this.password = password;
        this.gender = gender;
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
