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

<#if user??>

<div class="row">
    <form class="col s6 offset-s3" method="post" action="<@spring.url "/member/modify" />">

        <div class="row" style="margin-top:2em">
            <div class="input-field col s6">
                <input type="text" name="login" value="${user.login!}">
                <label>Nickname</label>
            </div>
            <div class="input-field col s6">
                <input type="text" name="mail" value="${user.mail!}">
                <label>Email</label>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s6">
                <input type="text" name="firstName" value="${user.firstName!}">
                <label>FirstName</label>
            </div>
            <div class="input-field col s6">
                <input type="text" name="surName" value=${user.surName!}"">
                <label>SurName</label>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s6">
                <input type="text" name="location" value="${user.location!}">
                <label>Location</label>
            </div>
            <div class="input-field col s6">
                <select name="gender">
                    <option value="A">Any</option>
                    <option value="F">Female</option>
                    <option value="M">Male</option>
                </select>
                <label>Gender</label>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s6">
                <input type="date" name="birthDate" value="${user.birthDate!}">
            </div>
        </div>

        <div class="row">
            <div class="input-field col s12">
                <textarea name="description" class="materialize-textarea" value="${user.description!}"></textarea>
                <label>Description</label>
            </div>
        </div>

        <button type="submit" class="waves-effect waves-light btn red right"
                style="margin-top:2em">
            Save
        </button>

    </form>
</div>
</#if>

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