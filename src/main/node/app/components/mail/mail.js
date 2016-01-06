(function(){
  'use strict';

  angular.module('app.mail')
  .controller('MailCtrl', ['$scope', '$resource', 'BaseUrl', function($scope, $resource, BaseUrl){

    console.log('hallo mail');

    //TODO baseUrl

    var Mail = $resource(BaseUrl + '/api/mail');
    $scope.herren1 = Mail.query({team: 'herren1'});
    $scope.herren2 = Mail.query({team: 'herren2'});
    $scope.herren3 = Mail.query({team: 'herren3'});
    $scope.abteilungsrat = Mail.query({team: 'abteilungsrat'});

    console.log($scope.herren1);
  }]);
})();
