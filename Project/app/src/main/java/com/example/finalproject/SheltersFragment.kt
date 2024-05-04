package com.example.finalproject

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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


/**
 * A simple [Fragment] subclass.
 * Use the [SheltersFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SheltersFragment : Fragment() {

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
            "The Bowery Mission - Tribeca Campus",
            "Coalition for the Homeless",
            "Project Renewal Third Street Men's Shelter",
            "Covenant House New York"
        )

        val addresses = listOf(
            "90 Lafayette Street, New York, NY, 10013",
            "129 Fulton St, New York, NY, 10038",
            "8 E 3rd St #8908, New York, NY 10003",
            "460 West 41st St, New York, NY 10036"
        )

        val resources = listOf(
            "Provides: food, clothing, meals, housing support, shower facilities, hygiene support",
            "Provides: food, clothing, housing, eviction assistance, domestic violence support",
            "Provides: housing support, employment services, healthcare assistance",
            "Provides: housing, health services, LGBTQ+ support, mental health resources"
        )

        val links = listOf(
            "https://www.bowery.org/",
            "https://www.coalitionforthehomeless.org/",
            "https://www.projectrenewal.org/",
            "https://ny.covenanthouse.org/"
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
                        text = addresses[index],
                        style = MaterialTheme.typography.bodySmall,
                        color = primaryLight,
                        modifier = Modifier
                            .padding(8.dp)
                    )
                    Text(
                        text = resources[index],
                        style = MaterialTheme.typography.bodySmall,
                        color = primaryLight,
                        modifier = Modifier
                            .padding(8.dp)
                    )
                    Text(
                        text = "Visit website",
                        style = MaterialTheme.typography.bodySmall,
                        color = primaryLight,
                        modifier = Modifier
                            .background(
                                color = primaryDark,
                                shape = RoundedCornerShape(20.dp)
                            )
                            .clickable { openUrl(links[index]) }
                            .padding(8.dp)
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