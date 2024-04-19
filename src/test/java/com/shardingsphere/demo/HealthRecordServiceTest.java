package com.shardingsphere.demo;

import com.shardingsphere.demo.entity.HealthRecord;
import com.shardingsphere.demo.service.HealthRecordService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class HealthRecordServiceTest {

	@Autowired
	private HealthRecordService healthRecordService;
	
	@Test
	public void testProcess() throws Exception {
		healthRecordService.processHealthRecords();
	}

	@Test
	public void testGetHealthRecord() throws Exception {
		List<HealthRecord> x= healthRecordService.getHealthRecord();
		System.out.println();
	}
}
