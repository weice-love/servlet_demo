package cn.weicelove.dao.impl;

import cn.weicelove.dao.UserDao;
import cn.weicelove.entity.User;
import cn.weicelove.util.DBUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author DIDIBABA_CAR_QPW Create in 2020/7/7 14:05
 */
public class UserDaoImpl implements UserDao {

    @Override
    public List<User> listAll() {
        List<User> list = new ArrayList<>();
        try {
            DBUtil.init();
            ResultSet rs = DBUtil.selectSql("select * from t_user");
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                list.add(user);
            }
            DBUtil.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean update(int id, String name) {
        boolean flag = false;
        DBUtil.init();
        String sql = "update user set name ='" + name
                 + "' where id = " + id;
        int i = DBUtil.addUpdDel(sql);
        if (i > 0) {
            flag = true;
        }
        DBUtil.closeConn();
        return flag;
    }

    public boolean delete(int id) {
        boolean flag = false;
        DBUtil.init();
        String sql = "delete  from user where id=" + id;
        int i = DBUtil.addUpdDel(sql);
        if (i > 0) {
            flag = true;
        }
        DBUtil.closeConn();
        return flag;
    }
}
