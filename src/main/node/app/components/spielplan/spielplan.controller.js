/*global jsPDF:false */
'use strict';

/**
* @ngdoc function
* @name homepageSfgTtApp.controller:SpielplanCtrl
* @description
* # SpielplanCtrl
* Controller of the homepageSfgTtApp
*/
angular.module('app.spielplan')
.controller('SpielplanCtrl', ['$scope', '$filter', '$timeout', 'spielplan', function ($scope, $filter, $timeout, spielplan) {
  $scope.spielplan = spielplan.query(function(){
    // for (var m in $scope.spielplan){
    //   var match = $scope.spielplan[m];
    //   console.log(match);
    //   // match.begin = new Date(match.date);
    //   // match.end = new Date(match.date);
    //   // match.end.setHours(match.end.getHours() + 3);
    // }
  });

  $scope.matchClass = function(match){
    console.log(match);
    if(match.date < Date.now()){
      return 'gray';
    }
    else {
      return 'green';
    }
  };

  $scope.teamFilterFunction = function(element){
    if($scope.team.name === 'Alle'){
      return true;
    }
    if(element.HeimVereinNr === 12015){
      if($scope.team.Altersklasse === element.HeimMannschaftAltersklasse){
        if($scope.team.MannschaftNr === element.HeimMannschaftNr){
          return true;
        }
      }
    }
    else{
      if($scope.team.Altersklasse === element.GastMannschaftAltersklasse){
        if($scope.team.MannschaftNr === element.GastMannschaftNr){
          return true;
        }
      }
    }

    return false;
  };

  $scope.homeFilterFunction = function(element){
    if($scope.home){
      if(element.GastVereinName === 'SF Gechingen'){
        return false;
      }
    }
    return true;
  };

  $scope.onPdf = function () {
    console.log('onPdf');
    /*jshint newcap: false */
    var pdf = new jsPDF();

    // write title
    pdf.setFontSize(22);
    pdf.text(20,20, 'Terminplan SfG Tischtennis');
    pdf.setFontSize(16);

    pdf.line(10, 30, 200, 30);


    // iterate over matches
    var y = 40;
    var lineHeight = 8;
    var matchesPerPage = 30;

    pdf.setFontSize(12);
    var ordered = $filter('orderBy')($scope.spielplan, 'date');
    for(var m in ordered){
      var match = ordered[m];

      // check if new page is neccessary
      // console.log(m > 0, m % matchesPerPage );
      if(m % matchesPerPage === 0 && m > 0){
        console.log('new page');
        pdf.addPage();
      }

      // calculate yval
      var yval = y + (m % matchesPerPage) * lineHeight;


      // Datum  Uhrzeit  Altersklasse  Heim  Gast  Ergebniss
      var date = $filter('date')(match.date, 'dd.MM.yyyy');
      var time = $filter('date')(match.date, 'HH:mm') + ' Uhr';
      var age = match.age;
      var home = $filter('limitTo')(match.home.name + ' ' + match.home.number, 20);
      var away = $filter('limitTo')(match.away.name + ' ' + match.away.number, 20);
      var result = match.home.points + ' : ' + match.away.points;

      // console.log(date, time, age, home, away, result);

      var xval = 15;
      pdf.text(xval, yval, date);
      xval += 25;

      pdf.text(xval, yval, time);
      xval += 20;
      pdf.text(xval, yval, age);
      xval += 15;
      pdf.text(xval, yval, home);
      xval += 45;
      pdf.text(xval, yval, away);
      xval += 45;
      pdf.text(xval, yval, result);
    }


    pdf.save('SpielplanSfgTischtennis.pdf');

  };

}])

.controller('UploadCtrl', ['$scope', '$http', 'spielplan', function ($scope, $http, spielplan) {


  $scope.onSubmit = function () {
    console.log('file name', $scope.filename);




    if($scope.filename){
      console.log(JSON.stringify($scope.filename));

      spielplan.get({init: true}, function(success){
        console.log(success);


        var formData = new FormData();

        formData.append('file', $scope.filename);
        console.log(formData);
        $http(
          {
            method: 'POST',
            url: success.url,
            data: formData,
            headers: {'Content-Type': undefined},
            transformRequest: angular.identity
          })
          .success(function() {
            console.log('upload success');
          });
        });

      }


    };
  }]);
