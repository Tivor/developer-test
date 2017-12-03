angular.module('app.common', [])

.factory('Product',['$http', function ($http){

    var returned= null;
    var getResponse = function(callBack){
        $http.get('/poc-backend/product/list').
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
