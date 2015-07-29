angular.module('Employee', []);
angular.module('Employee', [])
        .controller('EmployeeController', function ($scope, $http) {
            $scope.employees = {};
            $scope.employee = {};


            loadEmployee();
            function loadEmployee() {
                $http.get('/loadstaff').success(function (data) {
                    $scope.employees = data;
                }).error(function (data, status, header, config) {

                });
            }
            ;

            $scope.saveEmployee = function () {
                $http.post('/saveStaff', $scope.employee).success(function (data) {
                    alert('saveข้อมูลเรียบร้อย');

                }).error(function (data, status, header, config) {
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

            $scope.page = 1;
            $scope.nextPage = function () {
                $scope.page = 2;
            };
            $scope.backPage = function () {
                $scope.page = 1;
            };

        });



