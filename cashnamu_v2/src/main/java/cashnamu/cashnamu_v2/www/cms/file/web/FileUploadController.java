package cashnamu.cashnamu_v2.www.cms.file.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import cashnamu.cashnamu_v2.www.cms.file.dto.FileUploadDTO;
import cashnamu.cashnamu_v2.www.cms.file.service.FileUploadService;
import cashnamu.cashnamu_v2.www.cms.util.FileUploadUtil;

/**
 * 
* @packageName    : cashnamu.cashnamu_v2.www.cms.file.web
* @fileName        : FileUploadController.java
* @author        : rhkdg
* @description : 파일 경로 업로드 및 파일 생성
* =======================================
* DATE			AUTHOR			NOTE
* ---------------------------------------
* 2022.11.22
 */
@RestController
public class FileUploadController {

	@Autowired
	FileUploadService fileUploadService;
	
	/**
	 * 파일 목록
	 * @param fileUpload
	 * @param pageable
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/cms/file/list")
	public ResponseEntity<List<FileUploadDTO>> selectFileUploadList(FileUploadDTO fileUploadDTO) throws Exception{	
		List<FileUploadDTO> resultList = fileUploadService.selectFileUploadList(fileUploadDTO);
		return new ResponseEntity<>(resultList,HttpStatus.OK);
	}
	
	/**
	 * 파일 조회
	 * @param fileUpload
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/cms/file/view")
	public ResponseEntity<FileUploadDTO> viewFileUpload(FileUploadDTO fileUploadDTO) throws Exception {
		fileUploadDTO = fileUploadService.selectFileUpload(fileUploadDTO);
		return new ResponseEntity<>(fileUploadDTO,HttpStatus.OK);
	}
	
	/**
	 * 파일 수정
	 * @param fileUpload
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/cms/file/update")
	public ResponseEntity<FileUploadDTO> uploadFileUpload(FileUploadDTO fileUploadDTO) throws Exception {
		
		FileUploadDTO updateUpload = fileUploadService.updateFileUpload(fileUploadDTO);
		if(!ObjectUtils.isEmpty(updateUpload)) {
			FileUploadUtil.makeFile(updateUpload.getPath());//다이렉트 경로 생성
			return new ResponseEntity<FileUploadDTO>(updateUpload,HttpStatus.OK);
		}else {
			return new ResponseEntity<FileUploadDTO>(fileUploadDTO,HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 * 파일 등록
	 * @param fileUpload
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/cms/file/create")
	public ResponseEntity<FileUploadDTO> createFileUpload(FileUploadDTO fileUploadDTO) throws Exception {
		FileUploadDTO createUpload = fileUploadService.insertFileUpload(fileUploadDTO);
		if(!ObjectUtils.isEmpty(createUpload)) {
			FileUploadUtil.makeFile(createUpload.getPath());//다이렉트 경로 생성
			return new ResponseEntity<FileUploadDTO>(createUpload,HttpStatus.OK);
		}else {
			return new ResponseEntity<FileUploadDTO>(fileUploadDTO,HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * 파일 삭제
	 * @param fileUpload
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/cms/file/delete")
	public ResponseEntity<FileUploadDTO> deleteFileUpload(FileUploadDTO fileUploadDTO) throws Exception {
		
		try {
			fileUploadService.deleteFileUpload(fileUploadDTO);
		}catch (Exception e) {
			return new ResponseEntity<FileUploadDTO>(fileUploadDTO,HttpStatus.BAD_REQUEST);	
		}
		return new ResponseEntity<FileUploadDTO>(fileUploadDTO,HttpStatus.OK);
	}
}
