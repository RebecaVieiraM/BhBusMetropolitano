package com.example.bhbusmetropolitano

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.bhbusmetropolitano.model.OnibusModel
import com.example.bhbusmetropolitano.repository.AppDatabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val onibusDatabase = AppDatabase.getDataBase(this).onibusDAO()

        val retornoInsert = onibusDatabase.insertOnibus(OnibusModel().apply {
            this.nome = "Centro Contagem"
            this.numero = 2550
            this.cor = "vermelho"
            this.tipo = "ótimo"
            this.peso = "16t"
        })

        onibusDatabase.insertOnibus(OnibusModel().apply {
            this.nome = "Grajaú"
            this.numero = 330
            this.cor = "azul"
            this.tipo = "mediano"
            this.peso = "16t"
        })

        onibusDatabase.insertOnibus(OnibusModel().apply {
            this.nome = "Barreiro"
            this.numero = 122
            this.cor = "amarelo"
            this.tipo = "ótimo"
            this.peso = "16t"
        })

        onibusDatabase.insertOnibus(OnibusModel().apply {
            this.nome = "Centro BH"
            this.numero = 993
            this.cor = "laranja"
            this.tipo = "bom"
            this.peso = "16t"
        })

        onibusDatabase.updateOnibus(OnibusModel().apply {
            this.id_onibus = 1
            this.nome = "Centro Contagem"
            this.numero = 2551
            this.cor = "vermelho"
            this.tipo = "péssimo"
            this.peso = "16t"
        })

        onibusDatabase.deleteOnibus(OnibusModel().apply {
            this.id_onibus = 2
        })

        val retornoSelectMultiplo = onibusDatabase.getAll()

        for (item in retornoSelectMultiplo) {
            Log.d(
                "Retorno",
                "id_onibus: ${item.id_onibus}, nome: ${item.nome}," +
                        "numero: ${item.numero}, cor: ${item.cor}, tipo: ${item.tipo}, peso: ${item.peso}"
            )
        }
    }
}