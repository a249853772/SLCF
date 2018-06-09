package com.huhao.springboot.exceptionHandler;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	/*public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e)throws Exception{
		 ModelAndView mav = new ModelAndView();
	        mav.addObject("exception", e);
	        mav.addObject("url", req.getRequestURL());
	        mav.setViewName("errorPage");
	        return mav;
	}*/
}
