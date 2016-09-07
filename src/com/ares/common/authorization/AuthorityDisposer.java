package com.ares.common.authorization;

import java.util.UUID;

import org.apache.commons.lang.StringUtils;

import com.ares.common.utils.MD5Tool;

/**
 * 权限校验器，1.0版本单用户。
 * @author Cenby7
 *
 */
public class AuthorityDisposer {
	private String token;
	
	public String getCurrentToken(){
		if(StringUtils.isEmpty(token)){
			//生成token
			this.token = MD5Tool.getMD5(UUID.randomUUID().toString());
		}
		return token;
	}
	/**
	 * 验证
	 * @param token
	 * @return
	 */
	public boolean validate(String token){
		return this.token.equals(token);
	}
}
