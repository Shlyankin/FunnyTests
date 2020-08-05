package com.heads.thinking.funnytests

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Environment
import android.os.Parcelable
import android.provider.MediaStore
import androidx.core.content.FileProvider
import java.io.File

object Utils {
    public val IMAGE_REQUEST_CODE = 101

    fun getPickImageIntent(context: Context?): Intent? {
        var chooserIntent: Intent? = null

        if (context != null && getImageUri(context) != Uri.EMPTY) {
            var intentList: MutableList<Intent> = ArrayList()

            val pickIntent =
                Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)

            val takePhotoIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            takePhotoIntent.putExtra(MediaStore.EXTRA_OUTPUT, getImageUri(context))
            intentList = addIntentsToList(context, intentList, pickIntent)
            intentList = addIntentsToList(context, intentList, takePhotoIntent)

            if (intentList.size > 0) {
                chooserIntent = Intent.createChooser(
                    intentList.removeAt(intentList.size - 1),
                    context.getString(R.string.select_capture_image)
                )

                chooserIntent?.putExtra(
                    Intent.EXTRA_INITIAL_INTENTS,
                    intentList.toTypedArray<Parcelable>()
                )
            }
        }

        return chooserIntent
    }

    fun getExtension(filePath: String?): String? {
        if (filePath == null) {
            return null
        }

        val dot = filePath.lastIndexOf(".")

        return if (dot >= 0) {
            filePath.substring(dot)
        } else {
            // No extension.
            ""
        }
    }

    private fun getImageUri(context: Context?): Uri {
        val imageFile = getImageFile(context)

        if (context != null && imageFile != null) {
            return FileProvider.getUriForFile(
                context,
                BuildConfig.APPLICATION_ID + context.getString(R.string.file_provider_name),
                imageFile
            )
        }

        return Uri.EMPTY
    }

    fun getImageFile(context: Context?): File? {
        if (context != null) {
            val pathname =
                "${context.getExternalFilesDir(Environment.DIRECTORY_DCIM)}"
            val folder = File(pathname)
            folder.mkdirs()
            val file = File(folder, "Image_Tmp.jpg")
            file.createNewFile()
            return file
        }

        return null
    }

    private fun addIntentsToList(context: Context, list: MutableList<Intent>, intent: Intent): MutableList<Intent> {
        val resInfo = context.packageManager.queryIntentActivities(intent, 0)

        for (resolveInfo in resInfo) {
            val packageName = resolveInfo.activityInfo.packageName
            val targetedIntent = Intent(intent)
            targetedIntent.setPackage(packageName)
            list.add(targetedIntent)
        }

        return list
    }
}