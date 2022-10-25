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

    <link rel="stylesheet" href="/css/editNote.css"/>
    <link rel="icon" type="image/x-icon" href="/img/circleLogo.png">

    <title>CREASY | Edit Note</title>
</head>
<body class="d-flex flex-column justify-content-between vh-100">


<div>
    <%--header--%>
    <jsp:include page="./header.jsp"/>
    <%----------%>

        <div class="container justify-content-center">
        <div class="col-12 mt-5 text-center justify-content-center align-items-center">

    <form action="${pageContext.request.contextPath}/partners/edit-note/${note.id}" method="post">
        <h1>Edit Note</h1>
        <div>
            <textarea id="note" type="text" class="form-control my-4" name="exchange" rows="6"
                      >${note.exchange}</textarea>
        </div>

        <c:choose>
            <c:when test="${partner.stateProspect == StateProspect.ENDED}">
                <a href="${pageContext.request.contextPath}/partners/details-customer/${partner.id}" type="button" class="btn btn-secondary ps-3 pe-3">Abandon</a>
            </c:when>
            <c:otherwise>
                <a href="${pageContext.request.contextPath}/partners/details-prospect/${partner.id}" type="button" class="btn btn-secondary ps-3 pe-3">Abandon</a>
            </c:otherwise>
        </c:choose>


        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-primary ps-3 pe-3">Save</button>
    </form>
        </div>
</div>
</div>

<%--footer--%>
<jsp:include page="./footer.jsp"/>
<%----------%>

</body>
</html>