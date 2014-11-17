/**
 * 
 */
var ge;
var geocoder = new google.maps.Geocoder();
google.load("earth", "1", {"other_params":"sensor=false"});

function init() {
	google.earth.createInstance('map3d', initCB, failureCB);
}

function initCB(instance) {
	ge = instance;
	ge.getWindow().setVisibility(true);
	ge.getLayerRoot().enableLayerById(ge.LAYER_BORDERS, true);
	ge.getLayerRoot().enableLayerById(ge.LAYER_BUILDINGS, true);
	ge.getLayerRoot().enableLayerById(ge.LAYER_ROADS, true);
	ge.getLayerRoot().enableLayerById(ge.LAYER_TERRAIN, true);
	ge.getLayerRoot().enableLayerById(ge.LAYER_TREES, true);
	ge.getNavigationControl().setVisibility(ge.VISIBILITY_AUTO);
}

function failureCB(errorCode) {
}

google.setOnLoadCallback(init);

$(function() {
	$("#searchtopic").focusout(function() {
	    var topic = $(this).val();
	    if(topic!="")
	    	{
	    		window.alert(topic);
	    		codeAddress(topic);
	    	}
	});
	});

function codeAddress(name) {
   geocoder.geocode( { 'address': name}, function(results, status) {
      if (status == google.maps.GeocoderStatus.OK) {
    	  var placemark = ge.createPlacemark('');
    	  placemark.setName(name);

    	  // Set the placemark's location.  
    	  var point = ge.createPoint('');
    	  point.setLatitude(results[0].geometry.location.LatLng.lat());
    	  point.setLongitude(results[0].geometry.location.LatLng.lng());
    	  placemark.setGeometry(point);
    	  ge.getFeatures().appendChild(placemark);
      } else {
        alert("Geocode was not successful for the following reason: " + status);
      }
    });
  }