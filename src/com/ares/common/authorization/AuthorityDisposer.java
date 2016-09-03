package com.ares.common.authorization;

import java.util.UUID;

import org.apache.commons.lang.StringUtils;

import com.ares.common.utils.Md5;

/**
 * 权限校验器，1.0版本单用户。
 * @author Cenby7
 *
 */
public class AuthorityDisposer {
	private String token;
	
	public String getCurrentToken(){
		if(StringUtils.isEmpty(token)){
			Md5 md5  = new Md5(UUID.randomUUID().toString());
			//生成token
			this.token = md5.getStringDigest();
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
