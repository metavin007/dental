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
                    Materialize.toast('saveข้อมูลเรียบร้อย', 3000, 'rounded'); 
                    $scope.doctor = {};
                }).error(function (data, status, header, config) {
                    $scope.error = data;
                    Materialize.toast('คุณกรอกข้อมูลไม่เรียบร้อย', 3000, 'rounded');
                });
            };

            $scope.delectDoctor = function (rowdoctor) {
                $http.post('/deletedoctor', rowdoctor).success(function (data) {
                    loadDoctor();
                    Materialize.toast('ลบข้อมูลเรียบร้อย', 3000, 'rounded');
                }).error(function (data, status, header, config) {
                    Materialize.toast('ลบไม่สำเร็จ', 3000, 'rounded');
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
//  tag วันเกิด       
            $('.datepicker').pickadate({
                selectMonths: true, // Creates a dropdown to control month
                selectYears: 15 // Creates a dropdown of 15 years to control year
            });

        });



