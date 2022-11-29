package cashnamu.cashnamu_v2.www.modules.member.dto;

import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import cashnamu.cashnamu_v2.www.modules.member.domain.Member;
import cashnamu.cashnamu_v2.www.modules.member.service.LoginGubunType;
import lombok.Data;

@Data
public class MemberDTO {

	/**회원 아이디*/
	private String id;
	
	/**회원 고유키값*/
	private String dkey;
	
	/**전화번호*/
	private String phoneNumber;
	
	/**이름*/
	private String name;
	
	/**사용자 포인트*/
	private int point;
	
	/** 사용자 활성화 상태*/
	private int status;
	
	/** 로그인 구분*/
	@Enumerated(EnumType.STRING)
	private LoginGubunType gubun;
	
	/** 성별*/
	private String gender;
	
	/** 생일*/
	private String birthDay;
	
	/** 본인인증 키*/
	private String authKey;
	
	/**은행명*/
	private String bankName;
	
	/**예금주*/
	private String accountName;	
	
	/**계좌번호*/
	private String accountNumber;
	
	/**최근 접속 일자*/
	private Date finalConnectTime;
	
	/**등록 일자*/
	private Date createDate;

	//entity -> dto
	public MemberDTO(Member member) {
		this.id = member.getId();
		this.dkey = member.getDkey();
		this.phoneNumber = member.getPhoneNumber();
		this.name = member.getName();
		this.point = member.getPoint();
		this.status = member.getStatus();
		this.gubun = member.getGubun();
		this.gender = member.getGender();
		this.birthDay = member.getBirthDay();
		this.authKey = member.getAuthKey();
		this.bankName = member.getAccount().getBankName();
		this.accountName = member.getAccount().getAccountName();
		this.accountNumber = member.getAccount().getAccountNumber();
		this.finalConnectTime = member.getFinalConnectTime();
		this.createDate = member.getCreateDate();
	}
	
	
}
