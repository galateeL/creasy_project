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
<body class="container-fluid d-flex flex-row p-0" style="height: 100%;" >

<section class=" text-center d-flex flex-column justify-content-center align-middle col-2 " style="background-color:
#757575;">
    <h1 class="text-align-center" style="font-family: Pacifico; color:white; vertical-align: middle;">Ease your customer management !</h1>
</section>
<section class="col-8 m-0" tabindex="-1" role="dialog" id="modalSignin">

    <div class="d-flex justify-content-center">
                <form:form method="post" enctype="multipart/form-data"
                           action="${pageContext.request.contextPath}/signup"
                           modelAttribute="createUser" class="row">
                    <form:input path="id" type="number" name="id" id="id" class="form-control" hidden="true" />
                    <div class="col-12 d-flex flex-column align-items-center mt-5">
                        <img src="https://i.postimg.cc/jSTDLtq3/logo-creasy.png" alt="Logo">
                        <h1 >Welcome</h1>
                        <p style="color: #C3C3C3;">Create your account to continue</p>
                    </div>
                    <div class="mb-3 mt-3 col-12 d-flex flex-column align-items-center  ">
                        <label for="pictureUrl" style="color: #C3C3C3;">AVATAR</label>
                        <form:input type="file" id="text2"
                                    style="display:none"  class="form-control rounded-3 mt-2 w-50" path="pictureFile"/>
                        <form:input id="text" style="display:block"  type="text"
                                    class="form-control rounded-3 mt-2 w-50" path="pictureUrl"/>
                    </div>
                    <div class="form-check form-switch">
                        <input class="form-check-input" type="checkbox" role="switch" id="flexSwitchCheckDefault"
                               onclick="myFunction()">
                        <label class="form-check-label" for="flexSwitchCheckDefault">Default switch checkbox input</label>
                    </div>
                    <div class="mb-3 col-12 col-md-6 d-flex flex-column align-items-center  ">
                        <label for="firstName" style="color: #C3C3C3;">FIRST NAME</label>
                        <form:input type="text" class="form-control rounded-3 mt-2 w-50 " path="firstName"/>
                    </div>

                    <div class="mb-3 col-12 col-md-6 d-flex flex-column align-items-center">
                        <label for="email" style="color: #C3C3C3;">EMAIL</label>
                        <form:input class="form-control rounded-3 mt-2 w-50"  path="email" required="true"/>
                        <form:errors path="email" cssStyle="color: #ff0008;"/>

                    </div>

                    <div class="mb-3 col-12 col-md-6 d-flex flex-column align-items-center  ">
                        <label for="lastName" style="color: #C3C3C3;">LAST NAME</label>
                        <form:input type="text" class="form-control rounded-3 mt-2 w-50" path="lastName"/>
                    </div>
                    <div class="mb-3 col-12 col-md-6 d-flex flex-column align-items-center">
                        <label for="password" style="color: #C3C3C3;" >PASSWORD</label>
                        <form:input type="password" class="form-control rounded-3 mt-2 w-50" path="password"
                                    required="true"/>
                        <form:errors path="password" cssStyle="color: #ff0008;"/>

                    </div>
                    <div class="col-12 d-flex flex-column align-items-center">
                    <button class=" mb-2 btn btn-lg rounded-3 mt-3"
                            style=" background-color: #3AE1B1; color: white;" value="Save"type="submit">Create my
                        account
                    </button>
                    <small class="text-muted mt-3">By clicking Sign up, you agree to the terms of use. if you are
                        already register <a
                            href="${pageContext.request.contextPath}/signin">click here</a></small>
                    </div>
                </form:form>
    </div>
</section>

<script>
    function myFunction() {
        // Get the checkbox
        let checkBox = document.getElementById("flexSwitchCheckDefault");
        // Get the output text
        let text = document.getElementById("text");
        let text2 = document.getElementById("text2");

        // If the checkbox is checked, display the output text
        if (checkBox.checked == true){
            text.style.display = "none";
            text2.style.display = "block";
        } else {
            text.style.display = "block";
            text2.style.display = "none";
        }
    }
</script>
</body>
</html>