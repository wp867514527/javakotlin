package www.com.tianying.okhttpkotlin.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * @author CZZ
 * @data 2019/5/22
 * @email
 * @desc
 */
abstract class BaseActivity : AppCompatActivity(),IBase{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        init(savedInstanceState)
    }


}