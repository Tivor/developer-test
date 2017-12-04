angular.module("app.cart", ['app.common'])
    .controller("cartController", ['$scope', '$state', 'Product', 'Cart', function ($scope, $state, Product, Cart) {

         Product.listProducts(function (allProducts) {
             $scope.allProducts = allProducts;
         });

         $scope.add = function(id) {
            Cart.addProduct(id, function (result) {
             $scope.message = result;
            });
         }

         $scope.buy = function() {
            $state.go("pay");
         }


    }])






