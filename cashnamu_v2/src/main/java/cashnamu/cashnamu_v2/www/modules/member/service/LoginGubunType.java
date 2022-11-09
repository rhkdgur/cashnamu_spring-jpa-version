package cashnamu.cashnamu_v2.www.modules.member.service;

public enum LoginGubunType {
	NAVER("네이버"),
	GOOGLE("구글"),
	KAKAO("카카오");
	
	private String display = "";
	
	private LoginGubunType(String display) {
		this.display = display;
	}
	
	public String getDisplay() {
		return display;
	}
}
