package com.ares.common.exception.commonresolver;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.ares.common.exception.InvalidTokenException;
import com.ares.common.exception.NoDataException;
import com.ares.common.exception.ParamErrorException;
import com.ares.common.utils.MVCControler;

/**
 * 统一异常处理器-简易版本
 * @author Cenby7
 *
 */
public class SimpleExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception exception) {
		//返回结果
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("state", false);
		//异常捕捉
		if (exception instanceof NoDataException) {
			res.put("ErrorCode", 66001);
			res.put("ErrorMessage", exception.getMessage());
		}else if (exception instanceof ParamErrorException) {
			res.put("ErrorCode", 66002);
			res.put("ErrorMessage", exception.getMessage());
		}else if (exception instanceof InvalidTokenException) {
			res.put("ErrorCode", 66003);
			res.put("ErrorMessage", exception.getMessage());
		}else if (exception instanceof LoginException) {
			res.put("ErrorCode", 66004);
			res.put("ErrorMessage", exception.getMessage());
		}else {
			res.put("ErrorCode", 66000);
			res.put("ErrorMessage", "未知错误！");
		}
		
		//ajax统一返回application/json
		try {
			MVCControler.ajax(mapper.writeValueAsString(res), "text/html", request, response);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
