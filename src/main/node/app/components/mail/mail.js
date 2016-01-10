(function(){
  'use strict';

  angular.module('app.mail')
  .controller('MailCtrl', ['$scope', '$resource',  function($scope, $resource){

    console.log('hallo mail');

    var Mail = $resource('/api/mail');
    $scope.herren1 = Mail.query({team: 'herren1'});
    $scope.herren2 = Mail.query({team: 'herren2'});
    $scope.herren3 = Mail.query({team: 'herren3'});
    $scope.abteilungsrat = Mail.query({team: 'abteilungsrat'});

    console.log($scope.herren1);
  }]);
})();
