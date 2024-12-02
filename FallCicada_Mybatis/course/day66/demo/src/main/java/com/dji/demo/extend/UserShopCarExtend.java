package com.dji.demo.extend;

import com.dji.demo.User;
import org.apache.ibatis.annotations.CacheNamespace;

import java.util.List;

@CacheNamespace(blocking = true)
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
