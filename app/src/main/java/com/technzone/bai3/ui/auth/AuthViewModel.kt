package com.technzone.bai3.ui.auth

import android.content.Context
import com.technzone.bai3.BuildConfig
import com.technzone.bai3.common.CommonEnums
import com.technzone.bai3.data.pref.configuration.ConfigurationPref
import com.technzone.bai3.data.repos.user.UserRepo
import com.technzone.bai3.ui.base.viewmodel.BaseViewModel
import com.technzone.bai3.utils.pref.SharedPreferencesUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val userRepo: UserRepo,
    @ApplicationContext val context: Context,
    private val sharedPreferencesUtil: SharedPreferencesUtil,
    private val configurationPref: ConfigurationPref
) : BaseViewModel() {

    fun getTermsAndConditions(): String {
        return if (configurationPref.getAppLanguageValue() == CommonEnums.Languages.English.value)
            sharedPreferencesUtil.getConfigurationPreferences()?.configString?.englishTermsAndConditions
                ?: ""
        else sharedPreferencesUtil.getConfigurationPreferences()?.configString?.arabicTermsAndConditions
            ?: ""
    }


    fun getPrivacyPolicy(): String {
        return if (configurationPref.getAppLanguageValue() == CommonEnums.Languages.English.value)
            sharedPreferencesUtil.getConfigurationPreferences()?.configString?.englishPrivacyPolicy
                ?: ""
        else sharedPreferencesUtil.getConfigurationPreferences()?.configString?.arabicPrivacyPolicy
            ?: ""
    }

    fun appVersion():String{
        return BuildConfig.VERSION_NAME
    }
}