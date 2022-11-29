package cashnamu.cashnamu_v2.www.modules.member.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.hibernate.annotations.Comment;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@Getter
public class Account {
	/**은행명*/
	@Column(length = 10)
	@Comment("은행명")
	private String bankName;
	/**예금주*/
	@Column(length = 10)
	@Comment("예금주")
	private String accountName;	
	/**계좌번호*/
	@Column(length = 50)
	@Comment("계좌번호")
	private String accountNumber;
	
	@Builder(builderMethodName = "ByBuildAccount")
	public Account(String bankName, String accountName, String accountNumber) {
		this.bankName = bankName;
		this.accountName = accountName;
		this.accountNumber = accountNumber;
	}
	
}
