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


class ScrollingFragment : Fragment() {

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
            "CVS: 50% off all deodorants May 15th-20th.",
            "Target: Buy One Get One Free on Oatmeal",
            "7-11: 15% off water cases",
            "Aldi: Everyday low prices.",
            "iHop: Join iHop rewards today!",
            "Macy's: Sale on basics",
            "MTA: Discount on MetroCards",
            "Planet Fitness: Join today!",
            "Shoppers savings",
            "Walgreens: $2 off bath tissue"
        )

        val descriptions = listOf(
            "Happy Spring! CVS will be offering 50% off all deodorant products with a purchase of $5 or more.",
            "Looking for a healthy breakfast option for the whole family? From now until June 1st, when you buy one box of oatmeal, get the second one FREE!",
            "This deal applies with a purchase of $10 or more. Get Dasani or Aquafina water cases 15% off!",
            "Get ready-to-eat meals for as low as $5 from now until the end of the season. Feed the whole family!",
            "Enjoy daily specials, with entrees starting at just $6. Get 20% off your first online order with the code IHOP20.",
            "From now until June 1st, save big on basics! Shirts and blouses up to 20% off. Shorts and trousers up to 25% off.",
            "Get a MetroCard this season! Now when you swipe 15 times in one week with the same card, you ride free for the rest of the week.",
            "Join today for just $10 and get two free months of membership! Valid until September. Enjoy our facilities including state-of-the-art equipment, showers, and locker rooms.",
            "This summer, enjoy savings on basic hygiene items. Get 15% off period products from now until July 30th.",
            "In the month of May, when you make a purchase of $3 or more, get $2 off bath tissue. Good for up to 10 uses."
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
                        text = descriptions[index],
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


