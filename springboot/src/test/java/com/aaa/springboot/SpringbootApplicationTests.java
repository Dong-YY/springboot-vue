package com.aaa.springboot;

import com.aaa.springboot.domain.User;
import com.aaa.springboot.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootApplicationTests {

  @Autowired
  UserMapper userMapper;

  @Test
  public void selectPage(){
    LambdaQueryWrapper<User> userLambdaQueryWrapper = Wrappers.lambdaQuery();
    userLambdaQueryWrapper.like(User::getNickName,"");
    Page<User> page = new Page(1,10);
    Page<User> page1 = userMapper.selectPage(page, userLambdaQueryWrapper);
    System.out.println("总页数"+page1.getPages());
    System.out.println("总记录数"+page1.getTotal());

  }
}
