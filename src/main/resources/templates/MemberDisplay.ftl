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
        <#--<div class="col" style="max-width:800px" align="center">-->
        <#--//TODO faire du proportionel-->
            <div class="card blue-grey darken-1">
                <div class="row">

                    <div class="col s6">
                        <div class="row">
                            <div class="card-content white-text">
                                <span class="card-title">${user.login!}</span>

                                    <#if edit??>
                                        <a class="btn-floating btn waves-effect waves-light red"
                                           href="/member/modify"><i class="material-icons">mode_edit</i></a>
                                    </#if>
                            </div>
                            <div class="card-content white-text">
                                <i class="material-icons left">wc</i>

                                <p>${user.gender!}, ${user.age!} years</p>
                                <input type="text" name="age" id="Age"/>
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

       /* function CalculAge() {
            alert('Inside :');
            var td=new Date();// Le date d'ouverture de la page (aujourd'hui)
            var dtn=new Date(1982,9,4); // on lit la date de naissance
            var an=dtn.substr(6,4); // l'année (les quatre premiers caractères de la chaîne à partir de 6)
            var mois=dtn.substr(3,2);// On selectionne le mois de la date de naissance
            var day= dtn.substr(0,2); // On selectionne la jour de la date de naissance
            alert('Dans la zone isolée, la couleur est :'+td+ dtn);
            var age=td.getFullYear()-an; // l'âge du patient
            var mMois=td.getMonth()-mois; // On calcul  le mois de la date - le mois de la date de naissance
            if(mMois < 0) // s'il est strictement inferieur a 0
            {
                age=age-1; // On enléve 1 ans a l'age
            }
            else
            {
                if(mMois == 0)// s'il égal 0 on est sur le même mois
                {
                    var mDate=td.getDay()-day;
                    if(mDate < 0)
                    {
                        age=age-1;
                    }
                }
            }
            document.getElementById('Age').value=age;
        }
        CalculAge();*/
    </script>

    <script src="<@spring.url "/static/js/loginEvents.js" />"></script>
<#--<script src="<@spring.url "/static/js/mqmessages.js" />"></script>
<script src="<@spring.url "/static/js/map.js" />"></script>
<script src="<@spring.url "/static/js/time.js" />"></script>-->

</body>
</html>