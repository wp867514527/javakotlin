package www.com.tianying.okhttpkotlin.bean.api

/**
 * @author CZZ
 * @data 2019/5/22
 * @email
 * @desc
 */
data class NetBean<out T>(val errorCode: Int, val errorMsg: String, val data: T) {

}