package com.dji.demo.extend;

import com.dji.demo.User;

import java.util.List;

public class UserShopCarExtend extends User {
    private List<BookShopCarExtend> books;
    @Override
    public String toString() {
        return "UserShopCarExtend{id=" + super.getId() +
                ",username=" + super.getUsername() +
                ",phone=" + super.getPhone() +
                ", books=" + books + "}";
    }
}
