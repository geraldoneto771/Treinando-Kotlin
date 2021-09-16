package com.example.apptreinando.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.PopupMenu
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apptreinando.R
import com.example.apptreinando.databinding.FragmentHomeBinding
import com.example.apptreinando.databinding.ItemNoteUI
import com.example.apptreinando.model.NotesModel
import com.example.apptreinando.viewmodel.NotesViewModel
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class Home : Fragment() {

    private lateinit var mBinding: FragmentHomeBinding
    private lateinit var mViewmodel: NotesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = FragmentHomeBinding.inflate(inflater)
        mViewmodel = ViewModelProvider(requireActivity()).get(NotesViewModel::class.java)

        val date = Calendar.getInstance().time

        var dateTimeFormat = SimpleDateFormat("EEE, d MMM yyyy", Locale.getDefault())
        mBinding.date.text = dateTimeFormat.format(date)

        mViewmodel.getNote()

        mBinding.fab.setOnClickListener {
            findNavController().navigate(HomeDirections.actionHomeToRegistre())
        }

        mViewmodel.notes.observe(viewLifecycleOwner, Observer {
           mBinding.recyclerView.adapter = NoteAdapter(it)
           mBinding.recyclerView.layoutManager = LinearLayoutManager(requireContext(),
           RecyclerView.VERTICAL, false)
        })


        return mBinding.root
    }


    inner class NoteAdapter(val list: ArrayList<NotesModel>) :
        RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

        inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
            var bind: ItemNoteUI

            init {
                bind = ItemNoteUI.bind(itemView)
            }
        }


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder{
            return NoteViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_nota, parent, false)
            )
        }

        @SuppressLint("ResourceAsColor")
        override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
            val note = list[position]

            holder.bind.fieldName.text = note.titleNote


        }

        override fun getItemCount(): Int {
            return list.size
        }

    }


}