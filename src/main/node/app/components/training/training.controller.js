'use strict';

/**
 * @ngdoc function
 * @name homepageSfgTtApp.controller:TrainingCtrl
 * @description
 * # TrainingCtrl
 * Controller of the homepageSfgTtApp
 */
angular.module('app.training')
  .controller('TrainingCtrl', function ($scope) {
    $scope.trainings = [
    {
      'tag': 'Dienstag (September - April)',
      'ort': 'Sporthalle am Wasserturm',
      'uhrzeit': '19:15 - 21:45 Uhr'
    },
    {
      'tag': 'Freitag (September - April)',
      'ort': 'Schulturnhalle',
      'uhrzeit': '18:00 - 21:45 Uhr'
    },
    {
      'tag': 'Dienstag (Mai - August)',
      'ort': 'Sporthalle am Wasserturm',
      'uhrzeit': '19:15 - 21:45 Uhr'
    },
    {
      'tag': 'Freitag (Mai - August)',
      'ort': 'Schulturnhalle',
      'uhrzeit': '18:00 - 21:45 Uhr'
    }
    ];
  });
