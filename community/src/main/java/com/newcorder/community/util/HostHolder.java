package com.newcorder.community.util;

import com.newcorder.community.entity.User;
import org.springframework.stereotype.Component;

/*
 * 持有用户信息，用于代替session对象
 */
@Component
public class HostHolder {
    private ThreadLocal<User> users = new ThreadLocal<>();//以线程为key存入map

    public void setUser(User user) {
        users.set(user);
    }

    public User getUser() {
        return users.get();
    }

    public void clear() {
//        清理掉线程的值
        users.remove();
    }
}
