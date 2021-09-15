package com.example.apptreinando.model

import androidx.room.PrimaryKey
import io.realm.RealmObject

open class NotesModel(): RealmObject() {

    @PrimaryKey (autoGenerate = true)
    var id: Int? = null
    var titleNote: String = ""
    var descriptionNote: String = ""
}