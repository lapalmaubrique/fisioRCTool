var app = angular.module('login', [ "ui.bootstrap.modal",  "spring-security-csrf-token-interceptor" ]);

app.controller('LoginController', [ '$scope', '$http', '$location',

function($scope, $http, $location) {
	$scope.requiredName=true;
	$scope.requiredEmail=true;
	$scope.requiredPassword=true;
	visibilityButtonsForm(true);
	var url = $location.$$protocol+'://'+$location.$$host+":"+$location.$$port;
	
	$scope.open = function() {
		$scope.currentUser={};
		$scope.showModal = true;
	}

	$scope.cancel = function() {
		$scope.showModal = false;
	}
	
	$scope.closeModalInfo = function() {
		$scope.modalInfo = false;
	}

	$scope.register = function() {
		visibilityButtonsForm(false);
		var user = $scope.currentUser;
		$http.post(url+'/register', user)
		.success(function(data) {
			$scope.messageTitle="Correcto";
			$scope.message="Te has registrado correctamente. Le hemos enviado un email para confirmar el registro, gracias.";
			$scope.currentUser={};
			$scope.showModal = false;
			$scope.modalInfo = true;
			visibilityButtonsForm(true);
		}).error(function(data) {
			$scope.messageTitle="Error";
			$scope.message=data.message;
			$scope.currentUser={};
			$scope.showModal = false;
			$scope.modalInfo = true;
			visibilityButtonsForm(true);
		});
	}
	
	$scope.activeUser = function() {
		var token = document.getElementById("token").value;
		$http.post(url+'/activeUser', token)
		contador_regresivo(0,0,0,5);
	}
	
	function visibilityButtonsForm(visible){
		$scope.visibleButtonLoadRegister=!visible;
		$scope.visibleButtonRegister=visible;
	}

	function contador_regresivo(d, h, m, s) {
		var interval = setInterval(function() {
			if (s > 0) {
				s--;
			} else {
				if (m > 0) {
					m--;
					s = 59;
				} else {
					if (h > 0) {
						h--;
						m = 59;
						s = 59;
					} else {
						if (d > 0) {
							d--;
							h = 24;
							m = 59;
							s = 59;
						} else {
							clearInterval(interval);
							window.location.href=url+'/login';
						}
					}
				}
			}
			document.getElementById("segundos").innerHTML =  s + " segundos"
		}, 1000);
	}
	
} ]);