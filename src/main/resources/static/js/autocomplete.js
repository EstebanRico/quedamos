function initializeAutocomplete(id) {
    var element = document.getElementById(id);
    if (element) {
        var autocomplete = new google.maps.places.Autocomplete(element, {types: ['geocode']});
        google.maps.event.addListener(autocomplete, 'place_changed', onPlaceChanged);
    }
}

function onPlaceChanged() {
    var place = this.getPlace();

    console.log(place);  // Uncomment this line to view the full object returned by Google API.

    for (var i in place.address_components) {
        var component = place.address_components[i];
        for (var j in component.types) {  // Some types are ["country", "political"]
            if (component.types[j] == "locality") {
                var type_element = document.getElementById("location");
                type_element.value = component.long_name;
            }
            if (component.types[j] == "country") {
                var type_element = document.getElementById("country");
                type_element.value = component.long_name;
            }
            if (component.types[j] == "administrative_area_level_1") {
                var type_element = document.getElementById("region");
                type_element.value = component.long_name;
            }
            if (component.types[j] == "administrative_area_level_2") {
                var type_element = document.getElementById("departement");
                type_element.value = component.long_name;
            }
        }
    }
}

google.maps.event.addDomListener(window, 'load', function () {
    initializeAutocomplete('user_input_autocomplete_address');
});