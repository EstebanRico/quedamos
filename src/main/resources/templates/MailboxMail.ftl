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

<#include "navbar.ftl" />

<#if discussion??>

<div class="row">
    <div class="col-xs-12 col-sm-offset-3 col-sm-6">
        <div class="panel panel-default">
            <ul class="list-group" id="contact-list">
            <#--//TODO faille de sécurité attention, car il ne faut pas renvoyer toutes les informations des utilisateurs au client-->
                <#list discussion.listeMail as mail>
                        <li class="list-group-item">
                                <div class="col-xs-4 col-sm-2">
                                    <img src="http://www.sen-soyle.com/g/1guzel_fotograflar_profil_2.jpg"
                                         class="img-responsive img-circle"/>
                                </div>
                                <div class="col-xs-8 col-sm-3">
                                    <span class="name">${mail.msg!}</span><br/>
                                </div>
                                <div class="clearfix"></div>
                        </li>
                </#list>
            </ul>

        </div>

        <form method="post" action="/mail/send/${discussion.discId!}">
            <input type="text" class="form-control" name="userId2" style="display:none" value="${user.userId!}"/>
            <textarea rows="4" class="form-control" name="msg" placeholder="Enter reply"></textarea><p></p>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Send reply</button>
        </form>

    </div>
</div>
</#if>

<script src="/js/jquery.min.js"></script>
<script src="/js/ie10-viewport-bug-workaround.js"></script>
<script src="/js/bootstrap.min.js"></script>

</body>
</html>