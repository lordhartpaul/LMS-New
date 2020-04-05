package com.mycoding.lms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.mycoding.lms.dao.LmsDAO;
import com.mycoding.lms.model.Lms;



@Controller
public class Lmscontroller {
	
	@Autowired
	private LmsDAO lmsDao;

	@RequestMapping(value = "/apply", method=RequestMethod.GET)
	public String newResgistration(ModelMap model) {
		
		Lms lms = new Lms();
		model.addAttribute("lms", lms);
		return "apply";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveRegistration(@Valid Lms lms,BindingResult result, ModelMap model,RedirectAttributes redirectAttributes) {
		
		if(result.hasErrors()) {
			
			return "apply";
			
		}
		
		lmsDao.save(lms);
		  
		return "redirect:/viewlmss/1";
	}
	
	@RequestMapping("/viewlmss")  
    public ModelAndView viewlmss(){  
        List<Lms> list=lmsDao.getAllLmss();
        return new ModelAndView("viewlmss","list",list);  
    } 
	
	
	@RequestMapping(value="/viewlmss/{pageid}")
	public ModelAndView edit(@PathVariable int pageid) {
		
		int total=2;
		
		
		if(pageid==1) {
			
		}else {
			pageid=(pageid-1)*total+1;
		}
		List<Lms> list=lmsDao.getLmssByPage(pageid, total);
		return new ModelAndView("viewlmss", "list", list);
		
	}
	
	@RequestMapping(value="/editlms/{id}")  
    public String edit(@PathVariable int id,ModelMap model){  
       Lms lms=lmsDao.getLmsById(id);  
       model.addAttribute("lms", lms);
		return "editlms";
        
        
    }
	
	@RequestMapping(value="/editsave", method=RequestMethod.POST)
	public ModelAndView editsave(@ModelAttribute("lms") Lms p) {
		System.out.println("id is"+p.getId());
		lmsDao.update(p);
		return new ModelAndView("redirect:/viewlmss/1");
	}
	
	@RequestMapping(value="/deletelms/{id}", method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id) {
		
		lmsDao.delete(id);
		
		return new ModelAndView("redirect:/viewlmss/1");
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public ModelAndView delete() {
		
		lmsDao.delete();
		
		return new ModelAndView("redirect:/viewlmss/1");
	}
	
	
	@ModelAttribute("leaveType")
	public List<String> initializeLeaveTypes(){
		
		List<String> leaveType = new ArrayList<String>();
		leaveType.add("Casual - Sick Leave");
		leaveType.add("Privilege Leave");
		leaveType.add("Privilege Leave");
		leaveType.add("Self-marriage Leave");
		leaveType.add("Paternity Leave");
		leaveType.add("Maternity Leave");
		leaveType.add("Compassionate Leave");
		
		return leaveType;
		
	}
	
	@ModelAttribute("manager")
	public List<String> initializeManagers(){
		
		List<String> manager = new ArrayList<String>();
		manager.add("Selvi S");
		manager.add("Pallavi Shishodia");
		manager.add("T Deepak");
		manager.add("Kiran");
		
		return manager;
		
	}
	
	@ModelAttribute("ccTo")
	public List<String> initializeCcTos(){
		
		List<String> ccTo = new ArrayList<String>();
		ccTo.add("Rohit");
		ccTo.add("Pranesh");
		ccTo.add("Kritika");
		
		return ccTo;
		
	}
	
	@ModelAttribute("pageCount")
	public List<String> initializePageCount(){
		
		int total = 2;
		List<String> pageCount = new ArrayList<String>();
		int count = lmsDao.count();
		int result = ((count/total)+ (count%total));
		for(int k=0;k<result;k++) {
			pageCount.add(new Integer(k).toString());
		}
		
		return pageCount;
	}
	
}
