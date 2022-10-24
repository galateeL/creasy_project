<!DOCTYPE>

<html lang="en">
<head>
	<meta charset='utf-8' content="Cory Sanoy" name="Author" />

	<link href="http://fullcalendar.io/js/fullcalendar-2.2.5/fullcalendar.css" 
			 rel="stylesheet"></link>
	<link href="http://fullcalendar.io/js/fullcalendar-2.2.5/fullcalendar.print.css" 
			rel="stylesheet" media="print"></link>
	<script src="http://cdnjs.cloudflare.com/ajax/libs/moment.js/2.9.0/moment.min.js"
			 type="text/javascript"></script>
	<script src="http://cdn.jsdelivr.net/webjars/jquery/3.4.1/jquery.min.js"
	         type="text/javascript"></script>
	<script src="http://fullcalendar.io/js/fullcalendar-2.2.5/fullcalendar.min.js"
			 type="text/javascript"></script>

<script>

$(document).ready(function() {
	$('#calendar').fullCalendar({
		header: {
			left: 'prev,next today',
			center: 'title',
			right: 'month,agendaWeek,agendaDay'
		},
		defaultDate: '2019-06-01',
		editable: true,
		eventLimit: true, // allow "more" link when too many events
		events: {
	        url: '/allevents',
	        type: 'GET',
	        error: function() {
	            alert('there was an error while fetching events!');
	        },
	        //color: 'blue',   // a non-ajax option
	        //textColor: 'white' // a non-ajax option
	    }
	});
	
});
</script>

<style>
	body {
		margin: 40px 10px;
		padding: 0;
		font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
		font-size: 14px;
	}
	#calendar {
		max-width: 900px;
		margin: 0 auto;
	}
</style>
</head>
<body>
	<div id='calendar'></div>
</body>
</html>