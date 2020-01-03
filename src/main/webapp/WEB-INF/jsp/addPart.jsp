<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <title>Add New Part</title>
        <link href="<c:url value="/res/css/style.css"/>" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="content">
            <c:url value="/add" var="addPage"/>
            <H1>Добавление новой запчасти</H1>
            <form action="${addPage}" method="post">
                <table class="add-edit-table">
                    <tr>
                        <td><label for="title">Название детали</label></td>
                        <td><input type="text" name="title" id="title"></td>
                    </tr>
                    <tr>
                        <td><label for="amount">Количество</label></td>
                        <td><input type="text" name="amount" id="amount"></td>
                    </tr>
                    <tr>
                        <td><label for="needed">Нужна для сборки</label></td>
                        <td><input type="checkbox" name="needed" id="needed"></td>
                    </tr>
                    <tr>
                        <td>
                            <a href="/" class="btn default">Назад</a>
                        </td>
                        <td>
                            <button class="btn success" type="submit">Изменить деталь</button>
                        </td>
                    </tr>
                </table>
<%--                <a href="/" class="btn default">Назад</a>--%>
<%--                <button class="btn success" type="submit">Добавить деталь</button>--%>
            </form>

        </div>
    </body>
</html>
