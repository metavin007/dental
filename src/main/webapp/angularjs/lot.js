angular.module('Lot', []);
angular.module('Lot')
        .controller('LotController', function ($scope, $http) {

            $scope.lot = {};
            $scope.lots = {};

            loadLot();
            function loadLot() {
                $http.get('/loadlot').success(function (data) {
                    $scope.lots = data;
                }).error(function (data, status, header, config) {

                });
            }

            $scope.saveLot = function () {
                $http.post('/savelot', $scope.lot).success(function (data) {
                    Materialize.toast('saveข้อมูลเรียบร้อย', 3000, 'rounded');
                    loadLot();
                    $scope.typeProdunt = {};
                }).error(function (data, status, header, config) {
                    Materialize.toast('คุณกรอกข้อมูลไม่เรียบร้อย', 3000, 'rounded');
                });
            };

            $scope.deleteLot = function (rowLot) {
                $http.post('/deletelot', rowLot).success(function (data) {
                    Materialize.toast('ลบข้อมูลเรียบร้อย', 3000, 'rounded');
                    loadLot();
                }).error(function (data, status, header, config) {
                    Materialize.toast('ลบไม่สำเร็จ', 3000, 'rounded');
                });
            };

            //  tag วันเกิด       
            $('.datepicker').pickadate({
                selectMonths: true, // Creates a dropdown to control month
                selectYears: 15 // Creates a dropdown of 15 years to control year
            });
        });


