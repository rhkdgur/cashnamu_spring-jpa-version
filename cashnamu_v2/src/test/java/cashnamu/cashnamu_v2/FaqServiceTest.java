package cashnamu.cashnamu_v2;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.fail;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import cashnamu.cashnamu_v2.www.modules.information.faq.service.Faq;
import cashnamu.cashnamu_v2.www.modules.information.faq.service.FaqGubunType;
import cashnamu.cashnamu_v2.www.modules.information.faq.service.FaqService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Rollback(false)
class FaqServiceTest {
	
	@Autowired
	EntityManager em;
	
	@Autowired
	private FaqService faqService;

//	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	@Transactional
	void faqTest() {
		for(int i=0; i<5; i++) {
			Faq faq = new Faq();
			faq.setTitle("TEST"+i);
			faq.setGubun(FaqGubunType.C);
			faq.setContent("Content"+i);
			faqService.insertFaq(faq);
		}
		
		for(int i=0; i<5; i++) {
			Faq faq = new Faq();
			faq.setTitle("TEST2_"+i);
			faq.setGubun(FaqGubunType.O);
			faq.setContent("Content2_"+i);
			faqService.insertFaq(faq);
		}
		
		for(int i=0; i<5; i++) {
			Faq faq = new Faq();
			faq.setTitle("TEST3_"+i);
			faq.setGubun(FaqGubunType.S);
			faq.setContent("Content3_"+i);
			faqService.insertFaq(faq);
		}
	
		em.flush();
		em.clear();
		
		Faq faq2 = new Faq();
		faq2.setIdx((long) 1);
		faq2.setGubun(FaqGubunType.C);
		faq2 = faqService.findOne(faq2);
		System.out.println("faq2 : "+faq2.getTitle());
//		Page<Faq> list = faqService.findAllByGubun(faq2, PageRequest.of(0,10,Sort.by(Sort.Direction.DESC,"idx")));
	}

}
