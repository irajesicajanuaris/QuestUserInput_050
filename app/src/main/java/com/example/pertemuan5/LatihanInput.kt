package com.example.pertemuan5

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun LatihanInput(modifier: Modifier = Modifier) {
    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var noTelpon by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var memilihJk by remember { mutableStateOf("") }

    var namasv by remember { mutableStateOf("") }
    var emailsv by remember { mutableStateOf("") }
    var noTelponsv by remember { mutableStateOf("") }
    var alamatsv by remember { mutableStateOf("") }
    var memilihJksv by remember { mutableStateOf("") }

    val listJk = listOf("Laki-laki", "Perempuan")

    Column(modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("Biodata",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold)

        Spacer(Modifier.padding(12.dp))
        TextField(
            modifier = Modifier .fillMaxWidth() .padding(5.dp),
            value = nama,
            onValueChange = {nama = it},
            label = { Text("nama")},
            placeholder = { Text("Masukkan Nama Anda")}
        )

        Row {
            listJk.forEach { item ->
                Row (verticalAlignment = Alignment.CenterVertically){ RadioButton(
                    selected = memilihJk == item,
                    onClick = {
                        memilihJk = item
                    }
                )
                    Text(item) }
            }
        }

        TextField(
            modifier = Modifier .fillMaxWidth() .padding(5.dp),
            value = email,
            onValueChange = {email = it},
            label = { Text("E-Mail")},
            placeholder = { Text("Masukkan E-Mail Anda")}
        )

        TextField(
            modifier = Modifier .fillMaxWidth() .padding(5.dp),
            value = noTelpon,
            onValueChange = {noTelpon = it},
            label = { Text("No Telp")},
            placeholder = { Text("Masukkan No Telpon Anda")}
        )

        TextField(
            modifier = Modifier .fillMaxWidth() .padding(5.dp),
            value = alamat,
            onValueChange = {alamat = it},
            label = { Text("Alamat")},
            placeholder = { Text("Masukkan Alamat Anda")}
        )

        Button (onClick = {
            namasv = nama
            emailsv = email
            noTelponsv = noTelpon
            alamatsv = alamat
            memilihJksv = memilihJk
        }) {
            Text("Submit")
        }
        ElevatedCard(
            colors = CardDefaults.cardColors(containerColor = Color.LightGray), modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
        ){
            DetailSurat(judul = "Nama", isinya = namasv )
            DetailSurat(judul = "Jenis Kelamin", isinya = memilihJksv )
            DetailSurat(judul = "E-Mail", isinya = emailsv )
            DetailSurat(judul = "NoTelpon", isinya = noTelponsv )
            DetailSurat(judul = "Alamat", isinya = alamatsv )
            DetailSurat(judul = "Jenis Kelamin", isinya = memilihJksv )

        }
    }
}

@Composable
fun DetailSurat(
    judul:String,isinya:String
){
    Column (modifier = Modifier.fillMaxWidth().padding(16.dp),
    ){

    }

    Row (
        modifier = Modifier.fillMaxWidth().padding(top = 2.dp)
    ){
        Text(text = judul,
            modifier = Modifier.weight(0.8f))
        Text(text = ":",
            modifier = Modifier.weight(0.2f))
        Text(text = isinya,
            modifier = Modifier.weight(2f))}
}