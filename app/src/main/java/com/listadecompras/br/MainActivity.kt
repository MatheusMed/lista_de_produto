package com.listadecompras.br

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list_view = findViewById<ListView>(R.id.list_view_produtos)

        val btn_add = findViewById<Button>(R.id.btn_add)

        val txt_produto = findViewById<EditText>(R.id.txt_produto)

        val produtoAdapter = ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line)

        list_view.setOnItemLongClickListener { _, _, position, _ ->

            val item = produtoAdapter.getItem(position)

            produtoAdapter.remove(item)

            true
        }

        list_view.adapter = produtoAdapter

        btn_add.setOnClickListener {
            val produto = txt_produto.text.toString()

            if(produto.isNotEmpty()){
                produtoAdapter.add(produto)

                txt_produto.text.clear()
            }else{
                txt_produto.error = "Preencha um valor"
            }


        }
    }
}