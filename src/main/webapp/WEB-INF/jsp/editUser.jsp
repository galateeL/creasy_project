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

    <style>
        @import url('https://fonts.googleapis.com/css2?family=Pacifico&display=swap');
    </style>

    <title>Document</title>
</head>
<body class="container-fluid d-flex flex-row p-0" style="height: 100%; background-color:
#C3C3C3;">

<section class=" col-4 " style="text-align: end;" >
    <h1 class="" style="font-family: Pacifico; color:#757575;">Settings</h1>
</section>
<section class=" col-8 col-md-4 m-0 d-flex flex-column justify-content-center " tabindex="-1" role="dialog"
         id="modalSignin">

    <div class="container" style="background-color: white">
        <form:form method="post" action="${pageContext.request.contextPath}/edit" class="row">
            <form:input path="id" type="number" name="id" id="id" class="form-control" hidden="true" />
                <div class="mb-3 col-12 mt-4">
                    <label for="pictureUrl" style="color: #C3C3C3;">AVATAR</label>
                    <form:input type="text" class="form-control rounded-3 mt-3 w-75" path="pictureUrl"/>
                </div>
                <div class="mb-3 col-12 mt-5">
                    <label for="email" style="color: #FFC900;">EMAIL</label>
                    <form:input class="form-control rounded-3 mt-3 w-75"  path="email" required="true"/>
                </div>

                <div class="mb-3 col-12 mt-3 ">
                    <label for="firstName" style="color: #FFC900;" >FIRST NAME</label>
                    <form:input type="text" class="form-control rounded-3 mt-3 w-75 " path="firstName"/>
                </div>
                <div class="mb-3 col-12 mt-3 ">
                    <label for="lastName" style="color: #FFC900;" >LAST NAME</label>
                    <form:input type="text" class="form-control rounded-3 mt-3 w-75" path="lastName"/>
                </div>
            <div class="mb-3 col-12 mt-3 ">
                <label for="lastName" style="color: #FFC900;" >PASSWORD</label>
                <form:input type="password" class="form-control rounded-3 mt-3 w-75" path="password"/>
            </div>
                <div class="col-12 col-md-2"></div>
                <div class="col-12 col-md-3">
                    <button class=" mb-5 btn btn-lg rounded-3  mt-3" style=" background-color: #FFC900; color:
                    white;" value="Save"type="submit">Edit
                    </button>
                </div>
                <!--<div class="col-12 col-md-7 ">
                    <button class=" mb-5 btn btn-lg rounded-3 mt-3" style=" background-color: #F7526A; color: white;"
                            value="Save"type="submit">Delete my account
                    </button>-->
                </div>
        </form:form>
    </div>
</section>
</body>
</html>