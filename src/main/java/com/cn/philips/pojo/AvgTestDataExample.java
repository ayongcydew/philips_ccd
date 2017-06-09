package com.cn.philips.pojo;

import java.util.ArrayList;
import java.util.List;

public class AvgTestDataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AvgTestDataExample() {
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

        public Criteria andAvgBriIsNull() {
            addCriterion("avg_bri is null");
            return (Criteria) this;
        }

        public Criteria andAvgBriIsNotNull() {
            addCriterion("avg_bri is not null");
            return (Criteria) this;
        }

        public Criteria andAvgBriEqualTo(Double value) {
            addCriterion("avg_bri =", value, "avgBri");
            return (Criteria) this;
        }

        public Criteria andAvgBriNotEqualTo(Double value) {
            addCriterion("avg_bri <>", value, "avgBri");
            return (Criteria) this;
        }

        public Criteria andAvgBriGreaterThan(Double value) {
            addCriterion("avg_bri >", value, "avgBri");
            return (Criteria) this;
        }

        public Criteria andAvgBriGreaterThanOrEqualTo(Double value) {
            addCriterion("avg_bri >=", value, "avgBri");
            return (Criteria) this;
        }

        public Criteria andAvgBriLessThan(Double value) {
            addCriterion("avg_bri <", value, "avgBri");
            return (Criteria) this;
        }

        public Criteria andAvgBriLessThanOrEqualTo(Double value) {
            addCriterion("avg_bri <=", value, "avgBri");
            return (Criteria) this;
        }

        public Criteria andAvgBriIn(List<Double> values) {
            addCriterion("avg_bri in", values, "avgBri");
            return (Criteria) this;
        }

        public Criteria andAvgBriNotIn(List<Double> values) {
            addCriterion("avg_bri not in", values, "avgBri");
            return (Criteria) this;
        }

        public Criteria andAvgBriBetween(Double value1, Double value2) {
            addCriterion("avg_bri between", value1, value2, "avgBri");
            return (Criteria) this;
        }

        public Criteria andAvgBriNotBetween(Double value1, Double value2) {
            addCriterion("avg_bri not between", value1, value2, "avgBri");
            return (Criteria) this;
        }

        public Criteria andAvgXIsNull() {
            addCriterion("avg_x is null");
            return (Criteria) this;
        }

        public Criteria andAvgXIsNotNull() {
            addCriterion("avg_x is not null");
            return (Criteria) this;
        }

        public Criteria andAvgXEqualTo(Double value) {
            addCriterion("avg_x =", value, "avgX");
            return (Criteria) this;
        }

        public Criteria andAvgXNotEqualTo(Double value) {
            addCriterion("avg_x <>", value, "avgX");
            return (Criteria) this;
        }

        public Criteria andAvgXGreaterThan(Double value) {
            addCriterion("avg_x >", value, "avgX");
            return (Criteria) this;
        }

        public Criteria andAvgXGreaterThanOrEqualTo(Double value) {
            addCriterion("avg_x >=", value, "avgX");
            return (Criteria) this;
        }

        public Criteria andAvgXLessThan(Double value) {
            addCriterion("avg_x <", value, "avgX");
            return (Criteria) this;
        }

        public Criteria andAvgXLessThanOrEqualTo(Double value) {
            addCriterion("avg_x <=", value, "avgX");
            return (Criteria) this;
        }

        public Criteria andAvgXIn(List<Double> values) {
            addCriterion("avg_x in", values, "avgX");
            return (Criteria) this;
        }

        public Criteria andAvgXNotIn(List<Double> values) {
            addCriterion("avg_x not in", values, "avgX");
            return (Criteria) this;
        }

        public Criteria andAvgXBetween(Double value1, Double value2) {
            addCriterion("avg_x between", value1, value2, "avgX");
            return (Criteria) this;
        }

        public Criteria andAvgXNotBetween(Double value1, Double value2) {
            addCriterion("avg_x not between", value1, value2, "avgX");
            return (Criteria) this;
        }

        public Criteria andAvgYIsNull() {
            addCriterion("avg_y is null");
            return (Criteria) this;
        }

        public Criteria andAvgYIsNotNull() {
            addCriterion("avg_y is not null");
            return (Criteria) this;
        }

        public Criteria andAvgYEqualTo(Double value) {
            addCriterion("avg_y =", value, "avgY");
            return (Criteria) this;
        }

        public Criteria andAvgYNotEqualTo(Double value) {
            addCriterion("avg_y <>", value, "avgY");
            return (Criteria) this;
        }

        public Criteria andAvgYGreaterThan(Double value) {
            addCriterion("avg_y >", value, "avgY");
            return (Criteria) this;
        }

        public Criteria andAvgYGreaterThanOrEqualTo(Double value) {
            addCriterion("avg_y >=", value, "avgY");
            return (Criteria) this;
        }

        public Criteria andAvgYLessThan(Double value) {
            addCriterion("avg_y <", value, "avgY");
            return (Criteria) this;
        }

        public Criteria andAvgYLessThanOrEqualTo(Double value) {
            addCriterion("avg_y <=", value, "avgY");
            return (Criteria) this;
        }

        public Criteria andAvgYIn(List<Double> values) {
            addCriterion("avg_y in", values, "avgY");
            return (Criteria) this;
        }

        public Criteria andAvgYNotIn(List<Double> values) {
            addCriterion("avg_y not in", values, "avgY");
            return (Criteria) this;
        }

        public Criteria andAvgYBetween(Double value1, Double value2) {
            addCriterion("avg_y between", value1, value2, "avgY");
            return (Criteria) this;
        }

        public Criteria andAvgYNotBetween(Double value1, Double value2) {
            addCriterion("avg_y not between", value1, value2, "avgY");
            return (Criteria) this;
        }

        public Criteria andAvgUIsNull() {
            addCriterion("avg_u is null");
            return (Criteria) this;
        }

        public Criteria andAvgUIsNotNull() {
            addCriterion("avg_u is not null");
            return (Criteria) this;
        }

        public Criteria andAvgUEqualTo(Double value) {
            addCriterion("avg_u =", value, "avgU");
            return (Criteria) this;
        }

        public Criteria andAvgUNotEqualTo(Double value) {
            addCriterion("avg_u <>", value, "avgU");
            return (Criteria) this;
        }

        public Criteria andAvgUGreaterThan(Double value) {
            addCriterion("avg_u >", value, "avgU");
            return (Criteria) this;
        }

        public Criteria andAvgUGreaterThanOrEqualTo(Double value) {
            addCriterion("avg_u >=", value, "avgU");
            return (Criteria) this;
        }

        public Criteria andAvgULessThan(Double value) {
            addCriterion("avg_u <", value, "avgU");
            return (Criteria) this;
        }

        public Criteria andAvgULessThanOrEqualTo(Double value) {
            addCriterion("avg_u <=", value, "avgU");
            return (Criteria) this;
        }

        public Criteria andAvgUIn(List<Double> values) {
            addCriterion("avg_u in", values, "avgU");
            return (Criteria) this;
        }

        public Criteria andAvgUNotIn(List<Double> values) {
            addCriterion("avg_u not in", values, "avgU");
            return (Criteria) this;
        }

        public Criteria andAvgUBetween(Double value1, Double value2) {
            addCriterion("avg_u between", value1, value2, "avgU");
            return (Criteria) this;
        }

        public Criteria andAvgUNotBetween(Double value1, Double value2) {
            addCriterion("avg_u not between", value1, value2, "avgU");
            return (Criteria) this;
        }

        public Criteria andAvgVIsNull() {
            addCriterion("avg_v is null");
            return (Criteria) this;
        }

        public Criteria andAvgVIsNotNull() {
            addCriterion("avg_v is not null");
            return (Criteria) this;
        }

        public Criteria andAvgVEqualTo(Double value) {
            addCriterion("avg_v =", value, "avgV");
            return (Criteria) this;
        }

        public Criteria andAvgVNotEqualTo(Double value) {
            addCriterion("avg_v <>", value, "avgV");
            return (Criteria) this;
        }

        public Criteria andAvgVGreaterThan(Double value) {
            addCriterion("avg_v >", value, "avgV");
            return (Criteria) this;
        }

        public Criteria andAvgVGreaterThanOrEqualTo(Double value) {
            addCriterion("avg_v >=", value, "avgV");
            return (Criteria) this;
        }

        public Criteria andAvgVLessThan(Double value) {
            addCriterion("avg_v <", value, "avgV");
            return (Criteria) this;
        }

        public Criteria andAvgVLessThanOrEqualTo(Double value) {
            addCriterion("avg_v <=", value, "avgV");
            return (Criteria) this;
        }

        public Criteria andAvgVIn(List<Double> values) {
            addCriterion("avg_v in", values, "avgV");
            return (Criteria) this;
        }

        public Criteria andAvgVNotIn(List<Double> values) {
            addCriterion("avg_v not in", values, "avgV");
            return (Criteria) this;
        }

        public Criteria andAvgVBetween(Double value1, Double value2) {
            addCriterion("avg_v between", value1, value2, "avgV");
            return (Criteria) this;
        }

        public Criteria andAvgVNotBetween(Double value1, Double value2) {
            addCriterion("avg_v not between", value1, value2, "avgV");
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