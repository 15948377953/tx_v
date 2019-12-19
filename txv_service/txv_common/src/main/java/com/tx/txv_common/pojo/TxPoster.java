package com.tx.txv_common.pojo;

import java.io.Serializable;
import java.util.Date;

public class TxPoster implements Serializable {
    private String postId;

    private String postName;

    private String postLocation;

    private String postLable;

    private String postDesc;

    private String postType;

    private String state;

    private Date uploadTime;

    private String uploadStaff;

    private String orderNo;

    private String score;

    private String postData;

    private static final long serialVersionUID = 1L;

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId == null ? null : postId.trim();
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName == null ? null : postName.trim();
    }

    public String getPostLocation() {
        return postLocation;
    }

    public void setPostLocation(String postLocation) {
        this.postLocation = postLocation == null ? null : postLocation.trim();
    }

    public String getPostLable() {
        return postLable;
    }

    public void setPostLable(String postLable) {
        this.postLable = postLable == null ? null : postLable.trim();
    }

    public String getPostDesc() {
        return postDesc;
    }

    public void setPostDesc(String postDesc) {
        this.postDesc = postDesc == null ? null : postDesc.trim();
    }

    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType == null ? null : postType.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getUploadStaff() {
        return uploadStaff;
    }

    public void setUploadStaff(String uploadStaff) {
        this.uploadStaff = uploadStaff == null ? null : uploadStaff.trim();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score == null ? null : score.trim();
    }

    public String getPostData() {
        return postData;
    }

    public void setPostData(String postData) {
        this.postData = postData == null ? null : postData.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", postId=").append(postId);
        sb.append(", postName=").append(postName);
        sb.append(", postLocation=").append(postLocation);
        sb.append(", postLable=").append(postLable);
        sb.append(", postDesc=").append(postDesc);
        sb.append(", postType=").append(postType);
        sb.append(", state=").append(state);
        sb.append(", uploadTime=").append(uploadTime);
        sb.append(", uploadStaff=").append(uploadStaff);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", score=").append(score);
        sb.append(", postData=").append(postData);
        sb.append("]");
        return sb.toString();
    }
}