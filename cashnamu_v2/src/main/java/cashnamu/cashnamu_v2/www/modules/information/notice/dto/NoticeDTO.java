package cashnamu.cashnamu_v2.www.modules.information.notice.dto;

import java.time.LocalDateTime;

import cashnamu.cashnamu_v2.www.modules.information.notice.domain.Notice;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class NoticeDTO {

	private Long idx;
	
	private String title;
	
	private String content;
	
	private int view;
	
	private LocalDateTime createDate;
	
	public NoticeDTO() {}
	
	public NoticeDTO(Notice notice) {
		this.idx = notice.getIdx();
		this.title = notice.getTitle();
		this.content = notice.getContent();
		this.view = notice.getView();
		this.createDate = notice.getCreateDate();
	}	 

	public NoticeDTO(Long idx, String title, String content, int view, LocalDateTime createDate) {
		this.idx = idx;
		this.title = title;
		this.content = content;
		this.view = view;
		this.createDate = createDate;
	}	
	
	public Notice toEntity() {
		return Notice.builder().idx(idx).title(title).content(content).view(view).build();
	}
}
