/* global angular */

angular.module('DetailHealAndPayheal', []);
angular.module('DetailHealAndPayheal')
        .controller('DetailHealAndPayhealController', function ($scope, $http) {

            $scope.detailHeal = {};
            $scope.detailHeals = {};

            $scope.customers = {};
            $scope.doctors = {};

            $scope.listPayHeals = {};

            $scope.detailHeal = {};
            $scope.payHeals = [];

            loadDetailHeal();
            function loadDetailHeal() {
                $http.get('/loaddetailheal').success(function (data) {
                    $scope.detailHeals = data;
                }).error(function (data, status, header, cofig) {

                });
            }

            $scope.saveDetailheal = function () {
                $http.post('/savedetailheal', $scope.detailHeal).success(function (data) {
                    $http.post('/savepayheal', $scope.payHeals).success(function (data) {
                        Materialize.toast('saveข้อมูลเรียบร้อย', 3000, 'rounded');
                        loadDetailHeal();
                        $scope.detailHeal = {};
                        $scope.payHeals = [];
                        $scope.nameListPayHeal = '';
                        $scope.amountListPayHeal = '';
                    }).error(function (data, status, header, cofig) {
                        Materialize.toast('ผิดพลาดsavedetailHeal', 3000, 'rounded');
                    });
                }).error(function (data, status, header, cofig) {

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

            $scope.addRow = function (name) {
                if (!$scope.nameListPayHeal) {
                    Materialize.toast('คุณไม่ระบุข้อมูล', 3000, 'rounded');
                } else {
                    if ($scope.payHeals.length === 0) {
                        $scope.payHeals.push({'listPayHeal': $scope.nameListPayHeal,
                            'value': $scope.amountListPayHeal});
                        $scope.nameListPayHeal = '';
                        $scope.amountListPayHeal = '';
                    } else {
                        var flag = false;
                        for (var i = 0; i < $scope.payHeals.length; i++) {
                            if ($scope.payHeals[i].listPayHeal.name === name.name) {
                                $scope.payHeals[i] = {'listPayHeal': $scope.nameListPayHeal,
                                    'value': $scope.amountListPayHeal};
                                $scope.nameListPayHeal = '';
                                $scope.amountListPayHeal = '';
                                flag = true;
                                break;
                            }
                        }
                        if (flag === false) {
                            $scope.payHeals.push({'listPayHeal': $scope.nameListPayHeal,
                                'value': $scope.amountListPayHeal});
                            $scope.nameListPayHeal = '';
                            $scope.amountListPayHeal = '';
                        }
                    }

                }
                console.log($scope.payHeals);
            };

            $scope.removeRow = function (name) {
                var index = -1;
                var rowData = eval($scope.payHeals);
                for (var i = 0; i < rowData.length; i++) {
                    if (rowData[i].selectListName.name === name) {
                        index = i;
                        break;
                    }
                }
                if (index === -1) {
                    Materialize.toast('บางอย่างผิดพลาด', 3000, 'rounded');
                }
                $scope.payHeals.splice(index, 1);
            };

            //  tag วัน   
            $('.datepicker').pickadate({
                selectMonths: true, // Creates a dropdown to control month
                selectYears: 15 // Creates a dropdown of 15 years to control year
            });

            $(document).ready(function () {
                $('.modal-trigger').leanModal();
            });

        });


