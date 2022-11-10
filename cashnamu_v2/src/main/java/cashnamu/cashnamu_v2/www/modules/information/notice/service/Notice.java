package cashnamu.cashnamu_v2.www.modules.information.notice.service;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

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
@Getter @Setter
public class Notice {

	@Id @GeneratedValue
	private Long idx;
	
	@Column(length = 100)
	private String title;
	
	@Column(length = 2000)
	private String content;
	
	@Column(nullable = true)
	private int view;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
}
