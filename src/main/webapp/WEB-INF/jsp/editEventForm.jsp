<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

    <link rel="icon" type="image/x-icon" href="/img/circleLogo.png">

    <title>CREASY | Edit Event</title>
</head>
<body>


<header>
    <jsp:include page="./header.jsp"/>
</header>

<h1>Edit Note</h1>

<div class="row">

    <form action="${pageContext.request.contextPath}/partners/edit-event/${note.id}" method="post">

        <div>
            <label for="note" class="form-label">Note</label>
            <input id="note" type="text" class="form-control" name="exchange"
                   value="${note.exchange}">
        </div>

        <c:choose>
            <c:when test="${partner.stateProspect == StateProspect.ENDED}">
                <a href="${pageContext.request.contextPath}/partners/details-customer/${partner.id}" type="button" class="btn btn-secondary">Abandon</a>
            </c:when>
            <c:otherwise>
                <a href="${pageContext.request.contextPath}/partners/details-prospect/${partner.id}" type="button" class="btn btn-secondary">Abandon</a>
            </c:otherwise>
        </c:choose>


        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-primary">Save</button>
    </form>

</div>



</body>
</html>