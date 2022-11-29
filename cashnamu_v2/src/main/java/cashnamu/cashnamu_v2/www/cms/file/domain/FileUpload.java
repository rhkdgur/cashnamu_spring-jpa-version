package cashnamu.cashnamu_v2.www.cms.file.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Builder;
import lombok.Getter;

@Entity
@Table(name="cms_file_upload")
@Getter
@EntityListeners(AuditingEntityListener.class)
public class FileUpload{

	/**일련번호*/
	@Id @GeneratedValue
	private Long sno;
	
	/**파일경로 코드*/
	@Column(length = 80)
	private String code;
	
	/**제목*/
	@Column(length = 100)
	private String title;
	
	/**짧은 경로*/
	@Column(length = 100)
	private String shortPath;
	
	/**전체 경로*/
	@Column(length = 100)
	private String path;
	
	/**사용여부*/
	@Column(columnDefinition = "char",length = 1)
	private String useYn;
	
	@CreatedDate
	private Date createDate;
	
	@LastModifiedDate
	private Date modifyDate;
	
	public FileUpload() {}
	
	@Builder
	public FileUpload(String code, String title, String shortPath, String path, String useYn) {
		this.code = code;
		this.title = title;
		this.shortPath = shortPath;
		this.path = path;
		this.useYn = useYn;
	}
}
