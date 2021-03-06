package com.cn.philips.pojo;

import java.util.ArrayList;
import java.util.List;

public class CcdTestConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CcdTestConfigExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPlanidIsNull() {
            addCriterion("planid is null");
            return (Criteria) this;
        }

        public Criteria andPlanidIsNotNull() {
            addCriterion("planid is not null");
            return (Criteria) this;
        }

        public Criteria andPlanidEqualTo(Integer value) {
            addCriterion("planid =", value, "planid");
            return (Criteria) this;
        }

        public Criteria andPlanidNotEqualTo(Integer value) {
            addCriterion("planid <>", value, "planid");
            return (Criteria) this;
        }

        public Criteria andPlanidGreaterThan(Integer value) {
            addCriterion("planid >", value, "planid");
            return (Criteria) this;
        }

        public Criteria andPlanidGreaterThanOrEqualTo(Integer value) {
            addCriterion("planid >=", value, "planid");
            return (Criteria) this;
        }

        public Criteria andPlanidLessThan(Integer value) {
            addCriterion("planid <", value, "planid");
            return (Criteria) this;
        }

        public Criteria andPlanidLessThanOrEqualTo(Integer value) {
            addCriterion("planid <=", value, "planid");
            return (Criteria) this;
        }

        public Criteria andPlanidIn(List<Integer> values) {
            addCriterion("planid in", values, "planid");
            return (Criteria) this;
        }

        public Criteria andPlanidNotIn(List<Integer> values) {
            addCriterion("planid not in", values, "planid");
            return (Criteria) this;
        }

        public Criteria andPlanidBetween(Integer value1, Integer value2) {
            addCriterion("planid between", value1, value2, "planid");
            return (Criteria) this;
        }

        public Criteria andPlanidNotBetween(Integer value1, Integer value2) {
            addCriterion("planid not between", value1, value2, "planid");
            return (Criteria) this;
        }

        public Criteria andThresholdIsNull() {
            addCriterion("Threshold is null");
            return (Criteria) this;
        }

        public Criteria andThresholdIsNotNull() {
            addCriterion("Threshold is not null");
            return (Criteria) this;
        }

        public Criteria andThresholdEqualTo(Double value) {
            addCriterion("Threshold =", value, "threshold");
            return (Criteria) this;
        }

        public Criteria andThresholdNotEqualTo(Double value) {
            addCriterion("Threshold <>", value, "threshold");
            return (Criteria) this;
        }

        public Criteria andThresholdGreaterThan(Double value) {
            addCriterion("Threshold >", value, "threshold");
            return (Criteria) this;
        }

        public Criteria andThresholdGreaterThanOrEqualTo(Double value) {
            addCriterion("Threshold >=", value, "threshold");
            return (Criteria) this;
        }

        public Criteria andThresholdLessThan(Double value) {
            addCriterion("Threshold <", value, "threshold");
            return (Criteria) this;
        }

        public Criteria andThresholdLessThanOrEqualTo(Double value) {
            addCriterion("Threshold <=", value, "threshold");
            return (Criteria) this;
        }

        public Criteria andThresholdIn(List<Double> values) {
            addCriterion("Threshold in", values, "threshold");
            return (Criteria) this;
        }

        public Criteria andThresholdNotIn(List<Double> values) {
            addCriterion("Threshold not in", values, "threshold");
            return (Criteria) this;
        }

        public Criteria andThresholdBetween(Double value1, Double value2) {
            addCriterion("Threshold between", value1, value2, "threshold");
            return (Criteria) this;
        }

        public Criteria andThresholdNotBetween(Double value1, Double value2) {
            addCriterion("Threshold not between", value1, value2, "threshold");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andSdcm1IsNull() {
            addCriterion("sdcm1 is null");
            return (Criteria) this;
        }

        public Criteria andSdcm1IsNotNull() {
            addCriterion("sdcm1 is not null");
            return (Criteria) this;
        }

        public Criteria andSdcm1EqualTo(Integer value) {
            addCriterion("sdcm1 =", value, "sdcm1");
            return (Criteria) this;
        }

        public Criteria andSdcm1NotEqualTo(Integer value) {
            addCriterion("sdcm1 <>", value, "sdcm1");
            return (Criteria) this;
        }

        public Criteria andSdcm1GreaterThan(Integer value) {
            addCriterion("sdcm1 >", value, "sdcm1");
            return (Criteria) this;
        }

        public Criteria andSdcm1GreaterThanOrEqualTo(Integer value) {
            addCriterion("sdcm1 >=", value, "sdcm1");
            return (Criteria) this;
        }

        public Criteria andSdcm1LessThan(Integer value) {
            addCriterion("sdcm1 <", value, "sdcm1");
            return (Criteria) this;
        }

        public Criteria andSdcm1LessThanOrEqualTo(Integer value) {
            addCriterion("sdcm1 <=", value, "sdcm1");
            return (Criteria) this;
        }

        public Criteria andSdcm1In(List<Integer> values) {
            addCriterion("sdcm1 in", values, "sdcm1");
            return (Criteria) this;
        }

        public Criteria andSdcm1NotIn(List<Integer> values) {
            addCriterion("sdcm1 not in", values, "sdcm1");
            return (Criteria) this;
        }

        public Criteria andSdcm1Between(Integer value1, Integer value2) {
            addCriterion("sdcm1 between", value1, value2, "sdcm1");
            return (Criteria) this;
        }

        public Criteria andSdcm1NotBetween(Integer value1, Integer value2) {
            addCriterion("sdcm1 not between", value1, value2, "sdcm1");
            return (Criteria) this;
        }

        public Criteria andSdcm2IsNull() {
            addCriterion("sdcm2 is null");
            return (Criteria) this;
        }

        public Criteria andSdcm2IsNotNull() {
            addCriterion("sdcm2 is not null");
            return (Criteria) this;
        }

        public Criteria andSdcm2EqualTo(Integer value) {
            addCriterion("sdcm2 =", value, "sdcm2");
            return (Criteria) this;
        }

        public Criteria andSdcm2NotEqualTo(Integer value) {
            addCriterion("sdcm2 <>", value, "sdcm2");
            return (Criteria) this;
        }

        public Criteria andSdcm2GreaterThan(Integer value) {
            addCriterion("sdcm2 >", value, "sdcm2");
            return (Criteria) this;
        }

        public Criteria andSdcm2GreaterThanOrEqualTo(Integer value) {
            addCriterion("sdcm2 >=", value, "sdcm2");
            return (Criteria) this;
        }

        public Criteria andSdcm2LessThan(Integer value) {
            addCriterion("sdcm2 <", value, "sdcm2");
            return (Criteria) this;
        }

        public Criteria andSdcm2LessThanOrEqualTo(Integer value) {
            addCriterion("sdcm2 <=", value, "sdcm2");
            return (Criteria) this;
        }

        public Criteria andSdcm2In(List<Integer> values) {
            addCriterion("sdcm2 in", values, "sdcm2");
            return (Criteria) this;
        }

        public Criteria andSdcm2NotIn(List<Integer> values) {
            addCriterion("sdcm2 not in", values, "sdcm2");
            return (Criteria) this;
        }

        public Criteria andSdcm2Between(Integer value1, Integer value2) {
            addCriterion("sdcm2 between", value1, value2, "sdcm2");
            return (Criteria) this;
        }

        public Criteria andSdcm2NotBetween(Integer value1, Integer value2) {
            addCriterion("sdcm2 not between", value1, value2, "sdcm2");
            return (Criteria) this;
        }

        public Criteria andSdcm3IsNull() {
            addCriterion("sdcm3 is null");
            return (Criteria) this;
        }

        public Criteria andSdcm3IsNotNull() {
            addCriterion("sdcm3 is not null");
            return (Criteria) this;
        }

        public Criteria andSdcm3EqualTo(Integer value) {
            addCriterion("sdcm3 =", value, "sdcm3");
            return (Criteria) this;
        }

        public Criteria andSdcm3NotEqualTo(Integer value) {
            addCriterion("sdcm3 <>", value, "sdcm3");
            return (Criteria) this;
        }

        public Criteria andSdcm3GreaterThan(Integer value) {
            addCriterion("sdcm3 >", value, "sdcm3");
            return (Criteria) this;
        }

        public Criteria andSdcm3GreaterThanOrEqualTo(Integer value) {
            addCriterion("sdcm3 >=", value, "sdcm3");
            return (Criteria) this;
        }

        public Criteria andSdcm3LessThan(Integer value) {
            addCriterion("sdcm3 <", value, "sdcm3");
            return (Criteria) this;
        }

        public Criteria andSdcm3LessThanOrEqualTo(Integer value) {
            addCriterion("sdcm3 <=", value, "sdcm3");
            return (Criteria) this;
        }

        public Criteria andSdcm3In(List<Integer> values) {
            addCriterion("sdcm3 in", values, "sdcm3");
            return (Criteria) this;
        }

        public Criteria andSdcm3NotIn(List<Integer> values) {
            addCriterion("sdcm3 not in", values, "sdcm3");
            return (Criteria) this;
        }

        public Criteria andSdcm3Between(Integer value1, Integer value2) {
            addCriterion("sdcm3 between", value1, value2, "sdcm3");
            return (Criteria) this;
        }

        public Criteria andSdcm3NotBetween(Integer value1, Integer value2) {
            addCriterion("sdcm3 not between", value1, value2, "sdcm3");
            return (Criteria) this;
        }

        public Criteria andSdcm4IsNull() {
            addCriterion("sdcm4 is null");
            return (Criteria) this;
        }

        public Criteria andSdcm4IsNotNull() {
            addCriterion("sdcm4 is not null");
            return (Criteria) this;
        }

        public Criteria andSdcm4EqualTo(Integer value) {
            addCriterion("sdcm4 =", value, "sdcm4");
            return (Criteria) this;
        }

        public Criteria andSdcm4NotEqualTo(Integer value) {
            addCriterion("sdcm4 <>", value, "sdcm4");
            return (Criteria) this;
        }

        public Criteria andSdcm4GreaterThan(Integer value) {
            addCriterion("sdcm4 >", value, "sdcm4");
            return (Criteria) this;
        }

        public Criteria andSdcm4GreaterThanOrEqualTo(Integer value) {
            addCriterion("sdcm4 >=", value, "sdcm4");
            return (Criteria) this;
        }

        public Criteria andSdcm4LessThan(Integer value) {
            addCriterion("sdcm4 <", value, "sdcm4");
            return (Criteria) this;
        }

        public Criteria andSdcm4LessThanOrEqualTo(Integer value) {
            addCriterion("sdcm4 <=", value, "sdcm4");
            return (Criteria) this;
        }

        public Criteria andSdcm4In(List<Integer> values) {
            addCriterion("sdcm4 in", values, "sdcm4");
            return (Criteria) this;
        }

        public Criteria andSdcm4NotIn(List<Integer> values) {
            addCriterion("sdcm4 not in", values, "sdcm4");
            return (Criteria) this;
        }

        public Criteria andSdcm4Between(Integer value1, Integer value2) {
            addCriterion("sdcm4 between", value1, value2, "sdcm4");
            return (Criteria) this;
        }

        public Criteria andSdcm4NotBetween(Integer value1, Integer value2) {
            addCriterion("sdcm4 not between", value1, value2, "sdcm4");
            return (Criteria) this;
        }

        public Criteria andSdcm5IsNull() {
            addCriterion("sdcm5 is null");
            return (Criteria) this;
        }

        public Criteria andSdcm5IsNotNull() {
            addCriterion("sdcm5 is not null");
            return (Criteria) this;
        }

        public Criteria andSdcm5EqualTo(Integer value) {
            addCriterion("sdcm5 =", value, "sdcm5");
            return (Criteria) this;
        }

        public Criteria andSdcm5NotEqualTo(Integer value) {
            addCriterion("sdcm5 <>", value, "sdcm5");
            return (Criteria) this;
        }

        public Criteria andSdcm5GreaterThan(Integer value) {
            addCriterion("sdcm5 >", value, "sdcm5");
            return (Criteria) this;
        }

        public Criteria andSdcm5GreaterThanOrEqualTo(Integer value) {
            addCriterion("sdcm5 >=", value, "sdcm5");
            return (Criteria) this;
        }

        public Criteria andSdcm5LessThan(Integer value) {
            addCriterion("sdcm5 <", value, "sdcm5");
            return (Criteria) this;
        }

        public Criteria andSdcm5LessThanOrEqualTo(Integer value) {
            addCriterion("sdcm5 <=", value, "sdcm5");
            return (Criteria) this;
        }

        public Criteria andSdcm5In(List<Integer> values) {
            addCriterion("sdcm5 in", values, "sdcm5");
            return (Criteria) this;
        }

        public Criteria andSdcm5NotIn(List<Integer> values) {
            addCriterion("sdcm5 not in", values, "sdcm5");
            return (Criteria) this;
        }

        public Criteria andSdcm5Between(Integer value1, Integer value2) {
            addCriterion("sdcm5 between", value1, value2, "sdcm5");
            return (Criteria) this;
        }

        public Criteria andSdcm5NotBetween(Integer value1, Integer value2) {
            addCriterion("sdcm5 not between", value1, value2, "sdcm5");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}