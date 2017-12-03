angular.module("app.cart", ['app.common'])
    .controller("cartController", ['$scope', 'Product', function ($scope, Product) {

         Product.listProducts(function (allProducts) {
             $scope.allProducts = allProducts;
         });


    }])






