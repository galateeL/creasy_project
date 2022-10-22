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
        <title>CREASY | Prospect list</title>
    </head>
    <body>
    <main>

        <header>
            <jsp:include page="../header.jsp"/>
        </header>

        <h1>Prospect List</h1>

        <div class="container">
            <div class="row">


                <div class="col-sm-6">





        <a href="${pageContext.request.contextPath}/partners/add-prospect" class="btn"
           style="background-color: #8109CB; color:white ">Add prospect</a>


        <form class="d-flex" method="GET" action="${pageContext.request.contextPath}/partners/all-prospects">
            <input class="form-control me-2" type="text" placeholder="Search customer" name="keywordProspect" value="${keywordProspect}" id="keywordProspect">

            <input type="radio" id="AZ" name="sort" value="AZ">
            <label for="AZ">AZ</label><br>

            <input type="radio" id="ZA" name="sort" value="ZA">
            <label for="ZA">ZA</label><br>

            <input type="radio" id="ON" name="sort" value="ON">
            <label for="ON">ON</label><br><br>

            <input type="radio" id="NO" name="sort" value="NO">
            <label for="NO">NO</label><br><br>

            <input type="radio" id="NOT_STARTED" name="state" value="NOT_STARTED">
            <label for="NOT_STARTED">Not started</label><br>

            <input type="radio" id="IN_PROGRESS" name="state" value="IN_PROGRESS">
            <label for="IN_PROGRESS">In progress</label><br><br>

            <input type="radio" id="TO_FOLLOW_UP" name="state" value="TO_FOLLOW_UP">
            <label for="TO_FOLLOW_UP">To follow up</label><br><br>

            <button class="btn btn" type="submit" style="background-color: white;color:gray">Search</button>
        </form>

                </div>

                <div class="col-sm-6">


        <c:forEach items="${prospects}" var="prospect">
            <p>${prospect.firstname}</p>
            <p>${prospect.lastname}</p>
            <p>${prospect.company.name}</p>
            <a href="${pageContext.request.contextPath}/partners/details-prospect/${prospect.id}" class="btn"
               style="background-color: #05516b; color:white ">Detail</a>
        </c:forEach>
                </div>
            </div>
        </div>

    </main>

    </body>
</html>