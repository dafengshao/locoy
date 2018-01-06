package com.leisure.locoy;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
import com.leisure.locoy.provider.app.LocoyProviderMain;
import com.leisure.locoy.provider.domain.MerchantBookDO;
import com.leisure.locoy.provider.service.MerchantBookService;
import com.leisure.locoy.spider.LuoxiaSpider;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LocoyProviderMain.class)
public class MyBatisTest {
	@Autowired
	MyBatis2Java myBatis2Java;
	@Autowired
	MerchantBookService merchantBookService;
	@Test
	public void test() {
		myBatis2Java.run();
	}
	@Test
	public void testSpider() {
		List<MerchantBookDO> books = LuoxiaSpider.getBook();
		merchantBookService.insertSelectiveBatch(books);
		
	}
}
