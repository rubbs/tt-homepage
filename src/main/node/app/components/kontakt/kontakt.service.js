'use strict';

/**
 * @ngdoc service
 * @name app.kontakt
 * @description
 * # kontakt
 * Factory in the homepageSfgTtApp.
 */
angular.module('app.kontakt')
  .factory('kontakt', ['$resource', function ($resource) {
    // Service logic
    // ...
    return $resource(
      '/kontakt'
    );

  }]);
