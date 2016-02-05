(function(){

  'use strict';

angular.module('nodeApp')
.config(function($stateProvider, $urlRouterProvider, $mdThemingProvider){
  $urlRouterProvider.otherwise('/');

  // configure color theme

  $mdThemingProvider.theme('default')
    .primaryPalette('lime')
    .accentPalette('orange');
  // $locationProvider.html5Mode(true);
});
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
