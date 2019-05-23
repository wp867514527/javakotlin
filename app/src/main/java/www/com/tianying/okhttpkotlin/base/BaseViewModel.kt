package www.com.tianying.okhttpkotlin.base

import androidx.lifecycle.ViewModel
import www.com.tianying.okhttpkotlin.http.RetrofitClient

/**
 * @author CZZ
 * @data 2019/5/22
 * @email
 * @desc
 */
open class BaseViewModel : ViewModel() {
    val httpApi by lazy { RetrofitClient.httpApi }

}