angular.module('ListPayHeal', []);
angular.module('ListPayHeal')
        .controller('ListPayHealController', function ($scope, $http) {

            $scope.listPayHeal = {};
            $scope.listPayHeals = {};


            loadListPayHeal();
            function loadListPayHeal() {
                $http.get("/loadlistpayheal").success(function (data) {
                    $scope.listPayHeals = data;
                }).error(function (data, status, header, config) {

                });
            }

            $scope.saveListPayHeal = function () {
                $http.post("/savelistpayheal", $scope.listPayHeal).success(function (data) {
                    Materialize.toast('saveข้อมูลเรียบร้อย', 3000, 'rounded');
                    loadListPayHeal();
                    $scope.listPayHeal = {};
                }).error(function (data, status, header, config) {
                    Materialize.toast('คุณกรอกข้อมูลไม่เรียบร้อย', 3000, 'rounded');
                });
            };

            $scope.deleteListPayHeal = function (rowlistpayheal) {
                $http.post("/deletelistpayheal", rowlistpayheal).success(function (data) {
                    Materialize.toast('ลบข้อมูลเรียบร้อย', 3000, 'rounded');
                    loadListPayHeal();
                }).error(function (data, status, header, config) {
                    Materialize.toast('ลบไม่สำเร็จ', 3000, 'rounded');
                });
            };

        });
