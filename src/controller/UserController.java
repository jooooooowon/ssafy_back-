package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.User;
import service.UserService;
import service.UserServiceImpl;

@WebServlet("/user")
public class UserController extends HttpServlet {

    private UserService service = UserServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        req.setCharacterEncoding("UTF-8");
        doProcess(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        resp.setContentType("text/html); charset=UTF-8");
        doGet(req, resp);
    }

    private void doProcess(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        // TODO Auto-generated method stub
        String action = req.getParameter("action");
        switch (action) {
        case "doLogin":
            doLogin(req, resp);
            break;
        case "doLogout":
            doLogout(req, resp);
            break;
        case "doJoin":
            doJoin(req, resp);
            break;
        default:
            break;
        }
    }

    private void doJoin(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        // TODO Auto-generated method stub
        String id = req.getParameter("id");
        String pwd = req.getParameter("pwd");
        String name = req.getParameter("name");
        User user = new User(id, pwd, name);

        System.out.println("1");
        if (service.insert(user)) {
            System.out.println("2");
            req.setAttribute("result", false);
            req.getRequestDispatcher("user/join.jsp").forward(req, resp);
        } else {
            System.out.println("3");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }

    }

    private void doLogout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // TODO Auto-generated method stub
        HttpSession session = req.getSession();
        session.invalidate();
        resp.sendRedirect(req.getContextPath() + "/index.jsp" + "");
    }

    private void doLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String id = req.getParameter("id");
        String pwd = req.getParameter("pwd");

        User user = service.login(id, pwd);
        String msg = null;
        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("loginUser", user);
            msg = "로그인 성공!";
        } else {
            msg = "로그인 실패!";
        }
        req.setAttribute("msg", msg);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

}
