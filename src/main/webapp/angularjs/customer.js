angular.module('Customer', []);
angular.module('Customer', ['checklist-model'])
        .controller('CustomerController', function ($scope, $http) {
            $scope.customer = {};
            $scope.customers = {};
            $scope.medicalhistorys = {};

            $scope.error = {};


            loadCustomer();
            function loadCustomer() {
                $http.get('/customer').success(function (data) {
                    $scope.customers = data;
                }).error(function (data, status, header, config) {

                });
            }
            ;

            $scope.saveCustomer = function () {
                $http.post('/customer', $scope.customer).success(function (data) {
                    alert('saveข้อมูลเรียบร้อย');
                    $scope.customer = {};
                }).error(function (data) {
                    $scope.error = data;
                    alert('คุณกรอกข้อมูลไม่เรียบร้อย');
                });
            };

            $scope.deleteCustomer = function (rowcustomer) {
                $http.post('/customerdelete', rowcustomer).success(function (data) {
                    loadCustomer();
                    alert('ลบข้อมูลเรียบร้อย');
                }).error(function (data, status, header, config) {
                    alert('ลบไม่สำเร็จ');
                });
            };


            loadMedicalHistory();
            function loadMedicalHistory() {
                $http.get('/medicalhistory').success(function (data) {
                    $scope.medicalhistorys = data;
                }).error(function (data, status, header, config) {

                });
            }
            ;


            $scope.selectDetail = {};
            $scope.selectDetailCustomer = function (rowDetailCustomer) {
                $http.post('/selectdetailcustomer', rowDetailCustomer).success(function (data) {
                    $scope.selectDetail = data;
                }).error(function (data, status, header, config) {
                });
            };


            $scope.keyword = null;
            $scope.searchCustomer = function () {

                if (!$scope.keyword) {
                    loadCustomer();
                }
                $http.post('/customer/search', $scope.keyword).success(function (data) {
                    $scope.customers = data;
                });
            };

//tag select
//            $(document).ready(function () {
//                $('select').material_select();
//            });

//  tag วันเกิด       
            $('.datepicker').pickadate({
                selectMonths: true, // Creates a dropdown to control month
                selectYears: 15 // Creates a dropdown of 15 years to control year
            });



        });


