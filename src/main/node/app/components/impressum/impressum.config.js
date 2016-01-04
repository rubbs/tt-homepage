(function(){
'use strict';
angular.module('app.impressum')
.config(function($stateProvider){
  $stateProvider
  .state('impressum', {
    url: '/impressum',
    templateUrl: 'components/impressum/impressum.html'
  });
});

})();
