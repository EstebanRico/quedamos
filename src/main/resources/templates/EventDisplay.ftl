<#import "/spring.ftl" as spring />
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
    <title>StarGUI Web</title>

    <!-- CSS  -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,300,500' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/css/materialize.min.css">
    <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/leaflet/0.7.3/leaflet.css"/>
    <link rel="stylesheet" href="http://www.liedman.net/leaflet-routing-machine/dist/leaflet-routing-machine.css"/>
    <link href='https://api.mapbox.com/mapbox.js/plugins/leaflet-label/v0.2.1/leaflet.label.css' rel='stylesheet'/>

    <link href="<@spring.url "/static/css/global.css" />" rel="stylesheet">

</head>
<body>

<#include "navbar.ftl" />

<h2 class="header center">Event Display</h2>

<div class="row">
    <form class="col s6 offset-s3" method="post" action="<@spring.url "/event/create" />">

        <div class="row" style="margin-top:2em">
            <div class="input-field col s6">
                <input type="text" name="name" value="">
                <label>Event name</label>
            </div>
            <div class="input-field col s6">
                <input type="text" name="type" value="">
                <label>Event type</label>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s6">
                <input type="text" name="lieuRDV" value="">
                <label>Event position</label>
            </div>
            <div class="input-field col s3">
                <input type="text" name="dateRDV" value="">
                <label>Event date</label>
            </div>
            <div class="input-field col s2">
                <input type="text" name="heureRDV" value="">
                <label>Event time</label>
            </div>
            <div class="input-field col s1">
                <input type="text" name="nbPlaces" value="" />
                <label>Places</label>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s12">
                <textarea id="description" class="materialize-textarea"></textarea>
                <label>Description</label>
            </div>
        </div>


        <button type="submit" class="waves-effect waves-light btn red right"
                style="margin-top:2em">
            Create
        </button>

    </form>
</div>

<!--  Scripts-->
<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/js/materialize.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.14.0/jquery.validate.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.0.3/sockjs.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/leaflet/0.7.3/leaflet.js"></script>
<script src="http://www.liedman.net/leaflet-routing-machine/dist/leaflet-routing-machine.js"></script>
<script src='https://api.mapbox.com/mapbox.js/plugins/leaflet-label/v0.2.1/leaflet.label.js'></script>


<script type="text/javascript">
    window.stargui = window.stargui || {};
    window.stargui.BASE_URL = "<@spring.url "" />";
    $("#contents").show();
    $(document).ready(function () {
        $('select').material_select();
    });
</script>

<script src="<@spring.url "/static/js/loginEvents.js" />"></script>
<#--<script src="<@spring.url "/static/js/mqmessages.js" />"></script>
<script src="<@spring.url "/static/js/map.js" />"></script>
<script src="<@spring.url "/static/js/time.js" />"></script>-->

</body>
</html>