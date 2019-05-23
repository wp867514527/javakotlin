package www.com.tianying.okhttpkotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import www.com.tianying.okhttpkotlin.base.BaseViewModel
import www.com.tianying.okhttpkotlin.bean.Banner

/**
 * @author CZZ
 * @data 2019/5/22
 * @email
 * @desc
 */
class HomeViewModel : BaseViewModel() {
    val banner: MutableLiveData<List<Banner>> by lazy { MutableLiveData<List<Banner>>() }

    fun getHomeBanner() {
        httpApi.getHomeBanner()
                .subscribe()
}
}