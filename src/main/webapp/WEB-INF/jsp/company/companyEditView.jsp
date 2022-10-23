<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Creasy - Edit ${company.name}</title>

    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
          crossorigin="anonymous">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


    <link rel="stylesheet" href="/css/company/edit.css"/>

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

            <h1 class="mt-3 fw-bold ms-md-5 align-self-center">Edit company : ${company.name} </h1>

            <a class="btn mt-3 btn-secondary shadow-sm align-self-center border-0 ps-3 pe-3"
               href="${pageContext.request.contextPath}/companies/list">Back to company list</a>

        </div>
        <%----------------------------%>

        <div class="col row m-5 p-3">

            <form class="col-12 " action="${pageContext.request.contextPath}/companies/edit/${company.id}" method="POST"
                  enctype="multipart/form-data">

                <div class="d-flex flex-column flex-md-row justify-content-between">

                    <%-----Block on the left-----%>
                    <div class="col col-md-5 p-5 bg-white">
                        <div class="mb-3">
                            <label for="name" class="form-label">COMPANY NAME</label>
                            <input id="name" name="name" type="text" class="form-control"
                                   value="${company.name}">
                        </div>

                        <div class="mb-3">
                            <label for="activityArea" class="form-label">SECTOR OF ACTIVITY</label>
                            <input id="activityArea" name="activityArea" type="text" class="form-control"
                                   value="${company.activityArea}">
                        </div>

                        <div class="mb-3">
                            <label for="webSite" class="form-label">WEB SITE</label>
                            <input id="webSite" name="webSite" type="text" class="form-control"
                                   value="${company.webSite}">
                        </div>

                        <div class="mb-3">
                            <label for="siret" class="form-label">SIRET</label>
                            <input id="siret" name="siret" type="text" class="form-control"
                                   pattern="[0-9]{3}[0-9]{3}[0-9]{3}[0-9]{5}"
                                   value="${company.siret}">
                        </div>

                        <div class="mb-3">
                            <label for="creationDate" class="form-label">DATE OF CREATION</label>
                            <input id="creationDate" name="creationDate" type="date" class="form-control"
                                   value="${company.creationDate}">
                        </div>

                        <div class="mb-3">
                            <label for="logoFile" class="form-label">LOGO</label>
                            <div>
                                <label for="logoFile" class="btn btn-secondary shadow-sm border-0 ps-3 pe-3">Choose
                                    file</label>
                                <input id="logoFile" type="file" name="logoFile" class="form-control">
                            </div>
                        </div>
                    </div>
                    <%----------------------------%>

                    <%-----Block on the right-----%>
                    <div class="col col-md-5 p-5 bg-white">

                        <div class="mb-3">
                            <label for="address" class="form-label">ADDRESS</label>
                            <input id="address" name="address" type="text" class="form-control"
                                   value="${company.address}">
                        </div>

                        <div class="mb-3">
                            <label for="postalCode" class="form-label">POSTAL CODE</label>
                            <input id="postalCode" name="postalCode" type="text" class="form-control"
                                   value="${company.postalCode}">
                        </div>

                        <div class="mb-3">
                            <label for="city" class="form-label">CITY</label>
                            <input id="city" name="city" type="text" class="form-control" value="${company.city}">
                        </div>

                        <div class="d-md-flex justify-content-between">
                            <div class="mb-3">
                                <label for="latitude" class="form-label">LATITUDE</label>
                                <input id="latitude" name="latitude" type="text" class="form-control"
                                       value="${company.latitude}">
                            </div>

                            <div class="mb-3">
                                <label for="longitude" class="form-label">LONGITUDE</label>
                                <input id="longitude" name="longitude" type="text" class="form-control"
                                       value="${company.longitude}">
                            </div>

                        </div>

                        <div class="mb-3">
                            <label for="phoneNumberFixr" class="form-label">PHONE NUMBER</label>
                            <input id="phoneNumberFixr" name="phoneNumberFixr" type="tel" class="form-control"
                                   pattern="[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}"
                                   value="${company.phoneNumberFixr}">
                        </div>

                        <div class="mb-3">
                            <label for="email" class="form-label">EMAIL</label>
                            <input id="email" name="email" type="text" class="form-control"
                                   value="${company.email}">
                        </div>


                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <div class="d-flex justify-content-center">
                            <button type="submit"
                                    class="btn btn-primary shadow-sm align-self-center border-0 ps-3 pe-3">Validate
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
</body>
</html>