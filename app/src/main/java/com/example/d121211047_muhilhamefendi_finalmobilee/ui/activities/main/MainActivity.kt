package com.example.d121211047_muhilhamefendi_finalmobilee.ui.activities.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.d121211047_muhilhamefendi_finalmobilee.data.models.ListDoa
import com.example.d121211047_muhilhamefendi_finalmobilee.ui.activities.details.DetailsActivity
import com.example.d121211047_muhilhamefendi_finalmobilee.ui.theme.D121211047_MuhIlhamEfendi_FinalMobileeTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            D121211047_MuhIlhamEfendi_FinalMobileeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        CenterAlignedTopAppBar (
                            title = {
                                Text(
                                    text = "Doa-Doa",
                                    fontWeight = FontWeight.SemiBold,
                                )
                            }
                        )
                        val mainViewModels: MainViewModels = viewModel(factory = MainViewModels.Factory)
                        ListDoaScreen(mainViewModels.mainUiState)
                    }
                }
            }
        }
    }
}

@Composable
fun ListDoaScreen(mainUiState: MainUiState, modifier: Modifier = Modifier) {
    Box (
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        when (mainUiState) {
            is MainUiState.Loading -> Text(text = "Loading...", fontSize = 16.sp,
                modifier = Modifier.align(Alignment.Center)
            )
            is MainUiState.Error -> Text(text = "Error Found", fontSize = 16.sp,
                modifier = Modifier.align(Alignment.Center)
            )
            is MainUiState.Success -> ListDoaDoa(
                doadoa = mainUiState.doadoa,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}
@Composable
fun ListDoaDoa(doadoa: List<ListDoa>, modifier: Modifier = Modifier){
    LazyColumn(modifier = modifier){
        items(doadoa){data ->
            DoaItem(doa = data)
        }
    }
}
@Composable
fun DoaItem(doa: ListDoa){
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .padding(8.dp)
            .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
            .clickable {
                val intent = Intent(context, DetailsActivity::class.java)
                intent.putExtra("DOA", doa)
                context.startActivity(intent)
            }
    ) {
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                text = doa.doa.toString(),
                style = MaterialTheme.typography.headlineSmall,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Normal,
            )
        }
    }
}
