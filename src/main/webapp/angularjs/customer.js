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
                    Materialize.toast('saveข้อมูลเรียบร้อย', 3000, 'rounded');
                    $scope.customer = {};
                }).error(function (data) {
                    $scope.error = data;
                    Materialize.toast('คุณกรอกข้อมูลไม่เรียบร้อย', 3000, 'rounded');
                });
            };

            $scope.deleteCustomer = function (rowcustomer) {
                $http.post('/customerdelete', rowcustomer).success(function (data) {
                    loadCustomer();
                    Materialize.toast('ลบข้อมูลเรียบร้อย', 3000, 'rounded');
                }).error(function (data, status, header, config) {
                    Materialize.toast('ลบไม่สำเร็จ', 3000, 'rounded');
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
            $scope.searchCustomer = function (keyword) {
                if (!keyword) {
                    loadCustomer();
                }
                else {
                    $http.post('/customer/search', keyword).success(function (data) {
                        $scope.customers = data;
                    });
                }
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


