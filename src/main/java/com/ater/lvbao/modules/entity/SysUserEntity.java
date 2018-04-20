package com.ater.lvbao.modules.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 系统用户
 *
 * @author Onpu
 * @date 2017-04-01
 */
public class SysUserEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @Excel(name = "用户编号")
    private Long userId;
    /**
     *用户名
     */

    private String userName;

    /**
     * 密码
     */
    private String password;
    /**
     * 盐
     */
    private String salt;
    /**
     * 姓名
     */
    @Excel(name = "姓名")
    private String name;
    /**
     * 性别(1:男,2:女)
     */
    @Excel(name = "性别", replace = { "女_2", "男_1" })
    private Integer sex;

    /**
     * 年龄
     */
    private Integer age;
    /**
     * 社会职务
     */
    @Excel(name = "社会职务")
    private String socialDuty;
    /**
     * 党派1 2民主党派 3团员 4群众
     */
    @Excel(name = "党派", replace = { "共产党_1", "民主党派_2" ,"团员_3", "群众_4" })
    private Integer party;
    /**
     * 执业证
     */
    @Excel(name = "执业证")
    private String certificate;
    /**
     * 团队负责人is_leader是否是团队负责人 1：是 2：否
     */
    @Excel(name = "团队负责人", replace = { "是_1", "否_2"  })
    private Integer isLeader;

    /**
     * 身份证号
     */
    @Excel(name = "身份证号")
    private String cardNo;

   /**
     * 手机
     */
    @Excel(name = "手机")
    private String mobNo;
    /**
     * 邮箱
     */
    @Excel(name = "邮箱")
    private String email;
    /**
     * 办公室
     */
    @Excel(name = "办公室")
    private String unit;
    /**
     * 部门
     */
    @Excel(name = "部门")
    private String department;
    /**
     * 座位
     */
    @Excel(name = "座位类别" )
    private String seatNo;
    /**
     * 座位
     */
    @Excel(name = "座位费")
    private String seatCost;

    /**
     * 座机
     */
    @Excel(name = "座机")
    private String telNo;
    /**
     * 身份(sys_dictionary[type:0001].key)身份 1行政 2财务3律师助理 4绩效律师 5初级合伙人 6二级合伙人 7高级合伙人
     */
    @Excel(name = "身份", replace = { "行政_1", "财务_2" ,"律师助理_3", "绩效律师_4", "初级合伙人_5" ,"二级合伙人_6", "高级合伙人_7", "高级顾问_8", "律师_9", "实习律师_10", "顾问_11" })
    private Integer identity;
    /**
     * 出生年月
     */
    @Excel(name = "出生日期")
    private Date birthday;
    /**
     * 归属团队
     */
    @Excel(name = "归属团队")
    private String belongTeam;
    /**
     * 办公室
     */

    private String officeNo;
    /**
     * 专业
     */
    @Excel(name = "专业", replace = { "法学_1", "非法学_2"})
    private Integer profession;
    /**
     * 学历1:大专 2：本科 3：硕士研究生 4：博士研究生
     */
    @Excel(name = "学历", replace = { "大专_1", "本科_2" ,"硕士_3", "博士_4"})
    private Integer education;
    /**
     * 离职时间
     */
    @Excel(name = "离职时间", format = "yyyy-MM")
    private Date leaveTime;
    /**
     * 入职时间
     */
    @Excel(name = "入职时间", format = "yyyy-MM")
    private Date entryTime;
    /**
     * 行政费
     */
    @Excel(name = "行政费")
    private Double administrativeCost;
    /**
     * 卡位费
     */
    @Excel(name = "卡位费")
    private Double cardCost;
    /**
     * 工资
     */
    @Excel(name = "工资")
    private Double salary;

    /**
     * 装修费
     */
    @Excel(name = "装修费")
    private Double decorationFee;
    /**
     * 社保
     */
    @Excel(name = "社保")
    private Double social;

    @Excel(name = "公积金")
    private Double security;

    @Excel(name = "状态" , replace = { "在职_1", "离职_2","休假_3" })
    private Integer state;
    /**
     * 已交成本发票
     */
    private Double alreadyInvoice;
    /**
     * 已开票金额
     */
    private Double invoiceAmount;
    /**
     * 收款金额
     */
    private Double payAmount;
    /**
     * 已开票收入
     */
    private Double aleadyRevenue;
    /**
     * 已交保证金
     */
    private Double aleadyDeposit;
    /**
     * 已退保证金
     */
    private Double exitDeposit;
    /**
     * 已退卡位费
     */
    private Double exitCardfee;
    /**
     * 已交卡位费
     */
    private Double aleadyCardfee;
    /**
     * 已交房间费
     */
    private Double aleadyRoomfee;
    /**
     * 已交装修费
     */
    private Double aleadyDecorfee;
    /**
     * 已退装修费
     */
    private Double exitDecorfee;
    /**
     * 已退房间费、
     */
    private Double exitRoomfee;

    /**
     * 已交其他费用
     */
    private Double aleadyOtherfee;
    /**
     * 已退其他费用
     */
    private Double exitOtherfee;
    /**
     * 期初应缴金额
     */
    private Double initialPayamount;
    /**
     * 其他金额
     */
    private Double otherCost;
    /**
     * 删除状态(0：有效,1：无效)
     */
    private Integer isDeleted;
    /**
     * 创建时间
     */
    private Date gmtCreate;
    /**
     * 更新时间
     */
    private Date gmtModified;
    /**
     * 角色ID列表
     */
    private List<Long> roleIdList;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSocialDuty() {
        return socialDuty;
    }

    public void setSocialDuty(String socialDuty) {
        this.socialDuty = socialDuty;
    }

    public Integer getParty() {
        return party;
    }

    public void setParty(Integer party) {
        this.party = party;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public Integer getIsLeader() {
        return isLeader;
    }

    public void setIsLeader(Integer isLeader) {
        this.isLeader = isLeader;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getMobNo() {
        return mobNo;
    }

    public void setMobNo(String mobNo) {
        this.mobNo = mobNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public String getSeatCost() {
        return seatCost;
    }

    public void setSeatCost(String seatCost) {
        this.seatCost = seatCost;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public Integer getIdentity() {
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getBelongTeam() {
        return belongTeam;
    }

    public void setBelongTeam(String belongTeam) {
        this.belongTeam = belongTeam;
    }

    public String getOfficeNo() {
        return officeNo;
    }

    public void setOfficeNo(String officeNo) {
        this.officeNo = officeNo;
    }

    public Integer getProfession() {
        return profession;
    }

    public void setProfession(Integer profession) {
        this.profession = profession;
    }

    public Integer getEducation() {
        return education;
    }

    public void setEducation(Integer education) {
        this.education = education;
    }

    public Date getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(Date leaveTime) {
        this.leaveTime = leaveTime;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public Double getAdministrativeCost() {
        return administrativeCost;
    }

    public void setAdministrativeCost(Double administrativeCost) {
        this.administrativeCost = administrativeCost;
    }

    public Double getCardCost() {
        return cardCost;
    }

    public void setCardCost(Double cardCost) {
        this.cardCost = cardCost;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getDecorationFee() {
        return decorationFee;
    }

    public void setDecorationFee(Double decorationFee) {
        this.decorationFee = decorationFee;
    }

    public Double getSocial() {
        return social;
    }

    public void setSocial(Double social) {
        this.social = social;
    }

    public Double getSecurity() {
        return security;
    }

    public void setSecurity(Double security) {
        this.security = security;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Double getAlreadyInvoice() {
        return alreadyInvoice;
    }

    public void setAlreadyInvoice(Double alreadyInvoice) {
        this.alreadyInvoice = alreadyInvoice;
    }

    public Double getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(Double invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public Double getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Double payAmount) {
        this.payAmount = payAmount;
    }

    public Double getAleadyRevenue() {
        return aleadyRevenue;
    }

    public void setAleadyRevenue(Double aleadyRevenue) {
        this.aleadyRevenue = aleadyRevenue;
    }

    public Double getAleadyDeposit() {
        return aleadyDeposit;
    }

    public void setAleadyDeposit(Double aleadyDeposit) {
        this.aleadyDeposit = aleadyDeposit;
    }

    public Double getExitDeposit() {
        return exitDeposit;
    }

    public void setExitDeposit(Double exitDeposit) {
        this.exitDeposit = exitDeposit;
    }

    public Double getExitCardfee() {
        return exitCardfee;
    }

    public void setExitCardfee(Double exitCardfee) {
        this.exitCardfee = exitCardfee;
    }

    public Double getAleadyCardfee() {
        return aleadyCardfee;
    }

    public void setAleadyCardfee(Double aleadyCardfee) {
        this.aleadyCardfee = aleadyCardfee;
    }

    public Double getAleadyRoomfee() {
        return aleadyRoomfee;
    }

    public void setAleadyRoomfee(Double aleadyRoomfee) {
        this.aleadyRoomfee = aleadyRoomfee;
    }

    public Double getAleadyDecorfee() {
        return aleadyDecorfee;
    }

    public void setAleadyDecorfee(Double aleadyDecorfee) {
        this.aleadyDecorfee = aleadyDecorfee;
    }

    public Double getExitDecorfee() {
        return exitDecorfee;
    }

    public void setExitDecorfee(Double exitDecorfee) {
        this.exitDecorfee = exitDecorfee;
    }

    public Double getExitRoomfee() {
        return exitRoomfee;
    }

    public void setExitRoomfee(Double exitRoomfee) {
        this.exitRoomfee = exitRoomfee;
    }

    public Double getAleadyOtherfee() {
        return aleadyOtherfee;
    }

    public void setAleadyOtherfee(Double aleadyOtherfee) {
        this.aleadyOtherfee = aleadyOtherfee;
    }

    public Double getExitOtherfee() {
        return exitOtherfee;
    }

    public void setExitOtherfee(Double exitOtherfee) {
        this.exitOtherfee = exitOtherfee;
    }

    public Double getInitialPayamount() {
        return initialPayamount;
    }

    public void setInitialPayamount(Double initialPayamount) {
        this.initialPayamount = initialPayamount;
    }

    public Double getOtherCost() {
        return otherCost;
    }

    public void setOtherCost(Double otherCost) {
        this.otherCost = otherCost;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public List<Long> getRoleIdList() {
        return roleIdList;
    }

    public void setRoleIdList(List<Long> roleIdList) {
        this.roleIdList = roleIdList;
    }
}
