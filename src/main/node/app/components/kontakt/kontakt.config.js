(function(){
  'use strict';
  angular.module('app.kontakt')
  .config(function($stateProvider){
    $stateProvider
    .state('kontakt', {
      url: '/kontakt',
      templateUrl: 'components/kontakt/kontakt.html',
      controller: 'KontaktCtrl'
    });
  });

})();
