package com.qfedu.sport.domain;

public class Card {
    private Integer cid;

    private Integer gid;

    private Integer uid;

    private Integer count;

    private Integer cardstatus;

    private Integer size;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer id) {
        this.cid = cid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getCardstatus() {
        return cardstatus;
    }

    public void setCardstatus(Integer cardstatus) {
        this.cardstatus = cardstatus;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}