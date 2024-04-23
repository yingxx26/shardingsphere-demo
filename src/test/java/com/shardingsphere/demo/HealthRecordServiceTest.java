package com.shardingsphere.demo;

import com.shardingsphere.demo.entity.HealthRecord;
import com.shardingsphere.demo.service.HealthRecordService;
import org.apache.shardingsphere.shardingjdbc.jdbc.core.datasource.ShardingDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class HealthRecordServiceTest {

	@Autowired
	private DataSource dataSource;

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

	@Test
	public void testUpdateHealthRecord() throws Exception {
	    healthRecordService.updateHealthRecords();
		System.out.println();
	}

	@Test
	public void test1() throws Exception {
		Connection connection = dataSource.getConnection();
		PreparedStatement prepareStatement = connection.prepareStatement("select * from health_record  ");
		//prepareStatement.setString(1, "2342");
		prepareStatement.execute();
		ResultSet result2 = prepareStatement.getResultSet();
		if (result2.next()) {

		}
		System.out.println();
	}

}
