package com.dji.demo.mapper;

import com.dji.demo.ShopCar;
import com.dji.demo.extend.BookShopCarExtend;
import com.dji.demo.extend.UserShopCarExtend;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//购物车相关操作
@Mapper
public interface ShopCarMapper {
    // 指定用户往购物车添加书籍
    void insertShopCar(@Param("userId") Integer userId, @Param("bookId") Integer bookId, @Param("num") Integer num);

    // 指定用户修改购物车书籍数量
    void updateShopCar(ShopCar shopCar);

    // 删除指定用户购物车中某本书籍
    void deleteShopCar(@Param("userId") Integer userId, @Param("bookId") Integer bookId);

    // 清空指定用户购物车
    void clearShopCar(Integer userId);

    // 查询指定用户购物车中所有书籍（含数量）
    List<BookShopCarExtend> findBooksByUserId(Integer userId);

    // 查询指定用户信息，包含购物车中的书籍信息以及数量
    List<BookShopCarExtend> findUserWithShopCarBooks(@Param("userId") Integer userId);

    // 查询指定用户信息，包含购物车中的书籍信息以及数量
    UserShopCarExtend findUserByIdReset(Integer userId);

}