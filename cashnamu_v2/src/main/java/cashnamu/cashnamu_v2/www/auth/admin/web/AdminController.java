package cashnamu.cashnamu_v2.www.auth.admin.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;

import cashnamu.cashnamu_v2.www.auth.admin.login.AdminSession;
import cashnamu.cashnamu_v2.www.auth.admin.service.Admin;
import cashnamu.cashnamu_v2.www.auth.admin.service.AdminService;
import cashnamu.cashnamu_v2.www.auth.util.SHA256TypeHandler;

@RestController
public class AdminController {

	@Autowired
	AdminService adminService;
	
	
	@GetMapping("admin")
	public Page<Admin> selectAdminList(Admin admin,
								  @RequestParam Map<String,String> paramUtil,
								  Pageable pageable) throws Exception {		
		return adminService.findByAdmins(pageable);
	}
	
	@GetMapping(value="/admin/view")
	public Admin selectAdmin(@RequestBody Admin admin,SessionStatus status) throws Exception {		
		return adminService.findById(admin);
	}
	
	@PostMapping(value="/admin/create/action")
	public Map<String,String> createAdmin(@RequestBody Admin admin,SessionStatus status) throws Exception {
		Map<String,String> map = new HashMap<>();
		admin = adminService.insert(admin);
		if(admin == null) {
			map.put("result", "fail");
			return map;
		}
		map.put("result", "success");
		status.setComplete();
		return map;
	}
	
	@PostMapping(value="/admin/update/action")
	public Map<String,String> updateAdmin(@RequestBody Admin admin,SessionStatus status) throws Exception {
		
		Map<String,String> map = new HashMap<>();
		
		admin = adminService.update(admin);
		if(admin == null) {
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
		
		Admin admin = new Admin();
		admin.setAdminId(id);
		admin.setAdminPw(password);
		admin = adminService.findById(admin);
		
		if(!SHA256TypeHandler.matches(password, admin.getAdminPw())) {
			map.put("result", "fail");
			map.put("msg", "아이디 또는 비밀번호가 다릅니다.");
			return map;
		}
		
		AdminSession.CreateAdminSession(session, admin);
		map.put("result", "success");
		return map;
	}
}
