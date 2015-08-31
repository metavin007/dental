angular.module('DetailHealAndPayheal', []);
angular.module('DetailHealAndPayheal')
        .controller('DetailHealAndPayhealController', function ($scope, $http) {

            $scope.detailHeal = {};
            $scope.detailHeals = {};

            $scope.customers = {};
            $scope.doctors = {};
            $scope.listPayHeals = {};
            $scope.listPayHeal = {};


            loadDetailHeal();
            function loadDetailHeal() {
                $http.get('/loaddetailheal').success(function (data) {
                    $scope.detailHeals = data;
                }).error(function (data, status, header, cofig) {

                });
            }

            $scope.saveDetailheal = function () {
                $http.post('/savedetailheal', $scope.detailHeal).success(function (data) {
                    Materialize.toast('saveข้อมูลเรียบร้อย', 3000, 'rounded');
                    loadDetailHeal();
                    $scope.detailHeal = {};
                }).error(function (data, status, header, cofig) {
                    Materialize.toast('คุณกรอกข้อมูลไม่เรียบร้อย', 3000, 'rounded');
                });
            };

            $scope.deleteDetailheal = function (rowdetailheal) {
                $http.post('/deletedetailheal', rowdetailheal).success(function (data) {
                    Materialize.toast('ลบข้อมูลเรียบร้อย', 3000, 'rounded');
                    loadDetailHeal();
                }).error(function (data, status, header, config) {
                    Materialize.toast('ลบไม่สำเร็จ', 3000, 'rounded');
                });
            };

            loadCustomer();
            function loadCustomer() {
                $http.get('/customer').success(function (data) {
                    $scope.customers = data;
                }).error(function (data, status, header, config) {

                });
            }
            ;


            loadDoctor();
            function loadDoctor() {
                $http.get('/loaddoctor').success(function (data) {
                    $scope.doctors = data;
                }).error(function (data, status, header, config) {

                });
            }
            ;


            loadListPayHeal();
            function loadListPayHeal() {
                $http.get('/loadlistpayheal').success(function (data) {
                    $scope.listPayHeals = data;
                }).error(function (data, status, header, config) {

                });
            }
            ;

            //  tag วัน   
            $('.datepicker').pickadate({
                selectMonths: true, // Creates a dropdown to control month
                selectYears: 15 // Creates a dropdown of 15 years to control year
            });
            
            $(document).ready(function () {
                $('.modal-trigger').leanModal();
            });

        });


