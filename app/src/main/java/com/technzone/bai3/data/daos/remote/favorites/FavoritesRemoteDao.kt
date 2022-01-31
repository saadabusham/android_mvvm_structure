package com.technzone.bai3.data.daos.remote.favorites

import androidx.room.FtsOptions
import com.technzone.bai3.data.api.response.ResponseWrapper
import com.technzone.bai3.data.common.NetworkConstants
import com.technzone.bai3.data.models.FaqsResponse
import com.technzone.bai3.data.models.addresses.AddressList
import com.technzone.bai3.data.models.category.Category
import com.technzone.bai3.data.models.general.ListWrapper
import com.technzone.bai3.data.models.home.banner.Banner
import com.technzone.bai3.data.models.home.product.ProductFilter
import com.technzone.bai3.data.models.home.product.productdetails.Product
import com.technzone.bai3.data.models.home.product.productdetails.SocialMedia
import com.technzone.bai3.data.models.notification.Notification
import com.technzone.bai3.data.models.orders.Order
import com.technzone.bai3.data.models.orders.OrderDetails
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.*

interface FavoritesRemoteDao {

    @Headers("${NetworkConstants.SKIP_AUTHORIZATION_HEADER}:false")
    @POST("api/product/search")
    suspend fun getFavorites(
            @Body productFilter: ProductFilter
    ): ResponseWrapper<ListWrapper<Product>>

    @Headers("${NetworkConstants.SKIP_AUTHORIZATION_HEADER}:false")
    @GET("api/user/product/favorite")
    suspend fun getFavoriteIds(
    ): ResponseWrapper<List<Int>>

    @Headers("${NetworkConstants.SKIP_AUTHORIZATION_HEADER}:false")
    @POST("api/user/product/favorite/{id}")
    suspend fun addFavorite(
            @Path("id") id: Int
    ): ResponseWrapper<Any>

    @Headers("${NetworkConstants.SKIP_AUTHORIZATION_HEADER}:false")
    @DELETE("api/user/product/favorite/{id}")
    suspend fun removeFavorite(
            @Path("id") id: Int
    ): ResponseWrapper<Any>

}