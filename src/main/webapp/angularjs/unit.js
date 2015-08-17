angular.module('Unit', []);
angular.module('Unit')
        .controller('UnitController', function ($scope, $http) {

            $scope.unit = {};
            $scope.units = {};

            $scope.error = {};
            
            loadunit();
            function loadunit() {
                $http.get('/loadunit').success(function (data) {
                    $scope.units = data;
                }).error(function (data, status, header, config) {

                });
            }

            $scope.saveunit = function () {
                $http.post('/saveunit', $scope.unit).success(function (data) {
                    $scope.unit = {};
                    loadunit();
                    Materialize.toast('saveข้อมูลเรียบร้อย', 3000, 'rounded');
                }).error(function (data, status, header, config) {
                    Materialize.toast('คุณกรอกข้อมูลไม่เรียบร้อย', 3000, 'rounded');
                    $scope.error = data;
                });
            };

            $scope.deleteunit = function (rowunit) {
                $http.post('/deleteunit', rowunit).success(function (data) {
                    loadunit();
                    Materialize.toast('ลบข้อมูลเรียบร้อย', 3000, 'rounded');
                }).error(function (data, status, header, config) {
                    Materialize.toast('ลบไม่สำเร็จ', 3000, 'rounded');
                });
            };
        });
