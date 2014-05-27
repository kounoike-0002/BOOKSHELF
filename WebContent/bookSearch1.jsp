<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="bookSearch.Book"
    import="java.util.ArrayList"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>検索BOOK一覧</title>
    </head>
    <body>
        <center>
            <h1>検索BOOK一覧</h1>
            <%
            ArrayList<Book> books = (ArrayList<Book>)(request.getAttribute("books"));
            if(books.size() == 0){
            %>
            その様な本は見つかりませんでした。
            <%
            }else{
              for(int i = 0; books.size() > i; i++){
            %>
            ID:<%= books.get(i).getId() %><br>
            タイトル:<%= books.get(i).getTitle() %><br>
            ISBN番号:<%= books.get(i).getISBN() %><br>
            出版社:<%= books.get(i).getPublisher() %><br>
            著者:<%= books.get(i).getWriter() %><br>
            価格:<%= books.get(i).getPrice() %>円<br><br>
            <%
                }
            }
            %>
         </center>
    </body>
</html>