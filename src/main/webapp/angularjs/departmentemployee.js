angular.module('Department', []);
angular.module('Department', [])
        .controller('DepartmentController', function ($scope, $http) {
            $scope.departments = {};
            $scope.department = {};

            $scope.error = {};

            loadDepartment();
            function loadDepartment() {
                $http.get('/loaddepartmentemployee').success(function (data) {
                    $scope.departments = data;
                }).error(function (data, status, header, config) {

                });
            }
            ;

            $scope.saveDepartment = function () {
                $http.post('/savedepartmentemployee', $scope.department).success(function (data) {
                    Materialize.toast('saveข้อมูลเรียบร้อย', 3000, 'rounded');
                    loadDepartment();
                    $scope.department = {};
                }).error(function (data, status, header, config) {
                    $scope.error = data;
                    Materialize.toast('คุณกรอกข้อมูลไม่เรียบร้อย', 3000, 'rounded');
                });
            };

            $scope.delectDepartment = function (rowdepartment) {
                $http.post('/deletedepartmentemployee', rowdepartment).success(function (data) {
                    loadDepartment();
                    Materialize.toast('ลบข้อมูลเรียบร้อย', 3000, 'rounded');
                }).error(function (data, status, header, config) {
                    Materialize.toast('ลบไม่สำเร็จ', 3000, 'rounded');
                });
            };

        });



