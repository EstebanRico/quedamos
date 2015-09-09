<#import "/spring.ftl" as spring />
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
    <title>Quedamos</title>

    <!-- CSS  -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,300,500' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/css/materialize.min.css">
    <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/leaflet/0.7.3/leaflet.css"/>
    <link rel="stylesheet" href="http://www.liedman.net/leaflet-routing-machine/dist/leaflet-routing-machine.css"/>
    <link href='https://api.mapbox.com/mapbox.js/plugins/leaflet-label/v0.2.1/leaflet.label.css' rel='stylesheet'/>
    <link href="<@spring.url "/static/css/global.css" />" rel="stylesheet">
    <link href="https://assets.couchsurfing.com/assets/new_layout/new_layout-2d93e188165c33531b9f32acac318ac1.css"
          media="all" rel="stylesheet"/>

</head>
<body>

<#include "navbar.ftl" />

<#if user??>

<div class="row" style="margin-top:2em">

<#--<#if User??>-->
<#--//TODO faille de sécurité attention, car il ne faut pas renvoyer toutes les informations des utilisateurs au client-->
    <div class="row">
        <div class="col s6 offset-s3">
            <div class="card blue-grey darken-1">
                <div class="row">

                    <div class="col s6">
                        <div class="row">
                            <div class="card-content white-text">
                                <span class="card-title">${user.nickName!}</span>
                            </div>
                            <div class="card-content white-text">
                                <i class="material-icons left">wc</i>

                                <p>${user.gender!}, ${user.age!} years</p>
                            </div>
                            <div class="card-content white-text">
                                <i class="material-icons left">location_on</i>

                                <p>${user.location!}</p>
                            </div>
                            <div class="card-content white-text">
                                <i class="material-icons left">history</i>

                                <p>Member since ${user.inscription!}</p>
                            </div>
                        </div>
                    </div>

                    <div class="col s6">
                        <img style="margin-top:2em;max-width:100%;height:auto;display:block"
                             src="http://www.fairesonjardin.fr/images/inconnu.jpg?1438056051">
                    </div>

                    <div class="col s12">
                        <div class="card-content white-text">
                            <p>${user.description!}</p>
                        </div>
                    </div>

                </div>


                <div class="card-action">
                    <div class="col s12" style="margin-bottom:1em">
                        <div class="col s6">
                            <a href="#"><i class="material-icons left">mail</i>Send a message</a>
                        </div>
                        <div class="col s6">
                            <a href="#"><i class="material-icons left">person_add</i>Add to friend list</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


<#else>
    PAS DUTILISATEUR TROUVE
</#if>
<#--</#if>-->

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