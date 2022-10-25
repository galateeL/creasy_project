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
<body class="d-flex flex-column justify-content-between vh-100" style="background-color:
#F1F1F1;">
<jsp:include page="./header.jsp"/>
<section class=" col-2 mt-2" style="text-align: end;" >
    <h1 class="fw-bold" style="font-family: inter; color:#757575;">Settings</h1>
</section>
<div class=" container">
    <div class="row">
        <c:if test="${list != 'true' }">
            <div class ="col-3">

            </div>
        </c:if>
        <section class=" col-12 col-md-6 m-0 mt-2 mb-2 d-flex flex-column justify-content-center  " tabindex="-1"
                 role="dialog"
                 id="modalSignin">
            <div class="container" style="background-color: white">
                <form:form method="post" action="${pageContext.request.contextPath}/signin" class="row">
                    <sec:authorize access="isAuthenticated()">
                        <div class="mb-3 col-8 mt-4">
                            <img src="<sec:authentication
                        property="principal.pictureUrl"/>" alt="Logo"
                                 style="height: 100px;width: 100px;border-radius: 50%; object-fit: cover;" class="mt-4">
                        </div>
                        <div class="mb-3 col-12 mt-5">
                            <label for="email" style="color: #FFC900;">EMAIL</label>
                            <h5 class="form-control rounded-3 mt-3 w-75" id="email" name="user"><sec:authentication
                                    property="name"/></h5>
                        </div>

                        <div class="mb-3 col-12 mt-3 ">
                            <label for="firstName" style="color: #FFC900;" >FIRST NAME</label>
                            <h5 class="form-control rounded-3 mt-3 w-75" id="firstName" name="user"><sec:authentication
                                    property="principal.firstName"/></h5>
                        </div>
                        <div class="mb-3 col-12 mt-3 ">
                            <label for="lastName" style="color: #FFC900;" >LAST NAME</label>
                            <h5 class="form-control rounded-3 mt-3 w-75" id="lastName" name="user"><sec:authentication
                                    property="principal.lastName"/></h5>
                        </div>
                        <div class="col-12 row justify-content-center">
                            <div class="col-12 col-md-5 m-1 row align-item-center">
                                <a class=" mb-5 btn btn-lg rounded-3  mt-3" style=" background-color: #FFC900; color: white;"
                                   href="${pageContext.request.contextPath}/edit/<sec:authentication
                        property='principal.username'/>">Edit my account
                                </a>
                            </div>
                            <c:if test="${list != 'true' }">
                                <div class="col-12 col-md-6 row  m-1 align-item-center ">
                                    <a href="${pageContext.request.contextPath}/delete/<sec:authentication
                        property='principal.username'/>" class=" mb-5 btn btn-lg rounded-3 mt-3" style=" background-color: #F7526A; color: white;"
                                       value="Save"type="submit">Delete my account
                                    </a>
                                </div>

                            </c:if>
                        </div>
                    </sec:authorize>
                </form:form>
            </div>
        </section>
        <c:if test="${list == 'true' }">
            <section class="col-12 col-md-6 mt-2 mb-2" >
                <c:forEach items="${users}" var="user">
                    <c:choose>
                        <c:when test="${user.admin == true}">
                        </c:when>
                        <c:otherwise>
                            <div class=" card " style="border: none; border-radius: 0px;">
                                <div class="card-body row">
                                    <div class="col-8">
                                        <h5 class="card-title">${user.firstName} ${user.lastName}</h5>
                                        <h6 class="card-subtitle text-muted">${user.email}</h6>
                                    </div>
                                    <div class="col-4">
                                        <a href="${pageContext.request.contextPath}/delete/user/${user.email}"
                                           class=" m-1 btn btn-lg rounded-3 w-100" style=" background-color: #F7526A;
                                       color: white;"
                                           value="Save"type="submit">Delete
                                        </a>
                                    </div>
                                    <div class=" row justify-content-center mt-5">
                                        <hr class="w-50">
                                    </div>
                                </div>
                            </div>

                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </section>
        </c:if>
    </div>
</div>
<jsp:include page="./footer.jsp"/>
</body>
<style>
    hr:last-of-type ~ hr {
        display: none;
    }
</style>
</html>