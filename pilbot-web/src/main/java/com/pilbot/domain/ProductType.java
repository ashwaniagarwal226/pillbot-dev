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
//Ashwani Agarwal robin uttappa opopopopopop
@Entity
@Table(name = "pillbot_m_prod_type")
public class ProductType {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "prod_type_id", unique = true, nullable = false)
	private Integer prodTypeId;
	@Column(name = "prod_type_name", length = 50)
	private String prodTypeName;
	@Column(name = "is_active", length = 1)
	private String isActive;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "productType")
	private List<SaltBrandDO> saltBrandDO = new ArrayList<SaltBrandDO>();
	
	public Integer getProdTypeId() {
		return prodTypeId;
	}
	public void setProdTypeId(Integer prodTypeId) {
		this.prodTypeId = prodTypeId;
	}
	public String getProdTypeName() {
		return prodTypeName;
	}
	public void setProdTypeName(String prodTypeName) {
		this.prodTypeName = prodTypeName;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public List<SaltBrandDO> getSaltBrandDO() {
		return saltBrandDO;
	}
	public void setSaltBrandDO(List<SaltBrandDO> saltBrandDO) {
		this.saltBrandDO = saltBrandDO;
	}
}
