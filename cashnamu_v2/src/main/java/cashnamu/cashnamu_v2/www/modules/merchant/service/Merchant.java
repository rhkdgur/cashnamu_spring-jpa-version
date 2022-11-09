package cashnamu.cashnamu_v2.www.modules.merchant.service;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

/**
 * 
* @packageName    : cashnamu.cashnamu_v2.www.modules.merchant.service
* @fileName        : Merchant.java
* @author        : rhkdg
* @description : 머천트
* =======================================
* DATE			AUTHOR			NOTE
* ---------------------------------------
* 2022.11.10	고광혁			최초생성
 */
@Entity
@Table(name="merchant_list")
@Getter @Setter
public class Merchant {

	/**머천트 아이디*/
	@Id @Column(length = 30)
	private String merchantId;
	
	/**사이트 이름*/
	@Column(length = 50)
	private String siteName;
	
	/**카테고리*/
	@Column(length = 20)
	private String subCateg;
	
	/**도메인*/
	@Column(length = 200)
	private String siteUrl;
	
	/**모바일 사용여부*/
	@Column(columnDefinition = "CHAR", length = 1)
	private String mobileStatus;
	
	/**이미지 경로*/
	@Column(length = 200)
	private String imageLink;
	
	/**확인사항*/
	@Column(length = 4000)
	private String checkComment;
	
	/**유의사항*/
	@Column(length = 4000)
	private String adviceComment;
	
	/**커미션 정보*/
	@Column(length = 4000)
	private String commissionComment;

	/**조회수*/
	@Column(nullable = true)
	private int view;
	
	/**인기여부*/
	@Column(columnDefinition = "CHAR",length = 1)
	private String popularity;
	
	/**딥링크 상태*/
	@Column(columnDefinition = "CHAR",length = 1)
	private String deeplinkStatus;
	
	/**사용여부*/
	@Column(columnDefinition = "CHAR",length = 1)
	private String useStatus;
	
	/**인기순위*/
	@Column(nullable = true)
	private int popularityOrd;
	
	/**등록일자*/
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	
	/**수정일자*/
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifyDate;
}
