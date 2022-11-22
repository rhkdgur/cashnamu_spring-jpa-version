package cashnamu.cashnamu_v2.www.modules.information.faq.dto;

import java.util.Date;

import cashnamu.cashnamu_v2.www.modules.information.faq.domain.Faq;
import cashnamu.cashnamu_v2.www.modules.information.faq.service.FaqGubunType;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FaqDTO {

	/**일련번호*/
	private Long idx;
	
	/**제목*/
	private String title;
	
	/**내용*/
	private String content;
	
	/**구분*/
	private FaqGubunType gubun;
	
	private Date createDate;
	
	public FaqDTO(Faq faq) {
		this.idx = faq.getIdx();
		this.title = faq.getTitle();
		this.content = faq.getContent();
		this.gubun = faq.getGubun();
		this.createDate = faq.getCreateDate();
	}

	public FaqDTO(Long idx, String title, String content, FaqGubunType gubun, Date createDate) {
		this.idx = idx;
		this.title = title;
		this.content = content;
		this.gubun = gubun;
		this.createDate = createDate;
	}
	
	//Entity
	public Faq toEntity() {
		return Faq.builder().idx(idx).title(title).content(content).gubun(gubun).build();
	}
}
