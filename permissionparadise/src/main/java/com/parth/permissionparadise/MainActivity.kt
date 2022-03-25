package com.parth.permissionparadise

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var btnLocation : Button
    private lateinit var btnStorage : Button
    private lateinit var btnCamera : Button
    private lateinit var btnCallLog : Button
    private lateinit var btnMessage : Button
    private lateinit var btnContact : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*initviews()
        setOnClickListener()*/
    }

    /*private fun setOnClickListener() {
        btnMessage.setOnClickListener(this)
        btnLocation.setOnClickListener(this)
        btnCamera.setOnClickListener(this)
        btnCallLog.setOnClickListener(this)
        btnStorage.setOnClickListener(this)
        btnContact.setOnClickListener(this)
    }

    private fun initviews() {
        btnCallLog = findViewById(R.id.btnPermCallLog)
        btnCamera = findViewById(R.id.btnPermCameraPhoto)
        btnLocation = findViewById(R.id.btnPermLocation)
        btnMessage = findViewById(R.id.btnPermMessage)
        btnStorage = findViewById(R.id.btnPermStorage)
        btnContact = findViewById(R.id.btnPermContact)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnPermCallLog ->{
                PermissionUtils.setCallLogPermission(this@MainActivity)
            }
            R.id.btnPermCameraPhoto ->{
                PermissionUtils.setCameraPermission(this@MainActivity)
            }
            R.id.btnPermStorage ->{
                PermissionUtils.setStoragePermission(this@MainActivity)
            }
            R.id.btnPermMessage ->{
                PermissionUtils.setMessagePermission(this@MainActivity)
            }
            R.id.btnPermLocation ->{
                PermissionUtils.setLocationPermission(this@MainActivity)
            }
            R.id.btnPermContact ->{
                PermissionUtils.setContactPermission(this@MainActivity)
            }
        }
    }


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        // Check whether the permission request was rejected.
        when (requestCode) {
            101 -> {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED &&
                    grantResults[1] == PackageManager.PERMISSION_GRANTED ) {

                    Toast.makeText(this@MainActivity, "Location permission granted for P and below", Toast.LENGTH_SHORT)
                        .show()
                }else if(shouldShowRequestPermissionRationale(permissions[0])
                    || shouldShowRequestPermissionRationale(permissions[1])){
                    PermissionUtils.setLocationPermission(this@MainActivity)
                }else{
                    PermissionUtils.permisionDenied(this)
                }
            }
            102 ->{

                if (grantResults[0] == PackageManager.PERMISSION_GRANTED &&
                    grantResults[1] == PackageManager.PERMISSION_GRANTED &&
                    grantResults[2] == PackageManager.PERMISSION_GRANTED) {

                    Toast.makeText(this@MainActivity, "Location permission granted for Q", Toast.LENGTH_SHORT)
                        .show()

                }else if(shouldShowRequestPermissionRationale(permissions[0])
                    || shouldShowRequestPermissionRationale(permissions[1])
                    || shouldShowRequestPermissionRationale(permissions[2])){
                    PermissionUtils.setLocationPermission(this@MainActivity)
                }else{
                    PermissionUtils.permisionDenied(this)
                }
            }
            103 ->{

                if (grantResults[0] == PackageManager.PERMISSION_GRANTED &&
                    grantResults[1] == PackageManager.PERMISSION_GRANTED)
                {
                    PermissionUtils.showBackgroundLocationPermissionDialog(this@MainActivity)
                }else if(shouldShowRequestPermissionRationale(permissions[0])
                    || shouldShowRequestPermissionRationale(permissions[1])){
                    PermissionUtils.setLocationPermission(this@MainActivity)
                }else{
                    PermissionUtils.permisionDenied(this)
                }

            }
            104->{
                if (grantResults[0] != PackageManager.PERMISSION_GRANTED){
                    PermissionUtils.showBackgroundLocationPermissionDialog(this@MainActivity)
                }else{
                    Toast.makeText(this@MainActivity, "Location permission granted for Q and above", Toast.LENGTH_SHORT)
                        .show()
                }
            }
            201 ->{
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED &&
                    grantResults[1] == PackageManager.PERMISSION_GRANTED)
                {
                    Toast.makeText(this@MainActivity, "Call_Log permission granted", Toast.LENGTH_SHORT)
                        .show()
                }else if(shouldShowRequestPermissionRationale(permissions[0])){
                    PermissionUtils.setCallLogPermission(this@MainActivity)
                }else{
                    PermissionUtils.permisionDenied(this)
                }
            }
            202 ->{
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    Toast.makeText(this@MainActivity, "SMS permission granted", Toast.LENGTH_SHORT)
                        .show()
                }else if(shouldShowRequestPermissionRationale(permissions[0])){
                    PermissionUtils.setMessagePermission(this@MainActivity)
                }else{
                    PermissionUtils.permisionDenied(this)
                }
            }
            203 ->{
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    Toast.makeText(this@MainActivity, "Camera permission granted", Toast.LENGTH_SHORT)
                        .show()
                }else if(shouldShowRequestPermissionRationale(permissions[0])){
                    PermissionUtils.setCameraPermission(this@MainActivity)
                }else{
                    PermissionUtils.permisionDenied(this)
                }
            }
            204 ->{
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED
                    && grantResults[1] == PackageManager.PERMISSION_GRANTED)
                {
                    Toast.makeText(this@MainActivity, "Storage permission granted", Toast.LENGTH_SHORT)
                        .show()
                }else if(shouldShowRequestPermissionRationale(permissions[0])
                    || shouldShowRequestPermissionRationale(permissions[1])){
                    PermissionUtils.setStoragePermission(this@MainActivity)
                }else{
                    PermissionUtils.permisionDenied(this)
                }
            }
            205 ->{
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED
                    && grantResults[1] == PackageManager.PERMISSION_GRANTED)
                {
                    Toast.makeText(this@MainActivity, "Contact permission granted", Toast.LENGTH_SHORT)
                        .show()
                }else if(shouldShowRequestPermissionRationale(permissions[0])
                    || shouldShowRequestPermissionRationale(permissions[1])){
                    PermissionUtils.setContactPermission(this@MainActivity)
                }else{
                    PermissionUtils.permisionDenied(this)
                }
            }
        }

    }
*/
}