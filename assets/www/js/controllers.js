angular.module('starter.controllers', [])
.controller('LoginCtrl', function($scope, $state, UserService, $ionicLoading, $ionicPopup) {

  $scope.googleSignIn = function() {
    $ionicLoading.show({
      template: 'Logging in...'
    });
    window.plugins.googleplus.login(
        {},
        function (user_data) {
          console.log(user_data);
          //for the purpose of this example I will store user data on local storage
          UserService.setUser({
            userID: user_data.userId,
            name: user_data.displayName,
            email: user_data.email,
            picture: user_data.imageUrl,
            accessToken: user_data.accessToken,
            idToken: user_data.idToken
          });
          $ionicLoading.hide();
          $state.go('register');
        },
        function (msg) {
          $ionicLoading.hide();
          console.log(msg);
        }
    );
  };
  $scope.showPopup = function() {
  $scope.data = {};
  // An elaborate, custom popup
  var myPopup = $ionicPopup.show({
    template: '<input type="email" ng-model="data.email">',
    title: 'Enter Your Mail-Id',
    scope: $scope,
    buttons: [
      { text: '<b>Submit</b>',
        type: 'button-positive'	  },
      {
        text: '<b>Cancel</b>',
        onTap: function(e) {
          if (!$scope.data.wifi) {
            //don't allow the user to close unless he enters wifi password
            e.preventDefault();
          } else {
            return $scope.data.wifi;
          }
        }
      }
    ]
  });
     myPopup.then(function(res) {
     console.log('Thank you for not eating my delicious ice cream cone');
	 $state.go('register');
   });
 };
})
.controller('AppCtrl', function($scope, $ionicModal, $timeout) {
})
.controller('SplashCtrl', function($scope, $state, $timeout) {
    $timeout(function() {
      $state.go('login');
      }, 3000);
    })
.controller('TabsCtrl', function($scope) {
  $scope.savedtext = "1-4 RESIDENTIAL CONTACT"
})
.controller('SignatureCtrl', function($scope) {
})
.controller('HomefirstCtrl', function($scope) {
  $scope.name1 = "JOHN SMITH"
  $scope.name2 = "& KILLY SMITH"
  $scope.number = "(432) 311 0099"
  $scope.mail = "killy@gmail.com"
  $scope.address = "701 Brozes St., Austin, TX,78701"
  $scope.image1 = 'img/homefirst.png';
  $scope.home = "SINGLE FAMILY HOME"
  $scope.price = "$ 750,000"
  $scope.location = "701 Brazos St.Austin"
  $scope.date = "Oct 20, 2015"
})
.controller('HomeCtrl', function($scope) {
  $scope.name1 = "JOHN SMITH"
  $scope.name2 = "& KILLY SMITH"
  $scope.number = "(432) 311 0099"
  $scope.mail = "killy@gmail.com"
  $scope.address = "701 Brozes St., Austin, TX,78701"
  $scope.image1 = 'img/homefirst.png';
  $scope.image2 = 'img/homeimglist.png';
  $scope.home = "SINGLE FAMILY HOME"
  $scope.price = "$ 750,000"
  $scope.location = "701 Brazos St.Austin"
  $scope.date = "Oct 20, 2015"
})
.controller('BuyerdetailsCtrl', function($scope) {
  $scope.name1 = "JOHN SMITH"
  $scope.name2 = "& KILLY SMITH"
  $scope.number = "(432) 311 0099"
  $scope.mail = "killy@gmail.com"
  $scope.address = "701 Brozes St., Austin, TX,78701"
  $scope.image1 = 'img/homeimglist.png';
  $scope.home = "SINGLE FAMILY HOME"
  $scope.price = "$ 750,000"
  $scope.location = "701 Brazos St.Austin"
  $scope.date = "Oct 20, 2015"
  $scope.phone = "08251840191"
})
.controller('GetlistCtrl', function($scope) {
  $scope.image1 = 'img/homeimglist.png';
  $scope.home = "SINGLE FAMILY HOME"
  $scope.price = "$ 750,000"
  $scope.location = "701 Brazos St.Austin"
  $scope.image2 = 'img/bedrooms.png'
  $scope.image3 = 'img/bathrooms.png'
  $scope.image4 = 'img/sqft-img.png'
})
.controller('GetsearchCtrl', function($scope) {
  $scope.image1 = 'img/homeimglist.png';
  $scope.home = "SINGLE FAMILY HOME"
  $scope.price = "$ 750,000"
  $scope.location = "701 Brazos St.Austin"
  $scope.image2 = 'img/bedrooms.png'
  $scope.image3 = 'img/bathrooms.png'
  $scope.image4 = 'img/sqft-img.png'
})
.controller('PropertydetailsCtrl', function($scope) {
  $scope.name = "FOR SALE"
  $scope.add1 = "4803 Harmon Ave\nAustin, TX 78750\nSpicewood at Bull Creek"
  $scope.mail = "larry@gmail.com"
  $scope.image1 = 'img/PropertyDetai_imge_homel.png';
  $scope.home = "DETAILS"
  $scope.list = "LISTING AGENT INFORMATION"
  $scope.list1 = "LARRY SMITH"
  $scope.number = "453.345.3333"
  $scope.price = "$ 750,000"
  $scope.image2 = 'img/bedrooms.png'
  $scope.image3 = 'img/bathrooms.png'
  $scope.image4 = 'img/sqft-img.png'
  $scope.details = "Lorem ipsum dolor sit amet, consectetur\nadipiscing elit. Nam id sapien neque. Cum\nsociis natoque penatibus et magnis dis par-\nturient montes, nascetur ridiculus mus.\nFusce nec ultricies augue,at dictum elit.In\nhac habitasse platea dictumst. In tristique\nnisi ut ipsum ullamcorper,a pulvinar nisi tris-\ntique. Interdum et malesuada fames ac ante\nipsum primis in faucibus. Nulla ultrices ulla-\nmcorper lectus, vel viverra magna sceleris-\nque in. Quisque maximus ut mi id rutrum.\nDonec tincidunt maximus eros, quis rutrum\nenim consectetur sed."
})
.filter('nl3p', function () {
    return function(text){
        text = String(text).trim();
        return (text.length > 0 ? '<p class="pd">' + text.replace(/[\r\n]+/g, '</p><p class="pd">') + '</p>' : null);
    }
})
.controller('OffersdetailsCtrl', function($scope) {
  $scope.name = "FOR SALE"
  $scope.add1 = "4803 Harmon Ave\nAustin, TX 78750\nSpicewood at Bull Creek"
  $scope.mail = "larry@gmail.com"
  $scope.image1 = 'img/PropertyDetai_imge_homel.png';
  $scope.buyer = "Buyer"
  $scope.buyerval = "KELLY SMITH"
  $scope.offers = "Offers"
  $scope.offersval = "$745,000"
  $scope.fee = "Option Fee"
  $scope.feeval = "$100"
  $scope.period = "Option Period"
  $scope.periodval = "10 days"
  $scope.date = "Closing Date"
  $scope.dateval = "Dec 20, 2015"
  $scope.list = "LISTING AGENT INFORMATION"
  $scope.list1 = "LARRY SMITH"
  $scope.number = "453.345.3333"
  $scope.price = "$ 720,000"
  $scope.image2 = 'img/bedrooms.png'
  $scope.image3 = 'img/bathrooms.png'
  $scope.image4 = 'img/sqft-img.png'
})
.filter('nl3p', function () {
    return function(text){
        text = String(text).trim();
        return (text.length > 0 ? '<p class="pd">' + text.replace(/[\r\n]+/g, '</p><p class="pd">') + '</p>' : null);
    }
})
.controller('PickcontractCtrl', function($scope) {
  $scope.pickcontract = [
    { title: '1-4 FAMILY RESIDENTIAL CONTACT', id: 1 },
    { title: 'ADDENDUM', id: 2 },
    { title: 'NEW HOME CONTRACT', id: 3 },
    { title: 'FARM & RANCH CONTRACT', id: 4 },
  ];
$scope.create = function() {



function OpenNative() {
};

OpenNative.prototype.open = function(callbackContext) {
    callbackContext = callbackContext || {};
    cordova.exec(callbackContext.success || null, callbackContext.error || null, "OpenNative", "open", []);

};

/**
 * Load Plugin
 */

if(!window.plugins) {
    window.plugins = {};
}
if (!window.plugins.openNative) {
    window.plugins.openNative = new OpenNative();
}
alert("Hiiii");
//   $scope.put = functionalert ("hi");
 };                         ////          Ma.moveToNextScreen(); () {
//
//moveToNextScreen();
//
//      }
//<script type="text/javascript">
    function callNewActivity() {
        MainActivity.customFunctionCalled();
    }
//</script>


})
.controller('EditcontractCtrl', function($scope){
    $scope.para1 = "Lorem ipsum dolor sit amet, consectetur\nadipiscing elit. Etiam suscipit fermentum\nnibh, a lobortis magna sollicitudin ac. Sed \nlorem mi, sollicitudin a massa sed, mollis ali- \nquet turpis. Ut ornare maximus lorem et pel- \nlentesque. Sed odio nisl, faucibus eget ligula \nnon, mattis mollis eros."
    $scope.para2 = "Phasellus eu posuere turpis. Pellentesque\nmalesuada tellus a arcu sodales consectetur.\nSed consectetur sit amet neque euismod vi-\nverra. Donec id blandit ex. Maecenas quis\nurna lobortis, vehicula dolor quis, laoreet\njusto. Duis sem augue, posuere sed tellus\nnec, rhoncus sodales neque."
    $scope.para3 = "Curabitur lacus libero, posuere eu faucibus\nut, ultrices sollicitudin mi. Duis iaculis ali-\nquam est, nec faucibus dolor consequat eu.\nSed vestibulum cursus odio at rhoncus.\nPraesent tincidunt leo quis sodales inter-\ndum. Vestibulum ante ipsum primis in fauci-\nbus orci luctus et ultrices posuere cubilia\nCurae; Aenean egestas suscipit massa a fau-\ncibus."
    $scope.para4 = "Duis vel massa eros. Vestibulum et elit con-\nvallis, mollis sapien quis, congue turpis. Pel-\nlentesque imperdiet, arcu quis tincidunt\nplacerat, est diam interdum ex, et consequat\nnibh nibh et felis."
    $scope.para5 = "Pellentesque id ante quam. Pellentesque\ndictum vitae ipsum eu dictum. Proin ante\nlorem, tempus ut convallis vel, scelerisque sit\namet justo. Ut dictum id augue sit amet."

})
.controller('SavedcontractCtrl',function($scope, $ionicPopup, $timeout, $state) {
  $scope.savedtext = "1-4 RESIDENTIAL CONTACT"
 $scope.showAlert = function() {
   var alertPopup = $ionicPopup.alert({
       title: 'Contract has been successfully sent to the ',
       template: ''
   });
   alertPopup.then(function(res) {
     console.log('Thank you for not eating my delicious ice cream cone');
	 $state.go('app.tabs.home');
   });
 };
})
.controller('OffersCtrl', function($scope) {
  $scope.image1 = 'img/homeimglist.png';
  $scope.homepre = "Buyer:\n&nbspKELLY SMITH"
  $scope.price = "$ 750,000"
  $scope.location = "701 Brazos St.Austin"
  $scope.date = "Oct 20, 2015"
})
.filter('n30p', function () {
    return function(text){
        text = String(text).trim();
        return (text.length > 0 ? '<p class="off-namepre">' + text.replace(/[\r\n]+/g, '</p><p class="off-name">') + '</p>' : null);
    }
})
.controller('BuyeractiveCtrl', function($scope) {
    $scope.showstartCard = true;
    $scope.showsecondCard = false;

    $scope.hideCard = function() {
        $scope.showstartCard = false;
        $scope.showsecondCard = true;
    };
	$scope.showCard = function() {
    $scope.showstartCard = true;
    $scope.showsecondCard = false;
};
  $scope.name1 = "KILLY SMITH"
  $scope.name3 = "LARRY SMITH"
  $scope.number = "(432) 311 0099"
  $scope.offer1 = "3 OFFERS"
  $scope.address = "701 Brazos St., Austin, TX,78701"
  $scope.name2 = "ROGER BRODIE";
  $scope.name4 = "KELLY BRODIE";
  $scope.address1 = "1120 Barton Creek, Austin, TX,78701"
  $scope.price = "$ 750,000"
  $scope.location = "701 Brazos St.Austin"
  $scope.offer2 = "5 OFFERS"
})
.filter('n20p', function () {
    return function(text){
        text = String(text).trim();
        return (text.length > 0 ? '<p class="buyde-align ba-first">' + text.replace(/[\r\n]+/g, '</p><span class="badge badge-assertive sm-badge">') + '</span>' : null);
    }
})
.controller('BuyercloseCtrl', function($scope) {
  $scope.name1 = "KILLY SMITH"
  $scope.number = "(432) 311 0099"
  $scope.offer1 = "3 OFFERS"
  $scope.address = "701 Brazos St., Austin, TX,78701"
  $scope.name2 = "ROGER BRODIE";
  $scope.address1 = "1120 Barton Creek, Austin, TX,78701"
  $scope.price = "$ 750,000"
  $scope.location = "701 Brazos St.Austin"
  $scope.offer2 = "5 OFFERS"
})
.filter('n20p', function () {
    return function(text){
        text = String(text).trim();
        return (text.length > 0 ? '<p class="buyde-align ba-first">' + text.replace(/[\r\n]+/g, '</p><span class="badge badge-assertive sm-badge">') + '</span>' : null);
    }
})
.controller('PlaylistCtrl', function($scope, UserService, $ionicActionSheet, $state, $ionicLoading){
  $scope.user = UserService.getUser();

})
.controller('GetstartedCtrl', function($scope, $state, $ionicLoading, $compile, $ionicPlatform,                    $cordovaGeolocation) {
			$scope.disableTap = function () {
				var container = document.getElementsByClassName('pac-container');
				angular.element(container).attr('data-tap-disabled', 'true');
				var backdrop = document.getElementsByClassName('backdrop');
				angular.element(backdrop).attr('data-tap-disabled', 'true');
				// leave input field if google-address-entry is selected
				angular.element(container).on("click", function () {
					document.getElementById('address').blur();
				});
			};
            $scope.init = function() {
              var map = new google.maps.Map(document.getElementById('map'), {
				center: {lat: -33.8688, lng: 151.2195},
				zoom: 8,
				mapTypeId: google.maps.MapTypeId.ROADMAP
			  });
			    $scope.map = map;
				  if(!$scope.map) {
					return;
				}
				$scope.loading = $ionicLoading.show({
				  content: 'Getting current location...',
				  showBackdrop: false
				});
				navigator.geolocation.getCurrentPosition(function(pos) {
				  var pos = (new google.maps.LatLng(pos.coords.latitude, pos.coords.longitude));
				  var marker = new google.maps.Marker({
					  map: map,
					  position: pos,
					  icon: 'https://maps.google.com/mapfiles/ms/icons/green-dot.png'
					});
					map.setCenter(pos);
				  $scope.loading.hide();
				}, function(error) {
				  alert('Unable to get location: ' + error.message);
				});
			  var contentString = "<div class='row npad' ui-sref='propertydetails'><div class='col-40'><img  src='img/homeimglist.png' class='img-pop'></div><div class='col-60' style='padding: 2% 0 0 5%;'><div class='row h-imgtpop' ng-bind-html='home'></div><div class='row h-imgt2'  ng-bind-html='price'></div><div class='row list-pad list-mar'><img ng-src='{{image2}}' class='col-33 img-smpop'><img ng-src='{{image3}}' class='col-33 img-smpop'><img ng-src='{{image4}}' class='col-33 img-smpop'></div><div class='row npad list-mar'><div class='txt-sml'>3</div><div class='txt-sml'>2</div><div class='txt-sml'>1650</div></div></div></div>";
			  var compiled = $compile(contentString)($scope);
			  var infowindow = new google.maps.InfoWindow({
			  content: compiled[0]
			  });
		      var image = 'img/marker.png';
		      var marker = new google.maps.Marker({
			  map: map,
			  icon: image,
			  position:  {lat: 12.740913, lng: 77.825292}
		    });
              google.maps.event.addListener(marker, 'click', function() {
					  infowindow.open(map,marker);
				});
			// Create the search box and link it to the UI element.
			  var input = document.getElementById('address');
			  var searchBox = new google.maps.places.SearchBox(input);
			  // Bias the SearchBox results towards current map's viewport.
			  map.addListener('bounds_changed', function() {
				searchBox.setBounds(map.getBounds());
			  });
			  var markers = [];
			  // Listen for the event fired when the user selects a prediction and retrieve
			  // more details for that place.
			  searchBox.addListener('places_changed', function() {
				var places = searchBox.getPlaces();
				if (places.length == 0) {
				  return;
				}
				// Clear out the old markers.
				markers.forEach(function(marker) {
				marker.setMap(null);
				});
				markers = [];
				// For each place, get the icon, name and location.
				var bounds = new google.maps.LatLngBounds();
				places.forEach(function(place) {
				  var icon = {
					url: place.icon,
					size: new google.maps.Size(71, 71),
					origin: new google.maps.Point(0, 0),
					anchor: new google.maps.Point(17, 34),
					scaledSize: new google.maps.Size(25, 25)
				  };
				  // Create a marker for each place.
				  markers.push(new google.maps.Marker({
					map: map,
					icon: 'https://maps.google.com/mapfiles/ms/icons/red-dot.png',
					title: place.name,
					position: place.geometry.location
				  }));
				  if (place.geometry.viewport) {
					// Only geocodes have viewport.
					bounds.union(place.geometry.viewport);
				  } else {
					bounds.extend(place.geometry.location);
				  }
				});
				  map.fitBounds(bounds);
			  });
};
				  $scope.image1 = 'img/homeimglist.png';
				  $scope.home = "SINGLE FAMILY HOME"
				  $scope.price = "$ 750,000"
				  $scope.location = "701 Brazos St.Austin"
				  $scope.image2 = 'img/bedrooms.png'
				  $scope.image3 = 'img/bathrooms.png'
				  $scope.image4 = 'img/sqft-img.png'
				  $scope.showstartCard = true;
				  $scope.showsecondCard = false;
				  $scope.showsearch = false;
				  $scope.hideCard = function() {
					$scope.showstartCard = false;
					$scope.showsecondCard = true;
					$scope.showsearch = false;
				  };
			      $scope.hideCard1 = function() {
					$scope.showstartCard = false;
					$scope.showsecondCard = true;
					$scope.showsearch = true;
					};
				  $scope.showCard = function() {
					$scope.showstartCard = true;
					$scope.showsecondCard = false;
				};
	              $scope.items = [
				{
					image2 : 'img/bedrooms.png',
					image3 : 'img/bathrooms.png',
					image4 : 'img/sqft-img.png',
					homename: 'SINGLE FAMILY HOME',
					price: '$ 750,000',
					location: '701 Brazos St.Austin',
					image1 : 'img/homeimglist.png'
				},
				{
					image2 : 'img/bedrooms.png',
					image3 : 'img/bathrooms.png',
					image4 : 'img/sqft-img.png',
					homename: 'DOUBLE FAMILY HOME',
					price: '$ 745,000',
					location: '1120 Barton Creek, Austin, TX,78701',
					image1 : 'img/homeimglist.png'
				},

	];
})

.controller('EditbuyerCtrl', function($scope) {

})
.controller('AddbuyerCtrl', function($scope) {
  $scope.mapCreated = function(map) {
    $scope.map = map;
  };
});
