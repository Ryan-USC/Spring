package org.example.service;

public interface BuyGoodsService {
    // 购买商品的方法，goodsId：购买的商品编号，nums购买商品的数量
    void buy(Integer goodsId, Integer nums);
}
