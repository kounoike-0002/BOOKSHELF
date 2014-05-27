package bookSearch;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class BookSearch1
 */
@WebServlet("/BookSearch1")
public class BookSearch1 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Resource(name = "jdbc/crud")
    private DataSource ds;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookSearch1() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); // 文字コード設定
        request.setCharacterEncoding("UTF-8");
        String gettitle = (String) request.getParameter("title"); // 検索する本のタイトルを取得
        // gettitle= "'" + gettitle + "'";

        System.out.println(gettitle); // 原因不明の文字化け
        ArrayList<Book> books = new ArrayList<Book>();

        try (Connection con = ds.getConnection();
                PreparedStatement ps = con
                        .prepareStatement("SELECT * FROM BOOKSHELF WHERE title LIKE ?")) {

            ps.setString(1, "%" + gettitle + "%");

            try (ResultSet rs = ps.executeQuery()) {
                PrintWriter out = response.getWriter();



                while (rs.next()) {

                    Book book = new Book();

                    book.setId(rs.getInt("ID"));
                    book.setISBN(rs.getString("isbn"));
                    book.setPrice(rs.getInt("price"));
                    book.setPublisher(rs.getString("publisher"));
                    book.setWriter(rs.getString("writer"));
                    book.setTitle(rs.getString("title"));

                    books.add(book);
                }
                request.setAttribute("books", books);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = request
                .getRequestDispatcher("/bookSearch1.jsp");
        dispatcher.forward(request, response);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

}
