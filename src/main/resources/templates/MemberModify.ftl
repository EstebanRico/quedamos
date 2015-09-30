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

<#if !register??>
    <#include "navbar.ftl" />
<#else>
<div class="container">
    MEMBER REGISTERING
</#if>

    <form method="post" action="/member/modify" enctype="multipart/form-data">
        <div class="row">
            <div class="col-sm-12 col-xs-12 col-md-4 col-md-offset-2">
                <div class="panel panel-default">

                    <div class="row">

                        <div class="panel-thumbnail">
                            <img src="http://www.sen-soyle.com/g/1guzel_fotograflar_profil_2.jpg"
                                 class="img-responsive">
                            <input name="pictureFile" type="file" class="input-file">
                        </div>
                        <div class="panel-body">
                            <p class="lead">
                            <#if register??>
                                <input type="text" class="form-control" name="login" placeholder="Enter login"/>
                            <#else>
                            ${user.login!}
                            </#if>
                            </p>

                            <p class="lead">
                            <#if register??>
                            <#--<input type="text" class="form-control" name="direccion"
                                   placeholder="Enter direccion"/>-->
                                <input id="user_input_autocomplete_address" name="user_input_autocomplete_address"
                                       class="form-control" placeholder="Start typing your address...">
                            <#else>
                                <input type="text" class="form-control" name="direccion"
                                       value="${user.location!} ${user.region!} ${user.country!}"/>
                            </#if>
                            </p>

                            <p class="lead">
                                <input type="hidden" class="form-control" name="location" readonly
                                       value="${user.location!}"/>
                            </p>

                            <p class="lead">
                                <input type="hidden" class="form-control" name="region" readonly
                                       value="${user.region!}"/>
                            </p>

                            <p class="lead">
                                <input type="hidden" class="form-control" name="country" readonly
                                       value="${user.country!}"/>
                            </p>

                        </div>
                    </div>
                </div>
            </div>
            <div class="col-sm-12 col-xs-12 col-md-4 ">
                <div class="panel panel-default">
                    <div class="panel-heading"><h4>About me</h4></div>
                    <div class="panel-body">
                                <textarea class="form-control" rows="8"
                                          name="description"
                                          placeholder="Enter a short description of you">${user.description!}</textarea>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading"><h4>Overview</h4></div>
                    <div class="panel-body">

                        <p><input type="date" class="form-control" name="birthDate"
                                  value="${user.birthDate!}"/>
                        </p>

                        <p>

                        <div class="dropdown">
                            <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1"
                                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                Gender
                                <span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                                <li>Female</li>
                                <li>Male</li>
                            </ul>
                        </div>

                    <#if !register??>
                        <div class="input-field col s6">
                            <input type="hidden" name="userId" value="${user.userId!}" readonly>
                        </div>
                        </p>
                        <p>Member since 2013</p>
                    </#if>

                    </div>
                </div>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Save</button>
            </div>
        </div>

    </form>
</div>
<!--  Scripts-->
<script src="/js/jquery.min.js"></script>
<script src="/js/ie10-viewport-bug-workaround.js"></script>
<script src="/js/bootstrap.min.js"></script>

<!-- Include Google Maps JS API -->
<script type="text/javascript"
        src="https://maps.googleapis.com/maps/api/js?libraries=places&amp;key=AIzaSyB5H8agT-phtImF75GM2K98q47BmJMcbIc">
</script>

<!-- Custom JS code to bind to Autocomplete API -->
<script type="text/javascript" src="/js/autocomplete.js">
</script>

</body>
</html>