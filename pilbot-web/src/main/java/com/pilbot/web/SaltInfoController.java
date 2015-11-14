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

import com.pilbot.domain.SaltDO;
import com.pilbot.service.SaltInfoService;


@Controller
public class SaltInfoController {
	

	@Resource(name = "saltInfoService")
	private SaltInfoService saltInfoService;
	
	@RequestMapping("/formUser")
	public String formMain()
	{
		//logger.info("Hello Admin controller ");
		return "formMain";
	}
	
	@RequestMapping("/saltInfo")
	public ModelAndView viewSaltInfo(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception
	{	
		
		List<SaltDO>salts=saltInfoService.getSaltInfo();
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("salts",salts);
		modelMap.addAttribute("saltDO",new SaltDO());

		return  new ModelAndView("saltInfoForm",modelMap);
	}
	
	@RequestMapping("/submitSaltInfo")
	public ModelAndView submitSaltInfo(@ModelAttribute("saltDO")SaltDO saltDO,HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception
	{	
			
		saltInfoService.saveSaltDetails(saltDO);
		ModelMap modelMap = new ModelMap();
		
		modelMap.addAttribute("saltDO",new SaltDO());

		return  new ModelAndView("redirect:/app/saltInfo");
	}
	
	
	@RequestMapping("/deleteSalt")
	public ModelAndView deleteSaltInfo(@RequestParam("selectedId")Integer selectedId,HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception
	{	
		saltInfoService.deleteSaltDetails(selectedId);
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("saltDO",new SaltDO());

		return  new ModelAndView("redirect:/app/saltInfo",modelMap);
	}

	@RequestMapping("/editSalt")
	public ModelAndView editSaltInfo(@RequestParam("selectedId")Integer selectedId,HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception
	{	
		
		SaltDO salts=saltInfoService.getSaltInfoById(selectedId);
		ModelMap modelMap = new ModelMap();
		
		modelMap.addAttribute("saltDO",salts);

		return  new ModelAndView("editSaltInfoForm",modelMap);
	}
	
	@RequestMapping("/submitEditSalt")
	public ModelAndView submitEditSaltInfo(@ModelAttribute("saltDO")SaltDO saltDO,HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception
	{	
		
		ModelMap modelMap = new ModelMap();
		
		Boolean result=saltInfoService.updateSaltInfo(saltDO);
		/*modelMap.addAttribute("saltDO",salts);*/

		return  new ModelAndView("redirect:/app/saltInfo",modelMap);
	}
	
	
}
