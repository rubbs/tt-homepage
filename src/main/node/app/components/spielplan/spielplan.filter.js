(function(){
  'use strict';

  angular.module('app.spielplan')
  .filter('roman', function(){
    return function (input) {
		var roman = ['M','CM','D','CD','C','XC','L','XL','X','IX','V','IV','I'];
		var decimal = [1000,900,500,400,100,90,50,40,10,9,5,4,1];

		if(input <= 0 || input >= 4000){
			return input;
		}

		var romanNumeral = '';

		for(var i=0; i<roman.length; i++){
			while(input >= decimal[i]){
				input -= decimal[i];
				romanNumeral += roman[i];
			}
		}
      	return romanNumeral;
    };
  })
  .filter('homeMatch', function () {
    return function (input, enable) {
        if(!enable){
            return input;
        }
    	var ret = [];
    	for(var i=0; i<input.length; i++){
            var match = input[i];
    		if(match.home){
    			if(match.home.name === 'SF Gechingen'){
    				ret.push(match);
    			}
    		}
    	}
    	return ret;
    };
  });
})();
