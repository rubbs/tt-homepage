(function(){
  'use strict';

angular.module('app.training')
.config(function($stateProvider){
  $stateProvider
  .state('training', {
    url: '/training',
    templateUrl: 'components/training/training.html',
    controller: 'TrainingCtrl'
  });
});

})();
