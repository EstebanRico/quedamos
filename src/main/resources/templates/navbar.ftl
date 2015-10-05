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
                <#--<li class="nav navbar-nav">-->
                    <li><a href="/dashboard">Home</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                           aria-expanded="false">Les membres <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/member/search">Chercher</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                           aria-expanded="false">Les sorties <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/event/create">Créer</a></li>
                            <li><a href="/event/search">Chercher</a></li>
                        </ul>
                    </li>
                    <li><a href="/mail/mailbox">Ma messagerie</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#">Contact Us</a></li>
                </ul>
            </div>
            <!--/.nav-collapse -->
        </div>
        <!--/.container-fluid -->
    </nav>
