// app.js
 angular.module('routerApp', ['ui.router','app.cart','app.pay'])

.config(function($stateProvider, $urlRouterProvider) {

    $stateProvider
        .state('cart', {
            url: '/cart',
            templateUrl: 'app/cart/cart.view.html',
            controller: 'cartController'
        })

        .state('pay', {
            url: '/pay',
            templateUrl: 'app/pay/pay.view.html',
            controller: 'paymentController'
        })

        .state('success', {
            url: '/success',
            templateUrl: 'app/success.view.html'
        });
    $urlRouterProvider.otherwise('/cart');

});
