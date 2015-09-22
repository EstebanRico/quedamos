<#--
<ul id="sorties" class="dropdown-content">
    <li><a href="<@spring.url "/event/create" />">Creer</a></li>
    <li><a href="<@spring.url "/event/search" />">Chercher</a></li>
</ul>

<ul id="membres" class="dropdown-content">
    <li><a href="<@spring.url "/member/search" />">Chercher</a></li>
</ul>

<nav>
    <div class="nav-wrapper">
        <ul class="left">
            <li><a href="<@spring.url "/dashboard" />">Mon profil</a></li>
            <li><a class="dropdown-button" href="#!" data-activates="membres">Les Membres<i class="material-icons right">arrow_drop_down</i></a></li>
            <li><a class="dropdown-button" href="#!" data-activates="sorties">Les Sorties<i class="material-icons right">arrow_drop_down</i></a></li>
        </ul>
    </div>
</nav>-->
<body>

<div class="container">

    <!-- Static navbar -->
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                        aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Quedamos</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#">Home</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                           aria-expanded="false">Les membres <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Chercher</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                           aria-expanded="false">Les sorties <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Créer</a></li>
                            <li><a href="#">Chercher</a></li>
                        </ul>
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="../navbar-static-top/">Contact Us</a></li>
                </ul>
            </div>
            <!--/.nav-collapse -->
        </div>
        <!--/.container-fluid -->
    </nav>