package com.cn.philips.pojo;

import java.util.ArrayList;
import java.util.List;

public class G22MatrixExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public G22MatrixExample() {
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

        public Criteria andXg22IsNull() {
            addCriterion("xG22 is null");
            return (Criteria) this;
        }

        public Criteria andXg22IsNotNull() {
            addCriterion("xG22 is not null");
            return (Criteria) this;
        }

        public Criteria andXg22EqualTo(Double value) {
            addCriterion("xG22 =", value, "xg22");
            return (Criteria) this;
        }

        public Criteria andXg22NotEqualTo(Double value) {
            addCriterion("xG22 <>", value, "xg22");
            return (Criteria) this;
        }

        public Criteria andXg22GreaterThan(Double value) {
            addCriterion("xG22 >", value, "xg22");
            return (Criteria) this;
        }

        public Criteria andXg22GreaterThanOrEqualTo(Double value) {
            addCriterion("xG22 >=", value, "xg22");
            return (Criteria) this;
        }

        public Criteria andXg22LessThan(Double value) {
            addCriterion("xG22 <", value, "xg22");
            return (Criteria) this;
        }

        public Criteria andXg22LessThanOrEqualTo(Double value) {
            addCriterion("xG22 <=", value, "xg22");
            return (Criteria) this;
        }

        public Criteria andXg22In(List<Double> values) {
            addCriterion("xG22 in", values, "xg22");
            return (Criteria) this;
        }

        public Criteria andXg22NotIn(List<Double> values) {
            addCriterion("xG22 not in", values, "xg22");
            return (Criteria) this;
        }

        public Criteria andXg22Between(Double value1, Double value2) {
            addCriterion("xG22 between", value1, value2, "xg22");
            return (Criteria) this;
        }

        public Criteria andXg22NotBetween(Double value1, Double value2) {
            addCriterion("xG22 not between", value1, value2, "xg22");
            return (Criteria) this;
        }

        public Criteria andYg22IsNull() {
            addCriterion("yG22 is null");
            return (Criteria) this;
        }

        public Criteria andYg22IsNotNull() {
            addCriterion("yG22 is not null");
            return (Criteria) this;
        }

        public Criteria andYg22EqualTo(Double value) {
            addCriterion("yG22 =", value, "yg22");
            return (Criteria) this;
        }

        public Criteria andYg22NotEqualTo(Double value) {
            addCriterion("yG22 <>", value, "yg22");
            return (Criteria) this;
        }

        public Criteria andYg22GreaterThan(Double value) {
            addCriterion("yG22 >", value, "yg22");
            return (Criteria) this;
        }

        public Criteria andYg22GreaterThanOrEqualTo(Double value) {
            addCriterion("yG22 >=", value, "yg22");
            return (Criteria) this;
        }

        public Criteria andYg22LessThan(Double value) {
            addCriterion("yG22 <", value, "yg22");
            return (Criteria) this;
        }

        public Criteria andYg22LessThanOrEqualTo(Double value) {
            addCriterion("yG22 <=", value, "yg22");
            return (Criteria) this;
        }

        public Criteria andYg22In(List<Double> values) {
            addCriterion("yG22 in", values, "yg22");
            return (Criteria) this;
        }

        public Criteria andYg22NotIn(List<Double> values) {
            addCriterion("yG22 not in", values, "yg22");
            return (Criteria) this;
        }

        public Criteria andYg22Between(Double value1, Double value2) {
            addCriterion("yG22 between", value1, value2, "yg22");
            return (Criteria) this;
        }

        public Criteria andYg22NotBetween(Double value1, Double value2) {
            addCriterion("yG22 not between", value1, value2, "yg22");
            return (Criteria) this;
        }

        public Criteria andWg22IsNull() {
            addCriterion("wG22 is null");
            return (Criteria) this;
        }

        public Criteria andWg22IsNotNull() {
            addCriterion("wG22 is not null");
            return (Criteria) this;
        }

        public Criteria andWg22EqualTo(Double value) {
            addCriterion("wG22 =", value, "wg22");
            return (Criteria) this;
        }

        public Criteria andWg22NotEqualTo(Double value) {
            addCriterion("wG22 <>", value, "wg22");
            return (Criteria) this;
        }

        public Criteria andWg22GreaterThan(Double value) {
            addCriterion("wG22 >", value, "wg22");
            return (Criteria) this;
        }

        public Criteria andWg22GreaterThanOrEqualTo(Double value) {
            addCriterion("wG22 >=", value, "wg22");
            return (Criteria) this;
        }

        public Criteria andWg22LessThan(Double value) {
            addCriterion("wG22 <", value, "wg22");
            return (Criteria) this;
        }

        public Criteria andWg22LessThanOrEqualTo(Double value) {
            addCriterion("wG22 <=", value, "wg22");
            return (Criteria) this;
        }

        public Criteria andWg22In(List<Double> values) {
            addCriterion("wG22 in", values, "wg22");
            return (Criteria) this;
        }

        public Criteria andWg22NotIn(List<Double> values) {
            addCriterion("wG22 not in", values, "wg22");
            return (Criteria) this;
        }

        public Criteria andWg22Between(Double value1, Double value2) {
            addCriterion("wG22 between", value1, value2, "wg22");
            return (Criteria) this;
        }

        public Criteria andWg22NotBetween(Double value1, Double value2) {
            addCriterion("wG22 not between", value1, value2, "wg22");
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