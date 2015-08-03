angular.module('Employee', []);
angular.module('Employee',['checklist-model'])
        .controller('EmployeeController', function ($scope, $http) {
            $scope.employees = {};
            $scope.employee = {};

            $scope.departments = {};
            $scope.authorities = {};
            
             $scope.error = {};


            loadEmployee();
            function loadEmployee() {
                $http.get('/loadstaff').success(function (data) {
                    $scope.employees = data;
                }).error(function (data, status, header, config) {
alert('xxxxxx');
                });
            };

            $scope.saveEmployee = function () {
                $http.post('/saveStaff', $scope.employee).success(function (data) {
                    alert('saveข้อมูลเรียบร้อย');
                    $scope.employee = {};
                }).error(function (data, status, header, config) {
                    $scope.error = data;
                    alert('saveข้อมูลล้มเหลว');
                });
            };

            $scope.delectEmployee = function (rowemployee) {
                $http.post('/deleteStaff', rowemployee).success(function (data) {
                    loadEmployee();
                    alert('ลบข้อมูลเรียบร้อย');
                }).error(function (data, status, header, config) {
                    alert('ลบข้อมูลล้มเหลว');
                });
            };


            loadDepartment();
            function loadDepartment() {
                $http.get('/loaddepartmentemployee').success(function (data) {
                    $scope.departments = data;
                }).error(function (data, status, header, config) {

                });
            };
            
            
            loadAuthority();
            function loadAuthority(){
                $http.get('/loadauthority').success(function (data) {
                    $scope.authorities = data;
                    
                }).error(function (data, status, header, config){
                    
                });
            };
            
            
            $scope.page = 1;
            $scope.nextPage = function () {
                $scope.page = 2;
            };
            $scope.backPage = function () {
                $scope.page = 1;
            };

        });



