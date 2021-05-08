package com.eos.conf;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
@Transactional
public class GlobalTestConf {

	private static Logger logger = LoggerFactory
			.getLogger(GlobalTestConf.class);

	@BeforeAll
	public void setUp() {
		logger.info("GlobalTestConf-Setup");
		logger.info("================> start testing...");
	}
}
