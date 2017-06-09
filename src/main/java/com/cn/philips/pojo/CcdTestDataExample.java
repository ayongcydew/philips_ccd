package com.cn.philips.pojo;

import java.util.ArrayList;
import java.util.List;

public class CcdTestDataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CcdTestDataExample() {
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

        public Criteria andPlanNameIsNull() {
            addCriterion("plan_name is null");
            return (Criteria) this;
        }

        public Criteria andPlanNameIsNotNull() {
            addCriterion("plan_name is not null");
            return (Criteria) this;
        }

        public Criteria andPlanNameEqualTo(String value) {
            addCriterion("plan_name =", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameNotEqualTo(String value) {
            addCriterion("plan_name <>", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameGreaterThan(String value) {
            addCriterion("plan_name >", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameGreaterThanOrEqualTo(String value) {
            addCriterion("plan_name >=", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameLessThan(String value) {
            addCriterion("plan_name <", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameLessThanOrEqualTo(String value) {
            addCriterion("plan_name <=", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameLike(String value) {
            addCriterion("plan_name like", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameNotLike(String value) {
            addCriterion("plan_name not like", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameIn(List<String> values) {
            addCriterion("plan_name in", values, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameNotIn(List<String> values) {
            addCriterion("plan_name not in", values, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameBetween(String value1, String value2) {
            addCriterion("plan_name between", value1, value2, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameNotBetween(String value1, String value2) {
            addCriterion("plan_name not between", value1, value2, "planName");
            return (Criteria) this;
        }

        public Criteria andLocxIsNull() {
            addCriterion("locx is null");
            return (Criteria) this;
        }

        public Criteria andLocxIsNotNull() {
            addCriterion("locx is not null");
            return (Criteria) this;
        }

        public Criteria andLocxEqualTo(Integer value) {
            addCriterion("locx =", value, "locx");
            return (Criteria) this;
        }

        public Criteria andLocxNotEqualTo(Integer value) {
            addCriterion("locx <>", value, "locx");
            return (Criteria) this;
        }

        public Criteria andLocxGreaterThan(Integer value) {
            addCriterion("locx >", value, "locx");
            return (Criteria) this;
        }

        public Criteria andLocxGreaterThanOrEqualTo(Integer value) {
            addCriterion("locx >=", value, "locx");
            return (Criteria) this;
        }

        public Criteria andLocxLessThan(Integer value) {
            addCriterion("locx <", value, "locx");
            return (Criteria) this;
        }

        public Criteria andLocxLessThanOrEqualTo(Integer value) {
            addCriterion("locx <=", value, "locx");
            return (Criteria) this;
        }

        public Criteria andLocxIn(List<Integer> values) {
            addCriterion("locx in", values, "locx");
            return (Criteria) this;
        }

        public Criteria andLocxNotIn(List<Integer> values) {
            addCriterion("locx not in", values, "locx");
            return (Criteria) this;
        }

        public Criteria andLocxBetween(Integer value1, Integer value2) {
            addCriterion("locx between", value1, value2, "locx");
            return (Criteria) this;
        }

        public Criteria andLocxNotBetween(Integer value1, Integer value2) {
            addCriterion("locx not between", value1, value2, "locx");
            return (Criteria) this;
        }

        public Criteria andLocyIsNull() {
            addCriterion("locy is null");
            return (Criteria) this;
        }

        public Criteria andLocyIsNotNull() {
            addCriterion("locy is not null");
            return (Criteria) this;
        }

        public Criteria andLocyEqualTo(Integer value) {
            addCriterion("locy =", value, "locy");
            return (Criteria) this;
        }

        public Criteria andLocyNotEqualTo(Integer value) {
            addCriterion("locy <>", value, "locy");
            return (Criteria) this;
        }

        public Criteria andLocyGreaterThan(Integer value) {
            addCriterion("locy >", value, "locy");
            return (Criteria) this;
        }

        public Criteria andLocyGreaterThanOrEqualTo(Integer value) {
            addCriterion("locy >=", value, "locy");
            return (Criteria) this;
        }

        public Criteria andLocyLessThan(Integer value) {
            addCriterion("locy <", value, "locy");
            return (Criteria) this;
        }

        public Criteria andLocyLessThanOrEqualTo(Integer value) {
            addCriterion("locy <=", value, "locy");
            return (Criteria) this;
        }

        public Criteria andLocyIn(List<Integer> values) {
            addCriterion("locy in", values, "locy");
            return (Criteria) this;
        }

        public Criteria andLocyNotIn(List<Integer> values) {
            addCriterion("locy not in", values, "locy");
            return (Criteria) this;
        }

        public Criteria andLocyBetween(Integer value1, Integer value2) {
            addCriterion("locy between", value1, value2, "locy");
            return (Criteria) this;
        }

        public Criteria andLocyNotBetween(Integer value1, Integer value2) {
            addCriterion("locy not between", value1, value2, "locy");
            return (Criteria) this;
        }

        public Criteria andBriIsNull() {
            addCriterion("bri is null");
            return (Criteria) this;
        }

        public Criteria andBriIsNotNull() {
            addCriterion("bri is not null");
            return (Criteria) this;
        }

        public Criteria andBriEqualTo(Double value) {
            addCriterion("bri =", value, "bri");
            return (Criteria) this;
        }

        public Criteria andBriNotEqualTo(Double value) {
            addCriterion("bri <>", value, "bri");
            return (Criteria) this;
        }

        public Criteria andBriGreaterThan(Double value) {
            addCriterion("bri >", value, "bri");
            return (Criteria) this;
        }

        public Criteria andBriGreaterThanOrEqualTo(Double value) {
            addCriterion("bri >=", value, "bri");
            return (Criteria) this;
        }

        public Criteria andBriLessThan(Double value) {
            addCriterion("bri <", value, "bri");
            return (Criteria) this;
        }

        public Criteria andBriLessThanOrEqualTo(Double value) {
            addCriterion("bri <=", value, "bri");
            return (Criteria) this;
        }

        public Criteria andBriIn(List<Double> values) {
            addCriterion("bri in", values, "bri");
            return (Criteria) this;
        }

        public Criteria andBriNotIn(List<Double> values) {
            addCriterion("bri not in", values, "bri");
            return (Criteria) this;
        }

        public Criteria andBriBetween(Double value1, Double value2) {
            addCriterion("bri between", value1, value2, "bri");
            return (Criteria) this;
        }

        public Criteria andBriNotBetween(Double value1, Double value2) {
            addCriterion("bri not between", value1, value2, "bri");
            return (Criteria) this;
        }

        public Criteria andXIsNull() {
            addCriterion("x is null");
            return (Criteria) this;
        }

        public Criteria andXIsNotNull() {
            addCriterion("x is not null");
            return (Criteria) this;
        }

        public Criteria andXEqualTo(Double value) {
            addCriterion("x =", value, "x");
            return (Criteria) this;
        }

        public Criteria andXNotEqualTo(Double value) {
            addCriterion("x <>", value, "x");
            return (Criteria) this;
        }

        public Criteria andXGreaterThan(Double value) {
            addCriterion("x >", value, "x");
            return (Criteria) this;
        }

        public Criteria andXGreaterThanOrEqualTo(Double value) {
            addCriterion("x >=", value, "x");
            return (Criteria) this;
        }

        public Criteria andXLessThan(Double value) {
            addCriterion("x <", value, "x");
            return (Criteria) this;
        }

        public Criteria andXLessThanOrEqualTo(Double value) {
            addCriterion("x <=", value, "x");
            return (Criteria) this;
        }

        public Criteria andXIn(List<Double> values) {
            addCriterion("x in", values, "x");
            return (Criteria) this;
        }

        public Criteria andXNotIn(List<Double> values) {
            addCriterion("x not in", values, "x");
            return (Criteria) this;
        }

        public Criteria andXBetween(Double value1, Double value2) {
            addCriterion("x between", value1, value2, "x");
            return (Criteria) this;
        }

        public Criteria andXNotBetween(Double value1, Double value2) {
            addCriterion("x not between", value1, value2, "x");
            return (Criteria) this;
        }

        public Criteria andYIsNull() {
            addCriterion("y is null");
            return (Criteria) this;
        }

        public Criteria andYIsNotNull() {
            addCriterion("y is not null");
            return (Criteria) this;
        }

        public Criteria andYEqualTo(Double value) {
            addCriterion("y =", value, "y");
            return (Criteria) this;
        }

        public Criteria andYNotEqualTo(Double value) {
            addCriterion("y <>", value, "y");
            return (Criteria) this;
        }

        public Criteria andYGreaterThan(Double value) {
            addCriterion("y >", value, "y");
            return (Criteria) this;
        }

        public Criteria andYGreaterThanOrEqualTo(Double value) {
            addCriterion("y >=", value, "y");
            return (Criteria) this;
        }

        public Criteria andYLessThan(Double value) {
            addCriterion("y <", value, "y");
            return (Criteria) this;
        }

        public Criteria andYLessThanOrEqualTo(Double value) {
            addCriterion("y <=", value, "y");
            return (Criteria) this;
        }

        public Criteria andYIn(List<Double> values) {
            addCriterion("y in", values, "y");
            return (Criteria) this;
        }

        public Criteria andYNotIn(List<Double> values) {
            addCriterion("y not in", values, "y");
            return (Criteria) this;
        }

        public Criteria andYBetween(Double value1, Double value2) {
            addCriterion("y between", value1, value2, "y");
            return (Criteria) this;
        }

        public Criteria andYNotBetween(Double value1, Double value2) {
            addCriterion("y not between", value1, value2, "y");
            return (Criteria) this;
        }

        public Criteria andUIsNull() {
            addCriterion("u is null");
            return (Criteria) this;
        }

        public Criteria andUIsNotNull() {
            addCriterion("u is not null");
            return (Criteria) this;
        }

        public Criteria andUEqualTo(Double value) {
            addCriterion("u =", value, "u");
            return (Criteria) this;
        }

        public Criteria andUNotEqualTo(Double value) {
            addCriterion("u <>", value, "u");
            return (Criteria) this;
        }

        public Criteria andUGreaterThan(Double value) {
            addCriterion("u >", value, "u");
            return (Criteria) this;
        }

        public Criteria andUGreaterThanOrEqualTo(Double value) {
            addCriterion("u >=", value, "u");
            return (Criteria) this;
        }

        public Criteria andULessThan(Double value) {
            addCriterion("u <", value, "u");
            return (Criteria) this;
        }

        public Criteria andULessThanOrEqualTo(Double value) {
            addCriterion("u <=", value, "u");
            return (Criteria) this;
        }

        public Criteria andUIn(List<Double> values) {
            addCriterion("u in", values, "u");
            return (Criteria) this;
        }

        public Criteria andUNotIn(List<Double> values) {
            addCriterion("u not in", values, "u");
            return (Criteria) this;
        }

        public Criteria andUBetween(Double value1, Double value2) {
            addCriterion("u between", value1, value2, "u");
            return (Criteria) this;
        }

        public Criteria andUNotBetween(Double value1, Double value2) {
            addCriterion("u not between", value1, value2, "u");
            return (Criteria) this;
        }

        public Criteria andVIsNull() {
            addCriterion("v is null");
            return (Criteria) this;
        }

        public Criteria andVIsNotNull() {
            addCriterion("v is not null");
            return (Criteria) this;
        }

        public Criteria andVEqualTo(Double value) {
            addCriterion("v =", value, "v");
            return (Criteria) this;
        }

        public Criteria andVNotEqualTo(Double value) {
            addCriterion("v <>", value, "v");
            return (Criteria) this;
        }

        public Criteria andVGreaterThan(Double value) {
            addCriterion("v >", value, "v");
            return (Criteria) this;
        }

        public Criteria andVGreaterThanOrEqualTo(Double value) {
            addCriterion("v >=", value, "v");
            return (Criteria) this;
        }

        public Criteria andVLessThan(Double value) {
            addCriterion("v <", value, "v");
            return (Criteria) this;
        }

        public Criteria andVLessThanOrEqualTo(Double value) {
            addCriterion("v <=", value, "v");
            return (Criteria) this;
        }

        public Criteria andVIn(List<Double> values) {
            addCriterion("v in", values, "v");
            return (Criteria) this;
        }

        public Criteria andVNotIn(List<Double> values) {
            addCriterion("v not in", values, "v");
            return (Criteria) this;
        }

        public Criteria andVBetween(Double value1, Double value2) {
            addCriterion("v between", value1, value2, "v");
            return (Criteria) this;
        }

        public Criteria andVNotBetween(Double value1, Double value2) {
            addCriterion("v not between", value1, value2, "v");
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