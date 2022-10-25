<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
<body class="container-fluid d-flex flex-row p-0" style="min-height: 100%;" >

<section class=" text-center d-flex flex-column justify-content-center align-middle col-md-2  "
         style="background-color:
#757575;">
    <h1 class="text-align-center" style="font-family: Pacifico; color:white; vertical-align: middle;">Ease your customer management !</h1>
</section>

<section class="col-8 m-0" tabindex="-1" role="dialog" id="modalSignin">

    <div class="d-flex justify-content-center container">
        <form:form method="post" action="${pageContext.request.contextPath}/signin" class="row">

            <div class="col-12 d-flex flex-column align-items-center mt-5">
                <img src="https://i.postimg.cc/jSTDLtq3/logo-creasy.png" class="img-fluid" style="height:
                        200px;width: 300px; object-fit: scale-down" alt="Logo">
                <h1 >Welcome</h1>
                <p style="color: #C3C3C3;">Log in to your account to continue</p>
            </div>

            <div class="mb-3 col-12 d-flex flex-column align-items-center mt-3">
                <label for="email" style="color: #C3C3C3;">EMAIL</label>
                <form:input class="form-control rounded-3 mt-3 w-50" path="email"/>
            </div>

            <div class="mb-3 col-12 d-flex flex-column align-items-center mt-2">
                <label for="password" style="color: #C3C3C3;" >PASSWORD</label>
                <form:input type="password" class="form-control rounded-3 mt-3 w-50" path="password"/>
            </div>
            <div class="col-12 d-flex flex-column align-items-center">
                <button class=" mb-2 btn btn-lg rounded-3 mt-3" style=" background-color: #3AE1B1; color: white;"
                        value="Save"type="submit">login
                </button>
                <small class="text-muted mt-3">Don't have an account?<a
                        href="${pageContext.request.contextPath}/signup">
                    Sign_Up!</a></small>
            </div>
        </form:form>
    </div>
</section>
</body>
</html>