package com.frank.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class zhuanxiang {
    @RequestMapping("/zhuce")  
    public String test() {  
       
        return "zhuce"; 
    }
    
    @RequestMapping("/Login")  
    public String ce() {  
       
        return "Login"; 
    }
    @RequestMapping("/zhongzuan")  
    public String zuan(HttpServletRequest request, HttpServletResponse response) {  
    	
       
        return ""; 
    }
    @RequestMapping("/example")  
    public String ex(HttpServletRequest request, HttpServletResponse response) {  
    	
       
        return "example"; 
    }
    @RequestMapping("/try")  
    public String tt(HttpServletRequest request, HttpServletResponse response) {  
    	
       
        return "try"; 
    } 
    
    @RequestMapping("/client")  
    public String treat() {  
    	
       
        return "client"; 
    }
    
    @RequestMapping("/emplye")  
    public String trick() {  
    	
       
        return "emplye"; 
    }
    
    @RequestMapping("/boss")  
    public String manager() {  
    	
       
        return "boss"; 
    }
    
    
    @RequestMapping("/booking")  
    public String book() {  
    	
       
        return "booking"; 
    }
    
    @RequestMapping("/wait")  
    public String ww() {  
    	
       
        return "wait"; 
    }
    
    @RequestMapping("/find_passwd")  
    public String ff() {  
    	
       
        return "find_passwd"; 
    }
    
   
}