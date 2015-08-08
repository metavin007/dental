angular.module('Employee', []);
angular.module('Employee', ['checklist-model'])
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
                });
            }
            ;

            $scope.saveEmployee = function () {
                $http.post('/saveStaff', $scope.employee).success(function (data) {
                    Materialize.toast('saveข้อมูลเรียบร้อย', 3000, 'rounded'); 
                    $scope.employee = {};
                }).error(function (data, status, header, config) {
                    $scope.error = data;
                    Materialize.toast('คุณกรอกข้อมูลไม่เรียบร้อย', 3000, 'rounded');
                });
            };

            $scope.delectEmployee = function (rowemployee) {
                $http.post('/deleteStaff', rowemployee).success(function (data) {
                    loadEmployee();
                    Materialize.toast('ลบข้อมูลเรียบร้อย', 3000, 'rounded');
                }).error(function (data, status, header, config) {
                    Materialize.toast('ลบไม่สำเร็จ', 3000, 'rounded');
                });
            };


            loadDepartment();
            function loadDepartment() {
                $http.get('/loaddepartmentemployee').success(function (data) {
                    $scope.departments = data;
                }).error(function (data, status, header, config) {

                });
            }
            ;


            loadAuthority();
            function loadAuthority() {
                $http.get('/loadauthority').success(function (data) {
                    $scope.authorities = data;

                }).error(function (data, status, header, config) {

                });
            }
            ;


            $scope.page = 1;
            $scope.nextPage = function () {
                $scope.page = 2;
            };
            $scope.backPage = function () {
                $scope.page = 1;
            };

            //  tag วันเกิด       
            $('.datepicker').pickadate({
                selectMonths: true, // Creates a dropdown to control month
                selectYears: 15 // Creates a dropdown of 15 years to control year
            });


        });



