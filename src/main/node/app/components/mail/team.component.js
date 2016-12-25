

(function () {
  'use strict';
  var module = angular.module('app.mail');
  module.component('sfgTeam', {
    bindings: {
      name: '<'
    },
    controller: TeamCtrl,
    templateUrl: 'components/mail/team.component.html'
  });

  TeamCtrl.$inject = ['$scope'];
  function TeamCtrl($scope) {
    var vm = this;

    activate();


    function activate() {
      console.log('activate Team', vm);

      gapi.client.sfgTTApi.playersOfList({name: vm.name}).execute(function (resp) {
         console.log('resp', resp);
        vm.players = resp.items;
        $scope.$apply();
      });
    }
  }
})();
