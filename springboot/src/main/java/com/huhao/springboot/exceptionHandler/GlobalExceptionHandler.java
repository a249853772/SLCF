package com.huhao.springboot.exceptionHandler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e)throws Exception{
		 ModelAndView mav = new ModelAndView();
	        mav.addObject("exception", e);
	        mav.addObject("url", req.getRequestURL());
	        mav.setViewName("errorPage");
	        return mav;
	}
}
