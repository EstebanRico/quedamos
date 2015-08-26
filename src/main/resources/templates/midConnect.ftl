<div class="row">
    <form id="connectionForm" class="col s4">
    <#--<div class="row">-->
        <div class="input-field col">
            <i class="material-icons prefix">perm_identity</i>
            <input id="midInput" type="number" size="7" min="1" max="1048575" required
                   class="validate">
            <label for="midInput" data-error="requis, max 1048575.">MID du Taxi</label>
        </div>
        <div class="input-field col">
            <div class="switch">
                <label>
                <#--Déconnecté-->
                    <input id="connectionCheckBox" type="checkbox">
                    <span class="lever"></span>
                <#--Connecté-->
                </label>
            </div>
        </div>
    <#--</div>-->
    </form>
    <form class="col s6">
        <div class="input-field col s4">
            <select id="taximetre">
                <option value="1" selected>Libre</option>
                <option value="2">Client à bord</option>
                <option value="3">Dû</option>
            </select>
            <label>Etat Taximètre</label>
        </div>
    </form>
    <div id="time" class="col s2"></div>
</div>