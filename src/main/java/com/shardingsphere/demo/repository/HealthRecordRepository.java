package com.shardingsphere.demo.repository;

import com.shardingsphere.demo.entity.HealthRecord;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

/**
 * @author lzn
 */
@Mapper
public interface HealthRecordRepository extends BaseRepository<HealthRecord, Long> {


   List<HealthRecord> findHealthRecordPage();

    void batchUpdate(List<HealthRecord> recordList) throws SQLException;
}
