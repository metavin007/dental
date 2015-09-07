angular.module('Bill', []);
angular.module('Bill', [])
        .controller('BillController', function ($scope, $http) {

            $scope.orderProducts = {};
            $scope.orderProduct = {};

            loadOrderProducts();
            function loadOrderProducts() {
                $http.get('/loadorderproduct').success(function (data) {
                    $scope.orderProducts = data;
                }).error(function (data, status, header, config) {

                });
            }
            ;


            $scope.addRow = function (nameProduct) {
                if (!$scope.nameListPayHeal) {
                    Materialize.toast('คุณไม่ระบุข้อมูล', 3000, 'rounded');
                } else {
                    if ($scope.orderProduct.length === 0) {
                        $scope.orderProduct.push({'product_Lot': $scope.nameProduct,
                            'value': $scope.valueProduct});
                        $scope.nameProduct = '';
                        $scope.valueProduct = '';
                    } else {
                        var flag = false;
                        var temp = 0;
                        for (var i = 0; i < $scope.orderProduct.length; i++) {
                            if ($scope.orderProduct[i].product_Lot.name === name.name) {
                                temp = Number($scope.orderProduct[i].value) + Number($scope.valueProduct);
                                $scope.orderProduct[i] = {'product_Lot': $scope.nameProduct,
                                    'value': temp};
                                $scope.nameProduct = '';
                                $scope.valueProduct = '';
                                flag = true;
                                break;
                            }
                        }
                        if (flag === false) {
                            $scope.orderProduct.push({'product_Lot': $scope.nameProduct,
                                'value': $scope.valueProduct});
                            $scope.nameProduct = '';
                            $scope.valueProduct = '';
                        }
                    }

                }
            };

            $scope.removeRow = function (name) {
                var index = -1;
                var rowData = eval($scope.orderProduct);
                for (var i = 0; i < rowData.length; i++) {
                    if (rowData[i].product_Lot.name === name) {
                        index = i;
                        break;
                    }
                }
                if (index === -1) {
                    Materialize.toast('บางอย่างผิดพลาด', 3000, 'rounded');
                }
                $scope.orderProduct.splice(index, 1);
            };



            //  tag วันเกิด       
            $('.datepicker').pickadate({
                selectMonths: true, // Creates a dropdown to control month
                selectYears: 15 // Creates a dropdown of 15 years to control year
            });

            $(document).ready(function () {
                $('.modal-trigger').leanModal();
            });
        });

