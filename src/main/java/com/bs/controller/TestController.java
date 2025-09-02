package com.bs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
@RequestMapping("/testing")
public void test()
{
	System.out.println("Testing run succesfully........!!");
}

@RequestMapping("/checking")
public void check()
{
	System.out.println("Checking success.....!!");
}
}
