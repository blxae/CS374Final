package com.example.finalproject

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment


class MapFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                MaterialTheme {
                    ScrollingScreen()
                }
            }
        }
    }






    @Composable
    fun ScrollingScreen(){
        val titles = listOf(
            "Imagination Playground Public Restroom",
            "The Battery Public Restroom",
            "Washington Market Park Public Restroom",
            "Columbus Park Pavilion",
            "Washington Square Park Public Restroom",
            "McKinley Playground Public Restroom",
            "Seward Park Public Restroom",
            "Little Flower Playground Public Restroom",
            "Downing Street Playground Public Restroom",
            "Brian Watkins Tennis Center Public Restroom",

        )

        val descriptions = listOf(
            "165 JOHN STREET",
            "Battery Pl. & Washington St.",
            "Greenwich St. & Chambers St.",
            "Bayard Street between Baxter and Mulberry Streets",
            "5 Avenue, Waverly Place, West 4 & MacDougal Streets.",
            "Avenue A, East 3-East 4 Streets",
            "Jefferson & Canal Streets",
            "Madison Street opposite Jefferson Street",
            "Downing to Carmine Streets, Avenue of the Americas",
            "East River Park at Broome Street",
        )


        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
        ) {
            items(titles) { title ->
                val index = titles.indexOf(title)

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .background(
                            color = primaryContainerLight,
                            shape = RoundedCornerShape(20.dp)
                        )
                        .padding(10.dp)
                ) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.bodyLarge,
                        color = primaryLight,
                    )
                    Text(
                        text = descriptions[index],
                        style = MaterialTheme.typography.bodySmall,
                        color = primaryLight,
                        modifier = Modifier
                    )
                }
                Spacer(modifier = Modifier
                    .background(primaryDark)
                    .height(20.dp)
                )
            }
        }
    }



    private fun openUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}


