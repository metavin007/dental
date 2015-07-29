angular.module('Department', []);
angular.module('Department', [])
        .controller('DepartmentController', function ($scope, $http) {
            $scope.departments = {};
            $scope.department = {};
            
            
            loadDepartment();
            function loadDepartment(){
                $http.get('/loaddepartmentemployee').success(function (data){
                    $scope.departments = data;
                }).error(function (data,status,header,config){
                    
                });
            };
            
            $scope.saveDepartment = function () {
              $http.post('/savedepartmentemployee',$scope.department).success(function (data){
                    alert('saveข้อมูลเรียบร้อย');
                    loadDepartment();
              }).error(function (data,status,header,config){
                    alert('saveข้อมูลล้มเหลว');
              });                   
            };
            
            $scope.delectDepartment = function (rowdepartment){
               $http.post('/deletedepartmentemployee',rowdepartment).success(function (data){
                    loadDepartment();
                    alert('ลบข้อมูลเรียบร้อย');
               }).error(function (data,status,header,config){
                   alert('ลบข้อมูลล้มเหลว');
               });
            };
            
        });



