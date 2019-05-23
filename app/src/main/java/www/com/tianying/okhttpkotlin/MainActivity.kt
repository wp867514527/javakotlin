package www.com.tianying.okhttpkotlin

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

import www.com.tianying.okhttpkotlin.base.BaseActivity
import www.com.tianying.okhttpkotlin.base.BaseFragment
import www.com.tianying.okhttpkotlin.ui.fragment.HomeFragment

/**
 * @author CZZ
 * @date 2019/5/22
 * @email
 * @desc 主页面
 */

class MainActivity : BaseActivity() {
    private val homeFragment by lazy { HomeFragment() }
    private val fragmentList = arrayListOf<BaseFragment>()
    override fun getLayoutId(): Int = R.layout.activity_main
    override fun init(savedInstanceState: Bundle?) {
        bottom_navigation_view.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    switchFragment(0)
                }
                else -> {
                    switchFragment(1)
                }

            }
            return@setOnNavigationItemSelectedListener true
        }
        bottom_navigation_view.selectedItemId = R.id.home
    }

    init {
        fragmentList.add(homeFragment)
        fragmentList.add(homeFragment)
        fragmentList.add(homeFragment)
        fragmentList.add(homeFragment)

    }

    private fun switchFragment(pos: Int) {
        val fragment = fragmentList[pos]
        if (pos == 0) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.fl_content, fragment)
                    .commit()
        } else {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fl_content, fragment)
                    .commit()
        }

    }
}
