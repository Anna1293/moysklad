package com.example.moysklad.common;

public interface Urls {
    String API = "api";
    String SERVICE_NAME = "moysklad";
    String ROOT = "/" + API + "/" + SERVICE_NAME;

    interface Product {
        String PART = "product";
        String FULL = ROOT + "/" + PART;

        interface GetProductList {
            String PART = "getProductList";
            String FULL = Product.FULL + "/" + PART;
        }

        interface id {
            String PART = "{id}";
            String FULL = Product.FULL + "/" + PART;
        }

        interface PostProduct {
            String PART = "postProduct";
            String FULL = id.FULL + "/" + PART;
        }

        interface DeleteProduct {
            String PART = "deleteProduct";
            String FULL = id.FULL + "/" + PART;
        }

        interface PutProduct {
            String PART = "putProduct";
            String FULL = Product.FULL + "/" + PART;
        }


    }
}
