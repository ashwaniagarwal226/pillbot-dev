package com.pilbot.service;

import java.util.List;

import com.pilbot.domain.SaltBrandDO;

public interface BrandInfoService {
	
	public Boolean saveBrandDetails(SaltBrandDO brandDO);
	
	public  List<SaltBrandDO> getSaltBrandInfo();
	
	public Boolean deleteBrandDetails(Integer seletedSaltId);
	
	public SaltBrandDO getBrandInfoById(Integer seletedBrandId);
	
	public Boolean updateBrandInfo(SaltBrandDO brandDO);
	/*public List<SaltDO> getSaltInfo();
	
	public void deleteBrandDetails(Integer seletedSaltId);
	
	public SaltDO getSaltInfoById(Integer seletedSaltId);
	
	public Boolean updateSaltInfo(SaltDO saltDO);*/

}
