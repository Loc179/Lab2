package com.example.lab2;

import java.io.Serializable;

public class Contact  implements Serializable {//tuan tu hoa
    private String userName;
    private String userPhone;
    private int Id;

    private boolean active;

    public Contact(int Id, String userName, String userType)  {
        this.userName= userName;
        this.userPhone = userType;
        this.Id = Id;
        this.active= true;
    }

    public Contact(int Id,String userName, String userType, boolean active)  {
        this.userName= userName;
        this.userPhone = userType;
        this.Id = Id;
        this.active= active;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public int getId() {
        return Id;
    }

    public void setUserPhone(String userType) {
        this.userPhone = userType;
    }
    public void getId(int Id) {
        this.Id = Id;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return this.userName +" \n"+ this.userPhone;
    }

}
