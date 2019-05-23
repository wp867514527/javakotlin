package www.com.tianying.okhttpkotlin.ui.fragment

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import www.com.tianying.okhttpkotlin.R
import www.com.tianying.okhttpkotlin.base.BaseFragment
import www.com.tianying.okhttpkotlin.viewmodel.HomeViewModel

/**
 * @author CZZ
 * @data 2019/5/22
 * @email
 * @desc
 */
class HomeFragment :BaseFragment() {
    override fun init(savedInstanceState: Bundle?) {
        val viewModel = ViewModelProviders.of(this)
                .get(HomeViewModel::class.java)

        viewModel.getHomeBanner()
    }

    override fun getLayoutId(): Int = R.layout.fragment_home
}