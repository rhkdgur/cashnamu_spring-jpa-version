package cashnamu.cashnamu_v2.www.cms.file.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cashnamu.cashnamu_v2.www.cms.file.domain.FileUpload;
import cashnamu.cashnamu_v2.www.cms.file.dto.FileUploadDTO;
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
	public Page<FileUploadDTO> selectFileUploadList(FileUploadDTO fileUploadDTO,Pageable pageable){
		FileUpload fileUpload = fileUploadDTO.toEntity();
		Page<FileUpload> list = fileUploadRepository.findByCodeContainingIgnoreCaseOrTitleContainingIgnoreCase(fileUpload.getCode(),fileUpload.getTitle(),pageable);
		return list.map(m-> new FileUploadDTO(m.getCode(),m.getTitle(),m.getShortPath(),m.getPath(),m.getUseYn()));
	}
	
	/**상세*/
	@Transactional(readOnly = true)
	public FileUploadDTO selectFileUpload(FileUploadDTO fileUploadDTO) {
		FileUpload fileUpload = fileUploadDTO.toEntity();
		return new FileUploadDTO(fileUploadRepository.findById(fileUpload.getSno()).get());
	}
	
	/**등록
	 * @throws IllegalAccessException */
	@Transactional
	public FileUploadDTO insertFileUpload(FileUploadDTO fileUploadDTO) throws Exception {
		if(fileUploadDTO.getCode().isEmpty()) {
			if(checkFilePath(fileUploadDTO) > 0) {
				throw new IllegalAccessException();
			}
		}
		FileUpload fileUpload = fileUploadDTO.toEntity();
		return new FileUploadDTO(fileUploadRepository.save(fileUpload));
	}
	
	/**삭제*/
	@Transactional
	public void deleteFileUpload(FileUploadDTO fileUploadDTO) throws Exception{
		FileUpload fileUpload = fileUploadDTO.toEntity();
		fileUploadRepository.delete(fileUpload);
	}
	
	/**중복 경로 체크*/
	private int checkFilePath(FileUploadDTO fileUploadDTO) {
		FileUpload fileUpload = fileUploadDTO.toEntity();
		return fileUploadRepository.findByPathContainingIgnoreCaseOrShortPathContainingIgnoreCase(fileUpload.getPath(),fileUpload.getShortPath()).size();
	}
}
