package com.bws.apigateway.model.constants;

public class PropertyConstants {
    //CONTROLLER PATHS
    public static final String REQUEST_SECURE_SERVICE_USER_CONTROLLER = "${app.routesController.controllers.secure.userServiceController}";

    public static final String REQUEST_NOT_SECURE_SERVICE_AUTH_CONTROLLER = "${app.routesController.controllers.notSecure.authServiceController}";

    public static final String REQUEST_NOT_SECURE_SERVICE_STOCK_CONTROLLER = "${app.routesController.controllers.notSecure.stockServiceController}";

    public static final String REQUEST_SECURE_SERVICE_PAYMENT_CONTROLLER = "${app.routesController.controllers.secure.paymentServiceController}";

    public static final String REQUEST_SECURE_MESSAGE_SERVICE_CONTROLLER = "${app.routesController.controllers.secure.messageServiceController}";

    //AUTHENTICATION PATHS
    public static final String REQUEST_NOT_SECURE_REST_CONTROLLER_AUTH_SERVICE_LOGIN = "${app.routesController.requestMapping.notSecure.auth-service.authUser}"; //

    public static final String REQUEST_NOT_SECURE_REST_CONTROLLER_AUTH_SERVICE_REGISTER = "${app.routesController.requestMapping.notSecure.auth-service.registerUser}"; //

    public static final String REQUEST_SECURE_REST_CONTROLLER_AUTH_SERVICE_LOGOUT = "${app.routesController.requestMapping.secure.auth-service.logoutUser}";

    public static final String REQUEST_NOT_SECURE_REST_CONTROLLER_AUTH_SERVICE_REGISTER_AS_SELLER = "${app.routesController.requestMapping.notSecure.auth-service.registerSeller}";

    public static final String REQUEST_SECURE_REST_CONTROLLER_AUTH_SERVICE_PASSWORD_CHANGE = "${app.routesController.requestMapping.secure.auth-service.passwordChange}";

    public static final String REQUEST_NOT_SECURE_REST_CONTROLLER_AUTH_SERVICE_PASSWORD_FORGET = "${app.routesController.requestMapping.notSecure.auth-service.passwordForget}";

    public static final String REQUEST_NOT_SECURE_REST_CONTROLLER_AUTH_SERVICE_PASSWORD_CHANGE_WITH_CODE = "${app.routesController.requestMapping.notSecure.auth-service.passwordChangeWithCode}";

    //USER-SERVICE PATHS
    public static final String REQUEST_SECURE_REST_CONTROLLER_USER_SERVICE_BALANCE_ADD = "${app.routesController.requestMapping.secure.user-service.addBalance}"; //

    public static final String REQUEST_SECURE_REST_CONTROLLER_USER_SERVICE_BALANCE_GET = "${app.routesController.requestMapping.secure.user-service.getBalance}"; //

    public static final String REQUEST_SECURE_REST_CONTROLLER_USER_SERVICE_USER_ADD_ADDRESS_INFO = "${app.routesController.requestMapping.secure.user-service.addAddressInfo}";

    public static final String REQUEST_SECURE_REST_CONTROLLER_USER_SERVICE_USER_ACTIVATE = "${app.routesController.requestMapping.secure.user-service.userActivate}";

    public static final String REQUEST_SECURE_REST_CONTROLLER_USER_SERVICE_SELLER_ACTIVATE_BY_ADMIN= "${app.routesController.requestMapping.secure.user-service.sellerActivateByAdmin}";

    public static final String REQUEST_SECURE_REST_CONTROLLER_USER_SERVICE_SELLER_NOT_ACTIVATED = "${app.routesController.requestMapping.secure.user-service.getSellers}";

    public static final String REQUEST_SECURE_REST_CONTROLLER_USER_SERVICE_USER_PROFILE_PHOTO_ADD = "${app.routesController.requestMapping.secure.user-service.addPhoto}";

    public static final String REQUEST_SECURE_REST_CONTROLLER_USER_SERVICE_USER_PROFILE_PHOTO_GET = "${app.routesController.requestMapping.secure.user-service.getPhoto}";

    //PAYMENT-SERVICE PATHS
    public static final String REQUEST_SECURE_REST_CONTROLLER_PAYMENT_SERVICE_CART_ADD = "${app.routesController.requestMapping.secure.payment-service.addItemsInCart}";

    public static final String REQUEST_SECURE_REST_CONTROLLER_PAYMENT_SERVICE_CART_CLEAR = "${app.routesController.requestMapping.secure.payment-service.clearItemsInCart}";

    public static final String REQUEST_SECURE_REST_CONTROLLER_PAYMENT_SERVICE_CART_GET = "${app.routesController.requestMapping.secure.payment-service.getItemsInCart}";

    public static final String REQUEST_SECURE_REST_CONTROLLER_PAYMENT_SERVICE_CART_BUY = "${app.routesController.requestMapping.secure.payment-service.buyItemsInCart}";

    public static final String REQUEST_SECURE_REST_CONTROLLER_PAYMENT_SERVICE_QUERY_WITH_TRACKING_NUMBER = "${app.routesController.requestMapping.secure.payment-service.queryByTrackingNumber}";

    //STOCK-SERVICE PATHS
    public static final String REQUEST_NOT_SECURE_REST_CONTROLLER_STOCK_SERVICE_PRODUCT_LIST_GET = "${app.routesController.requestMapping.notSecure.stock-service.getProductList}";

    public static final String REQUEST_NOT_SECURE_REST_CONTROLLER_STOCK_SERVICE_PRODUCT_GET_BY_PRODUCT_CODE = "${app.routesController.requestMapping.notSecure.stock-service.getProductByProductId}";

    public static final String REQUEST_NOT_SECURE_REST_CONTROLLER_STOCK_SERVICE_CATEGORY_LIST_GET = "${app.routesController.requestMapping.notSecure.stock-service.getCategoryList}";

    public static final String REQUEST_SECURE_REST_CONTROLLER_STOCK_SERVICE_CATEGORY_ADD = "${app.routesController.requestMapping.secure.stock-service.addCategory}";

    public static final String REQUEST_SECURE_REST_CONTROLLER_STOCK_SERVICE_CATEGORY_UPDATE = "${app.routesController.requestMapping.secure.stock-service.updateCategory}";

    public static final String REQUEST_SECURE_REST_CONTROLLER_STOCK_SERVICE_PRODUCT_ADD = "${app.routesController.requestMapping.secure.stock-service.addProduct}";

    public static final String REQUEST_SECURE_REST_CONTROLLER_STOCK_SERVICE_PRODUCT_UPDATE = "${app.routesController.requestMapping.secure.stock-service.updateProduct}";

    public static final String REQUEST_SECURE_REST_CONTROLLER_STOCK_SERVICE_COMPANY_ADD = "${app.routesController.requestMapping.secure.stock-service.addCompany}";

    public static final String REQUEST_SECURE_REST_CONTROLLER_STOCK_SERVICE_COMMENT_ADD = "${app.routesController.requestMapping.secure.stock-service.addComment}";

    //MESSAGE-SERVICE PATHS
    public static final String REQUEST_SECURE_REST_CONTROLLER_MESSAGE_SERVICE_MESSAGE_LIST = "${app.routesController.requestMapping.secure.message-service.messageList}";

    public static final String REQUEST_SECURE_REST_CONTROLLER_MESSAGE_SERVICE_MESSAGES = "${app.routesController.requestMapping.secure.message-service.messages}";

    public static final String REQUEST_SECURE_REST_CONTROLLER_MESSAGE_SERVICE_SEND_MESSAGE = "${app.routesController.requestMapping.secure.message-service.sendMessage}";


}
