package com.balicamp.ngx.master;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.sokkheang.huo.common.NgxSpringOauthServerApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = NgxSpringOauthServerApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class NgxSpringOauthServerApplicationTests {

	@Test
	public void contextLoads() {
	}

}
