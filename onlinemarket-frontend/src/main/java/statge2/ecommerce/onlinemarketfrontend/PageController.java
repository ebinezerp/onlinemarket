package statge2.ecommerce.onlinemarketfrontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class PageController {
	
	
	public ModelAndView aboutus()
	{
		ModelAndView mv=new ModelAndView("masterpage");
		mv.addObject("pageName","aboutus");
		return mv;
	}
	
	



}
