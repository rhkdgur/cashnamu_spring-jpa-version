package cashnamu.cashnamu_v2.www.cms.category.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import cashnamu.cashnamu_v2.www.cms.category.dto.CategoryDescDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 
* @packageName    : cashnamu.cashnamu_v2.www.cms.category.domain
* @fileName        : CategoryDesc.java
* @author        : rhkdg
* @description : 카테고리 모듈 
* =======================================
* DATE			AUTHOR			NOTE
* ---------------------------------------
* 2022.12.04
 */
@Entity
@Table(name="cms_category_desc")
@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class CategoryDesc {
	
	@Id
	@Comment("일련코드")
	private String categCd;
	
	@Comment("카테고리1")
	private String col1Cd;
	
	@Comment("카테고리2")
	private String col2Cd;
	
	@Comment("카테고리 레벨")
	private int level;
	
	@Comment("제목")
	private String title;
	
	@Comment("순서")
	private int ord;
	
	@Comment("모듈 구분")
	private String gubun;
	
	@CreatedDate
	private LocalDateTime createDate;
	
	@LastModifiedDate
	private LocalDateTime modifyDate;

	
	@Builder	
	public CategoryDesc(CategoryDescDTO dto) {
		this.categCd = dto.getCategCd();
		this.col1Cd = dto.getCol1Cd();
		this.col2Cd = dto.getCol2Cd();
		this.level = dto.getLevel();
		this.title = dto.getTitle();
		this.ord = dto.getOrd();
		this.gubun = dto.getGubun();
		this.createDate = dto.getCreateDate();
		this.modifyDate = dto.getModifyDate();
	}
	
}
