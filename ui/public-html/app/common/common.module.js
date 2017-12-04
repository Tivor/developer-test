angular.module('app.common', [])

.factory('Payment',['$http', function ($http){

    var returned= null;
    var getResponse = function(paymentInfo, callBack){
        $http.post('http://localhost:8090/payment/buy', paymentInfo).
            then(function(respond){
                callBack(true);
            }, function(respond) {
                returned = false;
                callBack(returned);
            })
    }

    return {
        buy: getResponse
    }

}])
.factory('Cart',['$http', function ($http){

    var returned= null;
    var getResponse = function(id, callBack){
        $http.put('http://localhost:8090/shopping/add/' + id).
            then(function(respond){
                returned = 'Product added successfully!';
                callBack(returned);
            }, function(respond) {
                returned = 'Problem trying to add this product';
                callBack(returned);
            })
    }

    return {
        addProduct: getResponse
    }

}])
.factory('Product',['$http', function ($http){

    var returned= null;
    var getResponse = function(callBack){
//        $http.get('/poc-backend/product/list').
        $http.get('http://localhost:8090/shopping/list').
            then(function(respond){
                returned = respond.data;
                callBack(returned);
            }, function(respond) {
            })
    }

    return {
        listProducts: getResponse
    }

}]);
