<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Creasy - Add Prospect</title>

    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
          crossorigin="anonymous">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


    <link rel="stylesheet" href="/css/customer/add.css"/>

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet">


    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
            crossorigin="anonymous"></script>


</head>
<body class="d-flex flex-column justify-content-between vh-100">

<div>
    <%--header--%>
    <jsp:include page="../header.jsp"/>
    <%----------%>

    <div class="fluid-container col-12 justify-content-center">

        <%-----Title block-----%>
        <div class="ms-md-4 me-md-5 d-flex flex-column flex-md-row align-items-center justify-content-center justify-content-md-between">

            <h1 class="mt-3 fw-bold ms-md-5 align-self-center">Add Customer :</h1>

            <a class="btn mt-3 btn-secondary shadow-sm align-self-center border-0 ps-3 pe-3"
               href="${pageContext.request.contextPath}/partners/all-customers">Back to customer list</a>

        </div>
        <%----------------------------%>

        <div class="col row m-5 p-3">

            <form class="col-12 " action="${pageContext.request.contextPath}/partners/add-customer" method="POST"
                  enctype="multipart/form-data">

                <div class="d-flex flex-column flex-md-row justify-content-between">

                    <%-----Block on the left-----%>
                    <div class="col col-md-5 p-5 bg-white">

                        <div class="mb-3">
                            <label for="firstname-p" class="form-label">FIRST NAME</label>
                            <input id="firstname-p" name="firstname" type="text" class="form-control"
                                   placeholder="John">
                        </div>

                        <div class="mb-3">
                            <label for="lastname-p" class="form-label">LAST NAME</label>
                            <input id="lastname-p" name="lastname" type="text" class="form-control"
                                   placeholder="Smith">
                        </div>

                        <div class="mb-3">
                            <label class="form-label" for="company">COMPANY</label>
                            <select class="form-select" aria-label=".form-select" id="company" required name="company">
                                <option disabled selected>Choose...</option>
                                <c:forEach items="${companies}" var="company">
                                    <option value="${company.id}">${company.name}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="mb-3">
                            <label for="positionHeld-p" class="form-label">POSITION HELD IN COMPANY</label>
                            <input id="positionHeld-p" name="positionHeld" type="text" class="form-control" placeholder="ex : employee">
                        </div>


                    </div>
                    <%----------------------------%>

                    <%-----Block on the right-----%>
                    <div class="col col-md-5 p-5 bg-white">

                        <div class="mb-3">
                            <label for="fixedPhoneNumber-p" class="form-label">FIX PHONE NUMBER</label>
                            <input id="fixedPhoneNumber-p" name="fixedPhoneNumber" type="text" class="form-control"
                                   pattern="[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}"
                                   placeholder="ex : 0212345678">
                        </div>

                        <div class="mb-3">
                            <label for="mobilePhoneNumber-p" class="form-label">MOBILE PHONE NUMBER</label>
                            <input id="mobilePhoneNumber-p" name="mobilePhoneNumber" type="text" class="form-control"
                                   placeholder="ex : 0698765432">
                        </div>

                        <div class="mb-3">
                            <label for="email-p" class="form-label">EMAIL</label>
                            <input id="email-p" name="email" type="text" class="form-control"
                                   placeholder="ex : example@example.com">
                        </div>

                        <div class="mb-3">
                            <label for="pictureFile-p" class="form-label">PHOTO</label>
                            <div>
                                <label for="pictureFile-p" class="btn btn-secondary shadow-sm border-0 ps-3 pe-3">Choose
                                    file</label>
                                <input id="pictureFile-p" type="file" name="pictureFile" class="form-control">
                            </div>
                        </div>


                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <div class="d-flex justify-content-center">
                            <button type="submit"
                                    class="btn btn-primary shadow-sm align-self-center border-0 ps-3 pe-3">Add
                            </button>
                        </div>

                    </div>
                    <%----------------------------%>
                </div>
            </form>

        </div>

    </div>
    <%--back to top button--%>
    <jsp:include page="../backToTopButton.jsp"/>
    <%----------%>
</div>
<%--footer--%>
<jsp:include page="../footer.jsp"/>
<%----------%>

<%--back to top button script--%>
<script src="/js/BackToTopButton.js"></script>
<%----------%>

<script src="/js/currentPage.js"></script>
</body>
</html>