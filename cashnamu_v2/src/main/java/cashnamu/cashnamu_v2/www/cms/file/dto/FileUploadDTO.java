package cashnamu.cashnamu_v2.www.cms.file.dto;

import cashnamu.cashnamu_v2.www.cms.file.domain.FileUpload;
import lombok.Getter;
import lombok.Setter;

/**
* @packageName    : cashnamu.cashnamu_v2.www.cms.file.service
* @fileName        : FileUploadDTO.java
* @author        : rhkdg
* @description : 
* =======================================
* DATE			AUTHOR			NOTE
* ---------------------------------------
* 2022.11.22
*/
@Getter @Setter
public class FileUploadDTO {
	
	/**파일경로 코드*/
	private String code;
	
	/**제목*/
	private String title;
	
	/**짧은 경로*/
	private String shortPath;
	
	/**전체 경로*/
	private String path;
	
	/**사용여부*/
	private String useYn;

	/**경로 존쟁유무*/
	private boolean pathFlag = false;
	
	public FileUpload toEntity() {
		return FileUpload.builder().
				code(code).
				title(title).
				shortPath(shortPath).
				path(path).
				useYn(useYn).
				build();
	}
	
	public FileUploadDTO() {}
	
	public FileUploadDTO(FileUpload fileUpload) {
		this.code = fileUpload.getCode();
		this.title = fileUpload.getTitle();
		this.shortPath = fileUpload.getShortPath();
		this.path = fileUpload.getPath();
		this.useYn = fileUpload.getUseYn();
	}

	public FileUploadDTO(String code, String title, String shortPath, String path, String useYn) {
		this.code = code;
		this.title = title;
		this.shortPath = shortPath;
		this.path = path;
		this.useYn = useYn;
	}
}
