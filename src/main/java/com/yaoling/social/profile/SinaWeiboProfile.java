package com.yaoling.social.profile;

import org.pac4j.oauth.profile.OAuth20Profile;

import com.yaoling.social.definition.SinaWeiboAttributesDefinition;

/**
 * 微博用户信息
 * @author zrk  
 * @date 2016年4月15日 下午5:44:10
 */
public class SinaWeiboProfile extends OAuth20Profile implements ClientProfile{

	private static final long serialVersionUID = -7486869356444327783L;

	public String getOpenid() {
		return (String)getAttribute(SinaWeiboAttributesDefinition.IDSTR);
	}
	
	public String getNickname() {
		return (String)getAttribute(SinaWeiboAttributesDefinition.NAME);
	}
	
	//性别，m：男、f：女、n：未知 
	public Integer getSex() {
		String sex = (String)getAttribute(SinaWeiboAttributesDefinition.GENDER);
		if("m".equals(sex)) return 1;
		if("f".equals(sex)) return 0;
		return null;
	}
	public String getIcon(){
		return (String)getAttribute(SinaWeiboAttributesDefinition.AVATAR_HD);
	}

}
