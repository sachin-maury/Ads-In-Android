package com.hedroid.adsmasterclass.adsContainer.rewardedAdsContainer

import android.app.Activity
import android.widget.Toast
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.OnUserEarnedRewardListener
import com.google.android.gms.ads.rewarded.RewardItem
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback

fun rewardedAds(activity: Activity) {

    RewardedAd.load(activity,
        "ca-app-pub-3940256099942544/5224354917",
        AdRequest.Builder().build(),
        object : RewardedAdLoadCallback() {
            override fun equals(other: Any?): Boolean {
                return super.equals(other)
            }

            override fun onAdFailedToLoad(p0: LoadAdError) {
                super.onAdFailedToLoad(p0)
            }

            override fun onAdLoaded(rewardedAd: RewardedAd) {
                super.onAdLoaded(rewardedAd)
                rewardedAd.fullScreenContentCallback = object : FullScreenContentCallback() {
                    override fun equals(other: Any?): Boolean {
                        return super.equals(other)
                    }

                    override fun onAdDismissedFullScreenContent() {
                        super.onAdDismissedFullScreenContent()
                        rewardedAds(activity = activity)
                        onAdDismissedFullScreenContent()

                    }

                    override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                        super.onAdFailedToShowFullScreenContent(adError)


                    }
                }
                rewardedAd.show(activity, object : OnUserEarnedRewardListener {
                    override fun onUserEarnedReward(p0: RewardItem) {
                        Toast.makeText(activity, "add Finished", Toast.LENGTH_LONG).show()
                    }

                })
            }
        })
}