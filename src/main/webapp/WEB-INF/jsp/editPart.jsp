<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <title>Edit Part</title>
        <link href="<c:url value="/res/css/style.css"/>" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="content">
            <c:url value="/edit" var="editPage"/>
            <H1>Редактирование запчасти</H1>
            <form action="${editPage}" method="post">
                <input type="hidden" name="id" value="${part.id}">

                <table class="add-edit-table">
                    <tr>
                        <td><label for="title">Название детали</label></td>
                        <td><input type="text" name="title" id="title" value="${part.title}"></td>
                    </tr>
                    <tr>
                        <td><label for="amount">Количество</label></td>
                        <td><input type="text" name="amount" id="amount" value="${part.amount}"></td>
                    </tr>
                    <tr>
                        <td><label for="needed">Нужна для сборки</label></td>
                        <td><input type="checkbox" name="needed" id="needed" <c:if test="${part.needed == true}">checked</c:if>></td>
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
            </form>
        </div>
    </body>
</html>
