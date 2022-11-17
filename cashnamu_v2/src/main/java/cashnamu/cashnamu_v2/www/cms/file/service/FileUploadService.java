package cashnamu.cashnamu_v2.www.cms.file.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cashnamu.cashnamu_v2.www.cms.file.repository.FileUploadRepository;

/**
 * 
* @packageName    : cashnamu.cashnamu_v2.www.cms.file.service
* @fileName        : FileUploadService.java
* @author        : rhkdg
* @description : 파일 업로드 서비스
* =======================================
* DATE			AUTHOR			NOTE
* ---------------------------------------
* 2022.11.17	고광혁			최초생성
 */
@Service
public class FileUploadService {

	@Autowired
	private FileUploadRepository fileUploadRepository;
	
	/**목록조회*/
	@Transactional(readOnly = true)
	public Page<FileUpload> selectFileUploadList(FileUpload fileUpload,Pageable pageable){
		return fileUploadRepository.findByCodeContainingIgnoreCaseOrTitleContainingIgnoreCase(fileUpload, pageable);
	}
	
	/**상세*/
	@Transactional(readOnly = true)
	public FileUpload selectFileUpload(FileUpload fileUpload) {
		return fileUploadRepository.findById(fileUpload.getSno()).get();
	}
	
	/**등록*/
	@Transactional
	public FileUpload insertFileUpload(FileUpload fileUpload) {
		if(checkFilePath(fileUpload) > 0) {
			return null;
		}
		return fileUploadRepository.save(fileUpload);
	}
	
	/**수정*/
	@Transactional
	public FileUpload updateFileUpload(FileUpload fileUpload) {
		FileUpload prev = fileUploadRepository.findById(fileUpload.getSno()).get();
		prev = fileUpload;
		return fileUploadRepository.save(prev);
	}
	
	/**삭제*/
	@Transactional
	public void deleteFileUpload(FileUpload fileUpload) {
		fileUploadRepository.delete(fileUpload);
	}
	
	/**중복 경로 체크*/
	private int checkFilePath(FileUpload fileUpload) {
		return fileUploadRepository.findByPathContainingIgnoreCaseOrShortPathContainingIgnoreCase(fileUpload.getPath(),fileUpload.getShortPath()).size();
	}
}
