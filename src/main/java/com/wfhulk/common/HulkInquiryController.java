package com.wfhulk.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wfhulk.HttpAPIClient.HttpClient;

@RestController
public class HulkInquiryController {
	

	@RequestMapping("")
	public JSONResponse processMessage(final HttpServletRequest request, final HttpServletResponse response,@PathVariable("inputText")String inputText){
		JSONResponse responseObject = new JSONResponse();
		//TODO: HttpClient will return us the JSONRequest object.
		HttpClient httpClient = new HttpClient();
		JSONRequest jsonRequest = httpClient.invokeAPIAI(inputText);
		String action ="";
		if(jsonRequest!=null){
			action = jsonRequest.getActionName();
			if(action!=null){
				
			}
		}
		
		return responseObject;
	}
}
