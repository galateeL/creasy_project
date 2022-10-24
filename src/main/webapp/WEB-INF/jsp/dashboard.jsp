<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>

<%--        Graphs--%>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
        google.charts.load("current", {packages: ["corechart"]});
        google.charts.setOnLoadCallback(drawChart1);


        let customersnb = ${customersByUser};
        let prospectsnb = ${propectsByUser};

        let prospectsToFollowUp = ${prospectsToFollowUp};
        let prospectsInProgress = ${prospectsInProgress};
        let prospectsNotStarted = ${prospectsNotStarted};

        function drawChart1() {
            var data = google.visualization.arrayToDataTable([
                ['Part', 'Partner'],
                ['Customers', customersnb],
                ['Prospects', prospectsnb]
            ]);

            var options = {
                // title: 'My activity',
                pieHole: 0.4,
                width: 500,
                height: 250,
                colors: ['#ffc900', '#8109cb']
            };


            var chart = new google.visualization.PieChart(document.getElementById('donutchart'));
            chart.draw(data, options);
        }

        google.charts.setOnLoadCallback(drawChart2);

        function drawChart2() {
            var data = google.visualization.arrayToDataTable([
                ['Prospect', 'State'],
                ['To follow-up', prospectsToFollowUp],
                ['In progress', prospectsInProgress],
                ['Not started', prospectsNotStarted]
            ]);

            var options = {
                // title: 'Prospect states',
                pieHole: 0.4,
                width: 500,
                height: 250,
                colors: ['#8109cb', '#f7526a', '#3ae1b1']
            };

            var chart = new google.visualization.PieChart(document.getElementById('donutchart2'));
            chart.draw(data, options);
        }

    </script>
    <%--    --%>

    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">


    <title>CREASY | Dashboard</title>


    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
          crossorigin="anonymous">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="/css/company/list.css"/>

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet">

    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
            crossorigin="anonymous"></script>


    <style>
        @import url('https://fonts.googleapis.com/css2?family=Outfit:wght@700&display=swap');
    </style>


</head>
<body class="d-flex flex-column justify-content-between vh-100">




        <div>
            <%--header--%>
            <jsp:include page="./header.jsp"/>
            <%----------%>


            <div class="container-fluid col-12">

                <h1 class="mt-3 fw-bold text-center text-md-start ms-md-5">Dashboard</h1>

                <div class="ms-md-5 mt-4">
                    <h5>
                        <span style="color: #b3b3b3">Welcome to </span><span
                            style="color:#FFC900; font-family: 'Outfit', sans-serif; font-size: 25px">C</span><span
                            style="color:#F7526A; font-family: 'Outfit', sans-serif; font-size: 25px">r</span><span
                            style="color:#3AE1B1; font-family: 'Outfit', sans-serif; font-size: 25px">easy</span><span style="color: #b3b3b3"> CRM, your best ally for managing your business!</span>
                    </h5>
                    <h5  style="color: #b3b3b3">Creasy allows you to centralize all your partners' data and to facilitate
                        their
                        management.</h5>
                </div>


                <div class="row justify-content-center mt-1">

                    <%-- Left block--%>
                    <div class="d-flex flex-column justify-content-center col-12 col-md-5 p-5 me-3 text-secondary">

                        <div class="mb-3">
                            <label class="form-label p-2 shadow-sm" style="background-color: #D9D9D9; color: white">KEY
                                FIGURES</label>
                        </div>


                        <div class="bg-white my-1 py-2 ps-5 shadow-sm">
                            <p><span
                                    style="color: #8109CB;font-family: 'Outfit', sans-serif; font-size: 40px">${propectsByUser} </span>
                                prospects</p>
                        </div>

                        <div class="bg-white my-1 py-2 ps-5 shadow-sm">
                            <p><span
                                    style="color: #FFC900;font-family: 'Outfit', sans-serif; font-size: 40px">${customersByUser} </span>
                                customers</p>
                        </div>

                        <div class="bg-white my-1 py-2 ps-5 shadow-sm">
                            <p><span
                                    style="color: #3AE1B1;font-family: 'Outfit', sans-serif; font-size: 40px">${companiesByUser} </span>
                                companies</p>
                        </div>

                        <div class="bg-white my-1 py-2 ps-5  mt-4 shadow-sm">
                            <p><span
                                    style="color: #F7526A;font-family: 'Outfit', sans-serif; font-size: 40px">${prospectsToFollowUp} </span>
                                prospect(s) to follow up</p>
                        </div>

                        <div class="bg-white my-1 py-2 ps-5 shadow-sm">
                            <p><span
                                    style="color: #8109CB;font-family: 'Outfit', sans-serif; font-size: 40px">${prospectsNotStarted} </span>
                                prospect(s) not started</p>
                        </div>

                        <div class="bg-white my-1 py-2 ps-5 shadow-sm">
                            <p><span
                                    style="color: #8109CB;font-family: 'Outfit', sans-serif; font-size: 40px">${prospectsInProgress} </span>
                                prospect(s) in progress</p>
                        </div>

                    </div>

                    <%--           --%>

                    <%--Intermediaire block--%>
                    <div class="col-md-1"></div>
                    <%--                          --%>


                    <%--        Right block--%>
                    <div class="d-flex flex-column justify-content-center align-items-center col-12 col-md-5 p-5">
                        <label class="form-label p-2 shadow-sm" style="background-color: #D9D9D9; color: white">CUSTOMERS AND
                            PROSPECTS</label>
                        <div class="col row m-2 p-3 my-2" id="donutchart"></div>

                        <label class="form-label p-2" style="background-color: #D9D9D9; color: white">PROSPECTS
                            STATES</label>
                        <div class="col row m-2 p-3 my-2" id="donutchart2"></div>
                    </div>
                    <%--            --%>


                </div>

            </div>

        </div>


        <%--back to top button--%>
        <jsp:include page="./backToTopButton.jsp"/>
        <%----------%>
    </div>

    <%--footer--%>
    <jsp:include page="./footer.jsp"/>
    <%----------%>

    <%--back to top button script--%>
    <script src="/js/BackToTopButton.js"></script>
    <%----------%>


</body>
</html>