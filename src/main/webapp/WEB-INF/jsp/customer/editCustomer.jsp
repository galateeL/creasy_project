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
    <title>CREASY | Edit customer</title>
</head>
<body>
<main>

    <h1>Edit customer</h1>

    <form action="${pageContext.request.contextPath}/partners/edit-customer/${customer.id}" method="post">

        <div class="mb-2">
            <label for="firstname-p" class="form-label">First Name</label>
            <input type="text" class="form-control" id="firstname-p" name="firstname" value="${customer.firstname}">
        </div>

        <div class="mb-2">
            <label for="lastname-p" class="form-label">Last Name</label>
            <input id="lastname-p" type="text" class="form-control" name="lastname" value="${customer.lastname}">
        </div>

        <div class="mb-2">
            <label for="email-p" class="form-label">Email</label>
            <input id="email-p" type="email" class="form-control" name="email" value="${customer.email}">
        </div>

        <div class="mb-2">
            <label for="pictureUrl-p" class="form-label">Photo</label>
            <input id="pictureUrl-p" type="text" class="form-control" name="pictureUrl" value="${customer.pictureUrl}">
        </div>

        <div class="mb-2">
            <label for="fixedPhoneNumber-p" class="form-label">Fix phone number</label>
            <input id="fixedPhoneNumber-p" type="text" class="form-control" name="fixedPhoneNumber" value="${customer.fixedPhoneNumber}">
        </div>

        <div class="mb-2">
            <label for="mobilePhoneNumber-p" class="form-label">Mobile phone number</label>
            <input id="mobilePhoneNumber-p" type="text" class="form-control" name="mobilePhoneNumber" value="${customer.mobilePhoneNumber}">
        </div>


        <div class="mb-2">
            <label for="positionHeld-p" class="form-label">Position held in company</label>
            <input id="positionHeld-p" type="text" class="form-control" name="positionHeld" value="${customer.positionHeld}">
        </div>



        <%--        <ul class="list-group list-group-horizontal m-3">--%>
        <%--            <c:forEach items="${companies}" var="company">--%>
        <%--                <li style="color: #ff5630; background-color: #ffffff" class="list-group-item m-3">--%>
        <%--                    <c:out value="${company.name}"/>--%>
        <%--                </li>--%>
        <%--            </c:forEach>--%>
        <%--        </ul>--%>


        <button type="submit" class="btn" style="background: #ff5630; color: white">Edit
        </button>
    </form>


</main>

</body>
</html>