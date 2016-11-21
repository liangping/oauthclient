package com.yaoling.social.definition;

import org.pac4j.core.profile.AttributesDefinition;
import org.pac4j.core.profile.converter.Converters;

/**
 * 返回数据转化器
 * @author zrk  
 * @date 2016年4月15日 下午5:43:44
 */
public class WeiXinAttributesDefinition extends AttributesDefinition {

	public static final String ID = "id"; 							//数据库业务id
	public static final String OPEN_ID = "openid";					//openid。
	public static final String NICK_NAME = "nickname";				//用户在昵称。
	public static final String SEX = "sex";							//性别。 1
	public static final String PROVINCE = "province";				//省
	public static final String CITY = "city";						//市
	public static final String HEADIMGURL = "headimgurl";			//大小为40×40像素的QQ头像URL。

	public WeiXinAttributesDefinition() {
		//primary(ID, Converters.LONG);
		primary(OPEN_ID, Converters.STRING);
		primary(NICK_NAME, Converters.STRING);
		primary(SEX, Converters.INTEGER);
		primary(PROVINCE, Converters.STRING);
		primary(CITY, Converters.STRING);
		primary(HEADIMGURL, Converters.STRING);
	}

}
