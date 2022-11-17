package cashnamu.cashnamu_v2.www.cms.file.service;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="cms_file_upload")
@Getter @Setter
public class FileUpload{

	@Id @GeneratedValue
	private Long sno;
	
	@Column(length = 80)
	private String code;
	
	@Column(length = 100)
	private String title;
	
	@Column(length = 100)
	private String shortPath;
	
	@Column(length = 100)
	private String path;
	
	@Column(columnDefinition = "char",length = 1)
	private String useYn;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifyDate;
}
