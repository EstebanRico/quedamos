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
            <li><a href="<@spring.url "dashboard" />">Mon profil</a></li>
            <li><a class="dropdown-button" href="#!" data-activates="membres">Les Membres<i class="material-icons right">arrow_drop_down</i></a></li>
            <li><a class="dropdown-button" href="#!" data-activates="sorties">Les Sorties<i class="material-icons right">arrow_drop_down</i></a></li>
        </ul>
    </div>
</nav>