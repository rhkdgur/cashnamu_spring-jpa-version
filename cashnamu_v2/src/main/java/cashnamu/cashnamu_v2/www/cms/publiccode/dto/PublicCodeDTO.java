package cashnamu.cashnamu_v2.www.cms.publiccode.dto;

import java.time.LocalDateTime;

import cashnamu.cashnamu_v2.www.cms.publiccode.domain.PublicCode;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PublicCodeDTO {

	private String pubCd; 
	
	private String parentCd;
	
	private String title;
	
	private String remark;
	
	private String useYn;
	
	private int ord;

	private String createId;
	
	private String modifyId;
	
	private LocalDateTime createDate;
	
	private LocalDateTime modifyDate;
	
	//== 엔티티 변환 ==//
	public PublicCode toEntity() {
		return PublicCode.builder()
				.pubCd(pubCd)
				.parentCd(parentCd)
				.title(title)
				.remark(remark)
				.useYn(useYn)
				.ord(ord)
				.createId(createId)
				.modifyId(modifyId)
				.build();
	}

	//== 엔티티 값 가져오기 ==//
	public PublicCodeDTO(PublicCode publicCode) {
		this.pubCd = publicCode.getPubCd();
		this.parentCd = publicCode.getParentCd();
		this.title = publicCode.getTitle();
		this.remark = publicCode.getRemark();
		this.useYn = publicCode.getUseYn();
		this.ord = publicCode.getOrd();
		this.createId = publicCode.getCreateId();
		this.modifyId = publicCode.getModifyId();
		this.createDate = publicCode.getCreateDate();
		this.modifyDate = publicCode.getModifyDate();
	}
}
