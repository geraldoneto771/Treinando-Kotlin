package com.example.apptreinando.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import org.bson.types.ObjectId

open class NotesModel(): RealmObject() {

    @PrimaryKey
    var id: ObjectId = ObjectId()
    var titleNote: String = ""
    var descriptionNote: String = ""
}