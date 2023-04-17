package com.klef.jfsd.springboot.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.klef.jfsd.springboot.model.Admin;
import com.klef.jfsd.springboot.model.Customer;
import com.klef.jfsd.springboot.model.Product;
import com.klef.jfsd.springboot.service.AdminService;
import com.klef.jfsd.springboot.service.CustomerService;
import com.klef.jfsd.springboot.service.ProductService;


@Controller
public class ClientController 
{
	@Autowired
	private AdminService adminService;
	@Autowired
	private CustomerService customerService;
    @Autowired
    private ProductService productService;
	
	@GetMapping("/")
	public String mainhomedemo()
	{
		return "index";
	}
		@GetMapping("/adminlogin")
	public ModelAndView adminlogindemo()
	{
		ModelAndView mv =new ModelAndView("adminlogin");
		return mv;
	}
		
	
	@GetMapping("/login")
	public ModelAndView logindemo()
	{
		ModelAndView mv =new ModelAndView("login");
		return mv;
	}
	@GetMapping("/index")
	public ModelAndView indexdemo()
	{
		ModelAndView mv =new ModelAndView("index");
		return mv;
	}
	
	
	//---------------------------------------------------------------------------------------------------------------------------
	@GetMapping("/signup")
	public ModelAndView signupdemo()
	{
		ModelAndView mv =new ModelAndView("signup", "customer",new Customer());
		return mv;
	}
	
	
	
	@GetMapping("/adminhome")
	public ModelAndView adminhomedemo()
	{
		ModelAndView mv =new ModelAndView("adminhome");
		return mv;
	}
	
	
	
	
	@PostMapping("/checkadminlogin")
	public ModelAndView checkadminlogindemo(HttpServletRequest request)
	{
		ModelAndView mv=new ModelAndView();
		
		String auname=request.getParameter("auname");
		String apwd =request.getParameter("apwd");
		
	Admin admin = adminService.checkadminlogin(auname, apwd);
	
	if(admin!=null)
	{
		mv.setViewName("adminhome");
	}
	else
	{
		mv.setViewName("adminlogin");
		mv.addObject("msg","Login failed");
	}
		return mv;
	}
	
	//-------------------------------------------------------------------------------------------------
	
	@PostMapping("/checkcustomerlogin")
	public ModelAndView checkcustomerlogindemo(HttpServletRequest request)
	{
		ModelAndView mv=new ModelAndView();
		
		String cuname=request.getParameter("cuname");
		String cpwd =request.getParameter("cpwd");
	
		Customer customer = customerService.checkcustomerlogin(cuname, cpwd);
	
	if(customer!=null)
	{
		mv.setViewName("index");
	}
	else
	{
		mv.setViewName("login");
		mv.addObject("msg","Login failed");
	}
		return mv;
	}


	
	
	@GetMapping("/viewallcustomers")
	public ModelAndView viewallcustomerdemo()
	{
		ModelAndView mv =new ModelAndView("viewallcustomers");
		List<Customer> customerlist=adminService.viewallcustomers();
		mv.addObject("customerlist", customerlist);
		return mv;
	}
	
	
	@GetMapping("/deletecustomer")
	public String deletecustomerdemo(@RequestParam("id")int cid)
	{
		adminService.deletecustomer(cid);
		return "redirect:viewallcustomers";
	}
	
	@PostMapping("/addcustomer")
	public ModelAndView addcustomerdemo(@ModelAttribute("customer") Customer customer )
	{
		customerService.addcustomer(customer);
		
		ModelAndView mv =new ModelAndView();
		mv.setViewName("signup");
		mv.addObject("msg", "customer registered successfully" );
		return mv;
	}
//------------------------------------------------------------------

}
