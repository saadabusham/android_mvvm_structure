package com.technzone.bai3.ui.base.dialogs.appupdate

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Window
import androidx.databinding.DataBindingUtil
import com.technzone.bai3.R
import com.technzone.bai3.data.models.configuration.UpdateStatus
import com.technzone.bai3.databinding.DialogUpdateAppBinding
import com.technzone.bai3.utils.extensions.startAppDetailsOnGooglePlay


class UpdateAppDialog(
    var context: Activity,
    val updateStatus: UpdateStatus
) :
    Dialog(context) {

    lateinit var dialogUpdateAppDialog: DialogUpdateAppBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setCancelable(updateStatus.isMandatory == false)
        dialogUpdateAppDialog = DataBindingUtil.inflate(
            LayoutInflater.from(getContext()),
            R.layout.dialog_update_app,
            null,
            false
        );        dialogUpdateAppDialog.viewModel = this
        setContentView(dialogUpdateAppDialog.root)
        window?.setBackgroundDrawableResource(android.R.color.transparent);
    }

    fun onUpdateClicked() {
        context.startAppDetailsOnGooglePlay()
    }

    fun onRemindMeLaterClicked() {
        dismiss()
    }

    fun onCloseAppClicked() {
        context.finishAffinity()
    }
}