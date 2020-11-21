package br.com.teste.aula28_exercicio1.contador.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ContadorViewModel: ViewModel() {

    var contador = MutableLiveData<Int>().apply{ value = 0 }

    //outra opção
    /*init{
        contador.value = 0
    }*/

    fun incrementar(){
        if(contador.value != null){
            contador.value = contador.value!! + 1
        }
    }
}