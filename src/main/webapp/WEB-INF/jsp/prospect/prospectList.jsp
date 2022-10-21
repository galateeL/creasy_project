<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <title>CREASY | Prospect list</title>
    </head>
    <body>
    <main>

        <header>
            <jsp:include page="../header.jsp"/>
        </header>

        <h1>Prospect List</h1>

        <a href="${pageContext.request.contextPath}/partners/add-prospect" class="btn"
           style="background-color: #05516b; color:white ">Add new prospect</a>


        <c:forEach items="${prospects}" var="prospect">
            <p>${prospect.firstname}</p>
            <p>${prospect.lastname}</p>
            <p>${prospect.company.name}</p>
            <a href="${pageContext.request.contextPath}/partners/details-prospect/${prospect.id}" class="btn"
               style="background-color: #05516b; color:white ">Detail</a>
        </c:forEach>


    </main>

    </body>
</html>