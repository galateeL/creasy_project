<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>


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
                ['Customer', customersnb],
                ['Prospect', prospectsnb]
            ]);

            var options = {
                title: 'My Daily Activities',
                pieHole: 0.4,
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
                title: 'My Daily Activities',
                pieHole: 0.4,
            };

            var chart = new google.visualization.PieChart(document.getElementById('donutchart2'));
            chart.draw(data, options);
        }


    </script>


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

</head>

<body class="d-flex flex-column justify-content-between vh-100">


<div>
    <%--header--%>
    <jsp:include page="./header.jsp"/>
    <%----------%>

    <div class="container-fluid col-12">

        <h1 class="mt-3 fw-bold text-center text-md-start ms-md-5">Dashboard</h1>

        <div class="mt-4 ms-md-5 d-flex flex-column flex-md-row align-items-center justify-content-center justify-content-md-start">
            <h3>Creasy - Explain name project</h3>

            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam cursus imperdiet luctus. Nulla lobortis
                vitae risus nec dignissim. Cras sed nulla id orci iaculis porta. Nulla pulvinar ipsum felis, fermentum
                fringilla enim finibus ut. Aliquam maximus felis quis commodo suscipit. Mauris sollicitudin, magna et
                feugiat ultricies, tortor nisl vestibulum diam, ac venenatis felis risus at dui. Ut nec leo ultricies,
                pulvinar justo ac, molestie quam. Nullam vehicula ex sed risus feugiat, a tempus tortor laoreet.
                Pellentesque bibendum mollis tortor ut hendrerit.</p>

        </div>


        <div class="col row m-5 p-3">
            Graphs
        </div>

        <p>Prospects and customers</p>

        <div id="donutchart" style="width: 900px; height: 500px;"></div>

        <p>Prospects states detail</p>

        <div id="donutchart2" style="width: 900px; height: 500px; background-color: #999999"></div>


    </div>

        <h4>key figures</h4>
        <p>Number of prospects to follow up : ${prospectsToFollowUp}</p>
        <p>Number of prospects not started : ${prospectsNotStarted}      </p>
        <p>Number of prospects in progress  ${   prospectsInProgress}  </p>

        <p>Number of prospects  : ${propectsByUser} </p>
        <p>Number of customers : ${customersByUser}</p>
        <p>Number of companies : ${companiesByUser}</p>


</div>


</div>


</body>
</html>