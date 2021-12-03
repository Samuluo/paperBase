package com.paper.demo.service.impl;

import com.paper.demo.model.domain.User;
import com.paper.demo.mapper.UserMapper;
import com.paper.demo.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hjh
 * @since 2021-12-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
