package cashnamu.cashnamu_v2.www.cms.file.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<FileUploadDTO> selectFileUploadList(FileUploadDTO fileUploadDTO){
		FileUpload fileUpload = fileUploadDTO.toEntity();
		List<FileUpload> list = fileUploadRepository.findByCodeContainingIgnoreCaseOrTitleContainingIgnoreCase(fileUpload.getCode(),fileUpload.getTitle());
		List<FileUploadDTO> resultList = list.stream()
				.map(m-> new FileUploadDTO(m.getCode(),m.getTitle(),m.getShortPath(),m.getPath(),m.getUseYn()))
				.collect(Collectors.toList());
		
		return resultList;
	}
	
	/**상세*/
	@Transactional(readOnly = true)
	public FileUploadDTO selectFileUpload(FileUploadDTO fileUploadDTO) {
		FileUpload fileUpload = fileUploadDTO.toEntity();
		return new FileUploadDTO(fileUploadRepository.findById(fileUpload.getSno()).get());
	}
	
	/**등록*/
	@Transactional
	public FileUploadDTO insertFileUpload(FileUploadDTO fileUploadDTO) {
		if(checkFilePath(fileUploadDTO) > 0) {
			return null;
		}
		FileUpload fileUpload = fileUploadDTO.toEntity();
		return new FileUploadDTO(fileUploadRepository.save(fileUpload));
	}
	
	/**수정*/
	@Transactional
	public FileUploadDTO updateFileUpload(FileUploadDTO fileUploadDTO) {
		FileUpload fileUpload = fileUploadDTO.toEntity();
		FileUpload prev = fileUploadRepository.findById(fileUpload.getSno()).get();
		prev = fileUpload;
		return new FileUploadDTO(fileUploadRepository.save(prev));
	}
	
	/**삭제*/
	@Transactional
	public void deleteFileUpload(FileUploadDTO fileUploadDTO) {
		FileUpload fileUpload = fileUploadDTO.toEntity();
		fileUploadRepository.delete(fileUpload);
	}
	
	/**중복 경로 체크*/
	private int checkFilePath(FileUploadDTO fileUploadDTO) {
		FileUpload fileUpload = fileUploadDTO.toEntity();
		return fileUploadRepository.findByPathContainingIgnoreCaseOrShortPathContainingIgnoreCase(fileUpload.getPath(),fileUpload.getShortPath()).size();
	}
}
