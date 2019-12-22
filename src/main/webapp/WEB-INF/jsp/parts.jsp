<%--
  Created by IntelliJ IDEA.
  User: snipe
  Date: 11.11.2019
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Parts</title>
        <link href="<c:url value="/res/css/style.css"/>" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="content">
            <div>
                <p>Сортировать по:
                    <a href="<c:url value="/?page=${param.page}&sort=all"/>">Все</a>
                    <a href="<c:url value="/?page=${param.page}&sort=needed"/>">Нужные</a>
                    <a href="<c:url value="/?page=${param.page}&sort=utility"/>">Вспомогательные</a>
                </p>
            </div>
            <table>
                <thead>
                <tr>
                    <th class="left-td">Наименование</th>
                    <th class="center-td">Необходимость</th>
                    <th class="left-td">Количество</th>
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
                        <td class="right-td">${part.amount}</td>
                    </tr>
                </c:forEach>
            </table>

            <div id="page-number">
                <c:forEach begin="1" end="${pageCount}" step="1" varStatus="i">
                    <c:url value="/?sort=${param.sort}" var="url">
                        <c:param name="page" value="${i.index}"/>
                    </c:url>
                    <a href="${url}">${i.index}</a>
                </c:forEach>
            </div>

            <table>
                <tr>
                    <td class="left-td">Можно собрать</td>
                    <td class="center-td">${NumberOfComputers}</td>
                    <td class="right-td">Компьютеров</td>
                </tr>
            </table>

        </div>
    </body>
</html>
