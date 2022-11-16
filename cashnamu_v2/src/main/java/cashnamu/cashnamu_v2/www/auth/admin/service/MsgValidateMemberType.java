package cashnamu.cashnamu_v2.www.auth.admin.service;

public enum MsgValidateMemberType {
	
	NONE(""),
	OVERLAP("중복되는 회원 정보 입니다.");

	private String display = "";
	
	private MsgValidateMemberType(String display) {
		this.display = display;
	}
	
	public String getDisplay() {
		return display;
	}
}
