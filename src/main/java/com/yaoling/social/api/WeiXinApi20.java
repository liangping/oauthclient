package com.yaoling.social.api;


import com.github.scribejava.core.builder.api.DefaultApi20;
import com.github.scribejava.core.extractors.TokenExtractor;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthConfig;
import com.github.scribejava.core.oauth.OAuth20Service;
import com.github.scribejava.core.utils.OAuthEncoder;
import com.github.scribejava.core.utils.Preconditions;
import com.yaoling.social.api.service.WeiXinOAuth20ServiceImpl;

/**
 * 微信登录api
 * @author zrk  
 * @date 2016年4月15日 下午5:41:56
 */
public class WeiXinApi20 extends DefaultApi20 {
	//private static final String AUTHORIZE_URL = "https://open.weixin.qq.com/connect/qrconnect?response_type=code&appid=%s&redirect_uri=%s";
	private static final String AUTHORIZE_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=%s&state=#wechat_redirect";

	protected WeiXinApi20() {
	}
	
	public static WeiXinApi20 INSTANCE = new WeiXinApi20();

	@Override
	public String getAccessTokenEndpoint() {
		return "https://api.weixin.qq.com/sns/oauth2/access_token";
	}

	@Override
	public String getAuthorizationUrl(OAuthConfig config) {
		Preconditions.checkValidUrl(config.getCallback(),
				"Must provide a valid url as callback. 	WeiXin does not support OOB");

		return String.format(AUTHORIZE_URL, config.getApiKey(), OAuthEncoder.encode(config.getCallback()),OAuthEncoder.encode(config.hasScope()?config.getScope():"snsapi_base"));
	
	}

	@Override
	public TokenExtractor<OAuth2AccessToken> getAccessTokenExtractor() {
		return super.getAccessTokenExtractor();
	}

	@Override
	public OAuth20Service createService(OAuthConfig config) {
		return new WeiXinOAuth20ServiceImpl(this, config);
	}
	
}
