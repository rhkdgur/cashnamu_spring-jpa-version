package cashnamu.cashnamu_v2.www.auth.oauth.web;

import java.util.Map;

import cashnamu.cashnamu_v2.www.auth.oauth.OauthDetailsDTO;

abstract class BaseOauthController {

	/**
	 * OauthDetailsDTO 생성
	 * @param map
	 * @return
	 * @throws Exception
	 */
	protected OauthDetailsDTO createOauthDetail(Map<String,String> map) throws Exception {
		return new OauthDetailsDTO(map);
	}
}
