angular.module('ProductLot', []);
angular.module('ProductLot')
        .controller('ProductLotController', function ($scope, $http) {

            $scope.productLot = {};
            $scope.productLots = {};

            $scope.products = {};
            $scope.lots = {};

            loadProductLot();
            function loadProductLot() {
                $http.get('/loadproductlot').success(function (data) {
                    $scope.productLots = data;
                }).error(function (data, status, header, config) {

                });
            }

            $scope.saveProductLot = function () {
                $http.post('/saveproductlot', $scope.productLot).success(function (data) {
                    Materialize.toast('saveข้อมูลเรียบร้อย', 3000, 'rounded');
                    loadProductLot();
                    $scope.productLot = {};
                }).error(function (data, status, header, config) {
                    Materialize.toast('คุณกรอกข้อมูลไม่เรียบร้อย', 3000, 'rounded');
                });
            };

            $scope.deleteProductLot = function (columnproductLot) {
                $http.post('/deleteductlot',columnproductLot).success(function (data) {
                    Materialize.toast('ลบข้อมูลเรียบร้อย', 3000, 'rounded');
                    loadProductLot();
                }).error(function (data, status, header, config) {
                    Materialize.toast('ลบไม่สำเร็จ', 3000, 'rounded');
                });
            };

            loadProduct();
            function loadProduct() {
                $http.get('/loadproduct').success(function (data) {
                    $scope.products = data;
                }).error(function (data, status, header, config) {

                });
            }

            loadLot();
            function loadLot() {
                $http.get('/loadlot').success(function (data) {
                    $scope.lots = data;
                }).error(function (data, status, header, config) {

                });
            }
            //  tag วันเกิด       
            $('.datepicker').pickadate({
                selectMonths: true, // Creates a dropdown to control month
                selectYears: 15 // Creates a dropdown of 15 years to control year
            });

        });

