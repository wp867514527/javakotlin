package www.com.tianying.okhttpkotlin.bean.api

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import www.com.tianying.okhttpkotlin.bean.Article
import www.com.tianying.okhttpkotlin.bean.Banner


/**
 * @author CZZ
 * @data 2019/5/22
 * @email
 * @desc
 */
interface HttpApi {
    @GET("/banner/json")
    fun getHomeBanner(): Observable<NetBean<List<Banner>>>

    @GET("/article/list/{page}/json")
    fun getHomeData(@Path("page") page: Int): Observable<NetBean<Article>>
}