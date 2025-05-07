<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
    <head>
        <title>resportdata</title>
        <link href="webjars/bootstrap/5.3.3/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class = "container">
            <table class = "table">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${beans}" var="bean">
                        <tr>
                            <td>${bean.id}</td>
                            <td>${bean.name}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div> 
    </body>
</html>