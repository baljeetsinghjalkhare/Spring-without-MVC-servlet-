package com.bs.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TaxController {
	
@RequestMapping("/start")
public String showInputPage()
{
	System.out.print("Conroller call...!!");
	return "input.jsp";
}

@RequestMapping("/compute")
public void computeTax(HttpServletRequest request,HttpServletResponse response)throws IOException
{
String s1=request.getParameter("income");
String s2=request.getParameter("age");
int income=Integer.parseInt(s1);
int age=Integer.parseInt(s2);

int tax=0;
int rebate=0;
int nettax=0;
if(income>=500000)
{
	tax=income*20/100;
}
else {
	tax=income*10/100;	
}
if(age>60)
{
	rebate=tax*20/100;
}

nettax=tax-rebate;
PrintWriter out=response.getWriter();
out.println("income   :"+ income);
out.println("age      :"+ age);
out.println("tax      :"+ tax);
out.println("rebate   :"+ rebate);
out.println("netTax   :"+ nettax);

out.close();

}
}
