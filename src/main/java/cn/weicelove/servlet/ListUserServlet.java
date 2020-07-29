package cn.weicelove.servlet;

import cn.weicelove.dao.UserDao;
import cn.weicelove.dao.impl.UserDaoImpl;
import cn.weicelove.entity.User;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author DIDIBABA_CAR_QPW Create in 2020/7/7 14:21
 */
public class ListUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao ud = new UserDaoImpl();
        List<User> userAll = ud.listAll();
        req.setAttribute("userAll", userAll);
        req.getRequestDispatcher("/jsp/listAll.jsp").forward(req, resp);
    }
}
