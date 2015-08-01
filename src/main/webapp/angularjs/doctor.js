angular.module('Doctor', []);
angular.module('Doctor')
        .controller('DoctorController', function ($scope, $http) {
            $scope.doctors = {};
            $scope.doctor = {};

            $scope.error = {};

            loadDoctor();
            function loadDoctor() {
                $http.get('/loaddoctor').success(function (data) {
                    $scope.doctors = data;
                }).error(function (data, status, header, config) {

                });
            }
            ;

            $scope.saveDoctor = function () {
                $http.post('/savedoctor', $scope.doctor).success(function (data) {
                    alert('saveข้อมูลเรียบร้อย');
                    $scope.doctor = {};
                }).error(function (data, status, header, config) {
                    $scope.error = data;
                    alert('saveข้อมูลล้มเหลว');
                });
            };

            $scope.delectDoctor = function (rowdoctor) {
                $http.post('/deletedoctor', rowdoctor).success(function (data) {
                    loadDoctor();
                    alert('ลบข้อมูลเรียบร้อย');
                }).error(function (data, status, header, config) {
                    alert('ลบข้อมูลล้มเหลว');
                });
            };

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

        });



