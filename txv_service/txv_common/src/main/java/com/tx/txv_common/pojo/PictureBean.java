package com.tx.txv_common.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 展示轮播图实体类
 */
public class PictureBean implements Serializable {
    private String picId;
    private String picLocation;
    private String picVideo;
    private String picData;
    private Date uploadTime;
    private String picDesc;
    private String status;
    private String picType;
    private String order;
    private String picName;
    private String score;

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPicType() {
        return picType;
    }

    public void setPicType(String picType) {
        this.picType = picType;
    }

    public String getPicDesc() {
        return picDesc;
    }

    public void setPicDesc(String picDesc) {
        this.picDesc = picDesc;
    }

    public String getPicId() {
        return picId;
    }

    public void setPicId(String picId) {
        this.picId = picId;
    }

    public String getPicLocation() {
        return picLocation;
    }

    public void setPicLocation(String picLocation) {
        this.picLocation = picLocation;
    }

    public String getPicVideo() {
        return picVideo;
    }

    public void setPicVideo(String picVideo) {
        this.picVideo = picVideo;
    }

    public String getPicData() {
        return picData;
    }

    public void setPicData(String picData) {
        this.picData = picData;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }
}
