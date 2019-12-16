package com.teamwork.yat.ui.utils

import android.content.Context
import androidx.appcompat.app.AlertDialog

class AlertDialogUtils {

    companion object {

        fun showAlert(context: Context, message: String) {
            val dialog = AlertDialog.Builder(context)
            dialog.setMessage(message)
            dialog.setNeutralButton(
                context.resources.getString(android.R.string.ok)
            ) { dialog, _ -> dialog.dismiss() }
            val alertDialog = dialog.create()
            alertDialog.show()
        }

    }

}