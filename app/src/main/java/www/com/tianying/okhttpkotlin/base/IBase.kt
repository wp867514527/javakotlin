package www.com.tianying.okhttpkotlin.base

import android.os.Bundle

/**
 * @author CZZ
 * @data 2019/5/22
 * @email
 * @desc 接口
 */
interface IBase {
    fun  getLayoutId():Int
    fun  init(savedInstanceState: Bundle?)

}