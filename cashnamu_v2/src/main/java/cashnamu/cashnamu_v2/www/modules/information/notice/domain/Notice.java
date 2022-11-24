package cashnamu.cashnamu_v2.www.modules.information.notice.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import lombok.Builder;
import lombok.Getter;

/**
 * 
* @packageName    : cashnamu.cashnamu_v2.domain.information.notice.service
* @fileName        : Notice.java
* @author        : rhkdg
* @description : 공지사항 
* =======================================
* DATE			AUTHOR			NOTE
* ---------------------------------------
* 2022.11.10   고광혁				최초생성
 */
@Entity
@Table(name="notice_board")
@Getter
@EntityListeners(AuditingEntityListener.class)//자동 날짜 생성
public class Notice {

	@Id @GeneratedValue
	private Long idx;
	
	@Column(length = 100)
	private String title;
	
	@Column(length = 2000)
	private String content;
	
	@Column(nullable = true)
	private int view;
	
	@CreatedDate
	private LocalDateTime createDate;
	
	public Notice() {}

	@Builder
	public Notice(Long idx, String title, String content, int view) {
		super();
		this.idx = idx;
		this.title = title;
		this.content = content;
		this.view = view;
	}
}
