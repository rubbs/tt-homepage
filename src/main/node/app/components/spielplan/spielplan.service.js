(function(){
  'use strict';

  angular.module('app.spielplan')
  .factory('spielplan', ['$resource', function ($resource) {
    // Service logic
    // ...
    return $resource(
      '/api/matches'
    );

  }])
  .directive('fileModel', [ '$parse', function ($parse) {
 	return {
 		restrict: 'A',
 		link: function postLink(scope, element, attrs) {
 			var model = $parse(attrs.fileModel);
 			var modelSetter = model.assign;

 			element.bind('change', function(){
 				scope.$apply(function(){
 					if (element[0].files.length > 1) {
 						modelSetter(scope, element[0].files);
 					}
 					else {
 						modelSetter(scope, element[0].files[0]);
 					}
 				});
 			});
 		}
 	};
 }]);
})();
