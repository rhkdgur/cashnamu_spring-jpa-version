package cashnamu.cashnamu_v2.www.cms.category.dto;

import java.time.LocalDateTime;

import cashnamu.cashnamu_v2.www.cms.category.domain.CategoryDesc;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryDescDTO {
	
	private String categCd;
	
	private String col1Cd;
	
	private String col2Cd;
	
	private int level;
	
	private String title;
	
	private int ord;
	
	private String gubun;

	private LocalDateTime createDate;
	
	private LocalDateTime modifyDate;

	public CategoryDescDTO(CategoryDesc entity) {
		this.categCd = entity.getCategCd();
		this.col1Cd = entity.getCol1Cd();
		this.col2Cd = entity.getCol2Cd();
		this.level = entity.getLevel();
		this.title = entity.getTitle();
		this.ord = entity.getOrd();
		this.gubun = entity.getGubun();
		this.createDate = entity.getCreateDate();
		this.modifyDate = entity.getModifyDate();
	}
	
	
}
