package com.odx.test;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.odx.database.DBService;
import com.odx.database.Demo;

//This is the main controller class, which is used to process the requests.
@RestController
public class LongestPalindrome {
	
	
	private DBService db;
	
	@Autowired
	ProcessString ps; // Dependency injection
	@RequestMapping("/savePalindrome")
	public String savePalindrome(HttpServletRequest request) {
		String s = request.getParameter("_s_");
		if(s == null || "".equals(s))
			return "Please send parameter value for _s_";
		String longestPal = ps.longestPalindrome(s);
		Demo m = new Demo(longestPal);
		db = new DBService();
		db.saveDemo(m);
		return longestPal;
	}
	
	@RequestMapping("/getPalindrome")
	public String getPalindrome(HttpServletRequest request) {
		db = new DBService();
		String longestPal = db.getPalindrome();
		return longestPal;
	}

}
