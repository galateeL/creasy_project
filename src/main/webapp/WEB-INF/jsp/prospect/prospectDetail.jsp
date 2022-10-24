<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

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
    <title>CREASY | Prospect detail</title>
</head>
<body>
<main>

    <header>
        <jsp:include page="../header.jsp"/>
    </header>

    <h1>Prospect detail</h1>

    <p>${partner.firstname}</p>
    <p>${partner.lastname}</p>
    <p>${partner.company.name}</p>



<%--    Add dunning period--%>

    <form action="${pageContext.request.contextPath}/partners/${partner.id}/add-dunning-period" method="post">

        <div class="mb-2">
            <label for="dunningPeriod" class="form-label">Deadlines before dunning</label>
            <input type="number" class="form-control" id="dunningPeriod" name="dunningPeriod" placeholder="ex : 6 days">
        </div>

        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button type="submit" class="btn" style="background: #ff5630; color: white">Add dunning period
        </button>
    </form>

<%--          --%>






    <c:forEach items="${notes}" var="note">
        <p>${note.registerDate}</p>
        <p>${note.exchange}</p>

        <%--        Edit note--%>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <a href="${pageContext.request.contextPath}/partners/edit-note/${note.id}" class="btn btn-primary">Edit note</a>


        <%--        Delete note--%>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <a href="${pageContext.request.contextPath}/partners/delete-note/${note.id}" class="btn btn-primary">Delete
            note</a>

    </c:forEach>

    <jsp:include page="./deleteProspectModal.jsp"/>

    <!-- Button trigger modal -->
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
        Delete
    </button>


    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <a href="${pageContext.request.contextPath}/partners/edit-prospect/${partner.id}" class="btn btn-primary">Edit</a>

    <jsp:include page="../addNoteModal.jsp"/>

    <!-- Button trigger modal -->
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#noteModal">
        New note
    </button>

    <jsp:include page="../addEventModal.jsp"/>
    <!-- Button trigger modal -->
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#eventModal">
        New note
    </button>


</main>

</body>
</html>