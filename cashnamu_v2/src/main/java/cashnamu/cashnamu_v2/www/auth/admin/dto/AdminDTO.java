package cashnamu.cashnamu_v2.www.auth.admin.dto;

import java.time.LocalDateTime;
import java.util.Date;

import cashnamu.cashnamu_v2.www.auth.admin.domain.Admin;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AdminDTO {

	/**아이디*/
	private String adminId;
	
	/**비밀번호*/
	private String adminPw;
	
	/**이름*/ 
	private String adminName;
	
	/**접근권한*/
	private String access;
	
	/**페이지 접근권한*/
	private String pageAccess;
	
	private LocalDateTime createDate;
	
	//DTO -> entity
	public Admin toEntity() {
		return Admin.builder().
				adminId(adminId).
				adminName(adminName).
				adminPw(adminPw).
				access(access).pageAccess(pageAccess).build();
	}
	
	public AdminDTO() {}
	
	public AdminDTO(Admin admin) {
		this.adminId = admin.getAdminId();
		this.adminPw = admin.getAdminPw();
		this.adminName = admin.getAdminName();
		this.access = admin.getAccess();
		this.pageAccess = admin.getPageAccess();
		this.createDate = admin.getCreateDate();
	}

	public AdminDTO(String adminId, String adminPw, String adminName, String access, String pageAccess,LocalDateTime createDate) {
		this.adminId = adminId;
		this.adminPw = adminPw;
		this.adminName = adminName;
		this.access = access;
		this.pageAccess = pageAccess;
		this.createDate = createDate;
	}
}
