package com.dualguard

import android.util.Log
import com.github.kyuubiran.ezxhelper.init.EzXHelperInit
import com.github.kyuubiran.ezxhelper.utils.*
import de.robv.android.xposed.IXposedHookLoadPackage
import de.robv.android.xposed.IXposedHookZygoteInit
import de.robv.android.xposed.XC_MethodHook
import de.robv.android.xposed.XposedHelpers
import de.robv.android.xposed.callbacks.XC_LoadPackage
import java.lang.reflect.Field

class HookLicense : IXposedHookZygoteInit, IXposedHookLoadPackage {
    override fun initZygote(startupParam: IXposedHookZygoteInit.StartupParam) {
        EzXHelperInit.initZygote(startupParam)

        Log.d("DualGuard", "Hooking!")
    }

    private enum class MobileStatus {
        ERROR,
        EXPIRED,
        FREE,
        PREMIUM,
        TRIAL;
    }

    override fun handleLoadPackage(lpparam: XC_LoadPackage.LoadPackageParam?) {
        if (lpparam != null) {
            when (lpparam.packageName) {
                "com.adguard.android" -> {
                    Log.d("DualGuard", "Finding method")

                    val clazz = lpparam.classLoader.loadClass("com.adguard.android.service.license.c")

                    // I don't fu**ing know why findMethod Won't work, so here is it
                    findAllMethods(clazz) {
                        name == "a" && isStatic
                    }.hookMethod {
                        after { param ->
                            Log.d("DualGuard", "Now hooking method: " + param.method.name);
                            param.result = MobileStatus.PREMIUM
                        }
                    }
                }
            }
        }

    }
}