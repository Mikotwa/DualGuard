package com.dualguard

import android.widget.ImageView
import android.widget.TextView
import androidx.viewbinding.BuildConfig

import com.drakeet.about.*
import com.dualguard.BuildConfig.VERSION_NAME

class AboutActivity : AbsAboutActivity() {
    override fun onCreateHeader(icon: ImageView, slogan: TextView, version: TextView) {
        icon.setImageResource(R.drawable.ic_launcher_foreground);
        slogan.text = "关于 DualGuard";
        version.text = "v" + VERSION_NAME;
    }

    override fun onItemsCreated(items: MutableList<Any>) {
        items.add(Category("介绍与帮助"))
        items.add(Card("该模块旨在帮助那些购买了 AdGuard 个人版授权，却又拥有刚好大于三台设备的人使用高级特性。"
                + "\n\n"
                + "默认情况下，AdGuard 的个人版授权仅允许激活三台设备。该模块可以让 Android 设备上的 AdGuard 无视该授权限制。"
                + "\n\n"
                + "首先，该模块 *不能，也不会* 免费帮你获得高级版授权。如果你只是想要破解 AdGuard，那么你来错地方了。"
                + "\n\n"
                + "如果你已经拥有合法的 AdGuard 授权，那么请继续阅读使用方法：\n"
                + "1. 下载，安装 AdGuard 本体，并使用你的授权许可激活应用\n"
                + "2. 在 LSPosed 里激活该模块\n"
                + "3. 强行停止 + 重开 AdGuard"
                + "\n\n"
                + "在所有设备上享受高级版权限吧！"))

        items.add(Category("开发者"))
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