angular.module('Customer2', []);
angular.module('Customer2')
        .controller('CustomerController2', function ($scope, $http) {


            $scope.loadDetail = {};
            loadDetailCustomer();
            function loadDetailCustomer() {
                $http.get('/loaddetailcustomer').success(function (data) {
                    $scope.loadDetail = data.content[0];
                });
            }

        });





