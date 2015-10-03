angular.module('Customer', []);
angular.module('Customer', ['checklist-model'])
        .service('ServiceCustomer', function () {
              this.showCustomer = {};
                    this.setShowCustomer = function (showCustomer) {
                            this.showCustomer = showCustomer;
                    };
                    this.getShowCustomer = function () {
                            return this.showCustomer;
                    };
              this.updateCustomer = {};
                    this.setUpdateCustomer = function (updateCustomer) {
                            this.updateCustomer = updateCustomer;
                    };
                    this.getUpdateCustomer = function () {
                            return this.updateCustomer;
                    };
        })
        .controller('CustomerController', function ($scope, $http, ServiceCustomer) {
            
            $scope.customer = ServiceCustomer.getUpdateCustomer();
            $scope.customers = {};
            $scope.medicalhistorys = {};

            $scope.error = {};

            $scope.selectRowDataCustomer = function (rowcustomer) {
                ServiceCustomer.setShowCustomer(rowcustomer);         
            };


            loadCustomer();
            function loadCustomer() {
                $http.get('/loadcustomer').success(function (data) {
                    $scope.customers = data;
                }).error(function (data, status, header, config) {

                });
            }
            ;

            $scope.saveCustomer = function () {
                $http.post('/sevecustomer', $scope.customer).success(function (data) {
                    Materialize.toast('saveข้อมูลเรียบร้อย', 3000, 'rounded');
                    $scope.customer = {};
                }).error(function (data) {
                    $scope.error = data;
                    Materialize.toast('คุณกรอกข้อมูลไม่เรียบร้อย', 3000, 'rounded');
                });
            };

            $scope.deleteCustomer = function (rowcustomer) {
                $http.post('/deletecustomer', rowcustomer).success(function (data) {
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

//  tag วันเกิด       
            $('.datepicker').pickadate({
                selectMonths: true, // Creates a dropdown to control month
                selectYears: 15 // Creates a dropdown of 15 years to control year
            });

        })

        .controller('ShowdataCustomerController', function ($scope, ServiceCustomer) {
            $scope.showdatacustomer = ServiceCustomer.getShowCustomer();
    
            $scope.updateDataCustomer = function (showdatacustomer) {
                ServiceCustomer.setUpdateCustomer(showdatacustomer);
            };
        });


