package cashnamu.cashnamu_v2.www.modules.information.usagepolicy.dto;

import java.time.LocalDateTime;

import cashnamu.cashnamu_v2.www.modules.information.usagepolicy.domain.UsagePolicy;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
@Getter @Setter
@NoArgsConstructor
public class UsagePolicyDTO {

	private int sno = 0;
	
	private String termOfUse;
	
	private String privacyPolicy;
	
	private LocalDateTime createDate;
	
	private LocalDateTime modifyDate;
	
	public UsagePolicyDTO(UsagePolicy dto) {
		this.sno = dto.getSno();
		this.termOfUse = dto.getTermOfUse();
		this.privacyPolicy = dto.getPrivacyPolicy();
		this.createDate = dto.getCreateDate();
		this.modifyDate = dto.getModifyDate();
	}
	
	//entity
	public UsagePolicy toEntity() {
		return UsagePolicy.builder().
			   sno(this.sno).
			   termOfUse(termOfUse).
			   privacyPolicy(privacyPolicy).
			   createDate(createDate).
			   modifyDate(modifyDate).build();
	}
}
