package Action;

import Dao.BookDao;
import Entity.Book;
import Entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class BookAction extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String action = request.getParameter("action");
       if(action.equals("getall")){
           this.getAll(request, response);
       }
       
    }
    private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDao bdao = new BookDao();
        ArrayList<Book> bookArrayList = bdao.getAllBook();
        HttpSession session = request.getSession();
        session.setAttribute("allbooklist", bookArrayList);
        request.getRequestDispatcher("/booklist.jsp").forward(request,response);
    }
}
