package com.shardingsphere.demo.repository;

import com.shardingsphere.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author lzn
 */
@Mapper
public interface UserRepository extends BaseRepository<User, Long> {


    List<User> findAllUsers() ;
}
