package com.cn.philips.pojo;

public class CcdTestConfigResponse {
    private Integer id;

    private Integer planid;
    
    private String planName;

    private Double threshold;

    private Integer sdcm1;

    private Integer sdcm2;

    private Integer sdcm3;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPlanid() {
        return planid;
    }

    public void setPlanid(Integer planid) {
        this.planid = planid;
    }

    public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public Double getThreshold() {
        return threshold;
    }

    public void setThreshold(Double threshold) {
        this.threshold = threshold;
    }

    public Integer getSdcm1() {
        return sdcm1;
    }

    public void setSdcm1(Integer sdcm1) {
        this.sdcm1 = sdcm1;
    }

    public Integer getSdcm2() {
        return sdcm2;
    }

    public void setSdcm2(Integer sdcm2) {
        this.sdcm2 = sdcm2;
    }

    public Integer getSdcm3() {
        return sdcm3;
    }

    public void setSdcm3(Integer sdcm3) {
        this.sdcm3 = sdcm3;
    }
}