package com.longrise.springboot.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName:MyServlet
 * Package:com.longrise.springboot.servlet
 * Description:
 *
 * @Date:2018/12/22 10:18
 * @Author:Tanger@longrise.com
 */
@WebServlet(urlPatterns = "/myServlet")
public class MyServlet extends HttpServlet {
    private static final long serialVersionUID = -4134217146900871026L;
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().print("hello word");
        resp.getWriter().flush();
        resp.getWriter().close();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
