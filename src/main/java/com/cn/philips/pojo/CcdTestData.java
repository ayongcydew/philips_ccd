package com.cn.philips.pojo;

public class CcdTestData {
    private Integer id;

    private String planName;

    private Integer locx;

    private Integer locy;

    private Double bri;

    private Double x;

    private Double y;

    private Double u;

    private Double v;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName == null ? null : planName.trim();
    }

    public Integer getLocx() {
        return locx;
    }

    public void setLocx(Integer locx) {
        this.locx = locx;
    }

    public Integer getLocy() {
        return locy;
    }

    public void setLocy(Integer locy) {
        this.locy = locy;
    }

    public Double getBri() {
        return bri;
    }

    public void setBri(Double bri) {
        this.bri = bri;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getU() {
        return u;
    }

    public void setU(Double u) {
        this.u = u;
    }

    public Double getV() {
        return v;
    }

    public void setV(Double v) {
        this.v = v;
    }
}