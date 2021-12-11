package com.dualguard

import android.widget.ImageView
import android.widget.TextView
import androidx.viewbinding.BuildConfig

import com.drakeet.about.*
import com.dualguard.BuildConfig.VERSION_NAME

class AboutActivity : AbsAboutActivity() {
    override fun onCreateHeader(icon: ImageView, slogan: TextView, version: TextView) {
        icon.setImageResource(R.drawable.ic_launcher_foreground);
        slogan.text = getString(R.string.about_slogan);
        version.text = "v" + VERSION_NAME;
    }

    override fun onItemsCreated(items: MutableList<Any>) {
        items.add(Category(getString(R.string.about_module_intro_and_help_title)))
        items.add(Card(getString(R.string.about_module_intro_and_help_text)))

        items.add(Category(getString(R.string.about_module_developer_title)))
        items.add(
            Contributor(
                R.drawable.avatar_mogu,
                "Mogu",
                "Developer & designer",
            )
        )

        items.add(Category("Open Source Licenses"))
        items.add(
            License(
                "MultiType",
                "drakeet",
                License.APACHE_2,
                "https://github.com/drakeet/MultiType"
            )
        )
        items.add(
            License(
                "about-page",
                "drakeet",
                License.APACHE_2,
                "https://github.com/drakeet/about-page"
            )
        )
        items.add(
            License(
                "EzXHelper",
                "KyuubiRan",
                License.APACHE_2,
                "https://github.com/KyuubiRan/EzXHelper"
            )
        )
        items.add(
            License(
                "material-dialogs",
                "Aidan Follestad",
                License.APACHE_2,
                "https://github.com/afollestad/material-dialogs"
            )
        )
        items.add(
            License(
                "about-page",
                "drakeet",
                License.APACHE_2,
                "https://github.com/drakeet/about-page"
            )
        )
    }

}