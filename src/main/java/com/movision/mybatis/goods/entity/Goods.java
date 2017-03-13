package com.movision.mybatis.goods.entity;

import java.util.Date;

public class Goods {
    private Integer id;

    private String name;

    private String subname;

    private Double price;

    private Double origprice;

    private String attribute;

    private String provincecode;

    private String citycode;

    private Integer isself;

    private Integer shopid;

    private Integer isdamage;

    private Integer isquality;

    private String promotions;

    private Integer protype;

    private String brandid;

    private String brandsupple;

    private Integer sales;

    private Integer stock;

    private Integer goodsposition;

    private Integer iscombo;

    private Integer isspecial;

    private Integer isseckill;

    private Integer ishomepage;

    private Date recommenddate;

    private Date onlinetime;

    private Integer isdel;

    private Integer ishot;

    private Integer isessence;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSubname() {
        return subname;
    }

    public void setSubname(String subname) {
        this.subname = subname == null ? null : subname.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getOrigprice() {
        return origprice;
    }

    public void setOrigprice(Double origprice) {
        this.origprice = origprice;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute == null ? null : attribute.trim();
    }

    public String getProvincecode() {
        return provincecode;
    }

    public void setProvincecode(String provincecode) {
        this.provincecode = provincecode == null ? null : provincecode.trim();
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode == null ? null : citycode.trim();
    }

    public Integer getIsself() {
        return isself;
    }

    public void setIsself(Integer isself) {
        this.isself = isself;
    }

    public Integer getShopid() {
        return shopid;
    }

    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }

    public Integer getIsdamage() {
        return isdamage;
    }

    public void setIsdamage(Integer isdamage) {
        this.isdamage = isdamage;
    }

    public Integer getIsquality() {
        return isquality;
    }

    public void setIsquality(Integer isquality) {
        this.isquality = isquality;
    }

    public String getPromotions() {
        return promotions;
    }

    public void setPromotions(String promotions) {
        this.promotions = promotions == null ? null : promotions.trim();
    }

    public Integer getProtype() {
        return protype;
    }

    public void setProtype(Integer protype) {
        this.protype = protype;
    }

    public String getBrandid() {
        return brandid;
    }

    public void setBrandid(String brandid) {
        this.brandid = brandid == null ? null : brandid.trim();
    }

    public String getBrandsupple() {
        return brandsupple;
    }

    public void setBrandsupple(String brandsupple) {
        this.brandsupple = brandsupple == null ? null : brandsupple.trim();
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getGoodsposition() {
        return goodsposition;
    }

    public void setGoodsposition(Integer goodsposition) {
        this.goodsposition = goodsposition;
    }

    public Integer getIscombo() {
        return iscombo;
    }

    public void setIscombo(Integer iscombo) {
        this.iscombo = iscombo;
    }

    public Integer getIsspecial() {
        return isspecial;
    }

    public void setIsspecial(Integer isspecial) {
        this.isspecial = isspecial;
    }

    public Integer getIsseckill() {
        return isseckill;
    }

    public void setIsseckill(Integer isseckill) {
        this.isseckill = isseckill;
    }

    public Integer getIshomepage() {
        return ishomepage;
    }

    public void setIshomepage(Integer ishomepage) {
        this.ishomepage = ishomepage;
    }

    public Date getRecommenddate() {
        return recommenddate;
    }

    public void setRecommenddate(Date recommenddate) {
        this.recommenddate = recommenddate;
    }

    public Date getOnlinetime() {
        return onlinetime;
    }

    public void setOnlinetime(Date onlinetime) {
        this.onlinetime = onlinetime;
    }

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }

    public Integer getIshot() {
        return ishot;
    }

    public void setIshot(Integer ishot) {
        this.ishot = ishot;
    }

    public Integer getIsessence() {
        return isessence;
    }

    public void setIsessence(Integer isessence) {
        this.isessence = isessence;
    }
}