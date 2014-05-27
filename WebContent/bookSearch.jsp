<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>本検索ページ</title>
</head>
<body>
    <center>
        <h1>BOOK検索</h1>
        <form method="get" action="BookSearch1">
            <table>
                <tr>
                    <th>検索する本 :</th>
                    <th><input type="text" size="30" name="title"
                        value="本のタイトルを入力してください">
                    </text></th>
                </tr>
                <br>
            </table>
            <input type="submit" value="検索">
    </center>
    </form>
</body>
</html>