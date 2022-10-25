<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!doctype html>
<html lang="en" style="height: 100%;">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Pacifico&display=swap" rel="stylesheet">

    <link rel="icon" type="image/x-icon" href="/img/circleLogo.png">

    <style>
        @import url('https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap');
    </style>

    <title>Document</title>
</head>
<body class="vh-100" style="background-color:
#F1F1F1;">
<jsp:include page="./header.jsp"/>
<section class=" col-2 mt-2" style="text-align: end;" >
    <h1 class="fw-bold" style="font-family: inter; color:#757575;">Settings</h1>
</section>
<div class=" justify-content-center">
    <div class="row">
        <div class="col-2"></div>
        <section class=" col-8 m-0 mt-2 mb-2 d-flex flex-column justify-content-center  " tabindex="-1"
                 role="dialog"
                 id="modalSignin">
            <div class="container" style="background-color: white">
                <form:form method="post" action="${pageContext.request.contextPath}/evenement${partner.id}" class="row">
                    <sec:authorize access="isAuthenticated()">
                        <div class="mb-3 col-12 mt-5">
                            <label for="title" class="form-label">title</label>
                            <form:input class="form-control rounded-3 mt-3 w-75"  path="title" required="true"/>
                        </div>

                        <div class="mb-3 col-12 mt-3 ">
                            <label for="description" class="form-label">description</label>
                            <form:input class="form-control rounded-3 mt-3 w-75"  path="description" required="true"/>
                        </div>
                        <div class="mb-3 col-12 mt-3 ">
                            <label for="start">Start Date:</label>
                            <form:input class="form-control rounded-3 mt-3 w-75"  path="start" required="true"/>
                        </div>
                        <div class="mb-3 col-12 mt-3 ">
                            <label for="finish">Finish Date:</label>
                            <form:input class="form-control rounded-3 mt-3 w-75"  path="finish" required="true"/>
                        </div>
                        <div class="mb-3 col-12 mt-3 ">
                            <label for="address" class="form-label">Address</label>
                            <form:input class="form-control rounded-3 mt-3 w-75"  path="address" required="true"/>
                        </div>
                        <div class="col-12 row justify-content-center">
                            <div class="col-12 col-md-5 m-1 row align-item-center">
                                <a class=" mb-5 btn btn-lg rounded-3  mt-3" style=" background-color: #FFC900; color: white;"
                                   href="${pageContext.request.contextPath}/staticcalendar">Return to Calendar
                                </a>
                            </div>
                        </div>
                    </sec:authorize>
                </form:form>
            </div>
        </section>
        <div class="col-2"></div>
    </div>
</div>
<jsp:include page="./footer.jsp"/>
</body>
</html>