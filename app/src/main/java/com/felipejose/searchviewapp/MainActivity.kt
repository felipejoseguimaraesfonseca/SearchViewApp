package com.felipejose.searchviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pesquisa = findViewById<SearchView>(R.id.pesquisa) as SearchView

        val lista = findViewById<ListView>(R.id.lista) as ListView

        val linguagens =  arrayOf("Kotlin", "JavaScript", "Python", "Swift", "Flutter", "C#(sharp)", "C++", "C", "Java", "Angular","CSS", "PHP")

        val linguagemAdap : ArrayAdapter<String> = ArrayAdapter(this,android.R.layout.simple_list_item_1,linguagens)

        lista.adapter = linguagemAdap

        pesquisa.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                linguagemAdap.filter.filter(newText)
                return false
            }
        })

        }
    }

