package com.gklabs.jlsampleapp.view.reusable_views

import com.gklabs.jlsampleapp.api.dto.Price
import com.gklabs.jlsampleapp.api.dto.Product
import com.gklabs.jlsampleapp.api.dto.ProductDetailsResponse
import com.gklabs.jlsampleapp.api.dto.ProductListResponse

val productDetailsResponseForPreview: ProductDetailsResponse
    get() = ProductDetailsResponse(
        title = "Beko DFN05320W Freestanding Dishwasher, White",
        code = "81702601",
        displaySpecialOffer = "",
        media = null,
        price = priceForProduct,
        details = null,
        additionalServices = null
    )

val productForPreview: Product
    get() = Product(
        productId = "5846002",
        title = "Neff N30 S353HAX02G Fully Integrated Dishwasher",
        image = "https://johnlewis.scene7.com/is/image/JohnLewis/240253886?",
        price = priceForProduct
    )

val priceForProduct: Price
get() = Price(
    currency = "£",
    now = "549.00",
    then1 = "",
    then2 = "",
    uom = "",
    was = ""
)

val productListForPreview: List<Product> = listOf(
    Product(
        productId = "5846002",
        title = "Neff N30 S353HAX02G Fully Integrated Dishwasher",
        image = "https://johnlewis.scene7.com/is/image/JohnLewis/240253886?",
        price = priceForProduct
    ),
    Product(
        productId = "5761763",
        title = "Bosch Serie 2 SGS2ITW41G Freestanding Dishwasher, White",
        image = "https://johnlewis.scene7.com/is/image/JohnLewis/240251283?",
        price = priceForProduct
    ),
    Product(
        productId = "5087140",
        title = "Samsung Series 6 DW60M6040FW Freestanding Dishwasher, White",
        image = "https://johnlewis.scene7.com/is/image/JohnLewis/238723819?",
        price = priceForProduct
    ),
)

val productListResponseForPreview: ProductListResponse
get() = ProductListResponse(
    products = productListForPreview
)