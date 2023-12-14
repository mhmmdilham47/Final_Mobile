package com.example.d121211047_muhilhamefendi_finalmobilee.ui.activities.details

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.d121211047_muhilhamefendi_finalmobilee.data.models.ListDoa
import com.example.d121211047_muhilhamefendi_finalmobilee.ui.theme.D121211047_MuhIlhamEfendi_FinalMobileeTheme


class DetailsActivity: ComponentActivity()  {
    private var selectedDoa: ListDoa? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        selectedDoa = intent.getParcelableExtra("DOA")
        setContent {
            D121211047_MuhIlhamEfendi_FinalMobileeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DetailScreen()
                }
            }
        }
    }

    @Composable
    fun DetailScreen() {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = selectedDoa?.doa.toString(),
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Ayat : ${selectedDoa?.ayat?.toString()}",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Normal
            )

            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Latin: ${selectedDoa?.latin?.toString()}",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Normal
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Artinya: ${selectedDoa?.artinya?.toString()}",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Normal
             )
        }
    }