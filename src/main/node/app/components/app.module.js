'use strict';

/**
 * @ngdoc overview
 * @name nodeApp
 * @description
 * # nodeApp
 *
 * Main module of the application.
 */
angular
  .module('nodeApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ui.router',
    'ngSanitize',
    'ngMaterial',
    /*
    app specific
     */
    'app.kontakt',
    'app.main',
    'app.spielplan',
    'app.training',
    'app.mail',
    'app.impressum'
  ]);
