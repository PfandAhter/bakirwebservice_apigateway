package com.bws.apigateway.model.constants;

public class PropertyConstants {
    //MICROSERVICES PATHS
    public static final String REST_TEMPLATE_REQUEST_MICROSERVICE_AUTH_SERVICE_AUTH_LOGIN = "${app.routes.restTemplate.requestMicroservice.authService.authLogin}";

    public static final String REST_TEMPLATE_REQUEST_MICROSERVICE_AUTH_SERVICE_AUTH_REGISTER = "${app.routes.restTemplate.requestMicroservice.authService.registerUser}";

    public static final String REST_TEMPLATE_REQUEST_MICROSERVICE_PRODUCT_SERVICE_CATEGORY_GETLIST = "${app.routes.restTemplate.requestMicroservice.productService.getCategoryList}";

    public static final String REST_TEMPLATE_REQUEST_MICROSERVICE_PRODUCT_SERVICE_PRODUCT_GETLISTBYCATEGORYNAME = "${app.routes.restTemplate.requestMicroservice.productService.getProductListByCategoryName}";

    public static final String REST_TEMPLATE_REQUEST_MICROSERVICE_PRODUCT_SERVICE_PRODUCT_GETLIST = "${app.routes.restTemplate.requestMicroservice.productService.getProductList}";

    public static final String REST_TEMPLATE_REQUEST_MICROSERVICE_PAYMENT_SERVICE_BALANCE_ADD = "${app.routes.restTemplate.requestMicroservice.paymentService.addBalance}";

    public static final String REST_TEMPLATE_REQUEST_MICROSERVICE_PAYMENT_SERVICE_BALANCE_GET = "${app.routes.restTemplate.requestMicroservice.paymentService.getBalance}";

    public static final String REST_TEMPLATE_REQUEST_MICROSERVICE_PRODUCT_SERVICE_ORDER_LIST_CREATE = "${app.routes.restTemplate.requestMicroservice.productService.createOrderList}";

    public static final String REST_TEMPLATE_REQUEST_MICROSERVICE_PAYMENT_SERVICE_ORDERLIST_DELETEORDER = "${app.routes.restTemplate.requestMicroservice.paymentService.deleteOrderByProductCode}";

    public static final String REST_TEMPLATE_REQUEST_MICROSERVICE_PAYMENT_SERVICE_ORDERLIST_GET = "${app.routes.restTemplate.requestMicroservice.paymentService.getOrderList}";

    //CONTROLLER PATHS
    public static final String REQUEST_LOCKED_INDEXSERVICE = "${app.presented.routescontroller.requestmapping.locked.indexServiceController}";

    public static final String REQUEST_NOTLOCKED_AUTHSERVICE = "${app.presented.routescontroller.requestmapping.notlocked.authServiceController}";

    public static final String REQUEST_NOTLOCKED_PRODUCTSERVICE = "${app.presented.routescontroller.requestmapping.notlocked.authServiceController}";

    //AUTHENTICATION PATHS
    public static final String REQUEST_AUTHUSER = "${app.presented.routescontroller.notlocked.login.authUser}";

    public static final String REQUEST_REGISTERUSER = "${app.presented.routescontroller.notlocked.login.registerUser}";

    //INDEX PATHS
    public static final String REQUEST_INDEX_BALANCE_ADD = "${app.presented.routescontroller.locked.balance.addBalance}";

    public static final String REQUEST_INDEX_BALANCE_GET = "${app.presented.routescontroller.locked.balance.getBalance}";

    public static final String REQUEST_INDEX_ORDER_LIST_ADD = "${app.presented.routescontroller.locked.orderList.addOrderList}";

    public static final String REQUEST_INDEX_ORDER_LIST_DELETE = "${app.presented.routescontroller.locked.orderList.deleteOrderList}";

    public static final String REQUEST_INDEX_ORDER_LIST_GET = "${app.presented.routescontroller.locked.orderList.getOrderList}";

    //PRODUCT / CATEGORY PATHS
    public static final String REQUEST_PRODUCT_PRODUCTLIST= "${app.presented.routescontroller.notlocked.product.getProductList}";

    public static final String REQUEST_PRODUCT_PRODUCTLISTBYCATEGORYNAME = "${app.presented.routescontroller.notlocked.product.getProductListByCategoryname}";

    public static final String REQUEST_CATEGORY_CATEGORYLIST = "${app.presented.routescontroller.notlocked.category.getCategoryList}";

}
