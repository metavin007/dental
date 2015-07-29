angular.module('Doctor', []);
angular.module('Doctor', [])
        .controller('DoctorController', function ($scope, $http) {
            $scope.doctors = {};
            $scope.doctor = {};
            
            
            loadDoctor();
            function loadDoctor(){
                $http.get('/loaddoctor').success(function (data){
                    $scope.doctors = data;
                }).error(function (data,status,header,config){
                    
                });
            };
            
            $scope.saveDoctor = function () {
              $http.post('/savedoctor',$scope.doctor).success(function (data){
                    alert('saveข้อมูลเรียบร้อย');
                    
              }).error(function (data,status,header,config){
                    alert('saveข้อมูลล้มเหลว');
              });                   
            };
            
            $scope.delectDoctor = function (rowedoctor){
               $http.post('/deletedoctor',rowedoctor).success(function (data){
                    loadDoctor();
                    alert('ลบข้อมูลเรียบร้อย');
               }).error(function (data,status,header,config){
                   alert('ลบข้อมูลล้มเหลว');
               });
            };
            
        });



