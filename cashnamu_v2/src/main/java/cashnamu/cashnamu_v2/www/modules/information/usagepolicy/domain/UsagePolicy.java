package cashnamu.cashnamu_v2.www.modules.information.usagepolicy.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 
* @packageName    : cashnamu.cashnamu_v2.www.modules.information.usagepolicy.domain
* @fileName        : UsagePolicy.java
* @author        : rhkdg
* @description : 개인정보 처리, 이용약관 테이블 
* =======================================
* DATE			AUTHOR			NOTE
* ---------------------------------------
* 2022.11.29	고광혁			최초생성
 */
@Entity
@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class UsagePolicy {

	@Id @GeneratedValue
	@Comment("일련번호")
	private int sno = 0;
	
	@Column(columnDefinition = "MEDIUMTEXT")
	@Comment("이용약관")
	private String termOfUse;
	
	@Column(columnDefinition = "MEDIUMTEXT")
	@Comment("개인정보 처리 방침")
	private String privacyPolicy;
	
	@CreatedDate
	@Comment("등록일자")
	private LocalDateTime createDate;
	
	@LastModifiedDate
	@Comment("수정일자")
	private LocalDateTime modifyDate;
	
	@Builder
	public UsagePolicy(int sno, String termOfUse, String privacyPolicy, LocalDateTime createDate,
			LocalDateTime modifyDate) {
		super();
		this.sno = sno;
		this.termOfUse = termOfUse;
		this.privacyPolicy = privacyPolicy;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}
	
}
