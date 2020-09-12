package club.codezp.model;

import java.util.Date;

/**
  *
  *@Author:Zpg
  *@Date:2020/8/1 23:08
  *@Version:1.0
  *@Description:
  *
  *
 */
public class AdCreative {
    /**
    * 自增主键
    */
    private Long id;

    /**
    * 创意名称
    */
    private String name;

    /**
    * 物料类型(图片, 视频)
    */
    private Byte type;

    /**
    * 物料子类型(图片: bmp, jpg 等等)
    */
    private Byte materialType;

    /**
    * 高度
    */
    private Integer height;

    /**
    * 宽度
    */
    private Integer width;

    /**
    * 物料大小, 单位是 KB
    */
    private Long size;

    /**
    * 持续时长, 只有视频才不为 0
    */
    private Integer duration;

    /**
    * 审核状态
    */
    private Byte auditStatus;

    /**
    * 标记当前记录所属用户
    */
    private Long userId;

    /**
    * 物料地址
    */
    private String url;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 更新时间
    */
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Byte getMaterialType() {
        return materialType;
    }

    public void setMaterialType(Byte materialType) {
        this.materialType = materialType;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Byte getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Byte auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}