package com.myweb.dao;


import com.myweb.pojo.Jiashu;
import com.myweb.pojo.Laoren;
import com.myweb.pojo.User;

import java.util.List;

public interface XiTongDao {

    public List<User> findUsersByUsernameNotSuper();

    public List<User> findUsersByUsername(String username);

    public List<User> findUsersByUsernameAndIdNot(String username, int id);

    public List<Laoren> findLaorens(Laoren laoren);

    public List<Jiashu> findJiashus(Jiashu jiashu);

    public int saveJiashu(Jiashu jiashu);

    public int updateJiashuById(Jiashu jiashu);

    public int deleteJiashuById(int id);

    public Laoren getLaorenById(int id);

    public User getUserById(int id);

    public Jiashu getJiashuById(int id);

    public int saveLaoren(Laoren laoren);

    public int updateLaorenById(Laoren laoren);

    public int saveUser(User user);

    public int updateUserById(User user);

    public int deleteLaorenById(int id);

    public int deleteUserById(int id);

    public int updateLaorenTypeById(int type, int id);
}
