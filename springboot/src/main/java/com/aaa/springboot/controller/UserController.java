package com.aaa.springboot.controller;

import com.aaa.springboot.common.Result;
import com.aaa.springboot.domain.User;
import com.aaa.springboot.mapper.UserMapper;
import com.aaa.springboot.service.UserService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
@CrossOrigin  //跨域
@RestController
@RequestMapping("/user")
public class UserController {

  @Resource
  UserService userService;
  @Resource
  UserMapper userMapper;

  /**
   * 查询
   * @param pageNum
   * @param pageSize
   * @param name
   * @return
   */
  @GetMapping
  public Result<?> queryPage(@RequestParam(defaultValue = "1") Integer pageNum,
                          @RequestParam(defaultValue = "10") Integer pageSize,
                            @RequestParam(defaultValue = "") String name){
    Page<User> page = userService.page(new Page<>(pageNum, pageSize), Wrappers.<User>lambdaQuery().like(User::getNickName,name));
    return Result.success(page);
  }

  /**
   * 添加
   * @param user
   * @return
   */
  @PostMapping
  public Result<?> add(@RequestBody User user){
    user.setPassword("123");
    userService.save(user);
    return Result.success();
  }

  /**
   * 修改
   * @param user
   * @return
   */
  @PutMapping
  public Result<?> update(@RequestBody User user){
    userService.updateById(user);
    return Result.success();
  }


  @DeleteMapping("/{id}")
  public Result<?> delete(@PathVariable Long id){
    userService.removeById(id);
    return Result.success();
  }
}
