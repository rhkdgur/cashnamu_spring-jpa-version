package cashnamu.cashnamu_v2.www.cms.file.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import cashnamu.cashnamu_v2.www.BaseController;
import cashnamu.cashnamu_v2.www.ResponseResultType;
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
public class FileUploadController  extends BaseController{

	@Autowired
	FileUploadService fileUploadService;
	
	/**
	 * 파일 목록
	 * @param fileUpload
	 * @param pageable
	 * @return
	 * @throws Exception
	 */
	@GetMapping(MGN_URL+"/cms/file/list")
	public Page<FileUploadDTO> selectFileUploadList(FileUploadDTO fileUploadDTO,Pageable pageable) throws Exception{	
		return fileUploadService.selectFileUploadList(fileUploadDTO,pageable);
	}
	
	/**
	 * 파일 조회
	 * @param fileUpload
	 * @return
	 * @throws Exception
	 */
	@GetMapping(MGN_URL+"/cms/file/view")
	public ResponseEntity<FileUploadDTO> viewFileUpload(FileUploadDTO fileUploadDTO) throws Exception {
		fileUploadDTO = fileUploadService.selectFileUpload(fileUploadDTO);
		return new ResponseEntity<>(fileUploadDTO,HttpStatus.OK);
	}
	
	/**
	 * 파일 등록
	 * @param fileUpload
	 * @return
	 * @throws Exception
	 */
	@PostMapping(MGN_URL+"/cms/file/act/ins")
	public ResponseEntity<String> createFileUpload(FileUploadDTO fileUploadDTO) throws Exception {
		FileUploadDTO createUpload = fileUploadService.insertFileUpload(fileUploadDTO);
		if(!ObjectUtils.isEmpty(createUpload)) {
			FileUploadUtil.makeFile(createUpload.getPath());//다이렉트 경로 생성
			return new ResponseEntity<String>(ResponseResultType.INS_SUCCESS.getDisplay(),HttpStatus.OK);
		}else {
			return new ResponseEntity<String>(ResponseResultType.INS_FAIL.getDisplay(),HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 * 파일 삭제
	 * @param fileUpload
	 * @return
	 * @throws Exception
	 */
	@PostMapping(MGN_URL+"/cms/file/act/del")
	public ResponseEntity<String> deleteFileUpload(FileUploadDTO fileUploadDTO) throws Exception {
		
		try {
			fileUploadService.deleteFileUpload(fileUploadDTO);
		}catch (Exception e) {
			return new ResponseEntity<String>(ResponseResultType.DEL_SUCCESS.getDisplay(),HttpStatus.BAD_REQUEST);	
		}
		return new ResponseEntity<String>(ResponseResultType.DEL_SUCCESS.getDisplay(),HttpStatus.OK);
	}
}
