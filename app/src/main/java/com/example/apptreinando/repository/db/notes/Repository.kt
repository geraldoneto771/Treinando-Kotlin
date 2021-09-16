package com.example.apptreinando.repository.db.notes

import androidx.lifecycle.MutableLiveData
import com.example.apptreinando.model.NotesModel
import io.realm.Realm
import io.realm.kotlin.where

class Repository {

    //
    fun create(note: NotesModel){
        val realm = Realm.getDefaultInstance()

        realm.executeTransaction {
            it.insert(note)
        }
    }

    fun getAll(_notes: MutableLiveData<ArrayList<NotesModel>>) {
        val realm = Realm.getDefaultInstance()

        realm.addChangeListener {
            val notes = realm.where<NotesModel>().findAll()
            var list = ArrayList<NotesModel>()

            list.addAll(notes)
            list = ArrayList<NotesModel>()
            list.addAll(notes)
            _notes.postValue(list)

            _notes.value = list
        }
    }

}