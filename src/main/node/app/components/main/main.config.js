(function(){
'use strict';

angular.module('app.main')
.config(function($stateProvider){
  $stateProvider
  .state('main', {
    url: '/',
    templateUrl: 'components/main/main.html',
    controller: 'MainCtrl'
  });
});

})();
