package com.shardingsphere.demo.service;

import com.shardingsphere.demo.entity.HealthRecord;
import com.shardingsphere.demo.entity.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @author lzn
 */
public interface HealthRecordService {
	
	/**
	 * processHealthRecords
	 *
	 * @throws SQLException
	 */
	void processHealthRecords() throws SQLException;
	List<HealthRecord> getHealthRecord() throws SQLException;
}
