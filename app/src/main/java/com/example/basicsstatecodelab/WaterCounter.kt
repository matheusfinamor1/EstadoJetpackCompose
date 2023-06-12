package com.example.basicsstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

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
         */
        var count by remember {
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
}