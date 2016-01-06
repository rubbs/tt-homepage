(function(){

  'use strict';

angular.module('nodeApp')
.config(function($stateProvider, $urlRouterProvider){
  $urlRouterProvider.otherwise('/');

  // $locationProvider.html5Mode(true);
})
.constant('BaseUrl', (function(){
  if (document.location.hostname === 'localhost'){
    return 'http://localhost:8080';
  }
    else {
      return '';
    }
  })()
);
// .config(function ($routeProvider) {
//   $routeProvider
//     .when('/', {
//       templateUrl: 'components/main/main.html',
//       controller: 'MainCtrl'
//     })
//     .when('/about', {
//       templateUrl: 'components/about/about.html',
//       controller: 'AboutCtrl'
//     })
//     .when('/impressum', {
//       templateUrl: 'components/impressum/impressum.html',
//     })
//     .when('/kontakt', {
//       templateUrl: 'components/kontakt/kontakt.html',
//       controller: 'KontaktCtrl'
//     })
//     .when('/spielplan', {
//       templateUrl: 'components/spielplan/spielplan.html',
//       controller: 'SpielplanCtrl'
//     })
//     .when('/training', {
//       templateUrl: 'components/training/training.html',
//       controller: 'TrainingCtrl'
//     })
//     .when('/mail', {
//       templateUrl: 'components/mail/mail.html',
//       controller: 'MailCtrl'
//     })
//     .otherwise({
//       redirectTo: '/'
//     });
// });

})();
