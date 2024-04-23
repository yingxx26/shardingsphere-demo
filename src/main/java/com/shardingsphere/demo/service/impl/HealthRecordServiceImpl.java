package com.shardingsphere.demo.service.impl;

import com.shardingsphere.demo.entity.HealthRecord;
import com.shardingsphere.demo.entity.HealthTask;
import com.shardingsphere.demo.repository.HealthRecordRepository;
import com.shardingsphere.demo.repository.HealthTaskRepository;
import com.shardingsphere.demo.service.HealthRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lzn
 */
@Service
public class HealthRecordServiceImpl implements HealthRecordService {

	@Autowired
	private HealthRecordRepository healthRecordRepository;

	@Autowired
	private HealthTaskRepository healthTaskRepository;

	@Override
	public void processHealthRecords() throws SQLException{
		insertHealthRecords();
	}
	
	private List<Long> insertHealthRecords() throws SQLException {
        List<Long> result = new ArrayList<>(10);
        for (Long i = 1L; i <= 10; i++) {
        	HealthRecord healthRecord = insertHealthRecord(i);
            insertHealthTask(i, healthRecord);
            result.add(healthRecord.getRecordId());
        }
        return result;
    }
    
    private HealthRecord insertHealthRecord(final Long i) throws SQLException {
    	HealthRecord healthRecord = new HealthRecord();
    	healthRecord.setUserId(i);
    	healthRecord.setLevelId(i % 5);
    	healthRecord.setRemark("Remark" + i);
        healthRecordRepository.addEntity(healthRecord);
        return healthRecord;
    }
    
    private void insertHealthTask(final Long i, final HealthRecord healthRecord) throws SQLException {
    	HealthTask healthTask = new HealthTask();
    	healthTask.setRecordId(healthRecord.getRecordId());
    	healthTask.setUserId(i);
    	healthTask.setTaskName("TaskName" + i);
    	healthTaskRepository.addEntity(healthTask);
    }


	@Override
	public List<HealthRecord> getHealthRecord() throws SQLException {
		return healthRecordRepository.findEntities();
	}

	@Override
	public void updateHealthRecords() throws SQLException{
       List<HealthRecord>  list =new  ArrayList<HealthRecord>();

		HealthRecord healthRecord = new HealthRecord();
		healthRecord.setRecordId(988055244443357184L);
		healthRecord.setRemark("Remark" + 11);

		HealthRecord healthRecord2 = new HealthRecord();
		healthRecord2.setRecordId(988055244955062273L);
		healthRecord2.setRemark("Remark" + 22);
		list.add(healthRecord) ;
		list.add(healthRecord2) ;
		healthRecordRepository.batchUpdate(list);
	}
}
