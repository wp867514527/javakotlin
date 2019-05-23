package www.com.tianying.okhttpkotlin.http

import com.franmontiel.persistentcookiejar.PersistentCookieJar
import com.franmontiel.persistentcookiejar.cache.SetCookieCache
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import www.com.tianying.okhttpkotlin.base.BaseApp
import www.com.tianying.okhttpkotlin.bean.api.HttpApi
import www.com.tianying.okhttpkotlin.bean.api.HttpUtil
import java.util.logging.Level

/**
 * @author CZZ
 * @data 2019/5/22
 * @email
 * @desc retrofit 处理类  object 貌似 等于 java 静态类
 */
object RetrofitClient {
    // 懒加载
    val httpApi by lazy { RetrofitClient.getService(HttpApi::class.java,HttpUtil.baseUrl) }
    private val cache: Cache = Cache(BaseApp.context.cacheDir, 1024 * 1024 * 1024 * 20)
    private val cookieJar by lazy { PersistentCookieJar(SetCookieCache(), SharedPrefsCookiePersistor(BaseApp.context)) }

    private val okHttpClient: OkHttpClient // 一种成员变量的赋值写法
        get() {
            return OkHttpClient.Builder()
                    .cookieJar(cookieJar)
                    .cache(cache)
                    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .build()

        }


    private fun <S> getService(service: Class<S>, baseUrl: String): S {
        return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(FastJsonConverterFactory.create())
                .build().create(service)
    }


}