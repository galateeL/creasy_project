<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script src="http://cdnjs.cloudflare.com/ajax/libs/moment.js/2.9.0/moment.min.js"
            type="text/javascript"></script>
    <script src="http://cdn.jsdelivr.net/webjars/jquery/3.4.1/jquery.min.js"
            type="text/javascript"></script>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
          crossorigin="anonymous">


    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
            crossorigin="anonymous"></script>

    <link rel="stylesheet" href="/css/map.css"/>

    <link rel="icon" type="image/x-icon" href="/img/circleLogo.png">


    <title>CREASY | Map</title>
</head>
<body class="d-flex flex-column justify-content-between vh-100">

<div>
    <%--header--%>
    <jsp:include page="./header.jsp"/>
    <%----------%>

        <h1 class="mt-3 fw-bold text-center text-md-start ms-md-5">Locating customers :</h1>

        <div class="container-fluid">

            <div class="d-flex mt-5 justify-content-center">
                <div id="map_div"></div>
            </div>


        </div>


</div>

<%--footer--%>
<jsp:include page="./footer.jsp"/>
<%----------%>

<script src="/js/map.js"></script>
</body>


</html>