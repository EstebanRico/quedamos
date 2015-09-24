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
    <link href="/css/form.css" rel="stylesheet">
    <link href="/css/list-group.css" rel="stylesheet">


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



<#if (listeUser)??>
<div class="row">
    <div class="col-xs-12 col-sm-offset-3 col-sm-6">
        <#--<div class="col-xs-12 col-sm-offset-3 col-sm-6">-->
        <div class="panel panel-default">
            <ul class="list-group" id="contact-list">
            <#--//TODO faille de sécurité attention, car il ne faut pas renvoyer toutes les informations des utilisateurs au client-->
                <#list listeUser as user>
                    <#if (user.login)??>
                        <li class="list-group-item ">
                            <a href="/member/display/${user.login!}" style="color:darkorange;">
                                <div class="col-xs-4 col-sm-4">
                                    <img src="http://api.randomuser.me/portraits/men/49.jpg"
                                         class="img-responsive img-circle"/>
                                </div>
                                <div class="col-xs-8 col-sm-8">
                                    <span class="name">${user.login!}</span><br/>
                                ${user.location!}
                                </div>
                                <div class="clearfix"></div>
                            </a>
                        </li>
                    <#else>
                        Aucun utilisteur avec ces informations.
                    </#if>
                </#list>
            </ul>
        </div>
    </div>
</div>
<#else>

<#--<form class="col s6 offset-s3" method="post" action="<@spring.url "/member/search" />">-->
<div class="col-md-6 col-md-offset-3">
    <div class="panel panel-info">
        <div class="panel-heading">Member search</div>
        <div class="panel-body">
            <form role="form" method="post" action="/member/search">
                <div class="form-group">
                    <label class="control-label">Login</label>
                    <input type="text" class="form-control" name="login" placeholder="Enter login">
                </div>

                <div class="form-group">
                    <label class="control-label">Location</label>
                    <input type="text" class="form-control" name="location" placeholder="Enter location">
                </div>

                <button type="submit" class="btn btn-lg btn-primary btn-block">Search member</button>
            </form>

        </div>
    </div>
</div>

</#if>

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="/js/ie10-viewport-bug-workaround.js"></script>


</body>
</html>