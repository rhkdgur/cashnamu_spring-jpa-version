package cashnamu.cashnamu_v2.www.cms.file.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cashnamu.cashnamu_v2.www.cms.file.domain.FileUpload;

/**
 * 
* @packageName    : cashnamu.cashnamu_v2.www.cms.file.repository
* @fileName        : FileUploadRepository.java
* @author        : rhkdg
* @description : 파일 업로드 리포지토리 
* =======================================
* DATE			AUTHOR			NOTE
* ---------------------------------------
* 2022.11.17
 */
public interface FileUploadRepository extends JpaRepository<FileUpload, Long>{
	
	
	List<FileUpload> findByPathContainingIgnoreCaseOrShortPathContainingIgnoreCase(String path, String shortPath);
	
	List<FileUpload> findByCodeContainingIgnoreCaseOrTitleContainingIgnoreCase(String code, String title);

}
