package me.samen.pwm.common

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

/*
 * Copyright (c) 2016 Newshunt. All rights reserved.
 */
@Module
class AppModule(val application: Application, val key : String) {
    @Provides @Singleton fun getApp(): Application = application
    @Provides @Singleton @Named("encKey")  fun getEncKey(): String = key
}