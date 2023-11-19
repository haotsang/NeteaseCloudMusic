package com.haotsang.neteasecloudmusic.model.entity.radio.recommend;

import com.google.gson.annotations.SerializedName;
import com.haotsang.neteasecloudmusic.model.entity.Dj;

public class RecommendRadio {

    private long id;
    private Dj dj;
    private String name;
    private String picUrl;
    private String desc;
    private long subCount;
    private int programCount;
    private long createTime;
    private int categoryId;
    private String category;
    private long secondCategoryId;
    private String secondCategory;
    private int radioFeeType;
    private int feeScope;
    private boolean buyed;
    private String videos;
    private boolean finished;
    private boolean underShelf;
    private int purchaseCount;
    private int price;
    private int originalPrice;
    private String discountPrice;
    private long lastProgramCreateTime;
    private String lastProgramName;
    private long lastProgramId;
    private long picId;
    private String rcmdText;
    private boolean hightQuality;
    private boolean whiteList;
    private String liveInfo;
    private int playCount;
    private String icon;
    private boolean privacy;
    private String intervenePicUrl;
    private long intervenePicId;
    private boolean dynamic;
    private String shortName;
    private int taskId;
    private String manualTagsDTO;
    private String scoreInfoDTO;
//    private String descPicList;
    private boolean subed;
    private String original;
    private String replaceResource;
    private String immersionCover;
    private String immersionAnimation;
    private int danmakuCount;
    private boolean composeVideo;
    private String rcmdtext;
    private String lastUpdateProgramName;
    private String alg;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setDj(Dj dj) {
        this.dj = dj;
    }

    public Dj getDj() {
        return dj;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setSubCount(long subCount) {
        this.subCount = subCount;
    }

    public long getSubCount() {
        return subCount;
    }

    public void setProgramCount(int programCount) {
        this.programCount = programCount;
    }

    public int getProgramCount() {
        return programCount;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setSecondCategoryId(long secondCategoryId) {
        this.secondCategoryId = secondCategoryId;
    }

    public long getSecondCategoryId() {
        return secondCategoryId;
    }

    public void setSecondCategory(String secondCategory) {
        this.secondCategory = secondCategory;
    }

    public String getSecondCategory() {
        return secondCategory;
    }

    public void setRadioFeeType(int radioFeeType) {
        this.radioFeeType = radioFeeType;
    }

    public int getRadioFeeType() {
        return radioFeeType;
    }

    public void setFeeScope(int feeScope) {
        this.feeScope = feeScope;
    }

    public int getFeeScope() {
        return feeScope;
    }

    public void setBuyed(boolean buyed) {
        this.buyed = buyed;
    }

    public boolean getBuyed() {
        return buyed;
    }

    public void setVideos(String videos) {
        this.videos = videos;
    }

    public String getVideos() {
        return videos;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public boolean getFinished() {
        return finished;
    }

    public void setUnderShelf(boolean underShelf) {
        this.underShelf = underShelf;
    }

    public boolean getUnderShelf() {
        return underShelf;
    }

    public void setPurchaseCount(int purchaseCount) {
        this.purchaseCount = purchaseCount;
    }

    public int getPurchaseCount() {
        return purchaseCount;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setOriginalPrice(int originalPrice) {
        this.originalPrice = originalPrice;
    }

    public int getOriginalPrice() {
        return originalPrice;
    }

    public void setDiscountPrice(String discountPrice) {
        this.discountPrice = discountPrice;
    }

    public String getDiscountPrice() {
        return discountPrice;
    }

    public void setLastProgramCreateTime(long lastProgramCreateTime) {
        this.lastProgramCreateTime = lastProgramCreateTime;
    }

    public long getLastProgramCreateTime() {
        return lastProgramCreateTime;
    }

    public void setLastProgramName(String lastProgramName) {
        this.lastProgramName = lastProgramName;
    }

    public String getLastProgramName() {
        return lastProgramName;
    }

    public void setLastProgramId(long lastProgramId) {
        this.lastProgramId = lastProgramId;
    }

    public long getLastProgramId() {
        return lastProgramId;
    }

    public void setPicId(long picId) {
        this.picId = picId;
    }

    public long getPicId() {
        return picId;
    }

    public void setRcmdText(String rcmdText) {
        this.rcmdText = rcmdText;
    }

    public String getRcmdText() {
        return rcmdText;
    }

    public void setHightQuality(boolean hightQuality) {
        this.hightQuality = hightQuality;
    }

    public boolean getHightQuality() {
        return hightQuality;
    }

    public void setWhiteList(boolean whiteList) {
        this.whiteList = whiteList;
    }

    public boolean getWhiteList() {
        return whiteList;
    }

    public void setLiveInfo(String liveInfo) {
        this.liveInfo = liveInfo;
    }

    public String getLiveInfo() {
        return liveInfo;
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }

    public int getPlayCount() {
        return playCount;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }

    public void setPrivacy(boolean privacy) {
        this.privacy = privacy;
    }

    public boolean getPrivacy() {
        return privacy;
    }

    public void setIntervenePicUrl(String intervenePicUrl) {
        this.intervenePicUrl = intervenePicUrl;
    }

    public String getIntervenePicUrl() {
        return intervenePicUrl;
    }

    public void setIntervenePicId(long intervenePicId) {
        this.intervenePicId = intervenePicId;
    }

    public long getIntervenePicId() {
        return intervenePicId;
    }

    public void setDynamic(boolean dynamic) {
        this.dynamic = dynamic;
    }

    public boolean getDynamic() {
        return dynamic;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setManualTagsDTO(String manualTagsDTO) {
        this.manualTagsDTO = manualTagsDTO;
    }

    public String getManualTagsDTO() {
        return manualTagsDTO;
    }

    public void setScoreInfoDTO(String scoreInfoDTO) {
        this.scoreInfoDTO = scoreInfoDTO;
    }

    public String getScoreInfoDTO() {
        return scoreInfoDTO;
    }
//
//    public void setDescPicList(String descPicList) {
//        this.descPicList = descPicList;
//    }
//
//    public String getDescPicList() {
//        return descPicList;
//    }
//
    public void setSubed(boolean subed) {
        this.subed = subed;
    }

    public boolean getSubed() {
        return subed;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getOriginal() {
        return original;
    }

    public void setReplaceResource(String replaceResource) {
        this.replaceResource = replaceResource;
    }

    public String getReplaceResource() {
        return replaceResource;
    }

    public void setImmersionCover(String immersionCover) {
        this.immersionCover = immersionCover;
    }

    public String getImmersionCover() {
        return immersionCover;
    }

    public void setImmersionAnimation(String immersionAnimation) {
        this.immersionAnimation = immersionAnimation;
    }

    public String getImmersionAnimation() {
        return immersionAnimation;
    }

    public void setDanmakuCount(int danmakuCount) {
        this.danmakuCount = danmakuCount;
    }

    public int getDanmakuCount() {
        return danmakuCount;
    }

    public void setComposeVideo(boolean composeVideo) {
        this.composeVideo = composeVideo;
    }

    public boolean getComposeVideo() {
        return composeVideo;
    }

    public void setRcmdtext(String rcmdtext) {
        this.rcmdtext = rcmdtext;
    }

    public String getRcmdtext() {
        return rcmdtext;
    }

    public void setLastUpdateProgramName(String lastUpdateProgramName) {
        this.lastUpdateProgramName = lastUpdateProgramName;
    }

    public String getLastUpdateProgramName() {
        return lastUpdateProgramName;
    }

    public void setAlg(String alg) {
        this.alg = alg;
    }

    public String getAlg() {
        return alg;
    }

}