package com.cn.philips.pojo;

import java.util.ArrayList;
import java.util.List;

public class G12MatrixExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public G12MatrixExample() {
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
            addCriterion("Id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("Id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("Id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("Id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("Id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("Id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("Id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("Id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("Id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("Id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andXg12IsNull() {
            addCriterion("xG12 is null");
            return (Criteria) this;
        }

        public Criteria andXg12IsNotNull() {
            addCriterion("xG12 is not null");
            return (Criteria) this;
        }

        public Criteria andXg12EqualTo(Double value) {
            addCriterion("xG12 =", value, "xg12");
            return (Criteria) this;
        }

        public Criteria andXg12NotEqualTo(Double value) {
            addCriterion("xG12 <>", value, "xg12");
            return (Criteria) this;
        }

        public Criteria andXg12GreaterThan(Double value) {
            addCriterion("xG12 >", value, "xg12");
            return (Criteria) this;
        }

        public Criteria andXg12GreaterThanOrEqualTo(Double value) {
            addCriterion("xG12 >=", value, "xg12");
            return (Criteria) this;
        }

        public Criteria andXg12LessThan(Double value) {
            addCriterion("xG12 <", value, "xg12");
            return (Criteria) this;
        }

        public Criteria andXg12LessThanOrEqualTo(Double value) {
            addCriterion("xG12 <=", value, "xg12");
            return (Criteria) this;
        }

        public Criteria andXg12In(List<Double> values) {
            addCriterion("xG12 in", values, "xg12");
            return (Criteria) this;
        }

        public Criteria andXg12NotIn(List<Double> values) {
            addCriterion("xG12 not in", values, "xg12");
            return (Criteria) this;
        }

        public Criteria andXg12Between(Double value1, Double value2) {
            addCriterion("xG12 between", value1, value2, "xg12");
            return (Criteria) this;
        }

        public Criteria andXg12NotBetween(Double value1, Double value2) {
            addCriterion("xG12 not between", value1, value2, "xg12");
            return (Criteria) this;
        }

        public Criteria andYg12IsNull() {
            addCriterion("yG12 is null");
            return (Criteria) this;
        }

        public Criteria andYg12IsNotNull() {
            addCriterion("yG12 is not null");
            return (Criteria) this;
        }

        public Criteria andYg12EqualTo(Double value) {
            addCriterion("yG12 =", value, "yg12");
            return (Criteria) this;
        }

        public Criteria andYg12NotEqualTo(Double value) {
            addCriterion("yG12 <>", value, "yg12");
            return (Criteria) this;
        }

        public Criteria andYg12GreaterThan(Double value) {
            addCriterion("yG12 >", value, "yg12");
            return (Criteria) this;
        }

        public Criteria andYg12GreaterThanOrEqualTo(Double value) {
            addCriterion("yG12 >=", value, "yg12");
            return (Criteria) this;
        }

        public Criteria andYg12LessThan(Double value) {
            addCriterion("yG12 <", value, "yg12");
            return (Criteria) this;
        }

        public Criteria andYg12LessThanOrEqualTo(Double value) {
            addCriterion("yG12 <=", value, "yg12");
            return (Criteria) this;
        }

        public Criteria andYg12In(List<Double> values) {
            addCriterion("yG12 in", values, "yg12");
            return (Criteria) this;
        }

        public Criteria andYg12NotIn(List<Double> values) {
            addCriterion("yG12 not in", values, "yg12");
            return (Criteria) this;
        }

        public Criteria andYg12Between(Double value1, Double value2) {
            addCriterion("yG12 between", value1, value2, "yg12");
            return (Criteria) this;
        }

        public Criteria andYg12NotBetween(Double value1, Double value2) {
            addCriterion("yG12 not between", value1, value2, "yg12");
            return (Criteria) this;
        }

        public Criteria andWg12IsNull() {
            addCriterion("wG12 is null");
            return (Criteria) this;
        }

        public Criteria andWg12IsNotNull() {
            addCriterion("wG12 is not null");
            return (Criteria) this;
        }

        public Criteria andWg12EqualTo(Double value) {
            addCriterion("wG12 =", value, "wg12");
            return (Criteria) this;
        }

        public Criteria andWg12NotEqualTo(Double value) {
            addCriterion("wG12 <>", value, "wg12");
            return (Criteria) this;
        }

        public Criteria andWg12GreaterThan(Double value) {
            addCriterion("wG12 >", value, "wg12");
            return (Criteria) this;
        }

        public Criteria andWg12GreaterThanOrEqualTo(Double value) {
            addCriterion("wG12 >=", value, "wg12");
            return (Criteria) this;
        }

        public Criteria andWg12LessThan(Double value) {
            addCriterion("wG12 <", value, "wg12");
            return (Criteria) this;
        }

        public Criteria andWg12LessThanOrEqualTo(Double value) {
            addCriterion("wG12 <=", value, "wg12");
            return (Criteria) this;
        }

        public Criteria andWg12In(List<Double> values) {
            addCriterion("wG12 in", values, "wg12");
            return (Criteria) this;
        }

        public Criteria andWg12NotIn(List<Double> values) {
            addCriterion("wG12 not in", values, "wg12");
            return (Criteria) this;
        }

        public Criteria andWg12Between(Double value1, Double value2) {
            addCriterion("wG12 between", value1, value2, "wg12");
            return (Criteria) this;
        }

        public Criteria andWg12NotBetween(Double value1, Double value2) {
            addCriterion("wG12 not between", value1, value2, "wg12");
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