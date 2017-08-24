package com.cn.philips.pojo;

import java.util.ArrayList;
import java.util.List;

public class RulesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RulesExample() {
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
            addCriterion("planId is null");
            return (Criteria) this;
        }

        public Criteria andPlanidIsNotNull() {
            addCriterion("planId is not null");
            return (Criteria) this;
        }

        public Criteria andPlanidEqualTo(Integer value) {
            addCriterion("planId =", value, "planid");
            return (Criteria) this;
        }

        public Criteria andPlanidNotEqualTo(Integer value) {
            addCriterion("planId <>", value, "planid");
            return (Criteria) this;
        }

        public Criteria andPlanidGreaterThan(Integer value) {
            addCriterion("planId >", value, "planid");
            return (Criteria) this;
        }

        public Criteria andPlanidGreaterThanOrEqualTo(Integer value) {
            addCriterion("planId >=", value, "planid");
            return (Criteria) this;
        }

        public Criteria andPlanidLessThan(Integer value) {
            addCriterion("planId <", value, "planid");
            return (Criteria) this;
        }

        public Criteria andPlanidLessThanOrEqualTo(Integer value) {
            addCriterion("planId <=", value, "planid");
            return (Criteria) this;
        }

        public Criteria andPlanidIn(List<Integer> values) {
            addCriterion("planId in", values, "planid");
            return (Criteria) this;
        }

        public Criteria andPlanidNotIn(List<Integer> values) {
            addCriterion("planId not in", values, "planid");
            return (Criteria) this;
        }

        public Criteria andPlanidBetween(Integer value1, Integer value2) {
            addCriterion("planId between", value1, value2, "planid");
            return (Criteria) this;
        }

        public Criteria andPlanidNotBetween(Integer value1, Integer value2) {
            addCriterion("planId not between", value1, value2, "planid");
            return (Criteria) this;
        }

        public Criteria andIsbriactivatedIsNull() {
            addCriterion("isBriActivated is null");
            return (Criteria) this;
        }

        public Criteria andIsbriactivatedIsNotNull() {
            addCriterion("isBriActivated is not null");
            return (Criteria) this;
        }

        public Criteria andIsbriactivatedEqualTo(Integer value) {
            addCriterion("isBriActivated =", value, "isbriactivated");
            return (Criteria) this;
        }

        public Criteria andIsbriactivatedNotEqualTo(Integer value) {
            addCriterion("isBriActivated <>", value, "isbriactivated");
            return (Criteria) this;
        }

        public Criteria andIsbriactivatedGreaterThan(Integer value) {
            addCriterion("isBriActivated >", value, "isbriactivated");
            return (Criteria) this;
        }

        public Criteria andIsbriactivatedGreaterThanOrEqualTo(Integer value) {
            addCriterion("isBriActivated >=", value, "isbriactivated");
            return (Criteria) this;
        }

        public Criteria andIsbriactivatedLessThan(Integer value) {
            addCriterion("isBriActivated <", value, "isbriactivated");
            return (Criteria) this;
        }

        public Criteria andIsbriactivatedLessThanOrEqualTo(Integer value) {
            addCriterion("isBriActivated <=", value, "isbriactivated");
            return (Criteria) this;
        }

        public Criteria andIsbriactivatedIn(List<Integer> values) {
            addCriterion("isBriActivated in", values, "isbriactivated");
            return (Criteria) this;
        }

        public Criteria andIsbriactivatedNotIn(List<Integer> values) {
            addCriterion("isBriActivated not in", values, "isbriactivated");
            return (Criteria) this;
        }

        public Criteria andIsbriactivatedBetween(Integer value1, Integer value2) {
            addCriterion("isBriActivated between", value1, value2, "isbriactivated");
            return (Criteria) this;
        }

        public Criteria andIsbriactivatedNotBetween(Integer value1, Integer value2) {
            addCriterion("isBriActivated not between", value1, value2, "isbriactivated");
            return (Criteria) this;
        }

        public Criteria andBriconditionaIsNull() {
            addCriterion("briConditionA is null");
            return (Criteria) this;
        }

        public Criteria andBriconditionaIsNotNull() {
            addCriterion("briConditionA is not null");
            return (Criteria) this;
        }

        public Criteria andBriconditionaEqualTo(Integer value) {
            addCriterion("briConditionA =", value, "briconditiona");
            return (Criteria) this;
        }

        public Criteria andBriconditionaNotEqualTo(Integer value) {
            addCriterion("briConditionA <>", value, "briconditiona");
            return (Criteria) this;
        }

        public Criteria andBriconditionaGreaterThan(Integer value) {
            addCriterion("briConditionA >", value, "briconditiona");
            return (Criteria) this;
        }

        public Criteria andBriconditionaGreaterThanOrEqualTo(Integer value) {
            addCriterion("briConditionA >=", value, "briconditiona");
            return (Criteria) this;
        }

        public Criteria andBriconditionaLessThan(Integer value) {
            addCriterion("briConditionA <", value, "briconditiona");
            return (Criteria) this;
        }

        public Criteria andBriconditionaLessThanOrEqualTo(Integer value) {
            addCriterion("briConditionA <=", value, "briconditiona");
            return (Criteria) this;
        }

        public Criteria andBriconditionaIn(List<Integer> values) {
            addCriterion("briConditionA in", values, "briconditiona");
            return (Criteria) this;
        }

        public Criteria andBriconditionaNotIn(List<Integer> values) {
            addCriterion("briConditionA not in", values, "briconditiona");
            return (Criteria) this;
        }

        public Criteria andBriconditionaBetween(Integer value1, Integer value2) {
            addCriterion("briConditionA between", value1, value2, "briconditiona");
            return (Criteria) this;
        }

        public Criteria andBriconditionaNotBetween(Integer value1, Integer value2) {
            addCriterion("briConditionA not between", value1, value2, "briconditiona");
            return (Criteria) this;
        }

        public Criteria andBriconditionbIsNull() {
            addCriterion("briConditionB is null");
            return (Criteria) this;
        }

        public Criteria andBriconditionbIsNotNull() {
            addCriterion("briConditionB is not null");
            return (Criteria) this;
        }

        public Criteria andBriconditionbEqualTo(Integer value) {
            addCriterion("briConditionB =", value, "briconditionb");
            return (Criteria) this;
        }

        public Criteria andBriconditionbNotEqualTo(Integer value) {
            addCriterion("briConditionB <>", value, "briconditionb");
            return (Criteria) this;
        }

        public Criteria andBriconditionbGreaterThan(Integer value) {
            addCriterion("briConditionB >", value, "briconditionb");
            return (Criteria) this;
        }

        public Criteria andBriconditionbGreaterThanOrEqualTo(Integer value) {
            addCriterion("briConditionB >=", value, "briconditionb");
            return (Criteria) this;
        }

        public Criteria andBriconditionbLessThan(Integer value) {
            addCriterion("briConditionB <", value, "briconditionb");
            return (Criteria) this;
        }

        public Criteria andBriconditionbLessThanOrEqualTo(Integer value) {
            addCriterion("briConditionB <=", value, "briconditionb");
            return (Criteria) this;
        }

        public Criteria andBriconditionbIn(List<Integer> values) {
            addCriterion("briConditionB in", values, "briconditionb");
            return (Criteria) this;
        }

        public Criteria andBriconditionbNotIn(List<Integer> values) {
            addCriterion("briConditionB not in", values, "briconditionb");
            return (Criteria) this;
        }

        public Criteria andBriconditionbBetween(Integer value1, Integer value2) {
            addCriterion("briConditionB between", value1, value2, "briconditionb");
            return (Criteria) this;
        }

        public Criteria andBriconditionbNotBetween(Integer value1, Integer value2) {
            addCriterion("briConditionB not between", value1, value2, "briconditionb");
            return (Criteria) this;
        }

        public Criteria andIscoloractivatedIsNull() {
            addCriterion("isColorActivated is null");
            return (Criteria) this;
        }

        public Criteria andIscoloractivatedIsNotNull() {
            addCriterion("isColorActivated is not null");
            return (Criteria) this;
        }

        public Criteria andIscoloractivatedEqualTo(Integer value) {
            addCriterion("isColorActivated =", value, "iscoloractivated");
            return (Criteria) this;
        }

        public Criteria andIscoloractivatedNotEqualTo(Integer value) {
            addCriterion("isColorActivated <>", value, "iscoloractivated");
            return (Criteria) this;
        }

        public Criteria andIscoloractivatedGreaterThan(Integer value) {
            addCriterion("isColorActivated >", value, "iscoloractivated");
            return (Criteria) this;
        }

        public Criteria andIscoloractivatedGreaterThanOrEqualTo(Integer value) {
            addCriterion("isColorActivated >=", value, "iscoloractivated");
            return (Criteria) this;
        }

        public Criteria andIscoloractivatedLessThan(Integer value) {
            addCriterion("isColorActivated <", value, "iscoloractivated");
            return (Criteria) this;
        }

        public Criteria andIscoloractivatedLessThanOrEqualTo(Integer value) {
            addCriterion("isColorActivated <=", value, "iscoloractivated");
            return (Criteria) this;
        }

        public Criteria andIscoloractivatedIn(List<Integer> values) {
            addCriterion("isColorActivated in", values, "iscoloractivated");
            return (Criteria) this;
        }

        public Criteria andIscoloractivatedNotIn(List<Integer> values) {
            addCriterion("isColorActivated not in", values, "iscoloractivated");
            return (Criteria) this;
        }

        public Criteria andIscoloractivatedBetween(Integer value1, Integer value2) {
            addCriterion("isColorActivated between", value1, value2, "iscoloractivated");
            return (Criteria) this;
        }

        public Criteria andIscoloractivatedNotBetween(Integer value1, Integer value2) {
            addCriterion("isColorActivated not between", value1, value2, "iscoloractivated");
            return (Criteria) this;
        }

        public Criteria andColorconditionaIsNull() {
            addCriterion("colorConditionA is null");
            return (Criteria) this;
        }

        public Criteria andColorconditionaIsNotNull() {
            addCriterion("colorConditionA is not null");
            return (Criteria) this;
        }

        public Criteria andColorconditionaEqualTo(Integer value) {
            addCriterion("colorConditionA =", value, "colorconditiona");
            return (Criteria) this;
        }

        public Criteria andColorconditionaNotEqualTo(Integer value) {
            addCriterion("colorConditionA <>", value, "colorconditiona");
            return (Criteria) this;
        }

        public Criteria andColorconditionaGreaterThan(Integer value) {
            addCriterion("colorConditionA >", value, "colorconditiona");
            return (Criteria) this;
        }

        public Criteria andColorconditionaGreaterThanOrEqualTo(Integer value) {
            addCriterion("colorConditionA >=", value, "colorconditiona");
            return (Criteria) this;
        }

        public Criteria andColorconditionaLessThan(Integer value) {
            addCriterion("colorConditionA <", value, "colorconditiona");
            return (Criteria) this;
        }

        public Criteria andColorconditionaLessThanOrEqualTo(Integer value) {
            addCriterion("colorConditionA <=", value, "colorconditiona");
            return (Criteria) this;
        }

        public Criteria andColorconditionaIn(List<Integer> values) {
            addCriterion("colorConditionA in", values, "colorconditiona");
            return (Criteria) this;
        }

        public Criteria andColorconditionaNotIn(List<Integer> values) {
            addCriterion("colorConditionA not in", values, "colorconditiona");
            return (Criteria) this;
        }

        public Criteria andColorconditionaBetween(Integer value1, Integer value2) {
            addCriterion("colorConditionA between", value1, value2, "colorconditiona");
            return (Criteria) this;
        }

        public Criteria andColorconditionaNotBetween(Integer value1, Integer value2) {
            addCriterion("colorConditionA not between", value1, value2, "colorconditiona");
            return (Criteria) this;
        }

        public Criteria andColorconditionbIsNull() {
            addCriterion("colorConditionB is null");
            return (Criteria) this;
        }

        public Criteria andColorconditionbIsNotNull() {
            addCriterion("colorConditionB is not null");
            return (Criteria) this;
        }

        public Criteria andColorconditionbEqualTo(Integer value) {
            addCriterion("colorConditionB =", value, "colorconditionb");
            return (Criteria) this;
        }

        public Criteria andColorconditionbNotEqualTo(Integer value) {
            addCriterion("colorConditionB <>", value, "colorconditionb");
            return (Criteria) this;
        }

        public Criteria andColorconditionbGreaterThan(Integer value) {
            addCriterion("colorConditionB >", value, "colorconditionb");
            return (Criteria) this;
        }

        public Criteria andColorconditionbGreaterThanOrEqualTo(Integer value) {
            addCriterion("colorConditionB >=", value, "colorconditionb");
            return (Criteria) this;
        }

        public Criteria andColorconditionbLessThan(Integer value) {
            addCriterion("colorConditionB <", value, "colorconditionb");
            return (Criteria) this;
        }

        public Criteria andColorconditionbLessThanOrEqualTo(Integer value) {
            addCriterion("colorConditionB <=", value, "colorconditionb");
            return (Criteria) this;
        }

        public Criteria andColorconditionbIn(List<Integer> values) {
            addCriterion("colorConditionB in", values, "colorconditionb");
            return (Criteria) this;
        }

        public Criteria andColorconditionbNotIn(List<Integer> values) {
            addCriterion("colorConditionB not in", values, "colorconditionb");
            return (Criteria) this;
        }

        public Criteria andColorconditionbBetween(Integer value1, Integer value2) {
            addCriterion("colorConditionB between", value1, value2, "colorconditionb");
            return (Criteria) this;
        }

        public Criteria andColorconditionbNotBetween(Integer value1, Integer value2) {
            addCriterion("colorConditionB not between", value1, value2, "colorconditionb");
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