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

<#if user??>

<div class="row">
    <div class="col-sm-12 col-xs-12 col-md-4 col-md-offset-2">
        <div class="panel panel-default">
            <div class="panel-thumbnail">
                <img src="http://www.sen-soyle.com/g/1guzel_fotograflar_profil_2.jpg"
                     class="img-responsive">
            </div>
            <div class="panel-body">
                <p class="lead">${user.login!}
                    <#if edit??>
                        <a href="/member/modify"><span class="glyphicon glyphicon-edit" aria-hidden="true"/></a>
                    </#if>
                </p>

                <p class="lead">${user.location!}</p>

            </div>
        </div>
    </div>
    <div class="col-sm-12 col-xs-12 col-md-4 ">
        <div class="panel panel-default">
            <div class="panel-heading"><h4>About me</h4></div>
            <div class="panel-body">
            ${user.description!}
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading"><h4>Overview</h4></div>
            <div class="panel-body">
                <p id="Age"></p>

                <p>${birthDate!}</p>

                <p>Male</p>

                <p>Member since 2013</p>
            </div>
        </div>

        <#if !edit??>
            <p> <span onclick="alert('Hello !');">
            <button class="btn btn-lg btn-primary btn-block" type="submit">Add to friend list</button>
        </span></p>
            <p><span onclick="clickSendMessage()">
            <button id="buttonSend" class="btn btn-lg btn-primary btn-block" type="submit">Send a message</button>
        </span></p>

        <span id="msg" style="display:none"><p>
            <form method="post" action="/mail/send">
                <input type="text" class="form-control" name="userId2" style="display:none" value="${user.userId!}"/>
                <input type="text" class="form-control" name="sujet" placeholder="Enter subject"/>
                <textarea rows="4" class="form-control" name="msg" placeholder="Enter message"></textarea><p></p>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Send message</button>
            </form>
            </p>
        </span>
        </#if>

    </div>
</div>

<#else>
PAS DUTILISATEUR TROUVE
</#if>

<script>
    function clickSendMessage() {
        var buttonSend = document.getElementById('buttonSend');
        buttonSend.style.display = 'none';

        var msg = document.getElementById('msg');
        msg.style.display = 'block';
    }

</script>

<script src="/js/jquery.min.js"></script>
<script src="/js/ie10-viewport-bug-workaround.js"></script>
<script src="/js/bootstrap.min.js"></script>

</body>
</html>