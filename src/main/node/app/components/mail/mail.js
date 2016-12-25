(function(){
  'use strict';

  var module = angular.module('app.mail');
  module.controller('MailCtrl', MailCtrl);

  MailCtrl.$inject = ['teams'];

  function MailCtrl(teams){
    var vm = this;

    console.log('teams', teams);

    vm.teams = teams;

  }
})();
