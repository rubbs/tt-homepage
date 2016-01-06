(function(){
  'use strict';
  angular.module('app.spielplan')
  .config(function($stateProvider){
    $stateProvider
    .state('spielplan', {
      url: '/spielplan',
      templateUrl: 'components/spielplan/spielplan.html',
      controller: 'SpielplanCtrl'
    });
  });
})();
