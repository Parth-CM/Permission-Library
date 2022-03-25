package com.parth.permissionlibapp.common

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.IntentSender
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.LocationSettingsRequest
import com.google.android.material.snackbar.Snackbar

class PermissionUtils {

    companion object
    {
        fun setLocationPermission(activity: Activity) {


            if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.P)
            {
                if(!activity.applicationContext.checkSinglePermission(Manifest.permission.ACCESS_COARSE_LOCATION) ||
                    !activity.applicationContext.checkSinglePermission(Manifest.permission.ACCESS_FINE_LOCATION)){

                    val permList = arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_FINE_LOCATION)

                    if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.ACCESS_COARSE_LOCATION)
                        || ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.ACCESS_FINE_LOCATION)) {

                        // Show an alert dialog here with request explanation
                        val builder = AlertDialog.Builder(activity, androidx.appcompat.R.style.Base_ThemeOverlay_AppCompat_Dialog_Alert)
                        builder.setMessage("Location permission required...")
                        builder.setTitle("Please grant those permissions")
                        builder.setPositiveButton("OK") { dialogInterface, i ->
                            ActivityCompat.requestPermissions(activity, permList, 101)
                        }
                        builder.setNeutralButton("Cancel", null)
                        val dialog = builder.create()
                        dialog.show()
                    }else{
                        ActivityCompat.requestPermissions(activity, permList, 101)
                    }


                }else{
                    gpsDialog(activity)
                    Log.d("Parth","Permsion Granted")
                }


            }
            else if(Build.VERSION.SDK_INT == Build.VERSION_CODES.Q){

                if(!activity.applicationContext.checkSinglePermission(Manifest.permission.ACCESS_COARSE_LOCATION) ||
                    !activity.applicationContext.checkSinglePermission(Manifest.permission.ACCESS_FINE_LOCATION) ||
                    !activity.applicationContext.checkSinglePermission(Manifest.permission.ACCESS_BACKGROUND_LOCATION)){

                    val permList = arrayOf(
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_BACKGROUND_LOCATION)

                    if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.ACCESS_COARSE_LOCATION)
                        || ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.ACCESS_FINE_LOCATION)
                        || ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.ACCESS_BACKGROUND_LOCATION)) {

                        // Show an alert dialog here with request explanation
                        val builder = AlertDialog.Builder(activity, androidx.appcompat.R.style.Base_ThemeOverlay_AppCompat_Dialog_Alert)
                        builder.setMessage("Location permission required...")
                        builder.setTitle("Please grant those permissions")
                        builder.setPositiveButton("OK") { dialogInterface, i ->
                            ActivityCompat.requestPermissions(activity, permList, 102)
                        }
                        builder.setNeutralButton("Cancel", null)
                        val dialog = builder.create()
                        dialog.show()
                    }else{
                        ActivityCompat.requestPermissions(activity, permList, 102)
                    }

                }else{
                    gpsDialog(activity)
                    Log.d("Parth","Permission Granted")
                }
            }
            else{

                if(!activity.applicationContext.checkSinglePermission(Manifest.permission.ACCESS_COARSE_LOCATION) ||
                    !activity.applicationContext.checkSinglePermission(Manifest.permission.ACCESS_FINE_LOCATION)){

                    val permList = arrayOf(
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_FINE_LOCATION
                    )
                    if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.ACCESS_COARSE_LOCATION)
                        || ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.ACCESS_FINE_LOCATION)) {

                        // Show an alert dialog here with request explanation
                        val builder = AlertDialog.Builder(activity, androidx.appcompat.R.style.Base_ThemeOverlay_AppCompat_Dialog_Alert)
                        builder.setMessage("Location permission required...")
                        builder.setTitle("Please grant those permissions")
                        builder.setPositiveButton("OK") { dialogInterface, i ->
                            ActivityCompat.requestPermissions(activity, permList, 103)
                        }
                        builder.setNeutralButton("Cancel", null)
                        val dialog = builder.create()
                        dialog.show()
                    }else{
                        ActivityCompat.requestPermissions(activity, permList, 103)
                    }

                }else if(!activity.applicationContext.checkSinglePermission(Manifest.permission.ACCESS_BACKGROUND_LOCATION)){
                    showBackgroundLocationPermissionDialog(activity)
                }else{
                    gpsDialog(activity)
                    Log.d("Parth","Permsion Granted")
                }


            }

        }

        fun setCallLogPermission(activity: Activity){
            if(!activity.applicationContext.checkSinglePermission(Manifest.permission.READ_CALL_LOG) ||
                !activity.applicationContext.checkSinglePermission(Manifest.permission.WRITE_CALL_LOG)){

                val permList = arrayOf(
                    Manifest.permission.READ_CALL_LOG,
                    Manifest.permission.WRITE_CALL_LOG
                )
                if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.WRITE_CALL_LOG)
                    || ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.WRITE_CALL_LOG)) {

                    // Show an alert dialog here with request explanation
                    val builder = AlertDialog.Builder(activity, androidx.appcompat.R.style.Base_ThemeOverlay_AppCompat_Dialog_Alert)
                    builder.setMessage("Call_log permission required...")
                    builder.setTitle("Please grant those permissions")
                    builder.setPositiveButton("OK") { dialogInterface, i ->
                        ActivityCompat.requestPermissions(activity, permList, 201)
                    }
                    builder.setNeutralButton("Cancel", null)
                    val dialog = builder.create()
                    dialog.show()
                }else{
                    ActivityCompat.requestPermissions(activity, permList, 201)
                }

            }else{
                Toast.makeText(activity, "Call_Log permission already granted", Toast.LENGTH_SHORT).show()
            }
        }

        fun setMessagePermission(activity: Activity){
            if(!activity.applicationContext.checkSinglePermission(Manifest.permission.READ_SMS)){

                val permList = arrayOf(Manifest.permission.READ_SMS)
                if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.READ_SMS)) {

                    // Show an alert dialog here with request explanation
                    val builder = AlertDialog.Builder(activity, androidx.appcompat.R.style.Base_ThemeOverlay_AppCompat_Dialog_Alert)
                    builder.setMessage("SMS permission required...")
                    builder.setTitle("Please grant these permissions")
                    builder.setPositiveButton("OK") { dialogInterface, i ->
                        ActivityCompat.requestPermissions(activity, permList, 202)
                    }
                    builder.setNeutralButton("Cancel", null)
                    val dialog = builder.create()
                    dialog.show()
                }else{
                    ActivityCompat.requestPermissions(activity, permList, 202)
                }

            }else{
                Toast.makeText(activity, "SMS permission already granted", Toast.LENGTH_SHORT).show()
            }
        }

        fun setCameraPermission(activity: Activity){
            if(!activity.applicationContext.checkSinglePermission(Manifest.permission.CAMERA)){

                val permList = arrayOf(Manifest.permission.CAMERA)
                if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.CAMERA)) {

                    // Show an alert dialog here with request explanation
                    val builder = AlertDialog.Builder(activity, androidx.appcompat.R.style.Base_ThemeOverlay_AppCompat_Dialog_Alert)
                    builder.setMessage("SMS permission required...")
                    builder.setTitle("Please grant these permissions")
                    builder.setPositiveButton("OK") { dialogInterface, i ->
                        ActivityCompat.requestPermissions(activity, permList, 203)
                    }
                    builder.setNeutralButton("Cancel", null)
                    val dialog = builder.create()
                    dialog.show()
                }else{
                    ActivityCompat.requestPermissions(activity, permList, 203)
                }

            }else{
                Toast.makeText(activity, "SMS permission already granted", Toast.LENGTH_SHORT).show()
            }
        }

        fun setStoragePermission(activity: Activity){
            if(!activity.applicationContext.checkSinglePermission(Manifest.permission.READ_EXTERNAL_STORAGE) ||
                !activity.applicationContext.checkSinglePermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)){

                val permList = arrayOf(
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                )
                if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.READ_EXTERNAL_STORAGE)
                    || ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

                    // Show an alert dialog here with request explanation
                    val builder = AlertDialog.Builder(activity, androidx.appcompat.R.style.Base_ThemeOverlay_AppCompat_Dialog_Alert)
                    builder.setMessage("Storage permissions required...")
                    builder.setTitle("Please grant those permissions")
                    builder.setPositiveButton("OK") { dialogInterface, i ->
                        ActivityCompat.requestPermissions(activity, permList, 204)
                    }
                    builder.setNeutralButton("Cancel", null)
                    val dialog = builder.create()
                    dialog.show()
                }else{
                    ActivityCompat.requestPermissions(activity, permList, 204)
                }

            }else{
                Toast.makeText(activity, "Storage permissions already granted", Toast.LENGTH_SHORT).show()
            }
        }

        fun setContactPermission(activity: Activity){
            if(!activity.applicationContext.checkSinglePermission(Manifest.permission.READ_CONTACTS) ||
                !activity.applicationContext.checkSinglePermission(Manifest.permission.WRITE_CONTACTS)){

                val permList = arrayOf(
                    Manifest.permission.READ_CONTACTS,
                    Manifest.permission.WRITE_CONTACTS
                )
                if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.READ_CONTACTS)
                    || ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.WRITE_CONTACTS)) {

                    // Show an alert dialog here with request explanation
                    val builder = AlertDialog.Builder(activity, androidx.appcompat.R.style.Base_ThemeOverlay_AppCompat_Dialog_Alert)
                    builder.setMessage("Contact permissions required...")
                    builder.setTitle("Please grant those permissions")
                    builder.setPositiveButton("OK") { dialogInterface, i ->
                        ActivityCompat.requestPermissions(activity, permList, 204)
                    }
                    builder.setNeutralButton("Cancel", null)
                    val dialog = builder.create()
                    dialog.show()
                }else{
                    ActivityCompat.requestPermissions(activity, permList, 204)
                }

            }else{
                Toast.makeText(activity, "Contact permissions already granted", Toast.LENGTH_SHORT).show()
            }
        }


        private fun Context.checkSinglePermission(permission: String): Boolean {
            return ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED
        }


            fun showBackgroundLocationPermissionDialog(activity: Activity){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q){
                if (!activity.checkSinglePermission(Manifest.permission.ACCESS_BACKGROUND_LOCATION)){
                    val backPermList = arrayOf(Manifest.permission.ACCESS_BACKGROUND_LOCATION)
                    val dialog = AlertDialog.Builder(activity, androidx.appcompat.R.style.Base_ThemeOverlay_AppCompat_Dialog_Alert)
                        .setTitle("Background Location")
                        .setMessage("Allow background location permission for the app")
                        .setPositiveButton("Allow"){ dialog, _ ->
                            activity.requestPermissions(backPermList, 104)
                        }
                        .setNegativeButton("Cancel") { dialog, _ ->
                            dialog.dismiss()
                        }
                        .create()
                    dialog.show()
                }
            }
        }

        fun permisionDenied(activity: Activity) {
            activity.startActivity(Intent().apply {
                action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
                data = Uri.fromParts("package", activity.application.packageName, null)
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            })
        }


        fun gpsDialog(activity: Activity){
            val locationRequest = LocationRequest.create().apply { priority = LocationRequest.PRIORITY_LOW_POWER }
            val builder = LocationSettingsRequest.Builder().addLocationRequest(locationRequest)

            val settingsClient = LocationServices.getSettingsClient(activity)
            val locationSettingsResponseTask =
                settingsClient.checkLocationSettings(builder.build())

            locationSettingsResponseTask.addOnFailureListener { exception ->
                if (exception is ResolvableApiException){
                    // Location settings are not satisfied, but this can be fixed
                    // by showing the user a dialog.
                    try {
                        // Show the dialog by calling startResolutionForResult(),
                        // and check the result in onActivityResult().
                        exception.startResolutionForResult(activity,
                            201)
                    } catch (sendEx: IntentSender.SendIntentException) {

                    }
                } else {
                    Snackbar.make(activity.findViewById(android.R.id.content),
                        "Gps error occured...", Snackbar.LENGTH_INDEFINITE
                    ).setAction(android.R.string.ok) {
                        gpsDialog(activity)
                    }.show()
                }
            }
            locationSettingsResponseTask.addOnCompleteListener {
                if ( it.isSuccessful ) {
                    Log.d("Parth","call")
                }
            }

        }

    }




}