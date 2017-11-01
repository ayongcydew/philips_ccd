package com.cn.philips.pojo;

public class CcdTestRuleResponse {
    private Integer id;

    private Integer planid;
    
    private String planname;

    private Integer isbriactivated;

    private Integer briconditiona;

    private Integer briconditionb;

    private Integer iscoloractivated;

    private Double colorconditiona;

    private Double colorconditionb;

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

    public String getPlanname() {
		return planname;
	}

	public void setPlanname(String planname) {
		this.planname = planname;
	}

	public Integer getIsbriactivated() {
        return isbriactivated;
    }

    public void setIsbriactivated(Integer isbriactivated) {
        this.isbriactivated = isbriactivated;
    }

    public Integer getBriconditiona() {
        return briconditiona;
    }

    public void setBriconditiona(Integer briconditiona) {
        this.briconditiona = briconditiona;
    }

    public Integer getBriconditionb() {
        return briconditionb;
    }

    public void setBriconditionb(Integer briconditionb) {
        this.briconditionb = briconditionb;
    }

    public Integer getIscoloractivated() {
        return iscoloractivated;
    }

    public void setIscoloractivated(Integer iscoloractivated) {
        this.iscoloractivated = iscoloractivated;
    }

	public Double getColorconditiona() {
		return colorconditiona;
	}

	public void setColorconditiona(Double colorconditiona) {
		this.colorconditiona = colorconditiona;
	}

	public Double getColorconditionb() {
		return colorconditionb;
	}

	public void setColorconditionb(Double colorconditionb) {
		this.colorconditionb = colorconditionb;
	}

}