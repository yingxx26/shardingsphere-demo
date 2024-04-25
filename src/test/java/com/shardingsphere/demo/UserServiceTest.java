package com.shardingsphere.demo;

import com.shardingsphere.demo.algorithm.PreciseShardingTableAlgorithm;
import com.shardingsphere.demo.algorithm.RangeShardingTableAlgorithm;
import com.shardingsphere.demo.entity.HealthRecord;
import com.shardingsphere.demo.entity.User;
import com.shardingsphere.demo.service.UserService;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.TableRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.StandardShardingStrategyConfiguration;
import org.apache.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class UserServiceTest {

	@Autowired
	private SqlSession sqlsession;
	@Autowired
	private UserService userService;
	
	@Test
	public void testProcessUsers() throws Exception {
		List<User>  x=userService.getUsers();
		System.out.println();
	}


	@Test
	public void test2() throws Exception {
		List   user= sqlsession.selectList("com.shardingsphere.demo.repository.UserRepository.findAllUsers");
		List   users= (ArrayList<User>)user;
		System.out.println();
	}


	@Test
	public void test3() throws Exception {

	}

}
