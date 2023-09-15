package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Board;
import dto.User;
import service.BoardService;
import service.BoardServiceImpl;

@WebServlet("/board")
public class boardController extends HttpServlet {

    private BoardService service = BoardServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        req.setCharacterEncoding("UTF-8");
        doProcess(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        doGet(req, resp);
    }

    private void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String action = req.getParameter("action");
        switch (action) {
        case "regist":
            doRegist(req, resp);
            break;
        case "delete":

            doRemove(req, resp);
            break;
        case "update":

            doUpdate(req, resp);
            break;
        case "updatePage":

            doUpdatePage(req, resp);
            break;
        case "detail":
            doDetail(req, resp);

            break;
        case "list":
            doList(req, resp);

            break;

        default:
            break;
        }
    }

    private void doUpdatePage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        int num = Integer.parseInt(req.getParameter("num"));
        req.setAttribute("board", service.select(num));
        req.getRequestDispatcher("board/update.jsp").forward(req, resp);

    }

    private void doList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        req.setAttribute("list", service.selectAll());
        req.getRequestDispatcher("board/list.jsp").forward(req, resp);
    }

    private void doDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        int num = Integer.parseInt(req.getParameter("num"));
        Board board = service.select(num);
        System.out.println(board.getWriter());
        System.out.println(req.getSession().getAttribute("loginUser"));
        if(board.getWriter().equals(req.getSession().getAttribute("loginUser"))) {
            req.setAttribute("btns", "btns");
        }
        req.setAttribute("board", board);
        req.getRequestDispatcher("board/detail.jsp").forward(req, resp);

    }

    private void doUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        int num = Integer.parseInt(req.getParameter("num"));
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        Board board = service.select(num);
        System.out.println(board);
        board.setTitle(title);
        board.setContent(content);
        service.update(board);
        doList(req, resp);
    }

    private void doRemove(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        int num = Integer.parseInt(req.getParameter("num"));
        service.remove(num);
        doList(req, resp);

    }

    private void doRegist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        User user = (User) req.getSession().getAttribute("loginUser");
        service.insert(new Board(title, content, user));
        doList(req, resp);
    }
}
