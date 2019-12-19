package com.tx.txv_common.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TxPosterExample extends BaseExample{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TxPosterExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andPostIdIsNull() {
            addCriterion("POST_ID is null");
            return (Criteria) this;
        }

        public Criteria andPostIdIsNotNull() {
            addCriterion("POST_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPostIdEqualTo(String value) {
            addCriterion("POST_ID =", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdNotEqualTo(String value) {
            addCriterion("POST_ID <>", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdGreaterThan(String value) {
            addCriterion("POST_ID >", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdGreaterThanOrEqualTo(String value) {
            addCriterion("POST_ID >=", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdLessThan(String value) {
            addCriterion("POST_ID <", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdLessThanOrEqualTo(String value) {
            addCriterion("POST_ID <=", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdLike(String value) {
            addCriterion("POST_ID like", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdNotLike(String value) {
            addCriterion("POST_ID not like", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdIn(List<String> values) {
            addCriterion("POST_ID in", values, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdNotIn(List<String> values) {
            addCriterion("POST_ID not in", values, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdBetween(String value1, String value2) {
            addCriterion("POST_ID between", value1, value2, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdNotBetween(String value1, String value2) {
            addCriterion("POST_ID not between", value1, value2, "postId");
            return (Criteria) this;
        }

        public Criteria andPostNameIsNull() {
            addCriterion("POST_NAME is null");
            return (Criteria) this;
        }

        public Criteria andPostNameIsNotNull() {
            addCriterion("POST_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andPostNameEqualTo(String value) {
            addCriterion("POST_NAME =", value, "postName");
            return (Criteria) this;
        }

        public Criteria andPostNameNotEqualTo(String value) {
            addCriterion("POST_NAME <>", value, "postName");
            return (Criteria) this;
        }

        public Criteria andPostNameGreaterThan(String value) {
            addCriterion("POST_NAME >", value, "postName");
            return (Criteria) this;
        }

        public Criteria andPostNameGreaterThanOrEqualTo(String value) {
            addCriterion("POST_NAME >=", value, "postName");
            return (Criteria) this;
        }

        public Criteria andPostNameLessThan(String value) {
            addCriterion("POST_NAME <", value, "postName");
            return (Criteria) this;
        }

        public Criteria andPostNameLessThanOrEqualTo(String value) {
            addCriterion("POST_NAME <=", value, "postName");
            return (Criteria) this;
        }

        public Criteria andPostNameLike(String value) {
            addCriterion("POST_NAME like", value, "postName");
            return (Criteria) this;
        }

        public Criteria andPostNameNotLike(String value) {
            addCriterion("POST_NAME not like", value, "postName");
            return (Criteria) this;
        }

        public Criteria andPostNameIn(List<String> values) {
            addCriterion("POST_NAME in", values, "postName");
            return (Criteria) this;
        }

        public Criteria andPostNameNotIn(List<String> values) {
            addCriterion("POST_NAME not in", values, "postName");
            return (Criteria) this;
        }

        public Criteria andPostNameBetween(String value1, String value2) {
            addCriterion("POST_NAME between", value1, value2, "postName");
            return (Criteria) this;
        }

        public Criteria andPostNameNotBetween(String value1, String value2) {
            addCriterion("POST_NAME not between", value1, value2, "postName");
            return (Criteria) this;
        }

        public Criteria andPostLocationIsNull() {
            addCriterion("POST_LOCATION is null");
            return (Criteria) this;
        }

        public Criteria andPostLocationIsNotNull() {
            addCriterion("POST_LOCATION is not null");
            return (Criteria) this;
        }

        public Criteria andPostLocationEqualTo(String value) {
            addCriterion("POST_LOCATION =", value, "postLocation");
            return (Criteria) this;
        }

        public Criteria andPostLocationNotEqualTo(String value) {
            addCriterion("POST_LOCATION <>", value, "postLocation");
            return (Criteria) this;
        }

        public Criteria andPostLocationGreaterThan(String value) {
            addCriterion("POST_LOCATION >", value, "postLocation");
            return (Criteria) this;
        }

        public Criteria andPostLocationGreaterThanOrEqualTo(String value) {
            addCriterion("POST_LOCATION >=", value, "postLocation");
            return (Criteria) this;
        }

        public Criteria andPostLocationLessThan(String value) {
            addCriterion("POST_LOCATION <", value, "postLocation");
            return (Criteria) this;
        }

        public Criteria andPostLocationLessThanOrEqualTo(String value) {
            addCriterion("POST_LOCATION <=", value, "postLocation");
            return (Criteria) this;
        }

        public Criteria andPostLocationLike(String value) {
            addCriterion("POST_LOCATION like", value, "postLocation");
            return (Criteria) this;
        }

        public Criteria andPostLocationNotLike(String value) {
            addCriterion("POST_LOCATION not like", value, "postLocation");
            return (Criteria) this;
        }

        public Criteria andPostLocationIn(List<String> values) {
            addCriterion("POST_LOCATION in", values, "postLocation");
            return (Criteria) this;
        }

        public Criteria andPostLocationNotIn(List<String> values) {
            addCriterion("POST_LOCATION not in", values, "postLocation");
            return (Criteria) this;
        }

        public Criteria andPostLocationBetween(String value1, String value2) {
            addCriterion("POST_LOCATION between", value1, value2, "postLocation");
            return (Criteria) this;
        }

        public Criteria andPostLocationNotBetween(String value1, String value2) {
            addCriterion("POST_LOCATION not between", value1, value2, "postLocation");
            return (Criteria) this;
        }

        public Criteria andPostLableIsNull() {
            addCriterion("POST_LABLE is null");
            return (Criteria) this;
        }

        public Criteria andPostLableIsNotNull() {
            addCriterion("POST_LABLE is not null");
            return (Criteria) this;
        }

        public Criteria andPostLableEqualTo(String value) {
            addCriterion("POST_LABLE =", value, "postLable");
            return (Criteria) this;
        }

        public Criteria andPostLableNotEqualTo(String value) {
            addCriterion("POST_LABLE <>", value, "postLable");
            return (Criteria) this;
        }

        public Criteria andPostLableGreaterThan(String value) {
            addCriterion("POST_LABLE >", value, "postLable");
            return (Criteria) this;
        }

        public Criteria andPostLableGreaterThanOrEqualTo(String value) {
            addCriterion("POST_LABLE >=", value, "postLable");
            return (Criteria) this;
        }

        public Criteria andPostLableLessThan(String value) {
            addCriterion("POST_LABLE <", value, "postLable");
            return (Criteria) this;
        }

        public Criteria andPostLableLessThanOrEqualTo(String value) {
            addCriterion("POST_LABLE <=", value, "postLable");
            return (Criteria) this;
        }

        public Criteria andPostLableLike(String value) {
            addCriterion("POST_LABLE like", value, "postLable");
            return (Criteria) this;
        }

        public Criteria andPostLableNotLike(String value) {
            addCriterion("POST_LABLE not like", value, "postLable");
            return (Criteria) this;
        }

        public Criteria andPostLableIn(List<String> values) {
            addCriterion("POST_LABLE in", values, "postLable");
            return (Criteria) this;
        }

        public Criteria andPostLableNotIn(List<String> values) {
            addCriterion("POST_LABLE not in", values, "postLable");
            return (Criteria) this;
        }

        public Criteria andPostLableBetween(String value1, String value2) {
            addCriterion("POST_LABLE between", value1, value2, "postLable");
            return (Criteria) this;
        }

        public Criteria andPostLableNotBetween(String value1, String value2) {
            addCriterion("POST_LABLE not between", value1, value2, "postLable");
            return (Criteria) this;
        }

        public Criteria andPostDescIsNull() {
            addCriterion("POST_DESC is null");
            return (Criteria) this;
        }

        public Criteria andPostDescIsNotNull() {
            addCriterion("POST_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andPostDescEqualTo(String value) {
            addCriterion("POST_DESC =", value, "postDesc");
            return (Criteria) this;
        }

        public Criteria andPostDescNotEqualTo(String value) {
            addCriterion("POST_DESC <>", value, "postDesc");
            return (Criteria) this;
        }

        public Criteria andPostDescGreaterThan(String value) {
            addCriterion("POST_DESC >", value, "postDesc");
            return (Criteria) this;
        }

        public Criteria andPostDescGreaterThanOrEqualTo(String value) {
            addCriterion("POST_DESC >=", value, "postDesc");
            return (Criteria) this;
        }

        public Criteria andPostDescLessThan(String value) {
            addCriterion("POST_DESC <", value, "postDesc");
            return (Criteria) this;
        }

        public Criteria andPostDescLessThanOrEqualTo(String value) {
            addCriterion("POST_DESC <=", value, "postDesc");
            return (Criteria) this;
        }

        public Criteria andPostDescLike(String value) {
            addCriterion("POST_DESC like", value, "postDesc");
            return (Criteria) this;
        }

        public Criteria andPostDescNotLike(String value) {
            addCriterion("POST_DESC not like", value, "postDesc");
            return (Criteria) this;
        }

        public Criteria andPostDescIn(List<String> values) {
            addCriterion("POST_DESC in", values, "postDesc");
            return (Criteria) this;
        }

        public Criteria andPostDescNotIn(List<String> values) {
            addCriterion("POST_DESC not in", values, "postDesc");
            return (Criteria) this;
        }

        public Criteria andPostDescBetween(String value1, String value2) {
            addCriterion("POST_DESC between", value1, value2, "postDesc");
            return (Criteria) this;
        }

        public Criteria andPostDescNotBetween(String value1, String value2) {
            addCriterion("POST_DESC not between", value1, value2, "postDesc");
            return (Criteria) this;
        }

        public Criteria andPostTypeIsNull() {
            addCriterion("POST_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andPostTypeIsNotNull() {
            addCriterion("POST_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPostTypeEqualTo(String value) {
            addCriterion("POST_TYPE =", value, "postType");
            return (Criteria) this;
        }

        public Criteria andPostTypeNotEqualTo(String value) {
            addCriterion("POST_TYPE <>", value, "postType");
            return (Criteria) this;
        }

        public Criteria andPostTypeGreaterThan(String value) {
            addCriterion("POST_TYPE >", value, "postType");
            return (Criteria) this;
        }

        public Criteria andPostTypeGreaterThanOrEqualTo(String value) {
            addCriterion("POST_TYPE >=", value, "postType");
            return (Criteria) this;
        }

        public Criteria andPostTypeLessThan(String value) {
            addCriterion("POST_TYPE <", value, "postType");
            return (Criteria) this;
        }

        public Criteria andPostTypeLessThanOrEqualTo(String value) {
            addCriterion("POST_TYPE <=", value, "postType");
            return (Criteria) this;
        }

        public Criteria andPostTypeLike(String value) {
            addCriterion("POST_TYPE like", value, "postType");
            return (Criteria) this;
        }

        public Criteria andPostTypeNotLike(String value) {
            addCriterion("POST_TYPE not like", value, "postType");
            return (Criteria) this;
        }

        public Criteria andPostTypeIn(List<String> values) {
            addCriterion("POST_TYPE in", values, "postType");
            return (Criteria) this;
        }

        public Criteria andPostTypeNotIn(List<String> values) {
            addCriterion("POST_TYPE not in", values, "postType");
            return (Criteria) this;
        }

        public Criteria andPostTypeBetween(String value1, String value2) {
            addCriterion("POST_TYPE between", value1, value2, "postType");
            return (Criteria) this;
        }

        public Criteria andPostTypeNotBetween(String value1, String value2) {
            addCriterion("POST_TYPE not between", value1, value2, "postType");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("STATE is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("STATE is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("STATE =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("STATE <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("STATE >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("STATE >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("STATE <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("STATE <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("STATE like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("STATE not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("STATE in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("STATE not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("STATE between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("STATE not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andUploadTimeIsNull() {
            addCriterion("UPLOAD_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUploadTimeIsNotNull() {
            addCriterion("UPLOAD_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUploadTimeEqualTo(Date value) {
            addCriterionForJDBCDate("UPLOAD_TIME =", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("UPLOAD_TIME <>", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("UPLOAD_TIME >", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("UPLOAD_TIME >=", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeLessThan(Date value) {
            addCriterionForJDBCDate("UPLOAD_TIME <", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("UPLOAD_TIME <=", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeIn(List<Date> values) {
            addCriterionForJDBCDate("UPLOAD_TIME in", values, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("UPLOAD_TIME not in", values, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("UPLOAD_TIME between", value1, value2, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("UPLOAD_TIME not between", value1, value2, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadStaffIsNull() {
            addCriterion("UPLOAD_STAFF is null");
            return (Criteria) this;
        }

        public Criteria andUploadStaffIsNotNull() {
            addCriterion("UPLOAD_STAFF is not null");
            return (Criteria) this;
        }

        public Criteria andUploadStaffEqualTo(String value) {
            addCriterion("UPLOAD_STAFF =", value, "uploadStaff");
            return (Criteria) this;
        }

        public Criteria andUploadStaffNotEqualTo(String value) {
            addCriterion("UPLOAD_STAFF <>", value, "uploadStaff");
            return (Criteria) this;
        }

        public Criteria andUploadStaffGreaterThan(String value) {
            addCriterion("UPLOAD_STAFF >", value, "uploadStaff");
            return (Criteria) this;
        }

        public Criteria andUploadStaffGreaterThanOrEqualTo(String value) {
            addCriterion("UPLOAD_STAFF >=", value, "uploadStaff");
            return (Criteria) this;
        }

        public Criteria andUploadStaffLessThan(String value) {
            addCriterion("UPLOAD_STAFF <", value, "uploadStaff");
            return (Criteria) this;
        }

        public Criteria andUploadStaffLessThanOrEqualTo(String value) {
            addCriterion("UPLOAD_STAFF <=", value, "uploadStaff");
            return (Criteria) this;
        }

        public Criteria andUploadStaffLike(String value) {
            addCriterion("UPLOAD_STAFF like", value, "uploadStaff");
            return (Criteria) this;
        }

        public Criteria andUploadStaffNotLike(String value) {
            addCriterion("UPLOAD_STAFF not like", value, "uploadStaff");
            return (Criteria) this;
        }

        public Criteria andUploadStaffIn(List<String> values) {
            addCriterion("UPLOAD_STAFF in", values, "uploadStaff");
            return (Criteria) this;
        }

        public Criteria andUploadStaffNotIn(List<String> values) {
            addCriterion("UPLOAD_STAFF not in", values, "uploadStaff");
            return (Criteria) this;
        }

        public Criteria andUploadStaffBetween(String value1, String value2) {
            addCriterion("UPLOAD_STAFF between", value1, value2, "uploadStaff");
            return (Criteria) this;
        }

        public Criteria andUploadStaffNotBetween(String value1, String value2) {
            addCriterion("UPLOAD_STAFF not between", value1, value2, "uploadStaff");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNull() {
            addCriterion("ORDER_NO is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("ORDER_NO is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(String value) {
            addCriterion("ORDER_NO =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(String value) {
            addCriterion("ORDER_NO <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(String value) {
            addCriterion("ORDER_NO >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("ORDER_NO >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(String value) {
            addCriterion("ORDER_NO <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(String value) {
            addCriterion("ORDER_NO <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLike(String value) {
            addCriterion("ORDER_NO like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotLike(String value) {
            addCriterion("ORDER_NO not like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<String> values) {
            addCriterion("ORDER_NO in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<String> values) {
            addCriterion("ORDER_NO not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(String value1, String value2) {
            addCriterion("ORDER_NO between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(String value1, String value2) {
            addCriterion("ORDER_NO not between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("SCORE is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("SCORE is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(String value) {
            addCriterion("SCORE =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(String value) {
            addCriterion("SCORE <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(String value) {
            addCriterion("SCORE >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(String value) {
            addCriterion("SCORE >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(String value) {
            addCriterion("SCORE <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(String value) {
            addCriterion("SCORE <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLike(String value) {
            addCriterion("SCORE like", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotLike(String value) {
            addCriterion("SCORE not like", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<String> values) {
            addCriterion("SCORE in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<String> values) {
            addCriterion("SCORE not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(String value1, String value2) {
            addCriterion("SCORE between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(String value1, String value2) {
            addCriterion("SCORE not between", value1, value2, "score");
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