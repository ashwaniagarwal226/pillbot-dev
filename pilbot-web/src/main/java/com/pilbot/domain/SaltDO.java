package com.pilbot.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "pillbot_m_salt")
public class SaltDO {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "salt_id")
	private Integer saltId;

	@Column(name = "salt_name")
	private String saltName;

	@Column(name = "sch_type")
	private String schType;
	
	@Column(name = "prescptn_req")
	private String prescptnReq;
	
	@Column(name="prescptn_clause")
	private String prescptnClause;
	
	@Column(name="is_active")
	private String isActive;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "saltDO" )
	private List<SaltBrandDO> saltBrandDO = new ArrayList<SaltBrandDO>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "saltDO", cascade = { javax.persistence.CascadeType.ALL })
	private List<SaltInfoDO> saltInfoDO = new ArrayList<SaltInfoDO>();
	
	@Transient
	private Integer selectedId;
	
	public SaltDO(Integer saltId)
	{
		this.saltId=saltId;
	}

	public SaltDO() {
		
	}

	public Integer getSaltId() {
		return saltId;
	}

	public void setSaltId(Integer saltId) {
		this.saltId = saltId;
	}

	public String getSaltName() {
		return saltName;
	}

	public void setSaltName(String saltName) {
		this.saltName = saltName;
	}

	public String getSchType() {
		return schType;
	}

	public void setSchType(String schType) {
		this.schType = schType;
	}

	public String getPrescptnReq() {
		return prescptnReq;
	}

	public void setPrescptnReq(String prescptnReq) {
		this.prescptnReq = prescptnReq;
	}

	public String getPrescptnClause() {
		return prescptnClause;
	}

	public void setPrescptnClause(String prescptnClause) {
		this.prescptnClause = prescptnClause;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public Integer getSelectedId() {
		return selectedId;
	}

	public void setSelectedId(Integer selectedId) {
		this.selectedId = selectedId;
	}

	public List<SaltBrandDO> getSaltBrandDO() {
		return saltBrandDO;
	}

	public void setSaltBrandDO(List<SaltBrandDO> saltBrandDO) {
		this.saltBrandDO = saltBrandDO;
	}

	public List<SaltInfoDO> getSaltInfoDO() {
		return saltInfoDO;
	}

	public void setSaltInfoDO(List<SaltInfoDO> saltInfoDO) {
		this.saltInfoDO = saltInfoDO;
	}
}
