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
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

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
            "",
            "",
            "",
            "",
            "",
        )

        val addresses = listOf(
            "",
            "",
        )

        val resources = listOf(
            "",
            "",
            "",

        )

        val links = listOf(
            "https://www.cvs.com/",
            "https://www.target.com/",
            "https://www.7-eleven.com/",
            "https://www.aldi.us/",
            "https://www.ihop.com/en",
            "https://www.macys.com/",
            "https://new.mta.info/",
            "https://www.planetfitness.com/",
            "https://www.shoppersfood.com/",
            "https://www.walgreens.com/",
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
        ) {
            items(titles) { title ->
                val index = titles.indexOf(title)

                Column(
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
                    )
                    Text(
                        text = resources[index],
                        style = MaterialTheme.typography.bodySmall,
                        color = primaryLight,
                        modifier = Modifier
                    )
                    Text(
                        text = "Click here for this deal",
                        style = MaterialTheme.typography.bodySmall,
                        color = primaryLight,
                        modifier = Modifier
                            .clickable { openUrl(links[index]) }
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
