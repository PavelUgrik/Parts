<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <title>Parts</title>
        <link href="<c:url value="/res/css/style.css"/>" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
        <div class="content">
            <div class="topnav">
                    <a class="active">Сортировать по:</a>
                    <a href="<c:url value="/?sort=all"/>">Все</a>
                    <a href="<c:url value="/?sort=needed"/>">Нужные</a>
                    <a href="<c:url value="/?sort=utility"/>">Вспомогательные</a>
                <div class="search-container">
                    <form action="<c:url value="/"/>" method="get">
                        <input type="text" placeholder="Поиск..." name="query">
                        <button type="submit"><i class="fa fa-search"></i></button>
                    </form>
                </div>
            </div>
            <div class="pagination">
                <a class="active">Страница:</a>
                <c:forEach begin="1" end="${pageCount}" step="1" varStatus="i">
                    <c:url value="/?sort=${param.sort}" var="url">
                        <c:param name="page" value="${i.index}"/>
                    </c:url>
                    <a href="${url}">${i.index}</a>
                </c:forEach>
            </div>
            <table class="main-table">
                <thead>
                <tr>
                    <th class="center-td">Наименование</th>
                    <th class="center-td">Необходимость</th>
                    <th class="center-td">Количество</th>
                    <th colspan="2" class="right-td-td">Действия</th>
                </tr>
                </thead>
                <c:forEach var="part" items="${PartList}">
                    <tr>
                        <td class="left-td">${part.title}</td>
                        <td class="center-td">
                            <c:if test="${part.needed}">
                                да
                            </c:if>
                            <c:if test="${!part.needed}">
                                нет
                            </c:if>
                        </td>
                        <td class="center-td">${part.amount}</td>
                        <td><a class="edit-button" href="<c:url value="/edit/${part.id}"/>"><i class="fa fa-pencil-square-o"></i></a></td>
                        <td><a class="delete-button" href="<c:url value="/delete/${part.id}"/>"><i class="fa fa-trash"></i></a></td>
                    </tr>
                </c:forEach>
            </table>



            <div class="clear">
                <p>Всего можно собрать ${NumberOfComputers} компьютеров</p>
                <a href="/add">Добавить новую деталь</a>
            </div>
        </div>
    </body>
</html>
