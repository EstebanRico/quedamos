<#import "/spring.ftl" as spring />
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
    <!-- Custom styles for this template -->
    <link href="/css/navbar.css" rel="stylesheet">

    <!-- Bootstrap core CSS -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">

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

<div class="col-sm-12 col-xs-12 col-md-6 col-md-offset-3">

    <form class="form-signin" action="">
        <div class="panel panel-default">
            <div class="panel-heading"><h4>${event.name!}</h4></div>
            <div class="panel-body">
                <p><strong>Esta salida es </strong>${event.type!}</p>

                <p><strong>Su localizacion sera </strong>${event.location!}</p>

                <p><strong>Esta creado el </strong>${event.dateCreation!}</p>

                <p><strong>Organizado para </strong><a href="/member/display/${userLogin!}">${userLogin!}</a></p>

                <p>${event.nbPlaces!}</p>

                <p>${event.dateRDV!}</p>

                <p>${event.heureRDV!}</p>

                <p>${event.description!}</p>
            </div>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Inscribirse</button>
    </form>
</div>


<script src="/js/jquery.min.js"></script>
<script src="/js/ie10-viewport-bug-workaround.js"></script>
<script src="/js/bootstrap.min.js"></script>


</body>
</html>