package com.pilbot.service;

import java.util.List;

import com.pilbot.domain.SaltDO;

public interface SaltInfoService {
	
	public void saveSaltDetails(SaltDO saltDO);
	
	public List<SaltDO> getSaltInfo();
	
	public void deleteSaltDetails(Integer seletedSaltId);
	
	public SaltDO getSaltInfoById(Integer seletedSaltId);
	
	public Boolean updateSaltInfo(SaltDO saltDO);

}
