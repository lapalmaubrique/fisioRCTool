var app = angular.module('app', [ "ui.bootstrap.modal", "spring-security-csrf-token-interceptor" ])
.config(function(csrfProvider) {
    // optional configurations
    csrfProvider.config()
});

app.controller('ActorsController', [ '$scope', '$http', '$timeout', '$location',

function($scope, $http, $timeout, $location) {
	var baseURL = $location.$$absUrl;
	$scope.currentPage = 0;
    $scope.pageSize = 30;
    $scope.numPages = 0;
    $scope.data = [];
    
	$scope.getAllActors = function() {
		$http.get(baseURL+'/findAll').success(function(data) {
			$scope.actors = data;
			$scope.data = $scope.actors.slice($scope.currentPage, $scope.pageSize);
			$scope.numPages = Math.ceil(data.length / $scope.pageSize);
		});
	}
	
	$scope.activeCurrentPage = function(index){
	  return (index == $scope.currentPage) ? 'active' : '';
	}
	
	$scope.range = function(count){
	  var ratings = []; 
	  for (var i = 0; i < count; i++) { 
		  ratings.push(i);
	  } 
	  return ratings;
	}
	
	$scope.getDataPage = function(index){
		$scope.currentPage = index;
		var start = $scope.currentPage*$scope.pageSize;
		var end = start + $scope.pageSize;
		$scope.data = $scope.actors.slice(start, end);
	}

	$scope.getActor = function(id) {
		$http.get(baseURL+'/findById/' + id).success(function(data) {
			$scope.currentActor = data;
			$scope.showModal = true;
		});
	}
	
	$scope.open = function() {
		$scope.currentActor={};
		$scope.showModal = true;
	}

	$scope.cancel = function() {
		$scope.showModal = false;
	}

	$scope.saveActor = function() {
		var actor = $scope.currentActor;
		actor.lastUpdate=new Date();
		if(!actor.id){
			$http.post(baseURL+'/save', actor)
			.success(function(data) {
				$scope.showModal = false;
				$scope.msg='Actor guardado correctamente';
				$timeout(function() {
					$scope.getAllActors();
					$scope.currentPage = 0;
					$scope.msg='';
					$scope.currentActor={};
				  },2000);
			}).error(function(data) {
				$scope.msg = 'Se ha producido un error';
			});
		} else {
			$http.put(baseURL+'/update', actor)
			.success(function(data) {
				$scope.showModal = false;
				$scope.msg='Actor actualizado correctamente';
				$timeout(function() {
					$scope.getAllActors();
					$scope.currentPage = 0;
					$scope.msg='';
					$scope.currentActor={};
				  },2000);
			}).error(function(data) {
				$scope.msg = 'Se ha	producido un error';
			});
		}
	}
	
	$scope.deleteActor = function() {
		$http.delete(baseURL+'/delete/' + $scope.currentActor.id)
		.success(function() {
			$scope.showModal = false;
			$scope.msg='Actor eliminado correctamente';
			$timeout(function() {
				$scope.getAllActors();
				$scope.currentPage = 0;
				$scope.msg='';
				$scope.currentActor={};
			  },2000);
		}).error(function() {
			$scope.msg = 'Se ha	producido un error';
		});
	}
    

} ]);