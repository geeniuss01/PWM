package me.samen.pwm.common

import dagger.Component
import me.samen.pwm.edit.EditActivity
import me.samen.pwm.home.HomeActivity
import me.samen.pwm.setup.SetupActivity
import javax.inject.Singleton

/*
 * Copyright (c) 2016 Newshunt. All rights reserved.
 */
@Component(modules = arrayOf(AppModule::class))
@Singleton
interface AppComponent {
    fun encUtil(): EncryptionUtil?
    fun appData():Data?
    fun injectA(editActivity: EditActivity)
    fun injectA(homeActivity: HomeActivity)

    fun  injectA(setupActivity: SetupActivity)

}