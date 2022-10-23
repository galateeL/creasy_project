<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap');
    </style>



    <title>CREASY</title>
</head>
<body>


<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid d-flex justify-content-evenly">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse " id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0 " style="font-family: 'Inter', sans-serif;">
                <li class="d-flex justify-content-center align-items-center me-2 px-4">
                    <a class="navbar-brand" href="#"><img src="https://i.postimg.cc/P5LLYgPf/logo-creasy-1.png" alt="creasy-logo"
                                                          style="width: 100px"/></a>
                </li >
                <li class="nav-item d-flex justify-content-center align-items-center px-4">
                    <a class="nav-link" aria-current="page" href="#">Dashboard</a>
                </li>
                <li class="nav-item d-flex justify-content-center align-items-center px-4">
                    <a class="nav-link" href="${pageContext.request.contextPath}/companies/list">Companies</a>
                </li>
                <li class="nav-item d-flex justify-content-center align-items-center px-4">
                    <a class="nav-link" href="${pageContext.request.contextPath}/partners/all-customers">Customers</a>
                </li>
                <li class="nav-item d-flex justify-content-center align-items-center px-4">
                    <a class="nav-link" href="${pageContext.request.contextPath}/partners/all-prospects">Prospects</a>
                </li>
                <li class="nav-item d-flex justify-content-center align-items-center px-4">
                    <a class="nav-link" href="${pageContext.request.contextPath}/staticcalendar">Calendar</a>
                </li>
                <li class="nav-item d-flex justify-content-center align-items-center px-4">
                    <a class="nav-link" href="#">Settings</a>
                </li>
                <li class="nav-item d-flex justify-content-center align-items-center px-4">
                    <a class="nav-link" href="#">
                        <img src="https://i.postimg.cc/MGHn9L6H/man.png" alt="Avatar Logo" class="d-flex justify-content-center align-items-center" style="width:44px; text-align: center"
                             class="rounded-pill">
                    </a>
                    <a class="nav-link" href="#">Firstname Lastname</a>
                </li>
                <li class="nav-item d-flex justify-content-center align-items-center px-4">
                    <a class="nav-link" href="#">Logout</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

</body>
</html>