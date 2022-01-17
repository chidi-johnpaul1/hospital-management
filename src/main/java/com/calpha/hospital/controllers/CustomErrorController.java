package com.calpha.hospital.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.ServletWebRequest;

@Controller
public class CustomErrorController implements ErrorController {
    
	@Autowired
	private ErrorAttributes errorAttributes;
	
	@Override
	public String getErrorPath() {
		return "/error";         //mandatory path
	}
	
	@RequestMapping("/error")    //mandatory mapping
	public @ResponseBody String handleError(HttpServletRequest req) {
		
		ServletWebRequest servletWebRequest = new ServletWebRequest(req);

		@SuppressWarnings("deprecation")
		Map<String, Object> errors = errorAttributes.getErrorAttributes(servletWebRequest, true);

		StringBuilder builder = new StringBuilder();
		builder.append("<html><body>");
		builder.append("<h2>ERROR SUMMARY</h2>");

		builder.append("<table border='1.5'>");
		errors.forEach((key, value) -> {
			builder.append("<tr>").append("<td>").append(key).append("</td>").append("<td>").append(value).append("</td>")
					.append("</tr>");
		});
		builder.append("</table>");
		builder.append("</body></html>");
		return builder.toString();
	}
}