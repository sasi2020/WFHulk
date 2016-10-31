/**
 * 
 */
package com.wfhulk.bookconference;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wfhulk.common.ProcessorInterface;

/**
 * @author Shasanka
 *
 */
public class BookConferenceProcessor implements ProcessorInterface {
	private List<String> REQUIRED_PARAMETERS=Arrays.asList("CAPACITY","FROM_TIME","TO_TIME","DATE");
	private HashMap<String,String> errorMessages = new HashMap<>();
	

	/* (non-Javadoc)
	 * @see com.wellsfargo.common.ProcessorInterface#validate(java.util.Map)
	 */
	public String validate(Map<String, Object> parameterMap) {
		String errorMessage=" Please tell us the";
		if(parameterMap!=null){
			for(String key:parameterMap.keySet()){
				if(!REQUIRED_PARAMETERS.contains(key)){
					errorMessage +=errorMessages.get(key);
				}
			}
		}
		
		return errorMessage;
	}

	/* (non-Javadoc)
	 * @see com.wellsfargo.common.ProcessorInterface#processRequest(java.util.Map)
	 */
	public String processRequest(Map<String, Object> parameterMap) {
		// TODO Auto-generated method stub
		return null;
	}

}
