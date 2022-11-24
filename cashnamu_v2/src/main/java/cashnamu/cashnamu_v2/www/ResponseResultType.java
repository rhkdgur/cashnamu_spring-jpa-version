package cashnamu.cashnamu_v2.www;

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
public enum ResponseResultType {

	INS_SUCCESS("저장 되었습니다."),
	INS_FAIL("저장에 실패하였습니다."),
	UPD_SUCCESS("수정 되었습니다."),
	UPD_FAIL("수정에 실패하였습니다."),
	DEL_SUCCESS("삭제 되었습니다."),
	DEL_FAIL("삭제에 실패하였습니다.");
	
	private String display = "";
	
	ResponseResultType(String display) {
		this.display = display;
	}
	
	public String getDisplay() {
		return display;
	}
}
