package cashnamu.cashnamu_v2.www.auth.admin.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;

import cashnamu.cashnamu_v2.www.auth.admin.AdminSession;
import cashnamu.cashnamu_v2.www.auth.admin.dto.AdminDTO;
import cashnamu.cashnamu_v2.www.auth.admin.service.AdminService;
import cashnamu.cashnamu_v2.www.auth.util.SHA256TypeHandler;

@RestController
public class AdminController {

	@Autowired
	AdminService adminService;
	
	
	@GetMapping("admin")
	public List<AdminDTO> selectAdminList(AdminDTO adminDTO,
								  @RequestParam Map<String,String> paramUtil
								  ) throws Exception {		
		return adminService.findByAdmins();
	}
	
	@GetMapping(value="/admin/view")
	public AdminDTO selectAdmin(@RequestBody AdminDTO adminDTO,SessionStatus status) throws Exception {		
		return adminService.findById(adminDTO);
	}
	
	@PostMapping(value="/admin/create/action")
	public Map<String,String> createAdmin(@RequestBody AdminDTO adminDTO,SessionStatus status) throws Exception {
		Map<String,String> map = new HashMap<>();
		adminDTO = adminService.insert(adminDTO);
		if(adminDTO == null) {
			map.put("result", "fail");
			return map;
		}
		map.put("result", "success");
		status.setComplete();
		return map;
	}
	
	@PostMapping(value="/admin/update/action")
	public Map<String,String> updateAdmin(@RequestBody AdminDTO adminDTO,SessionStatus status) throws Exception {
		
		Map<String,String> map = new HashMap<>();
		
		adminDTO = adminService.update(adminDTO);
		if(adminDTO == null) {
			map.put("result", "fail");
			return map;
		}
		
		map.put("result", "success");
		status.setComplete();
		return map;
	}
	
	@PostMapping(value="/admin/login")
	public Map<String,String> adminLogin(@RequestParam("id") String id,
							 @RequestParam("password") String password,
							 HttpSession session ) throws Exception {
		
		Map<String,String> map = new HashMap<>();
		
		if("".equals(id) || "".equals(password)) {
			map.put("result", "empty");
			map.put("msg", "아이디 또는 비밀번호를 입력해주시기 바랍니다.");
			return map;
		}
		
		AdminDTO adminDTO = new AdminDTO();
		adminDTO.setAdminId(id);
		adminDTO.setAdminPw(password);
		adminDTO = adminService.findById(adminDTO);
		
		if(!SHA256TypeHandler.matches(password, adminDTO.getAdminPw())) {
			map.put("result", "fail");
			map.put("msg", "아이디 또는 비밀번호가 다릅니다.");
			return map;
		}
		
		AdminSession.CreateAdminSession(session, adminDTO);
		map.put("result", "success");
		return map;
	}
}
