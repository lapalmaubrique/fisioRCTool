var app = angular.module('app', [ "ui.bootstrap.modal", "spring-security-csrf-token-interceptor" ])
.config(function(csrfProvider) {
    // optional configurations
    csrfProvider.config()
});

app.controller('BasicDataController', [ '$scope', '$http', '$timeout', '$location',

function($scope, $http, $timeout, $location) {
	var baseURL = $location.$$absUrl;
	$scope.currentPage = 0;
    $scope.pageSize = 30;
    $scope.numPages = 0;
    $scope.data = [];
    
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
		$scope.data = $scope.basicDatas.slice(start, end);
	}

	$scope.open = function() {
		$scope.currentBasicData={};
		$scope.showModal = true;
	}

	$scope.cancel = function() {
		$scope.showModal = false;
	}

	$scope.getBasicData = function(id) {
		$http.get(baseURL+'/findById/' + id).success(function(data) {
			$scope.currentBasicData = data;
			$scope.showModal = true;
		});
	}
    
	$scope.getAllBasicData = function() {
		$http.get(baseURL+'/findAll').success(function(data) {
			$scope.basicDatas = data;
			$scope.data = $scope.basicDatas.slice($scope.currentPage, $scope.pageSize);
			$scope.numPages = Math.ceil(data.length / $scope.pageSize);
		});
	}
	
	$scope.saveBasicData = function() {
		var basicData = $scope.currentBasicData;
		if(!basicData.id){
			$http.post(baseURL+'/save', basicData)
			.success(function(data) {
				$scope.showModal = false;
				$scope.msg='Datos básicos guardado correctamente';
				$timeout(function() {
					$scope.getAllBasicData();
					$scope.currentPage = 0;
					$scope.msg='';
					$scope.currentBasicData={};
				  },2000);
			}).error(function(data) {
				$scope.msg = 'Se ha producido un error';
			});
		}
	}

} ]);