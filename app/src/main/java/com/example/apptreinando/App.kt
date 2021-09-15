package com.example.apptreinando

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        // Iniciando o realm
        Realm.init(this)

        //configurando o realm
        val conf = RealmConfiguration.Builder()
            .name("app.realm")
            .schemaVersion(0L)
            .allowQueriesOnUiThread(true)
            .allowWritesOnUiThread(true)
            .build()

        // Setando as configurações do realm com as informações da conf
        Realm.setDefaultConfiguration(conf)

    }
}