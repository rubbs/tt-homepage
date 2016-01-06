(function(){
  'use strict';
  angular.module('app.mail')
  .config(function($stateProvider){
    $stateProvider
    .state('mail', {
      url: '/mail',
      templateUrl: 'components/mail/mail.html',
      controller: 'MailCtrl'
    });
  });
})();
