<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
<#--//TODO mettre une icone au site-->
<#--<link rel="icon" href="favicon.ico">-->

    <title>Quedamos</title>

    <!-- Bootstrap core CSS -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/css/signin.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]>
    <script src="/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="/js/html5shiv.min.js"></script>
    <script src="/js/respond.min.js"></script>
    <![endif]-->
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
        <#--<form class="col s6 offset-s3" method="post" action="<@spring.url "/member/search" />">-->
        <form class="col s6 offset-s3" method="post" action="/member/search">

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

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="/js/ie10-viewport-bug-workaround.js"></script>


</body>
</html>