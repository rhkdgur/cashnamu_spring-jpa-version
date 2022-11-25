package cashnamu.cashnamu_v2.www.cms.publiccode.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 
* @packageName    : cashnamu.cashnamu_v2.www.cms.publiccode.domain
* @fileName        : PublicCode.java
* @author        : rhkdg
* @description : 공통코드 관리 테이블
* =======================================
* DATE			AUTHOR			NOTE
* ---------------------------------------
* 2022.11.25	고광혁			최초생성
 */
@Entity
@Table(name="cms_public_code")
@Getter
@NoArgsConstructor
public class PublicCode {
	
	@Id
	@Comment("코드")
	@Column(length = 30,nullable = false)
	private String pubCd; 
	
	@Comment("상위코드")
	@Column(length = 30,nullable = false)
	private String parentCd;
	
	@Comment("제목")
	@Column(length = 100)
	private String title;
	
	@Comment("비고")
	@Column(length = 1000)
	private String remark;
	
	@Comment("사용여부")
	@Column(columnDefinition = "char", length = 1)
	@ColumnDefault("'Y'")
	private String useYn;
	
	@Comment("정렬순서")
	@Column(nullable = true)
	@ColumnDefault("0")
	private int ord;
	
	@Comment("등록아이디")
	@Column(length = 50)
	private String createId;
	
	@Comment("수정아이디")
	@Column(length = 50)
	private String modifyId;
	
	@CreatedDate
	private LocalDateTime createDate;
	
	@LastModifiedDate
	private LocalDateTime modifyDate;
	
	@Builder
	public PublicCode(String pubCd, String parentCd, String title, String remark, String useYn, int ord,
			String createId, String modifyId, LocalDateTime createDate, LocalDateTime modifyDate) {
		this.pubCd = pubCd;
		this.parentCd = parentCd;
		this.title = title;
		this.remark = remark;
		this.useYn = useYn;
		this.ord = ord;
		this.createId = createId;
		this.modifyId = modifyId;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}
	
}
