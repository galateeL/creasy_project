
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<header>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid d-flex justify-content-evenly">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse " id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0 " style="font-family: 'Inter', sans-serif;">
                <li class="d-flex justify-content-center align-items-center me-2 ms-3 px-4">
                    <a class="navbar-brand" href="#"><img src="https://i.postimg.cc/P5LLYgPf/logo-creasy-1.png" alt="creasy-logo"
                                                          style="width: 100px"/></a>
                </li >
                <li class="nav-item d-flex justify-content-center align-items-center px-4">
                    <a class="nav-link" aria-current="page" href="${pageContext.request.contextPath}/dashboard">Dashboard</a>
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
                <li class="nav-item d-flex justify-content-center align-items-center">
                    <a class="nav-link" href="#">
                        <sec:authorize access="isAuthenticated()">
                            <img src="<sec:authentication property = "principal.pictureUrl"/>" alt="profil avatar"
                                class="d-flex justify-content-center align-items-center rounded-pill" style="width:35px; height:35px; object-fit: cover; text-align: center">
                        </sec:authorize>
                    </a>
                <li class="nav-item d-flex justify-content-center align-items-center">
                <a class="nav-link" href="${pageContext.request.contextPath}/details/user">
                    <sec:authorize access="isAuthenticated()">
                        <sec:authentication property="principal.firstName" /> <sec:authentication property="principal.lastName" />
                    </sec:authorize>
                </a>
                </li>
                </li>
                <li class="nav-item d-flex justify-content-center align-items-center px-4 me-2">
                    <a class="nav-link" href="#">Logout</a>
                </li>


            </ul>
        </div>
    </div>
</nav>

</header>