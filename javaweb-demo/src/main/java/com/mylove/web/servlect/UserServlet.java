package com.mylove.web.servlect;

import com.mylove.pojo.User;
import com.mylove.service.UserService;
import com.mylove.service.impl.UserServiceImpl;
import com.mylove.util.CheckCodeUtil;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet{
    private UserService userService=new UserServiceImpl();

    /**
     * 添加用户
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 处理post 请求的乱码问题
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        userService.add(new User(username,password,email));
        request.getRequestDispatcher("index.html").forward(request,response);

    }

    /**
     * 生成验证码
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void checkCode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 生成验证码
        ServletOutputStream os = response.getOutputStream();
        String checkCode = CheckCodeUtil.outputVerifyImage(100, 50, os, 4);

        // 存入session
        HttpSession session = request.getSession();
        session.setAttribute("checkCodeGen", checkCode);
    }

    /**
     * 注册
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取用户输入的验证码
        String checkCode = request.getParameter("yzm");
        // 获取程序生成的验证码 从 session
        HttpSession session = request.getSession();
        String checkCodeGen = (String) session.getAttribute("checkCodeGen");

        // 比对验证码
        if (!checkCodeGen.equalsIgnoreCase(checkCode)) {
            request.setAttribute("register_msg", "验证码错误");
            request.getRequestDispatcher("index.html").forward(request,response);
            //不允许注册
            return;
        }
        request.getRequestDispatcher("user/add").forward(request,response);
    }

    /**
     * 查询用户名是否存在
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void selectUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接收用户名
        String username = request.getParameter("username");

        //2.调用 service 查询 user 对象
        User user = userService.selectUser(username);

        if (user!=null){
            response.getWriter().write("exist");
            return;
        }
        response.getWriter().write("noexist");
    }
}
