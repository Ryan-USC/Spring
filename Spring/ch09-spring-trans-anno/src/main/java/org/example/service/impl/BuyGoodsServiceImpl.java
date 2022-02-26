package org.example.service.impl;

import org.example.dao.GoodsDao;
import org.example.dao.SaleDao;
import org.example.domain.Goods;
import org.example.domain.Sale;
import org.example.excep.NotEnoughException;
import org.example.service.BuyGoodsService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class BuyGoodsServiceImpl implements BuyGoodsService {
    private SaleDao saleDao;
    private GoodsDao goodsDao;

    /*
    * rollbackFor：表示发生指定的异常一定回滚
    *   处理逻辑：
    *       1）spring框架会首先检查方法抛出的异常是不是在rollback的属性值，
    *           如果异常在rollback列表中，不管是什么类型异常，一定回滚。
    *       2）如果抛出的异常不在rollbackFor列表中，spring会判断异常是不是RunTimeException
    *           如果是，一定回滚
    * */
//    @Transactional(
//            propagation = Propagation.REQUIRED,
//            isolation = Isolation.DEFAULT,
//            readOnly = false,
//            rollbackFor = {
//                    NullPointerException.class,
//                    NotEnoughException.class
//            }
//    )
    @Transactional
    @Override
    public void buy(Integer goodsId, Integer nums) {
        System.out.println("buy method start");
        // 记录销售信息，向Sale表添加记录
        Sale sale = new Sale();
        sale.setGid(goodsId);
        sale.setNums(nums);
        saleDao.insertSale(sale);
        //更新库存
        Goods goods = goodsDao.selectGoods(goodsId);
        if (goods == null){
            throw new NullPointerException("编号是" + goodsId + "的商品不存在");
        } else if (goods.getAmount() < nums){
            throw new NotEnoughException("编号是" + goodsId + "的商品库存不足");
        }
        //修改库存了
        Goods buyGoods = new Goods();
        buyGoods.setId(goodsId);
        buyGoods.setAmount(nums);
        goodsDao.updateGoods(buyGoods);
        System.out.println("buy method end");
    }

    public void setSaleDao(SaleDao saleDao) {
        this.saleDao = saleDao;
    }

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }
}
