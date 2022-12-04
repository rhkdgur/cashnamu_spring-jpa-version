package cashnamu.cashnamu_v2.www.cms.access.log.login.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import cashnamu.cashnamu_v2.www.cms.access.log.AccessLoginStatusType;
import cashnamu.cashnamu_v2.www.cms.access.log.login.dto.CmsAccessLoginLogDTO;
import cashnamu.cashnamu_v2.www.modules.member.service.LoginGubunType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="cms_access_login_log")
@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class CmsAccessLoginLog {

	@Id @GeneratedValue
	@Comment("일련번호")
	private Long sno;
	
	@Column(length = 50)
	@Comment("접속 ip")
	private String accessIp;
	
	@Column(length = 50)
	@Comment("접근 아이디")
	private String accessId;
	
	@Column(length = 200)
	@Comment("접근 dkey")
	private String dkey;
	
	@Column(length = 20)
	@Comment("접근 상태")
	@Enumerated(EnumType.STRING)
	private AccessLoginStatusType accessLoginStatus;
	
	@Column(length = 20)
	@Comment("접근 구분")
	@Enumerated(EnumType.STRING)
	private LoginGubunType accessLoginGubun;
	
	@Column(length = 200)
	@Comment("비고")
	private String remark;
	
	@CreatedDate
	private LocalDateTime createDate;

	@Builder
	public CmsAccessLoginLog(CmsAccessLoginLogDTO dto) {
		this.sno = dto.getSno();
		this.accessIp = dto.getAccessIp();
		this.accessId = dto.getAccessId();
		this.dkey = dto.getDkey();
		this.accessLoginStatus = dto.getAccessLoginStatus();
		this.accessLoginGubun = dto.getAccessLoginGubun();
		this.remark = dto.getRemark();
		this.createDate = dto.getCreateDate();
	}
	
}
