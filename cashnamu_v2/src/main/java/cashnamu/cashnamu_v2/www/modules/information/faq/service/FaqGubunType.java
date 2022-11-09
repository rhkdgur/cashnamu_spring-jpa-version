package cashnamu.cashnamu_v2.www.modules.information.faq.service;

public enum FaqGubunType {
	
	S("시작하기"),
	O("주문하기"),
	C("캐시백받기"),
	R("환급받기");

	private String display = "";
	
	private FaqGubunType(String display) {
		this.display = display;
	}
	
	public String getDisplay() {
		return display;
	}
}
