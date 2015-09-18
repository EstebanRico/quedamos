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
<#--<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">-->

    <link href="<@spring.url "/static/css/global.css" />" rel="stylesheet">

</head>
<body>

<#include "navbar.ftl" />

<div class="row" style="margin-top:2em">

<#if (listeUser)??>
<#--//TODO faille de sécurité attention, car il ne faut pas renvoyer toutes les informations des utilisateurs au client-->
    <#list listeUser as user>
        <#if (user.login)??>
            <div class="row">
                <div class="col s6 offset-s3">
                    <ul class="collection">
                        <a href="display/${user.login!}" style="color:darkorange;">
                            <li class="collection-item avatar s6">
                                <img src="http://cdn-premiere.ladmedia.fr/var/premiere/storage/images/fluctuat/societe/news/de-la-prediction-d-un-profil-psychopathe-sur-twitter-3454664/62778436-1-fre-FR/De-la-prediction-d-un-profil-psychopathe-sur-Twitter_w670_h372.jpg"
                                     alt="" class="circle">
                        <span class="title">
                        ${user.login!}
                        </span>

                                <p>
                                ${user.location!}
                                    <br>
                                    //TODO possibilité d'ajouter d'autres champs
                                </p>
                            </li>
                        </a>
                    </ul>
                </div>
            </div>
        <#else>
            Aucun utilisteur avec ces informations.
        </#if>
    </#list>
<#else>

    <div class="row">
        <form class="col s6 offset-s3" method="post" action="<@spring.url "/member/search" />">

            <div class="row" style="margin-top:2em">
                <div class="input-field col s12">
                    <input type="text" name="login" value="">
                    <label>Login</label>
                </div>
            </div>

            <div class="row style=" margin-top:2em
            "">
            <div class="input-field col s12">
                <input type="text" name="location" value="">
                <label>
                <#--<i class="material-icons left">location_on</i>-->
                    Location</label>
            </div>


            <div class="row style=" margin-top:2em
            ">
            <div class="input-field col s12">
                <select name="gender">
                    <option value="A">Any</option>
                    <option value="F">Female</option>
                    <option value="M">Male</option>
                </select>
                <label>
                <#--<i class="material-icons left">wc</i>-->
                    Gender</label>
            </div>


            <button type="submit" id="member/search" class="waves-effect waves-light btn red right"
                    style="margin-top:2em">
                Search
            </button>

        </form>
    </div>
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