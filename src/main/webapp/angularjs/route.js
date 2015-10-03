angular.module('route', ['ngRoute', 'Customer', 'Department', 'Employee', 'Doctor',
    'TypeProduct','Unit','Product','Lot','ProductLot','ListPayHeal','DetailHealAndPayheal'
    ,'Bill','Appointment']);
angular.module('route')
        .config(function ($routeProvider) {
            $routeProvider
                    .when('/', {
                        templateUrl: '../body/bodymain.html'})
                    .when('/addcustomer', {
                        templateUrl: '../body/bodyaddcustomer.html',
                        controller: 'CustomerController'})
                    .when('/tablecustomer', {
                        templateUrl: '../body/bodytablecustomer.html',
                        controller: 'CustomerController'})
                     .when('/showdetailcustomer', {
                        templateUrl: '../body/showdetailcustomer.html',
                        controller: 'ShowdataCustomerController'})
                    .when('/addemployee', {
                        templateUrl: '../body/bodyaddemployee.html',
                        controller: 'EmployeeController'})
                    .when('/tableemployee', {
                        templateUrl: '../body/bodytableemployee.html',
                        controller: 'EmployeeController'})
                    .when('/adddepartmentemployee', {
                        templateUrl: '../body/bodyadddepartmentemployee.html'
                        , controller: 'DepartmentController'})
                    .when('/adddoctor', {
                        templateUrl: '../body/bodyadddoctor.html',
                        controller: 'DoctorController'})
                    .when('/tabledoctor', {
                        templateUrl: '../body/bodytabledoctor.html',
                        controller: 'DoctorController'})
                   


                    .when('/addtypeproduct', {
                        templateUrl: '../body/bodyaddtypeproduct.html',
                        controller: 'TypeProductController'})
                    .when('/addunit', {
                        templateUrl: '../body/bodyaddunit.html',
                        controller: 'UnitController'})
                    .when('/addproduct', {
                        templateUrl: '../body/bodyaddproduct.html',
                        controller: 'ProductController'})
                    .when('/tableproduct', {
                        templateUrl: '../body/bodytableproduct.html',
                        controller: 'ProductController'})
                    
                    
                    .when('/addlot', {
                        templateUrl: '../body/bodyaddLot.html',
                        controller: 'LotController'})
                    .when('/addproductlot', {
                        templateUrl: '../body/bodyaddproductlot.html',
                        controller: 'ProductLotController'})
                    
                    
                    .when('/addlistpayheal', {
                        templateUrl: '../body/bodyaddlistpayheal.html',
                        controller: 'ListPayHealController'})
                    .when('/adddetailheal-and-payheal', {
                        templateUrl: '../body/bodyadddetailheal-and-payheal.html',
                        controller: 'DetailHealAndPayhealController'})
                    
                    .when('/addbill', {
                        templateUrl: '../body/bodyaddbill.html',
                        controller: 'BillController'})
                    
                    .when('/addappointment',{
                        templateUrl:'../body/bodyaddappointment.html',
                        controller:'AppointmentController'})

                    .otherwise({redirecTo: '../body/bodymain.html'})
                    ;


        });