angular.module('Product', []);
angular.module('Product')
        .controller('ProductController', function ($scope, $http) {

            $scope.products = {};
            $scope.product = {};
            $scope.typeProducts = {};
            $scope.unitProducts = {};

            $scope.error = {};

            loadProduct();
            function loadProduct() {
                $http.get('/loadproduct').success(function (data) {
                    $scope.products = data;
                }).error(function (data, status, header, config) {

                });
            }

            loadTypeProduct();
            function loadTypeProduct() {
                $http.get('/loadtypeproduct').success(function (data) {
                    $scope.typeProducts = data;
                }).error(function (data, status, header, config) {

                });
            }

            loadUnitProduct();
            function loadUnitProduct() {
                $http.get('/loadunit').success(function (data) {
                    $scope.unitProducts = data;
                }).error(function (data, status, header, config) {

                });
            }

            $scope.saveProduct = function () {
                $http.post('/saveproduct', $scope.product).success(function (data) {
                    $scope.product = {};
                    Materialize.toast('saveข้อมูลเรียบร้อย', 3000, 'rounded');
                }).error(function (data, status, header, config) {
                    Materialize.toast('คุณกรอกข้อมูลไม่เรียบร้อย', 3000, 'rounded');
                    $scope.error = data;
                });
            };

            $scope.deleteProduct = function (rowproduct) {
                $http.post('/deleteproduct', rowproduct).success(function (data) {
                    loadProduct();
                    Materialize.toast('ลบข้อมูลเรียบร้อย', 3000, 'rounded');
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




