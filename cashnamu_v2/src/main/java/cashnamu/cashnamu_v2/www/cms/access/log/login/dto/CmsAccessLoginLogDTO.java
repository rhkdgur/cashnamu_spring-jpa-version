package cashnamu.cashnamu_v2.www.cms.access.log.login.dto;

import java.time.LocalDateTime;

import cashnamu.cashnamu_v2.www.cms.access.log.AccessLoginStatusType;
import cashnamu.cashnamu_v2.www.cms.access.log.login.domain.CmsAccessLoginLog;
import cashnamu.cashnamu_v2.www.modules.member.service.LoginGubunType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CmsAccessLoginLogDTO {

	private Long sno;

	private String accessIp;
	
	private String accessId;
	
	private String dkey;
	
	private AccessLoginStatusType accessLoginStatus;
	
	private LoginGubunType accessLoginGubun;
	
	private String remark;
	
	private LocalDateTime createDate;

	public CmsAccessLoginLogDTO(CmsAccessLoginLog vo) {
		this.sno = vo.getSno();
		this.accessIp = vo.getAccessIp();
		this.accessId = vo.getAccessId();
		this.dkey = vo.getDkey();
		this.accessLoginStatus = vo.getAccessLoginStatus();
		this.accessLoginGubun = vo.getAccessLoginGubun();
		this.remark = vo.getRemark();
		this.createDate = vo.getCreateDate();
	}
}
