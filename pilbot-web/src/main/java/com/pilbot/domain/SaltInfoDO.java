package com.pilbot.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "pillbot_m_salt_info")
public class SaltInfoDO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "salt_info_id", unique = true, nullable = false)
	private Integer saltInfoId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "salt_id")
	private SaltDO saltDO;
	
	@Column(name = "ailment_desc", length = 65535)
	private String ailmentDesc;
	
	@Column(name = "ailment_sub_type_desc", length = 65535)
	private String ailmentSubTypeDesc;
	
	@Column(name = "how_it_works", length = 65535)
	private String howItWorks;
	
	@Column(name = "side_effect", length = 65535)
	private String sideEffect;
	
	@Column(name = "intake_advise", length = 65535)
	private String intakeAdvise;
	
	@Column(name = "FAQ", length = 65535)
	private String faq;
	
	@Column(name = "food_advise", length = 65535)
	private String foodAdvise;
	
	@Column(name = "other_info", length = 65535)
	private String otherInfo;
	@Column(name = "Source", length = 65535)
	private String source;
	public Integer getSaltInfoId() {
		return saltInfoId;
	}
	public void setSaltInfoId(Integer saltInfoId) {
		this.saltInfoId = saltInfoId;
	}
	public SaltDO getSaltDO() {
		return saltDO;
	}
	public void setSaltDO(SaltDO saltDO) {
		this.saltDO = saltDO;
	}
	public String getAilmentDesc() {
		return ailmentDesc;
	}
	public void setAilmentDesc(String ailmentDesc) {
		this.ailmentDesc = ailmentDesc;
	}
	public String getAilmentSubTypeDesc() {
		return ailmentSubTypeDesc;
	}
	public void setAilmentSubTypeDesc(String ailmentSubTypeDesc) {
		this.ailmentSubTypeDesc = ailmentSubTypeDesc;
	}
	public String getHowItWorks() {
		return howItWorks;
	}
	public void setHowItWorks(String howItWorks) {
		this.howItWorks = howItWorks;
	}
	public String getSideEffect() {
		return sideEffect;
	}
	public void setSideEffect(String sideEffect) {
		this.sideEffect = sideEffect;
	}
	public String getIntakeAdvise() {
		return intakeAdvise;
	}
	public void setIntakeAdvise(String intakeAdvise) {
		this.intakeAdvise = intakeAdvise;
	}
	public String getFaq() {
		return faq;
	}
	public void setFaq(String faq) {
		this.faq = faq;
	}
	public String getFoodAdvise() {
		return foodAdvise;
	}
	public void setFoodAdvise(String foodAdvise) {
		this.foodAdvise = foodAdvise;
	}
	public String getOtherInfo() {
		return otherInfo;
	}
	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}

}
