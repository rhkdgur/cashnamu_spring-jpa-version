package cashnamu.cashnamu_v2;

import static org.junit.jupiter.api.Assertions.fail;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import cashnamu.cashnamu_v2.www.modules.information.notice.service.Notice;
import cashnamu.cashnamu_v2.www.modules.information.notice.service.NoticeService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Rollback(false)
class NoticeServiceTest {
	
	@Autowired
	EntityManager em;
	
	@Autowired
	NoticeService noticeService;

//	@Test
	void test() {
		fail("Not yet implemented");
	}

	
	@Test
	void NoticeTest() {
	
		Notice notice = new Notice();
		notice.setTitle("안녕");
		notice.setContent("글이야");
		
		noticeService.insertNotice(notice);
		
//		noticeService.viewPlusInsert(notice);
	}
}
