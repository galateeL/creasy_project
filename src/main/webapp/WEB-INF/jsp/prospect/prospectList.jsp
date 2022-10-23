<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>

    <title>CREASY | Prospect list</title>

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
<main>

    <header>
        <jsp:include page="../header.jsp"/>
    </header>


    <div class="fluid-container col-12 justify-content-center">

        <h1 class="mt-3 fw-bold text-center text-md-start ms-md-5">Prospects</h1>

        <div class="mt-4 ms-md-5 d-flex flex-column flex-md-row align-items-center justify-content-center justify-content-md-start m-5">
            <%--Add prospect button--%>
            <a href="${pageContext.request.contextPath}/partners/add-prospect" class="btn"
               style="background-color: #8109CB; color:white ">Add prospect</a>
            <%---------%>
        </div>

            <form class="d-flex align-items-center m-5" method="GET" action="${pageContext.request.contextPath}/partners/all-prospects">
                <%--                        Search prospect--%>
                <div class="mt-4 ms-md-5 d-flex flex-column flex-md-row align-items-center justify-content-center justify-content-md-start">

                    <input class="form-control me-2" type="text" placeholder="Search customer" name="keywordProspect"
                           value="${keywordProspect}" id="keywordProspect">
                </div>

                <div class="mt-4 ms-md-5 d-flex flex-column flex-md-row align-items-center justify-content-center justify-content-md-start">

                    <div class="form-check me-5">
                        <input class="form-check-input" type="radio" name="sort" id="AZ" value="AZ">
                        <label class="form-check-label text-secondary" for="AZ">
                            A-Z
                        </label>
                    </div>

                    <div class="form-check me-5">
                        <input class="form-check-input" type="radio" name="sort" id="ZA" value="ZA">
                        <label class="form-check-label text-secondary" for="ZA">
                            Z-A
                        </label>
                    </div>

                    <div class="form-check me-5">
                        <input class="form-check-input" type="radio" name="sort" id="ON" value="ON">
                        <label class="form-check-label text-secondary" for="ON">
                            Oldest to newest
                        </label>
                    </div>

                    <div class="form-check me-5">
                        <input class="form-check-input" type="radio" name="sort" id="NO" value="ON">
                        <label class="form-check-label text-secondary" for="NO">
                            Newest to oldest
                        </label>
                    </div>
<%--                    <div class="form-check me-5">--%>
<%--                                            <input class="form-check-input" type="radio" id="AZ" name="sort" value="AZ">--%>
<%--                                            <label for="AZ">A-Z</label><br>--%>
<%--                                    </div>--%>

<%--                    <div class="form-check me-5">--%>
<%--                                            <input class="form-check-input" type="radio" id="ZA" name="sort" value="ZA">--%>
<%--                                            <label for="ZA">Z-A</label><br>--%>
<%--                    </div>--%>
<%--                                            <input type="radio" id="ON" name="sort" value="ON">--%>
<%--                                            <label for="ON">Oldest to newest</label><br><br>--%>

<%--                                            <input type="radio" id="NO" name="sort" value="NO">--%>
<%--                                            <label for="NO">Newest to oldest</label><br><br>--%>


                    <%--                        <input type="radio" id="NOT_STARTED" name="state" value="NOT_STARTED">--%>
                    <%--                        <label for="NOT_STARTED">Not started</label><br>--%>

                    <%--                        <input type="radio" id="IN_PROGRESS" name="state" value="IN_PROGRESS">--%>
                    <%--                        <label for="IN_PROGRESS">In progress</label><br><br>--%>

                    <%--                        <input type="radio" id="TO_FOLLOW_UP" name="state" value="TO_FOLLOW_UP">--%>
                    <%--                        <label for="TO_FOLLOW_UP">To follow up</label><br><br>--%>

                    <div class="form-check me-5">
                        <input class="form-check-input" type="radio" name="sort" id="NOT_STARTED" value="NOT_STARTED">
                        <label class="form-check-label text-secondary" for="NOT_STARTED">
                            Not started
                        </label>
                    </div>

                    <div class="form-check me-5">
                        <input class="form-check-input" type="radio" name="sort" id="IN_PROGRESS" value="IN_PROGRESS">
                        <label class="form-check-label text-secondary" for="IN_PROGRESS">
                            In progress
                        </label>
                    </div>

                    <div class="form-check me-5">
                        <input class="form-check-input" type="radio" name="sort" id="TO_FOLLOW_UP" value="TO_FOLLOW_UP">
                        <label class="form-check-label text-secondary" for="TO_FOLLOW_UP">
                            To follow up
                        </label>
                    </div>

                    <button class="btn btn" type="submit" style="background-color: white;color:gray"><img src="https://i.postimg.cc/KcMNKkn1/Capture.jpg" alt="validate logo" width="70px"/></button>

<%--                </div>--%>
            </form>
        </div>



        <%--Card for each companies--%>
        <div class="col row m-5 p-3">
            <c:forEach items="${prospects}" var="prospect">
                <div class="col-lg-6 col-12 mt-4">
                    <div class="card h-100 border-0">
                        <div class="card-body d-md-flex justify-content-between overflow-auto">
                            <div class="align-items-start">
                                <h5 class="card-title fw-bold text-break">${prospect.lastname} ${prospect.firstname} </h5>
                                <p class="card-text">${prospect.company.name}</p>
                            </div>
                            <a class="btn align-self-center ms-md-2 mt-3 mt-md-0 ps-3 pe-3"
                               href="${pageContext.request.contextPath}/partners/details-prospect/${prospect.id}">Details</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <%---------%>



    </div>
</main>

</body>
</html>