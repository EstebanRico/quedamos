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


<#if listeEvent??>
<div class="row">
    <div class="col-xs-12 col-sm-offset-3 col-sm-6">
        <div class="panel panel-default">
            <ul class="list-group" id="contact-list">
            <#--//TODO faille de sécurité attention, car il ne faut pas renvoyer toutes les informations des utilisateurs au client-->
                <#list listeEvent as event>
                    <#if (event.name)??>
                        <li class="list-group-item">
                            <a href="/event/display/${event.eventId!}" style="color:darkorange;">
                                <div class="col-xs-4 col-sm-2">
                                    <img src="http://www.icône.com/images/icones/1/0/pictograms-nps-land-tennis.png"
                                         class="img-responsive img-circle"/>
                                </div>
                                <div class="col-xs-8 col-sm-3">
                                    <span class="name">${event.name!}</span><br/>
                                    ${event.location!}<br/>
                                    ${event.type!}<br/>
                                </div>
                                <div class="clearfix"></div>
                            </a>
                        </li>
                    <#else>
                        PAS D'EVENEMENT RECUPERE
                    </#if>
                </#list>
            </ul>
        </div>
    </div>
</div>
<#else>

<div class="col-md-6 col-md-offset-3">
    <div class="panel panel-info">
        <div class="panel-heading">Member search</div>
        <div class="panel-body">
            <form role="form" method="post" action="/event/search">
                <div class="form-group">
                    <label class="control-label">Type</label>
                    <input type="text" class="form-control" name="type" placeholder="Enter type">
                </div>
                <div class="form-group">
                    <label class="control-label">Location</label>
                    <input type="text" class="form-control" name="location" placeholder="Enter location">
                </div>
                <button type="submit" class="btn btn-lg btn-primary btn-block">Search event</button>
            </form>
        </div>
    </div>
</div>


</div>
</#if>

<script src="/js/jquery.min.js"></script>
<script src="/js/ie10-viewport-bug-workaround.js"></script>
<script src="/js/bootstrap.min.js"></script>

</body>
</html>