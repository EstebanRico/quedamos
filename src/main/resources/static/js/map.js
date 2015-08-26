(function (global) {

    global.stargui = global.stargui || {};
    global.stargui.map = global.stargui.map || {};
    var $map = global.stargui.map;

    var createButton = function (label, container, br) {
        var btn = L.DomUtil.create('button', '', container);
        btn.setAttribute('type', 'button');
        btn.innerHTML = label;
        if (br) {
            L.DomUtil.create('br', '', container);
        }
        return btn;
    };

    var taxiIcon = L.icon({
        iconUrl: 'https://storage.googleapis.com/material-icons/external-assets/v1/icons/svg/ic_local_taxi_black_24px.svg',
        iconSize: [36, 36],
        iconAnchor: [18, 18],
        popupAnchor: [0, -18],
        labelAnchor: [14, 0] // as I want the label to appear 2px past the icon (18 + 2 - 6)
    });

    var clientIcon = L.icon({
        iconUrl: 'https://storage.googleapis.com/material-icons/external-assets/v1/icons/svg/ic_person_pin_black_24px.svg',
        iconSize: [36, 36],
        iconAnchor: [18, 18],
        popupAnchor: [0, -18],
        labelAnchor: [14, 0] // as I want the label to appear 2px past the icon (18 + 2 - 6)
    });

    var destIcon = L.icon({
        iconUrl: 'https://storage.googleapis.com/material-icons/external-assets/v1/icons/svg/ic_pin_drop_black_24px.svg',
        iconSize: [36, 36],
        iconAnchor: [18, 18],
        popupAnchor: [0, -18],
        labelAnchor: [14, 0] // as I want the label to appear 2px past the icon (18 + 2 - 6)
    });


    var control = L.Routing.control({
        pointMarkerStyle: {
            radius: 5,
            color: '#0f0',
            fillColor: 'white',
            opacity: 1,
            fillOpacity: 0.7
        },
        plan: L.Routing.plan([
            L.latLng(48.898993, 2.303819)
        ], {
            createMarker: function (i, wp) {
                var text = "destination";
                var icon = destIcon;
                if (i == 0) {
                    text = "moi, taxi";
                    icon = taxiIcon;
                } else if (i == 1 && isClient) {
                    text = "client";
                    icon = clientIcon;
                }
                return L.marker(wp.latLng, {
                    draggable: true,
                    icon: icon
                }).bindLabel(text);
            },
            routeWhileDragging: true
        })
        ,
        lineOptions: {
            styles: [
                {color: '#455a64', opacity: 0.5, weight: 8},
                {color: 'white', opacity: 0.8, weight: 7},
                {color: '#00acc1', opacity: 1, weight: 4}
            ]
        }
    }).addTo(map);

    $map.waypoints = control.getWaypoints();

    var isClient = false;

    /**
     * BINDINGS
     */

    // see http://leaflet-extras.github.io/leaflet-providers/preview/
    var map = L.map('map').setView([48.898993, 2.303819], 15);

    L.tileLayer('http://{s}.tile.openstreetmap.se/hydda/full/{z}/{x}/{y}.png', {
        attribution: '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
    }).addTo(map);

    map.on('click', function (e) {
        var container = L.DomUtil.create('div'),
            startBtn = createButton('Téléporter le taxi ici', container, true),
            clientBtn = createButton('Lieu du client', container, true),
            destBtn = createButton('Destination du client', container, false);

        L.popup()
            .setContent(container)
            .setLatLng(e.latlng)
            .openOn(map);

        L.DomEvent.on(startBtn, 'click', function () {
            control.spliceWaypoints(0, 1, e.latlng);
            map.closePopup();
        });

        L.DomEvent.on(destBtn, 'click', function () {
            control.spliceWaypoints(2, 1, e.latlng);
            map.closePopup();
        });

        L.DomEvent.on(clientBtn, 'click', function () {
            isClient = true;
            control.spliceWaypoints(1, isClient ? 1 : 0, e.latlng);
            map.closePopup();
        });

    });

})(window);