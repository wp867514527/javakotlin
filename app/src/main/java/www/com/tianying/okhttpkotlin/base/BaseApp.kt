package www.com.tianying.okhttpkotlin.base

import android.app.Application
import android.content.Context

/**
 * @author CZZ
 * @data 2019/5/22
 * @email
 * @desc
 */
class BaseApp : Application() {
    // 伴生对象 == java 静态成员以及函数
    companion object {
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }
}