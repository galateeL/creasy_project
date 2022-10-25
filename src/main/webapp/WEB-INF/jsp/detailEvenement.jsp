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
<div class="row">
    <div class="col-3"></div>
    <div class="card border container col-6">
        <div class="card-body">
            <div class="d-flex justify-content-center">
                <p class="card-text text-break fw-bold" style="font-size: 25px;" >${event.partner.firstname}
                    ${event.partner.lastname}</p>
            </div>
            <div class="d-flex justify-content-center mt-2">
                <p class="date text-break">${event.start} - ${event.finish}</p>
            </div>
            <div class="d-flex justify-content-center">
                <p  style="font-size: 20px;" class="card-text text-break"
                >${event.title}</p>
            </div>
            <div class="d-flex justify-content-center">
                <p class="card-text text-break" >${event.description}</p>
            </div>
            <div class="d-flex justify-content-center mb-1">
                <p class="card-text text-break" >${event.address}</p>
            </div>
            <div class="d-flex mt-3 justify-content-center">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <a href="${pageContext.request.contextPath}/staticcalendar"
                   class="btn btn-primary  my-md-3 mb-2">Return to calendar</a>
            </div>

        </div>
    </div>
    <div class="col-3"></div>
</div>
<jsp:include page="./footer.jsp"/>
</body>
</html>