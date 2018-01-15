package com.jwebcoder.emailsystem.entity;

public class Attachment {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ATTACHMENT.ID
     *
     * @mbg.generated
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ATTACHMENT.VERSION
     *
     * @mbg.generated
     */
    private Integer version;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ATTACHMENT.EMAIL_ID
     *
     * @mbg.generated
     */
    private String emailId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ATTACHMENT.TYPE
     *
     * @mbg.generated
     */
    private String type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ATTACHMENT.URL
     *
     * @mbg.generated
     */
    private String url;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ATTACHMENT.OWNER
     *
     * @mbg.generated
     */
    private String owner;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ATTACHMENT.CREATE_DATETIME
     *
     * @mbg.generated
     */
    private String createDatetime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ATTACHMENT.LAST_UPDATE_DATETIME
     *
     * @mbg.generated
     */
    private String lastUpdateDatetime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ATTACHMENT.CUSTOM1
     *
     * @mbg.generated
     */
    private String custom1;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ATTACHMENT.CUSTOM2
     *
     * @mbg.generated
     */
    private String custom2;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ATTACHMENT.CUSTOM3
     *
     * @mbg.generated
     */
    private String custom3;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ATTACHMENT.CUSTOM4
     *
     * @mbg.generated
     */
    private Integer custom4;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ATTACHMENT.CUSTOM5
     *
     * @mbg.generated
     */
    private Integer custom5;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ATTACHMENT.ATTACHMENT
     *
     * @mbg.generated
     */
    private byte[] attachment;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATTACHMENT.ID
     *
     * @return the value of ATTACHMENT.ID
     *
     * @mbg.generated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATTACHMENT.ID
     *
     * @param id the value for ATTACHMENT.ID
     *
     * @mbg.generated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATTACHMENT.VERSION
     *
     * @return the value of ATTACHMENT.VERSION
     *
     * @mbg.generated
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATTACHMENT.VERSION
     *
     * @param version the value for ATTACHMENT.VERSION
     *
     * @mbg.generated
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATTACHMENT.EMAIL_ID
     *
     * @return the value of ATTACHMENT.EMAIL_ID
     *
     * @mbg.generated
     */
    public String getEmailId() {
        return emailId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATTACHMENT.EMAIL_ID
     *
     * @param emailId the value for ATTACHMENT.EMAIL_ID
     *
     * @mbg.generated
     */
    public void setEmailId(String emailId) {
        this.emailId = emailId == null ? null : emailId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATTACHMENT.TYPE
     *
     * @return the value of ATTACHMENT.TYPE
     *
     * @mbg.generated
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATTACHMENT.TYPE
     *
     * @param type the value for ATTACHMENT.TYPE
     *
     * @mbg.generated
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATTACHMENT.URL
     *
     * @return the value of ATTACHMENT.URL
     *
     * @mbg.generated
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATTACHMENT.URL
     *
     * @param url the value for ATTACHMENT.URL
     *
     * @mbg.generated
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATTACHMENT.OWNER
     *
     * @return the value of ATTACHMENT.OWNER
     *
     * @mbg.generated
     */
    public String getOwner() {
        return owner;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATTACHMENT.OWNER
     *
     * @param owner the value for ATTACHMENT.OWNER
     *
     * @mbg.generated
     */
    public void setOwner(String owner) {
        this.owner = owner == null ? null : owner.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATTACHMENT.CREATE_DATETIME
     *
     * @return the value of ATTACHMENT.CREATE_DATETIME
     *
     * @mbg.generated
     */
    public String getCreateDatetime() {
        return createDatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATTACHMENT.CREATE_DATETIME
     *
     * @param createDatetime the value for ATTACHMENT.CREATE_DATETIME
     *
     * @mbg.generated
     */
    public void setCreateDatetime(String createDatetime) {
        this.createDatetime = createDatetime == null ? null : createDatetime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATTACHMENT.LAST_UPDATE_DATETIME
     *
     * @return the value of ATTACHMENT.LAST_UPDATE_DATETIME
     *
     * @mbg.generated
     */
    public String getLastUpdateDatetime() {
        return lastUpdateDatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATTACHMENT.LAST_UPDATE_DATETIME
     *
     * @param lastUpdateDatetime the value for ATTACHMENT.LAST_UPDATE_DATETIME
     *
     * @mbg.generated
     */
    public void setLastUpdateDatetime(String lastUpdateDatetime) {
        this.lastUpdateDatetime = lastUpdateDatetime == null ? null : lastUpdateDatetime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATTACHMENT.CUSTOM1
     *
     * @return the value of ATTACHMENT.CUSTOM1
     *
     * @mbg.generated
     */
    public String getCustom1() {
        return custom1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATTACHMENT.CUSTOM1
     *
     * @param custom1 the value for ATTACHMENT.CUSTOM1
     *
     * @mbg.generated
     */
    public void setCustom1(String custom1) {
        this.custom1 = custom1 == null ? null : custom1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATTACHMENT.CUSTOM2
     *
     * @return the value of ATTACHMENT.CUSTOM2
     *
     * @mbg.generated
     */
    public String getCustom2() {
        return custom2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATTACHMENT.CUSTOM2
     *
     * @param custom2 the value for ATTACHMENT.CUSTOM2
     *
     * @mbg.generated
     */
    public void setCustom2(String custom2) {
        this.custom2 = custom2 == null ? null : custom2.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATTACHMENT.CUSTOM3
     *
     * @return the value of ATTACHMENT.CUSTOM3
     *
     * @mbg.generated
     */
    public String getCustom3() {
        return custom3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATTACHMENT.CUSTOM3
     *
     * @param custom3 the value for ATTACHMENT.CUSTOM3
     *
     * @mbg.generated
     */
    public void setCustom3(String custom3) {
        this.custom3 = custom3 == null ? null : custom3.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATTACHMENT.CUSTOM4
     *
     * @return the value of ATTACHMENT.CUSTOM4
     *
     * @mbg.generated
     */
    public Integer getCustom4() {
        return custom4;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATTACHMENT.CUSTOM4
     *
     * @param custom4 the value for ATTACHMENT.CUSTOM4
     *
     * @mbg.generated
     */
    public void setCustom4(Integer custom4) {
        this.custom4 = custom4;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATTACHMENT.CUSTOM5
     *
     * @return the value of ATTACHMENT.CUSTOM5
     *
     * @mbg.generated
     */
    public Integer getCustom5() {
        return custom5;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATTACHMENT.CUSTOM5
     *
     * @param custom5 the value for ATTACHMENT.CUSTOM5
     *
     * @mbg.generated
     */
    public void setCustom5(Integer custom5) {
        this.custom5 = custom5;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATTACHMENT.ATTACHMENT
     *
     * @return the value of ATTACHMENT.ATTACHMENT
     *
     * @mbg.generated
     */
    public byte[] getAttachment() {
        return attachment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATTACHMENT.ATTACHMENT
     *
     * @param attachment the value for ATTACHMENT.ATTACHMENT
     *
     * @mbg.generated
     */
    public void setAttachment(byte[] attachment) {
        this.attachment = attachment;
    }
}