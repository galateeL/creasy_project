<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Creasy - ${company.name}</title>

    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
          crossorigin="anonymous">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


    <link rel="stylesheet" href="/css/company/details.css"/>

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

            <h1 class="mt-3 fw-bold ms-md-5 align-self-center">Company details</h1>

            <a class="btn mt-3 btn-secondary shadow-sm align-self-center border-0 ps-3 pe-3"
               href="${pageContext.request.contextPath}/companies/list">Back to company list</a>

        </div>
        <%----------------------------%>

        <div class="col row m-5 p-3">
            <div class="headBar col-12 d-md-flex justify-content-md-between bg-white mb-5 pt-md-3 pb-md-3">

                <div class="d-md-flex text-center text-md-start">
                    <img class="imgLogoC img-fluid ms-md-2 me-md-2 border" src="${company.logo}">
                    <div>
                        <h5 class="comp-name ms-md-2">${company.name}</h5>
                        <a class="ms-md-2 text-decoration-none link-dark" href="${company.webSite}" target="_blank"
                           rel="noopener noreferrer">${company.webSite}</a>
                    </div>
                </div>

                <div class="d-flex flex-column flex-md-row text-center  align-self-center ">
                    <a class="fa fa-phone fa-3x me-md-2 text-decoration-none" aria-hidden="true"
                       href="tel:${company.phoneNumberFixr}"></a>

                    <a class="fa fa-envelope-o fa-3x mt-4 mt-md-0 ms-md-4 me-md-2 text-decoration-none"
                       aria-hidden="true" href="mailto: ${company.email}"></a>

                    <a class="fa fa-map-marker fa-3x mt-4 mb-4 mt-md-0 mb-md-0 ms-md-4 me-md-5 text-decoration-none"
                       aria-hidden="true" href="http://maps.google.com?q=${company.latitude},${company.longitude}"
                       target="_blank" rel="noopener noreferrer"></a>

                    <a class="btn btn-primary shadow-sm align-self-center border-0 ps-3 pe-3 me-md-3 mb-md-0 mb-4"
                       href="${pageContext.request.contextPath}/companies/edit/${company.id}">Edit</a>
                </div>

            </div>
        </div>


        <div class="col row m-5 p-3">

            <div class="d-flex flex-column flex-md-row justify-content-between">

                <%-----Block on the left-----%>
                <div class="col col-md-7 p-4 bg-white mb-5">

                    <div class="mb-3">
                        <label class="form-label p-2">SECTOR OF ACTIVITY</label>
                        <div class="comp-inf fw-bold">${company.activityArea}</div>
                    </div>

                    <div class="mb-3">
                        <label class="form-label p-2">SIRET</label>
                        <div class="comp-inf fw-bold">${company.siret}</div>
                    </div>

                    <div class="mb-3">
                        <label class="form-label p-2">ADDRESS</label>
                        <div class="comp-inf fw-bold">${company.address}</div>
                    </div>

                    <div class="mb-3">
                        <label class="form-label p-2">POSTAL CODE</label>
                        <div class="comp-inf fw-bold">${company.postalCode}</div>
                    </div>

                    <div class="mb-3">
                        <label class="form-label p-2">CITY</label>
                        <div class="comp-inf fw-bold">${company.city}</div>
                    </div>

                    <div class="mb-3">
                        <label class="form-label p-2">DATE OF CREATION</label>
                        <div class="comp-inf fw-bold">${company.creationDate}</div>
                    </div>

                </div>
                <%----------------------------%>

                <%-----Block on the right-----%>
                <div class="col col-md-4 p-4 mt-5 mt-md-0 bg-white mb-5">

                    <div class="mb-3">
                        <label class="form-label p-2">CLIENTS AND PROSPECTS</label>
                        <div>
                            <c:forEach items="${partner}" var="partner">
                            <h5 class="part-info fw-bold text-break">${partner.lastname} ${partner.firstname}</h5>
                        </div>
                    </div>
                    </c:forEach>
                </div>
            </div>

        </div>
        <%----------------------------%>
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