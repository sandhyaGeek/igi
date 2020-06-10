package com.odx.test;

import org.springframework.stereotype.Component;
//This class is used to process the string and find the longest palindrome, contains main logic.
@Component
public class ProcessString {
	
	public ProcessString() {
		
	}
	public String longestPalindrome(String s) {
        int n = s.length();
        for(int len = n;len>0;len--){
            for(int i =0,j=len;  j-i<=len && j<=n; i++,j++){
                if(isPalindrome(s.substring(i,j)))
                    return s.substring(i,j);
            }
        }
        return "";
    }
    
    public boolean isPalindrome(String s){
        int n = s.length()-1;
        for(int i=0;i<=n/2;i++){
            if(s.charAt(i)!=s.charAt(n-i))
                return false;
        }
        return true;
    }
}
