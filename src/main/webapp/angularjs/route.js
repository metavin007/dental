angular.module('route', ['ngRoute', 'Customer']);
angular.module('route')
        .config(function ($routeProvider) {
            $routeProvider
                    .when('/', {templateUrl: '../body/bodymain.html'})
                    .when('/addcustomer', {templateUrl: '../body/bodyaddcustomer.html',
                        controller: 'CustomerController'})
                    .when('/tablecustomer', {templateUrl: '../body/bodytablecustomer.html',
                        controller: 'CustomerController'})
                    .when('/addemployee', {templateUrl: '../body/bodyaddemployee.html'})
                    .when('/tableemployee', {templateUrl: '../body/bodytableemployee.html'})
                    .when('/adddepartmentemployee', {templateUrl: '../body/bodyadddepartmentemployee.html'})
                    .when('/adddoctor', {templateUrl: '../body/bodyadddoctor.html'})
                    .when('/tabledoctor', {templateUrl: '../body/bodytabledoctor.html'})
                    .otherwise({redirecTo: '../body/bodymain.html'})
                    ;
        });