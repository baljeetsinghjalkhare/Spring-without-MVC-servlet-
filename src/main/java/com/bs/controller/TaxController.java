package com.bs.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bs.model.TaxModel;
import com.bs.service.TaxService;

@Controller
public class TaxController {
	
@RequestMapping("/start")
public String showInputPage()
{
	System.out.print("Start..");
	return "input.jsp";
}

//@RequestMapping("/compute")
/*public ModelAndView computeTax(HttpServletRequest request,HttpServletResponse response)throws IOException
*/
/*public ModelAndView computeTax(@RequestParam("income") int income, @RequestParam("age") int age)//complex for decleration:
*/
@Autowired
private TaxService taxService;

@RequestMapping("/compute")            //   l use taxModel in view page ${TaxModel.tax}
public ModelAndView computeTax(@ModelAttribute("property") TaxModel taxModel)
{
	System.out.println(taxModel);
	
	//request read
	
	/*
	   String s1=request.getParameter("income"); String
	   s2=request.getParameter("age");
       int income=Integer.parseInt(s1);
       int age=Integer.parseInt(s2);
     */
	
	/* no need to set externall i use @ModelAttribute("taxModel") TaxModel taxModel;
	 * TaxModel taxModel=new TaxModel(); 
	 * taxModel.setIncome(income);
	 * taxModel.setAge(age);
	 */
	
	
//request process
	
	/*Tight Coupled Controller is totally dependent on TaxService*/
//TaxService taxService=new TaxService();//Tight Coupling
taxService.taxCompute(taxModel);

//response
ModelAndView mv=new ModelAndView();
//mv.addObject("taxModel",taxModel); //we already mention in method  decleration  @ModelAttribute("taxModel")
mv.setViewName("result.jsp");
return mv;
/*
 * PrintWriter out=response.getWriter(); out.println("income   :"+
 * taxModel.getIncome()); out.println("age      :"+ taxModel.getAge());
 * out.println("tax      :"+ taxModel.getTax()); out.println("rebate   :"+
 * taxModel.getRebate()); out.println("netTax   :"+ taxModel.getNetTax());
 * 
 * out.close();
 */

}
}
