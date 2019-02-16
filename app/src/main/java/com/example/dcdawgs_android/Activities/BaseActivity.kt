package com.example.dcdawgs_android
import android.support.v7.app.AppCompatActivity
import com.amazonaws.mobile.config.AWSConfiguration
import com.amazonaws.mobileconnectors.appsync.AWSAppSyncClient

open class BaseActivity: AppCompatActivity() {
    private var _AWSAppSyncClient: AWSAppSyncClient? = null

    val awsAppSyncClient: AWSAppSyncClient
        get() {
            if (_AWSAppSyncClient == null) {
                val awsConfig: AWSConfiguration = AWSConfiguration(applicationContext)
                val builder = AWSAppSyncClient.builder()
                _AWSAppSyncClient = builder.awsConfiguration(awsConfig).build()
            }
            return _AWSAppSyncClient ?: throw AssertionError("AppSyncClient Unexpectedly Null")
        }

}