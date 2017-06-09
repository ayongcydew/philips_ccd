package com.cn.philips.pojo;

import java.util.ArrayList;
import java.util.List;

public class EllipticExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EllipticExample() {
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

        public Criteria andAIsNull() {
            addCriterion("a is null");
            return (Criteria) this;
        }

        public Criteria andAIsNotNull() {
            addCriterion("a is not null");
            return (Criteria) this;
        }

        public Criteria andAEqualTo(Double value) {
            addCriterion("a =", value, "a");
            return (Criteria) this;
        }

        public Criteria andANotEqualTo(Double value) {
            addCriterion("a <>", value, "a");
            return (Criteria) this;
        }

        public Criteria andAGreaterThan(Double value) {
            addCriterion("a >", value, "a");
            return (Criteria) this;
        }

        public Criteria andAGreaterThanOrEqualTo(Double value) {
            addCriterion("a >=", value, "a");
            return (Criteria) this;
        }

        public Criteria andALessThan(Double value) {
            addCriterion("a <", value, "a");
            return (Criteria) this;
        }

        public Criteria andALessThanOrEqualTo(Double value) {
            addCriterion("a <=", value, "a");
            return (Criteria) this;
        }

        public Criteria andAIn(List<Double> values) {
            addCriterion("a in", values, "a");
            return (Criteria) this;
        }

        public Criteria andANotIn(List<Double> values) {
            addCriterion("a not in", values, "a");
            return (Criteria) this;
        }

        public Criteria andABetween(Double value1, Double value2) {
            addCriterion("a between", value1, value2, "a");
            return (Criteria) this;
        }

        public Criteria andANotBetween(Double value1, Double value2) {
            addCriterion("a not between", value1, value2, "a");
            return (Criteria) this;
        }

        public Criteria andBIsNull() {
            addCriterion("b is null");
            return (Criteria) this;
        }

        public Criteria andBIsNotNull() {
            addCriterion("b is not null");
            return (Criteria) this;
        }

        public Criteria andBEqualTo(Double value) {
            addCriterion("b =", value, "b");
            return (Criteria) this;
        }

        public Criteria andBNotEqualTo(Double value) {
            addCriterion("b <>", value, "b");
            return (Criteria) this;
        }

        public Criteria andBGreaterThan(Double value) {
            addCriterion("b >", value, "b");
            return (Criteria) this;
        }

        public Criteria andBGreaterThanOrEqualTo(Double value) {
            addCriterion("b >=", value, "b");
            return (Criteria) this;
        }

        public Criteria andBLessThan(Double value) {
            addCriterion("b <", value, "b");
            return (Criteria) this;
        }

        public Criteria andBLessThanOrEqualTo(Double value) {
            addCriterion("b <=", value, "b");
            return (Criteria) this;
        }

        public Criteria andBIn(List<Double> values) {
            addCriterion("b in", values, "b");
            return (Criteria) this;
        }

        public Criteria andBNotIn(List<Double> values) {
            addCriterion("b not in", values, "b");
            return (Criteria) this;
        }

        public Criteria andBBetween(Double value1, Double value2) {
            addCriterion("b between", value1, value2, "b");
            return (Criteria) this;
        }

        public Criteria andBNotBetween(Double value1, Double value2) {
            addCriterion("b not between", value1, value2, "b");
            return (Criteria) this;
        }

        public Criteria andQIsNull() {
            addCriterion("q is null");
            return (Criteria) this;
        }

        public Criteria andQIsNotNull() {
            addCriterion("q is not null");
            return (Criteria) this;
        }

        public Criteria andQEqualTo(Double value) {
            addCriterion("q =", value, "q");
            return (Criteria) this;
        }

        public Criteria andQNotEqualTo(Double value) {
            addCriterion("q <>", value, "q");
            return (Criteria) this;
        }

        public Criteria andQGreaterThan(Double value) {
            addCriterion("q >", value, "q");
            return (Criteria) this;
        }

        public Criteria andQGreaterThanOrEqualTo(Double value) {
            addCriterion("q >=", value, "q");
            return (Criteria) this;
        }

        public Criteria andQLessThan(Double value) {
            addCriterion("q <", value, "q");
            return (Criteria) this;
        }

        public Criteria andQLessThanOrEqualTo(Double value) {
            addCriterion("q <=", value, "q");
            return (Criteria) this;
        }

        public Criteria andQIn(List<Double> values) {
            addCriterion("q in", values, "q");
            return (Criteria) this;
        }

        public Criteria andQNotIn(List<Double> values) {
            addCriterion("q not in", values, "q");
            return (Criteria) this;
        }

        public Criteria andQBetween(Double value1, Double value2) {
            addCriterion("q between", value1, value2, "q");
            return (Criteria) this;
        }

        public Criteria andQNotBetween(Double value1, Double value2) {
            addCriterion("q not between", value1, value2, "q");
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