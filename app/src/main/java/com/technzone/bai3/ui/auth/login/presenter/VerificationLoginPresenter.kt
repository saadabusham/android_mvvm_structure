package com.technzone.bai3.ui.auth.forgetpassword.presenters

import com.technzone.bai3.ui.base.presenters.BaseBindingPresenter

interface VerificationForgetPasswordPresenter :BaseBindingPresenter{
    fun onVerifyClicked()
    fun onResendClicked()
}