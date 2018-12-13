package com.qfedu.sport.domain;

import java.util.List;

public class Goods {
    private Integer id;

    private String goodsname;

    private String goodsprice;

    private String goodsdetail;

    private String goodstext;

    private String goodsimg;

    private List<GoodsImages> goodsImages;

    private Integer goodscount;

    private Integer materials;

    public List<GoodsImages> getGoodsImages() {
        return goodsImages;
    }

    public void setGoodsImages(List<GoodsImages> goodsImages) {
        this.goodsImages = goodsImages;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname == null ? null : goodsname.trim();
    }

    public String getGoodsprice() {
        return goodsprice;
    }

    public void setGoodsprice(String goodsprice) {
        this.goodsprice = goodsprice == null ? null : goodsprice.trim();
    }

    public String getGoodsdetail() {
        return goodsdetail;
    }

    public void setGoodsdetail(String goodsdetail) {
        this.goodsdetail = goodsdetail == null ? null : goodsdetail.trim();
    }

    public String getGoodstext() {
        return goodstext;
    }

    public void setGoodstext(String goodstext) {
        this.goodstext = goodstext == null ? null : goodstext.trim();
    }

    public String getGoodsimg() {
        return goodsimg;
    }

    public void setGoodsimg(String goodsimg) {
        this.goodsimg = goodsimg == null ? null : goodsimg.trim();
    }

    public Integer getGoodscount() {
        return goodscount;
    }

    public void setGoodscount(Integer goodscount) {
        this.goodscount = goodscount;
    }

    public Integer getMaterials() {
        return materials;
    }

    public void setMaterials(Integer materials) {
        this.materials = materials;
    }
}