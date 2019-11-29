package com.licong.service.impl;

import com.licong.dao.UserDao;
import com.licong.pojo.User;
import com.licong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userss")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User selectOne(User user) {
        /*ExampleMatcher  matcher =ExampleMatcher.matchingAny().withMatcher("name", ExampleMatcher.GenericPropertyMatchers.caseSensitive().exact());
        Example<User> of=Example.of(user,matcher);
        Optional<User> one = userRespositry.findOne(of);
        User user1=null;
       if(one.isPresent()){
           user1=one.get();
       }*/
        System.out.println(user);
        return userDao.selectOne(user);
    }

    @Override
    public Integer userAdd(User user) {
        return userDao.userAdd(user);
    }
}
