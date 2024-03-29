package com.example.basicsstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/*
@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    /**
     * Composição: Uma descrição da IU criada pelo Jetpack Compose ao executar elementos combinaveis.
     *
     * Composição Inicial: A criação de uma composição ao executar elementos combinaveis pela primeira
     * vez.
     *
     * Recomposição: Nova execução de elementos combinaveis para atualizar a composição quando os
     * dados mudam.
     */
    Column(modifier = Modifier.padding(16.dp)) {
        /**
         * MutableState e State tornam o estado observavel (por conta do "value").
         * O Compose monitora cada elemento combinavel que le propriedades do estado "value" e aciona
         * uma recomposição quando "value" muda.
         *
         * Remember é utilizado como mecanismo para armazenar um unico objeto na composição.
         * No caso, quando haver a recomposição, o valor do "count" não será perdido.
         *
         * Neste exemplo, estamos utilizando o delegate "by", que faz com que nao precise referenciar
         * de forma explicita o ".value" do objeto.
         *
         * RememberSaveable salva o estado para quando há mudança de config e rotação (se fizer
         * rotação de tela com um valor que tem somente o "remember", esse valor será perdido)
         */
        var count by rememberSaveable {
            mutableStateOf(0)
        }

        if (count > 0) {
            Text(
                text = "You've had $count glasses.",
            )
        }
        Button(
            onClick = { count++ },
            Modifier.padding(top = 8.dp),
            enabled = count < 10
        ) {
            Text(text = "Add one")
        }
    }
}*/

@Composable
fun StatelessCounter(count: Int, onIncrement: () -> Unit, modifier: Modifier = Modifier){
    Column(
        modifier = modifier.padding(16.dp)
    ) {
        if(count > 0){
            Text(text = "You've had $count glasses.")
        }
        Button(
            onClick = onIncrement, Modifier.padding(top = 8.dp), enabled = count < 10
        ) {
            Text(text = "Add one")
        }
    }
}

@Composable
fun StatefulCounter(modifier: Modifier = Modifier){
    var count by rememberSaveable {
        mutableStateOf(0)
    }
    StatelessCounter(count = count, onIncrement = {count++}, modifier)
}



