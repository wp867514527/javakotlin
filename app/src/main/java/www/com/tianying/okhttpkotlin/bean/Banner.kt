package www.com.tianying.okhttpkotlin.bean

/**
 * @author CZZ
 * @data 2019/5/22
 * @email
 * @desc
 */
data class Banner(
    val desc: String,
    val id: Int,
    val imagePath: String,
    val isVisible: Int,
    val order: Int,
    val title: String,
    val type: Int,
    val url: String
)