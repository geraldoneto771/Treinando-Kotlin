package com.example.apptreinando.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apptreinando.model.NotesModel
import com.example.apptreinando.repository.db.notes.Repository as NotesDB

class NotesViewModel: ViewModel() {

    //
    private val _notes = MutableLiveData<ArrayList<NotesModel>>().apply { value = ArrayList() }
    val notes: LiveData<ArrayList<NotesModel>> = _notes

    // Criar nota no repositorio local
    fun createNotes(note: NotesModel) { NotesDB().create(note)}

    // Deletar nota
    //fun deleteNote(id: String): Boolean { return NotesDB().delete(id, _notes)}

    // Pegar lista de notas do repositorio local
    //fun getNote() { NotesDB().getAll(_notes)}

    //
    /*fun update(note: NotesModel, item: Int) {
        var obj = _notes.value?.get(item)!!
        NotesDB().update(note, _notes.obj)
    }*/
}