package cashnamu.cashnamu_v2;

import static org.junit.jupiter.api.Assertions.fail;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import cashnamu.cashnamu_v2.www.auth.admin.domain.Admin;
import cashnamu.cashnamu_v2.www.auth.admin.service.AdminService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Rollback(false)
class AdminServiceTest {
	
	@Autowired
	EntityManager em;
	
	@Autowired
	private AdminService adminService;

//	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	@Transactional
	void AdminTest() {
		try {
//		Admin admin = new Admin();
//		admin.setAdminId("test");
//		admin.setAdminPw("test");
//		admin.setAdminName("test1");
//		
//		adminService.insert(admin);
//		
//		System.out.println("@@@@@ : "+admin.getAdminName());
//		
//		em.flush();
//		em.clear();
//		
//		admin.setAdminName("test2");
//		Admin prev = adminService.update(admin);
//		System.out.println("@@@@@@@@@@@@ : "+prev.getAdminName());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
