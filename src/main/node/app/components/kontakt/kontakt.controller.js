'use strict';

/**
 * @ngdoc function
 * @name homepageSfgTtApp.controller:KontaktCtrl
 * @description
 * # KontaktCtrl
 * Controller of the homepageSfgTtApp
 */
angular.module('app.kontakt')
  .controller('KontaktCtrl', ['$scope', '$timeout', 'kontakt', 'ngDialog', function ($scope, $timeout, kontakt, ngDialog) {
    $scope.onSend = function(){
      // parse text out of textarea

      var text = angular.element("#message");

      var message = {
        user: ' ' + $scope.user,
        msg: ' ' + text.val()
      }

      kontakt.save(message, function(){
        console.log("success");
        var dialog = ngDialog.open({
          template: '<p>Email gesendet!</p>',
          plain: true
        });


        $timeout(function(){
          dialog.close();
          text.val('');
        $scope.user = '';
        }, 2000)
      });
    }
  }]);
