package com.pilbot.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "pillbot_m_salt_brand")
public class SaltBrandDO {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "brand_id", unique = true, nullable = false)
		private Integer brandId;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "salt_id")
	private SaltDO saltDO;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "prod_type_id")
	private ProductType productType;
	@Column(name = "brand_name", length = 100)
	private String brandName;
	@Column(name = "manufacture_name", length = 100)
	private String manufactureName;
	@Column(name = "is_generic", length = 1)
	private String isGeneric;
	@Column(name = "dosage_strength", length = 100)
	private String dosageStrength;
	@Column(name = "price", precision = 10, scale = 4)
	private BigDecimal price;
	@Column(name = "unit", length = 100)
	private String unit;
	@Column(name="is_active",length=1)
	private String isActive;
	
	@Transient
	private Integer selectedId;
	
	public Integer getBrandId() {
		return brandId;
	}
	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}
	
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getManufactureName() {
		return manufactureName;
	}
	public void setManufactureName(String manufactureName) {
		this.manufactureName = manufactureName;
	}
	public String getIsGeneric() {
		return isGeneric;
	}
	public void setIsGeneric(String isGeneric) {
		this.isGeneric = isGeneric;
	}
	public String getDosageStrength() {
		return dosageStrength;
	}
	public void setDosageStrength(String dosageStrength) {
		this.dosageStrength = dosageStrength;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public SaltDO getSaltDO() {
		return saltDO;
	}
	public void setSaltDO(SaltDO saltDO) {
		this.saltDO = saltDO;
	}
	public ProductType getProductType() {
		return productType;
	}
	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Integer getSelectedId() {
		return selectedId;
	}
	public void setSelectedId(Integer selectedId) {
		this.selectedId = selectedId;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

}
