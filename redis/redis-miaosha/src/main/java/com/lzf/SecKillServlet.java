package com.lzf; /**
 * 秒杀案例
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

public class SecKillServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SecKillServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userid = new Random().nextInt(50000) + "";
        String prodid = request.getParameter("prodid");

        //boolean isSuccess=com.lzf.SecKill_redis.doSecKill(userid,prodid);
//        System.out.println(userid);
//        System.out.println(prodid);
        boolean isSuccess = SecKill_redis.doSecKill(userid, prodid);
        response.getWriter().print(isSuccess);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
