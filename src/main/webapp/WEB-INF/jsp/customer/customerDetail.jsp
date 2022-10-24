<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Creasy - Prospect Details</title>

    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
          crossorigin="anonymous">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


    <link rel="stylesheet" href="/css/customer/details.css"/>

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

            <h1 class="mt-3 fw-bold ms-md-5 align-self-center">Prospect details</h1>

            <a class="btn mt-3 btn-secondary shadow-sm align-self-center border-0 ps-3 pe-3"
               href="${pageContext.request.contextPath}/partners/all-customers">Back to customer list</a>

        </div>
        <%----------------------------%>

        <div class="col row m-5 p-3">
            <div class="headBar col-12 d-md-flex justify-content-md-between bg-white mb-5 pt-md-3 pb-md-3">

                <div class="d-md-flex text-center text-md-start">
                    <img class="imgPicture img-fluid ms-md-2 me-md-2 border" src="${partner.pictureUrl}">
                    <div>
                        <h5 class="pros-name ms-md-2">${partner.lastname} ${partner.firstname}</h5>
                        <a class="ms-md-2 text-decoration-none link-dark"
                           href="mailto: ${partner.email}">${partner.email}</a>
                    </div>
                </div>

                <div class="d-flex flex-column flex-md-row text-center  align-self-center ">
                    <jsp:include page="../addEventModal.jsp"/>
                    <!-- Button trigger modal -->
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <button type="button"
                            class="btn btn-secondary shadow-sm align-self-center border-0 ps-3 pe-3 me-md-3 mb-md-0 mb-4"
                            data-bs-toggle="modal" data-bs-target="#eventModal">
                        Book an event
                    </button>

                    <jsp:include page="./deleteCustomerModal.jsp"/>

                    <!-- Button trigger modal -->
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <button type="button"
                            class="btn btn-danger shadow-sm align-self-center border-0 ps-3 pe-3 me-md-3 mb-md-0 mb-4"
                            data-bs-toggle="modal" data-bs-target="#exampleModal">
                        Delete
                    </button>


                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <a href="${pageContext.request.contextPath}/partners/edit-prospect/${partner.id}"
                       class="btn btn-primary shadow-sm align-self-center border-0 ps-3 pe-3 me-md-3 mb-md-0 mb-4">Edit</a>

                </div>

            </div>
        </div>


        <div class="col row m-5 p-3">

            <div class="d-flex flex-column flex-md-row justify-content-center">

                <%-----Block on the left-----%>
                <div class="col-12 p-4 bg-white mb-5">

                    <div class="row row-cols-3 d-flex flex-column flex-md-row">

                        <div class="mb-3 col">
                            <label class="form-label p-2 px-5 ">MOBILE PHONE NUMBER</label>
                            <div class="comp-inf fw-bold text-nowrap">${partner.mobilePhoneNumber}</div>
                        </div>

                        <div class="mb-3 col">
                            <label class="form-label p-2 px-5 ">FIX PHONE NUMBER</label>
                            <div class="comp-inf fw-bold text-nowrap">${partner.fixedPhoneNumber}</div>
                        </div>

                        <div class="mb-3 col text-nowrap"></div>

                        <div class="mb-3 col">
                            <label class="form-label p-2 px-5 ">COMPANY</label>
                            <div class="comp-inf fw-bold text-nowrap">${partner.company.name}</div>
                        </div>

                        <div class="mb-3 col">
                            <label class="form-label p-2 px-5 ">POSITION HELD</label>
                            <div class="comp-inf fw-bold text-nowrap text-break">${partner.positionHeld}</div>
                        </div>

                        <div class="mb-3 col">
                            <label class="form-label p-2 px-5">STATE OF PROGRESS</label>
                            <div class="comp-inf fw-bold text-nowrap">${partner.stateProspect}</div>
                        </div>
                    </div>

                    <hr>
                    <!-- Button trigger modal -->
                    <jsp:include page="../addNoteModal.jsp"/>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <button type="button" class="btn btn-validate mb-3" data-bs-toggle="modal" data-bs-target="#noteModal">
                        New note
                    </button>

                    <c:forEach items="${notes}" var="note">
                        <div class="card border">
                            <div class="card-body">
                                <div class="align-items-start">
                                    <p class="date text-break">${note.registerDate}</p>
                                    <p class="card-text text-break" >${note.exchange}</p>
                                </div>
                            </div>
                        </div>

                        <%--        Edit note--%>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <a href="${pageContext.request.contextPath}/partners/edit-note/${note.id}" class="btn btn-primary my-2 my-md-3 mb-md-5">Edit note</a>


                        <%--        Delete note--%>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <a href="${pageContext.request.contextPath}/partners/delete-note/${note.id}" class="btn btn-danger my-md-3 mb-5 mb-md-5">Delete
                            note</a>

                    </c:forEach>

                </div>
                <%----------------------------%>
            </div>
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