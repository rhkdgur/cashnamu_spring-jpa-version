package cashnamu.cashnamu_v2.www.cms.access.log;

/**
 * 
* @packageName    : cashnamu.cashnamu_v2.www
* @fileName        : ResponseResultType.java
* @author        : rhkdg
* @description : POST 등록 처리 결과 ENUM
* =======================================
* DATE			AUTHOR			NOTE
* ---------------------------------------
* 2022.11.24	고광혁			최초생성
 */
public enum AccessLoginStatusType {

	LOGIN_SUCCESS("로그인 성공"),
	LOGIN_FAIL("로그인 실패"),
	LOGIN_ERROR("로그인 접근시 에러 발생");
	
	private String display = "";
	
	AccessLoginStatusType(String display) {
		this.display = display;
	}
	
	public String getDisplay() {
		return display;
	}
}
