package com.ssafy.board.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardServiceTest {
	@Autowired
	private BoardService bservice;
	
	@Autowired
	private BoardDao bdao;
	
	@Test
	public void testMakePage() {
		assertNotNull(bservice.makePage(1));
	}
	
	@Test
	public void testSelectOne() {
		assertNotNull(bdao.selectOne(3));
		assertEquals(3, bdao.selectOne(3).getBnum());
	}
	
}
