package com.bws.apigateway.model.constants;

import org.springframework.beans.factory.annotation.Value;

public class PropertyConstants {
    //MICROSERVICES PATHS
    @Value("${app.routes.restTemplate.requestMicroservice.authService.authLogin}")
    public static final String REST_TEMPLATE_REQUEST_MICROSERVICE_AUTH_SERVICE_AUTH_LOGIN = "${app.routes.restTemplate.requestMicroservice.authService.authLogin}";

    //CONTROLLER PATHS
    public static final String REQUEST_LOCKED_INDEXSERVICE = "${app.routescontroller.requestmapping.locked.indexServiceController}";

    public static final String REQUEST_NOTLOCKED_AUTHSERVICE = "${app.routescontroller.requestmapping.notlocked.authServiceController}";

    public static final String REQUEST_NOTLOCKED_PRODUCTSERVICE = "${app.routescontroller.requestmapping.notlocked.authServiceController}";

    //AUTHENTICATION PATHS
    public static final String REQUEST_AUTHUSER = "${app.routescontroller.notlocked.login.authUser}";

    public static final String REQUEST_REGISTERUSER = "${app.routescontroller.notlocked.login.registerUser}";

    //INDEX PATHS
    public static final String REQUEST_INDEX_BALANCE_ADD = "${app.routescontroller.locked.balance.addBalance}";

    public static final String REQUEST_INDEX_BALANCE_GET = "${app.routescontroller.locked.balance.getBalance}";

    //PRODUCT / CATEGORY PATHS
    public static final String REQUEST_PRODUCT_PRODUCTLIST= "${app.routescontroller.notlocked.product.getProductList}";

    public static final String REQUEST_PRODUCT_PRODUCTLISTBYCATEGORYNAME = "${app.routescontroller.notlocked.product.getProductListByCategoryname}";

    public static final String REQUEST_CATEGORY_CATEGORYLIST = "${app.routescontroller.notlocked.category.getCategoryList}";

}
