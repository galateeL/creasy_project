<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Creasy - Companies List</title>

    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
          crossorigin="anonymous">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="/css/company/list.css"/>

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet">



    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
            crossorigin="anonymous"></script>




</head>
<body>

<header>
    <jsp:include page="../header.jsp"/>
</header>

<div class="fluid-container col-12 justify-content-center">

    <h1 class="mt-3 fw-bold ms-5">Companies :</h1>

    <div class="mt-4 ms-md-5 d-flex flex-column flex-md-row align-items-center justify-content-center justify-content-md-start">

        <%--Add company button--%>
        <a class="btn shadow-sm align-self-center"
           href="${pageContext.request.contextPath}/companies/add">Add Company</a>
            <%---------%>

        <%--search bar with search icon button--%>
        <form action="${pageContext.request.contextPath}/companies/list" method="get" class="d-flex ms-md-2 col-10 col-lg-2" role="search">
            <input name="search" value="${searchName}" type="search" class="Search form-control shadow-sm" placeholder="Search..." aria-label="Search">
            <button class="bg-transparent border-0 fa fa-search" type="submit"></button>
        </form>
        <%---------%>

    </div>


    <%--Card for each companies--%>
    <div class="col row m-5 p-3">
        <c:forEach items="${companies}" var="company">
            <div class="col-lg-6 col-12 mt-4">
                <div class="card h-100 border-0">
                    <div class="card-body d-md-flex justify-content-between overflow-auto">
                        <div class="align-items-start">
                            <h5 class="card-title fw-bold text-break">${company.name}</h5>
                            <p class="card-text">${company.address}</p>
                        </div>
                        <a class="btn align-self-center ms-2"
                           href="${pageContext.request.contextPath}/companies/details/${company.id}">Details</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <%---------%>

</div>
</body>
</html>