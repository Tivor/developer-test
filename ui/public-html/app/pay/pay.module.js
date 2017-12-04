angular.module("app.pay", ['app.common'])
    .controller("paymentController", ['$scope', '$state', 'Payment', function ($scope, $state, Payment) {

        $scope.paymentInfo = {};

        $scope.home = function() {
            $state.go('cart');
        }

        $scope.buy = function () {
            Payment.buy($scope.paymentInfo, function (result) {
             if (result === true ) {
                $state.go('success');
             } else {
                alert("Invalid Payment Info!");
             }
            });
        }

    }])
