package com.cn.philips.pojo;

public class AvgTestData {
    private Integer id;

    private String planName;
    
    private Double MaxBri;

    private Double avgBri;

    private Double avgX;

    private Double avgY;

    private Double avgU;

    private Double avgV;
    
    private Double avgDeltaUV;
    
    private Double maxDeltaUV;

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

    public Double getMaxBri() {
		return MaxBri;
	}

	public void setMaxBri(Double maxBri) {
		MaxBri = maxBri;
	}

	public Double getAvgBri() {
        return avgBri;
    }

    public void setAvgBri(Double avgBri) {
        this.avgBri = avgBri;
    }

    public Double getAvgX() {
        return avgX;
    }

    public void setAvgX(Double avgX) {
        this.avgX = avgX;
    }

    public Double getAvgY() {
        return avgY;
    }

    public void setAvgY(Double avgY) {
        this.avgY = avgY;
    }

    public Double getAvgU() {
        return avgU;
    }

    public void setAvgU(Double avgU) {
        this.avgU = avgU;
    }

    public Double getAvgV() {
        return avgV;
    }

    public void setAvgV(Double avgV) {
        this.avgV = avgV;
    }

	public Double getAvgDeltaUV() {
		return avgDeltaUV;
	}

	public void setAvgDeltaUV(Double avgDeltaUV) {
		this.avgDeltaUV = avgDeltaUV;
	}

	public Double getMaxDeltaUV() {
		return maxDeltaUV;
	}

	public void setMaxDeltaUV(Double maxDeltaUV) {
		this.maxDeltaUV = maxDeltaUV;
	}
    
}