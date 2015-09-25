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

<h2 class="header center">Create event</h2>

<div class="row">
    <form class="col s6 offset-s3" method="post" action="<@spring.url "/event/create" />">

        <div class="row" style="margin-top:2em">
            <div class="input-field col s6">
                <input type="text" name="name">
                <label>Event name</label>
            </div>
            <div class="input-field col s6">
                <input type="text" name="type" value="">
                <label>Event type</label>
            </div>
            <div class="input-field col s6">
                <input type="text" name="location" value="">
                <label>Event location</label>
            </div>
        </div>


        <div class="row">
            <div class="input-field col s3">
                <input type="text" name="dateRDV" value="">
                <label>Event date</label>
            </div>
            <div class="input-field col s2">
                <input type="text" name="heureRDV" value="">
                <label>Event time</label>
            </div>
            <div class="input-field col s1">
                <input type="text" name="nbPlaces" value="">
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

<script src="/js/jquery.min.js"></script>
<script src="/js/ie10-viewport-bug-workaround.js"></script>
<script src="/js/bootstrap.min.js"></script>

</body>
</html>