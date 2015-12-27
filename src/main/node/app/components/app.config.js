



angular.module('nodeApp')
.config(function ($routeProvider) {
  $routeProvider
    .when('/', {
      templateUrl: 'components/main/main.html',
      controller: 'MainCtrl'
    })
    .when('/about', {
      templateUrl: 'components/about/about.html',
      controller: 'AboutCtrl'
    })
    .when('/impressum', {
      templateUrl: 'components/impressum/impressum.html',
    })
    .when('/kontakt', {
      templateUrl: 'components/kontakt/kontakt.html',
      controller: 'KontaktCtrl'
    })
    .when('/spielplan', {
      templateUrl: 'components/spielplan/spielplan.html',
      controller: 'SpielplanCtrl'
    })
    .when('/training', {
      templateUrl: 'components/training/training.html',
      controller: 'TrainingCtrl'
    })
    .otherwise({
      redirectTo: '/'
    });
});
