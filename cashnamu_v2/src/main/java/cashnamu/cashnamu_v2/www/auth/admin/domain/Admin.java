package cashnamu.cashnamu_v2.www.auth.admin.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Builder;
import lombok.Getter;

@Entity
@Table(name="cms_member")
@Getter
public class Admin {

	/**아이디*/
	@Id @Column(length = 80)
	private String adminId;
	
	/**비밀번호*/
	@Column(length=200)
	private String adminPw;
	
	/**이름*/ 
	@Column(length=100)
	private String adminName;
	
	/**접근권한*/
	@Column(length=100)
	private String access;
	
	/**페이지 접근권한*/
	@Column(length=100)
	private String pageAccess;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	
	public Admin() {}

	@Builder
	public Admin(String adminId, String adminPw, String adminName, String access, String pageAccess) {
		this.adminId = adminId;
		this.adminPw = adminPw;
		this.adminName = adminName;
		this.access = access;
		this.pageAccess = pageAccess;
	}
	
}
