package cashnamu.cashnamu_v2.www.auth.admin.service;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="cms_member")
@Getter @Setter
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
	
}
