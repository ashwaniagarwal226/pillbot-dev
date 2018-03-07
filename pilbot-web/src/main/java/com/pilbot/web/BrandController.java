package com.pilbot.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pilbot.domain.SaltBrandDO;
import com.pilbot.service.BrandInfoService;

@Controller
public class BrandController {
	
	@Resource(name = "brandInfoService")
	private BrandInfoService brandInfoService;
	
	@RequestMapping("/brandInfo")
	public ModelAndView viewBrandInfo(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception
	{	
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("brandDO",new SaltBrandDO());
		List<SaltBrandDO>brands=brandInfoService.getSaltBrandInfo();
		modelMap.addAttribute("brands",brands);
		return  new ModelAndView("brandInfoForm",modelMap);
	}
	
	@RequestMapping("/submitBrandInfo")
	public ModelAndView submitBrandInfo(@ModelAttribute("brandDO")SaltBrandDO brandDO,HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception
	{	
		Boolean result=null;	
		result=brandInfoService.saveBrandDetails(brandDO);
		ModelMap modelMap = new ModelMap();
		
		modelMap.addAttribute("brandDO",new SaltBrandDO());

		return  new ModelAndView("redirect:/app/brandInfo");
	}
	
	@RequestMapping("/deleteBrand")
	public ModelAndView deleteBrandInfo(@RequestParam("selectedId")Integer selectedId,HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception
	{	
		brandInfoService.deleteBrandDetails(selectedId);
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("brandDO",new SaltBrandDO());

		return  new ModelAndView("redirect:/app/brandInfo",modelMap);
	}

	@RequestMapping("/editBrand")
	public ModelAndView editBrandInfo(@RequestParam("selectedId")Integer selectedId,HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception
	{	
		SaltBrandDO brandDO=brandInfoService.getBrandInfoById(selectedId);
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("brandDO",brandDO);

		return  new ModelAndView("editBrandInfoForm",modelMap);
	}
	@RequestMapping("/submitEditBrand")
	public ModelAndView submitEditBrandInfo(@ModelAttribute("brandDO")SaltBrandDO brandDO,HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception
	{	
		
		ModelMap modelMap = new ModelMap();
		
		Boolean result=brandInfoService.updateBrandInfo(brandDO);
		/*modelMap.addAttribute("saltDO",salts);*/

		return  new ModelAndView("redirect:/app/brandInfo",modelMap);
	}
}
