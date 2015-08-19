angular.module('TypeProduct', []);
angular.module('TypeProduct')
        .controller('TypeProductController', function ($scope, $http) {

            $scope.typeProdunts = {};
            $scope.typeProdunt = {};

            $scope.error = {};

            loadTypeProduct();
            function loadTypeProduct() {
                $http.get('/loadtypeproduct').success(function (data) {
                    $scope.typeProdunts = data;
                }).error(function (data, status, header, config) {

                });
            }
            ;

            $scope.saveTypeProduct = function () {
                $http.post('/savetypeproduct', $scope.typeProdunt).success(function (data) {
                    Materialize.toast('saveข้อมูลเรียบร้อย', 3000, 'rounded');
                    loadTypeProduct();
                    $scope.typeProdunt = {};
                }).error(function (data, status, header, config) {
                    Materialize.toast('คุณกรอกข้อมูลไม่เรียบร้อย', 3000, 'rounded');
                    $scope.error = data;
                });
            };

            $scope.deleteTypeProduct = function (rowtypeproduct) {
                $http.post('/deletetypeproduct', rowtypeproduct).success(function (data) {
                    loadTypeProduct();
                    Materialize.toast('ลบข้อมูลเรียบร้อย', 3000, 'rounded');
                }).error(function (data, status, header, config) {
                    Materialize.toast('ลบไม่สำเร็จ', 3000, 'rounded');
                });
            };
            //  tag วัน   
            $('.datepicker').pickadate({
                selectMonths: true, // Creates a dropdown to control month
                selectYears: 15 // Creates a dropdown of 15 years to control year
            });

        });


