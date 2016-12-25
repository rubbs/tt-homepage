(function(){
  'use strict';
  angular.module('app.mail')
  .config(function($stateProvider){
    $stateProvider
    .state('mail', {
      url: '/mail',
      templateUrl: 'components/mail/mail.html',
      controller: 'MailCtrl',
      controllerAs: '$ctrl',
      resolve: {teams: loadTeams}
    });
  });

  loadTeams.$inject = ['$q'];

  function loadTeams($q) {
    var deferred = $q.defer();
    gapi.client.sfgTTApi.mailLists().execute(function (resp) {

      console.log(resp);
      var teams = resp.items;
      deferred.resolve(teams);
    });
    return deferred.promise;
  }
})();
