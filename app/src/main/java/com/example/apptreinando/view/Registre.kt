package com.example.apptreinando.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.apptreinando.databinding.FragmentRegistreBinding
import com.example.apptreinando.model.NotesModel
import com.example.apptreinando.viewmodel.NotesViewModel
import com.google.android.material.snackbar.Snackbar


class Registre : Fragment() {

    private lateinit var mBinding: FragmentRegistreBinding
    private lateinit var mViewModel: NotesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = FragmentRegistreBinding.inflate(inflater)
        mViewModel = ViewModelProvider(requireActivity()).get(NotesViewModel::class.java)

        mBinding.buttonSaveRegistreNote.setOnClickListener {

            saveNote()
            findNavController().popBackStack()
        }

        return mBinding.root
    }

    private fun saveNote() {

        val notes = NotesModel()

        try {

            val titleNote = mBinding.editTitleNote.text
            val descriptionNote = mBinding.editDescription

            notes.titleNote = titleNote.toString()
            notes.descriptionNote = descriptionNote.toString()

            mViewModel.createNotes(notes)


            Snackbar.make(mBinding.root, "Nota salva com sucesso!", Snackbar.LENGTH_SHORT).show()

        } catch (nfe: NumberFormatException) {
            Snackbar.make(
                mBinding.root,
                "Informe valores validos", Snackbar.LENGTH_SHORT
            ).show()
        }

    }

}