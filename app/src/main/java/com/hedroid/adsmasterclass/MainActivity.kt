package com.hedroid.adsmasterclass

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.farimarwat.composenativeadmob.nativead.BannerAdAdmobMedium
import com.farimarwat.composenativeadmob.nativead.BannerAdAdmobSmall
import com.farimarwat.composenativeadmob.nativead.rememberNativeAdState
import com.google.android.gms.ads.MobileAds
import com.hedroid.adsmasterclass.adsContainer.InterstitialAds.interstitialAdsContainer
import com.hedroid.adsmasterclass.adsContainer.bannersAds.AdMobBanner
import com.hedroid.adsmasterclass.adsContainer.rewardedAdsContainer.rewardedAds
import com.hedroid.adsmasterclass.ui.theme.AdsMasterClassTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        MobileAds.initialize(this)

        setContent {
            val adstate = rememberNativeAdState(context = this@MainActivity, adUnitId = "ca-app-pub-3940256099942544/2247696110")
            AdsMasterClassTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
                   Column {
                       AdMobBanner(modifier = Modifier
                           .padding(innerPadding)
                           .fillMaxWidth())
                       Spacer(modifier = Modifier.height(20.dp))

                       Button(onClick = { interstitialAdsContainer(activity = this@MainActivity) }) {
                           Text(text = "Show Interstitial Ad")
                       }
                       Spacer(modifier = Modifier.height(20.dp))
                       Button(onClick = { rewardedAds(activity = this@MainActivity) }) {
                           Text(text = "Show Rewarded Ad")
                       }
                       Spacer(modifier = Modifier.height(10.dp))

                           //Small Banner
                           BannerAdAdmobSmall(loadedAd = adstate)
                           Spacer(modifier = Modifier.fillMaxWidth())
                           //Medium Banner
                           BannerAdAdmobMedium(loadedAd = adstate)


                   }
                }
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AdsMasterClassTheme {
        Greeting("Android")
    }
}