package com.technzone.bai3.data.repos.common

import com.technzone.bai3.data.api.response.APIResource
import com.technzone.bai3.data.api.response.ResponseHandler
import com.technzone.bai3.data.api.response.ResponseWrapper
import com.technzone.bai3.data.daos.remote.common.CommonRemoteDao
import com.technzone.bai3.data.models.FaqsResponse
import com.technzone.bai3.data.models.category.Category
import com.technzone.bai3.data.models.general.ListWrapper
import com.technzone.bai3.data.models.home.banner.Banner
import com.technzone.bai3.data.models.home.product.productdetails.SocialMedia
import com.technzone.bai3.data.models.notification.Notification
import com.technzone.bai3.data.repos.base.BaseRepo
import okhttp3.MultipartBody
import okhttp3.RequestBody
import javax.inject.Inject

class CommonRepoImp @Inject constructor(
    responseHandler: ResponseHandler,
    private val commonRemoteDao: CommonRemoteDao
) : BaseRepo(responseHandler), CommonRepo {

    override suspend fun getNotifications(
        pageSize: Int,
        pageNumber: Int
    ): APIResource<ResponseWrapper<ListWrapper<Notification>>> {
        return try {
            responseHandle.handleSuccess(
                commonRemoteDao.getNotifications(pageSize, pageNumber)
            )
        } catch (e: Exception) {
            responseHandle.handleException(e)
        }
    }

    override suspend fun getFaqs(
        pageSize: Int,
        pageNumber: Int
    ): APIResource<ResponseWrapper<ListWrapper<FaqsResponse>>> {
        return try {
            responseHandle.handleSuccess(commonRemoteDao.getFaqs(pageSize, pageNumber))
        } catch (e: Exception) {
            responseHandle.handleException(e)
        }
    }

    override suspend fun contactUs(
        message: RequestBody,
        image1: MultipartBody.Part?,
        image2: MultipartBody.Part?,
        image3: MultipartBody.Part?
    ): APIResource<ResponseWrapper<Any>> {
        return try {
            responseHandle.handleSuccess(commonRemoteDao.contactUs(message, image1, image2, image3))
        } catch (e: Exception) {
            responseHandle.handleException(e)
        }
    }

    override suspend fun getCategories(
        pageSize: Int,
        pageNumber: Int,
        name: String?,
        parentId: Int?
    ): APIResource<ResponseWrapper<ListWrapper<Category>>> {
        return try {
            responseHandle.handleSuccess(
                commonRemoteDao.getCategories(
                    pageSize,
                    pageNumber,
                    name,
                    parentId
                )
            )
        } catch (e: Exception) {
            responseHandle.handleException(e)
        }
    }

    override suspend fun getContactUsSocialMedia(): APIResource<ResponseWrapper<List<SocialMedia>>> {
        return try {
            responseHandle.handleSuccess(commonRemoteDao.getContactUsSocialMedia())
        } catch (e: Exception) {
            responseHandle.handleException(e)
        }
    }

    override suspend fun getBanner(
        pageSize: Int,
        pageNumber: Int
    ): APIResource<ResponseWrapper<ListWrapper<Banner>>> {
        return try {
            responseHandle.handleSuccess(commonRemoteDao.getBanner(pageSize, pageNumber))
        } catch (e: Exception) {
            responseHandle.handleException(e)
        }
    }

}