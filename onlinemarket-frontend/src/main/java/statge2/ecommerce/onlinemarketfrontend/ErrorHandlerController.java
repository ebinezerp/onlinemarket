package statge2.ecommerce.onlinemarketfrontend;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import statge2.ecommerce.onlinemarketbackend.dto.Users;

@Controller
public class ErrorHandlerController {
	@RequestMapping("/uservalidator")
	public String userValidator(@Valid Users users,BindingResult result)
	{
		if(result.hasErrors())
		{
			return "failure";
		}
		return "success";
	}
}
