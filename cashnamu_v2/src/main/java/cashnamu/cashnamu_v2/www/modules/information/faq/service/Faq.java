package cashnamu.cashnamu_v2.www.modules.information.faq.service;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

/**
 * 
* @packageName    : cashnamu.cashnamu_v2.domain.information.faq.service
* @fileName        : Faq.java
* @author        : rhkdg
* @description : Faq
* =======================================
* DATE			AUTHOR			NOTE
* ---------------------------------------
* 2022.11.10	고광혁			최초생성
 */
@Entity
@Table(name="faq")
@Getter @Setter
public class Faq {

	@Id @GeneratedValue
	private int idx;
	
	@Column(length = 100)
	private String title;
	
	@Column(length = 2000)
	private String content;
	
	@Enumerated(EnumType.STRING)
	private FaqGubunType gubun;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
}
