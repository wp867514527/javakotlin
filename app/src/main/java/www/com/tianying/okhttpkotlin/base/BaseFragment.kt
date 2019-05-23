package www.com.tianying.okhttpkotlin.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * @author CZZ
 * @data 2019/5/22
 * @email
 * @desc
 */
abstract class BaseFragment : Fragment(), IBase {
    private var rootView: View? = null
    private var userVisible: Boolean = false
    private var viewInitialize: Boolean = false
    private var dataInitialize: Boolean = false
    private var savedInstanceState: Bundle? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (rootView != null) {
            if (rootView?.parent != null) {
                if (rootView?.parent is ViewGroup) { // 判断类型
                    var parent = rootView?.parent as ViewGroup // 转换类型
                    parent.removeView(rootView)
                }

            }
        } else {
            rootView = inflater.inflate(getLayoutId(), container, false)
            this.savedInstanceState = savedInstanceState
        }


        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewInitialize = true
        lazyView()
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        this.userVisible = isVisibleToUser
        if (isVisibleToUser) {
            lazyView()
        }
    }

    private fun lazyView() {
        if (userVisible && viewInitialize && !dataInitialize) {
            init(savedInstanceState)
            dataInitialize = true
        }

    }
}