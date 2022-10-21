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
    <title>CREASY | Customer list</title>
</head>
<body>
<main>
    <header>
        <jsp:include page="../header.jsp"/>
    </header>

    <h1>Customer List</h1>

    <c:forEach items="${customers}" var="customer">
        <p>${customer.firstname}</p>
        <p>${customer.lastname}</p>
        <a href="${pageContext.request.contextPath}/partners/details/${customer.id}" class="btn"
           style="background-color: #05516b; color:white ">Detail</a>
    </c:forEach>


</main>

</body>
</html>