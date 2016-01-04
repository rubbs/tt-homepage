(function(){
  'use strict';
  angular.module('app.spielplan')
  .config(function($stateProvider){
    $stateProvider
    .state('upload', {
      url: '/upload',
      templateUrl: 'components/spielplan/upload.html',
      controller: 'UploadCtrl'
    })
    .state('spielplan', {
      url: '/spielplan',
      templateUrl: 'components/spielplan/spielplan.html',
      controller: 'SpielplanCtrl'
    });
  });
})();
