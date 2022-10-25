<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script src="http://cdnjs.cloudflare.com/ajax/libs/moment.js/2.9.0/moment.min.js"
            type="text/javascript"></script>
    <script src="http://cdn.jsdelivr.net/webjars/jquery/3.4.1/jquery.min.js"
            type="text/javascript"></script>
    <title>Document</title>
</head>
<body>
<div id="map_div" style="width: 400px; height: 300px"></div>
</body>
<script type="text/javascript">
    google.charts.load("current", {
        "packages":["map"],
        // Note: you will need to get a mapsApiKey for your project.
        // See: https://developers.google.com/chart/interactive/docs/basic_load_libs#load-settings
        "mapsApiKey": "AIzaSyBgX40Z-wQVqDaTGZQpfe1EbRMvv4L4dX0"
    });
    google.charts.setOnLoadCallback(drawChart);
    function drawChart() {

        var data = new google.visualization.DataTable();
        data.addColumn('number', 'Lat');
        data.addColumn('number', 'Long');
        data.addColumn('string', 'Name')

        fetch("/allcustomers").then(res=>res.json()).then(companies=>{
            companies.forEach(company => {
                console.log(company)
                data.addRow([parseFloat(company.latitude),parseFloat(company.longitude),company.name])
            })
            console.log(data)
            var map = new google.visualization.Map(document.getElementById('map_div'));
            map.draw(data,{

                showTooltip: true,
                showInfoWindow: true
            });
        });

    }

</script>
</html>