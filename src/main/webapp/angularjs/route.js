angular.module('route', ['ngRoute', 'Customer', 'Department','Employee','Doctor','Customer2']);
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
                    .when('/detailcustomer',{
                        templateUrl: '../body/bodydetailcustomer.html',
                        controller: 'CustomerController2'})
                   
                    
                    .otherwise({redirecTo: '../body/bodymain.html'})
                    ;
        });