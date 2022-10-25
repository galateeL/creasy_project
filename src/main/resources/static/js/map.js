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