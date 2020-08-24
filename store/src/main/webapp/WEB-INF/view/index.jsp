<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css" />
    </head>

    <body>
        <h1>Home page</h1>

        <ol>
            <c:forEach var="item" items="${products}">
                <li><a href = "/home/product/${item.id}/"> ${item.title}</a></li>
            </c:forEach>
        </ol>

        <a href="/home/addproduct/">Add product</a>

    </body>
</html>