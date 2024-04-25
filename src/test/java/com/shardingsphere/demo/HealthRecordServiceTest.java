package com.shardingsphere.demo;

import com.shardingsphere.demo.algorithm.PreciseShardingTableAlgorithm;
import com.shardingsphere.demo.algorithm.RangeShardingTableAlgorithm;
import com.shardingsphere.demo.entity.HealthRecord;
import com.shardingsphere.demo.entity.User;
import com.shardingsphere.demo.service.HealthRecordService;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.TableRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.StandardShardingStrategyConfiguration;
import org.apache.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
import org.apache.shardingsphere.shardingjdbc.jdbc.core.datasource.ShardingDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class HealthRecordServiceTest {

	@Autowired
	private DataSource dataSource;

	@Qualifier("shardinngSqlSession")
	@Autowired
	private SqlSession sqlSession;

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

		Map<String, DataSource> dataSourceMap = new HashMap<>();
		// 配置第一个数据源
		BasicDataSource dataSource1 = new BasicDataSource();
		dataSource1.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource1.setUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8&useTimezone=true&allowPublicKeyRetrieval=true");
		dataSource1.setUsername("root");
		dataSource1.setPassword("123456");
		dataSourceMap.put("ds0", dataSource1);


		// 配置Order表规则
		TableRuleConfiguration orderTableRuleConfig = new TableRuleConfiguration("health_record", "ds0.health_record_${0..1}");

		// 配置分库 + 分表策略
		orderTableRuleConfig.setTableShardingStrategyConfig(new StandardShardingStrategyConfiguration("record_id",
				new PreciseShardingTableAlgorithm(), new RangeShardingTableAlgorithm()));

		// 配置分片规则
		ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
		shardingRuleConfig.getTableRuleConfigs().add(orderTableRuleConfig);

		// 获取数据源对象
		DataSource dataSource2 = ShardingDataSourceFactory.createDataSource(dataSourceMap, shardingRuleConfig, new Properties());


		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource2);
        // 配置Mapper扫描路径
		sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mappers/*.xml"));
		SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBean.getObject();
		SqlSession sqlSession=sqlSessionFactory.openSession();

		List   HealthRecord= sqlSession.selectList("com.shardingsphere.demo.repository.HealthRecordRepository.findHealthRecordPage");
		System.out.println();
	}

	@Test
	public void test2() throws Exception {
		List   HealthRecord= sqlSession.selectList("com.shardingsphere.demo.repository.HealthRecordRepository.findHealthRecordPage");
		System.out.println();
	}


}
