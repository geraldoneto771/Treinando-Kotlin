package com.example.apptreinando.model

import androidx.room.PrimaryKey
import io.realm.RealmObject

open class NotesModel(): RealmObject() {

    @PrimaryKey (autoGenerate = true)
    var id: Int = 0
    var titleNote: String = ""
    var descriptionNote: String = ""
}