<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css" />
    </head>

    <body>
        <h1>${product.title}</h1>
        <div>Cost: ${product.cost}</div>
        <ol>
            <c:forEach var="item" items="${customers}">
                <li><a href = "/home/customer/${item.id}/">${item.name}</a></li>
            </c:forEach>
        </ol>
        <div><a href="/home/">Home page</a></div>
    </body>
</html>