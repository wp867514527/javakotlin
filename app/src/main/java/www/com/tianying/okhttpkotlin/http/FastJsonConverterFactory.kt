package www.com.tianying.okhttpkotlin.http

import com.alibaba.fastjson.JSON
import okhttp3.MediaType
import okhttp3.RequestBody
import okhttp3.ResponseBody
import okio.Okio
import retrofit2.Converter
import retrofit2.Retrofit
import java.io.IOException
import java.lang.reflect.Type

/**
 * @author CZZ
 * @data 2019/5/22
 * @email  https://blog.csdn.net/sugaryaruan/article/details/81067741
 * @desc fastJson 解析
 */
class FastJsonConverterFactory:Converter.Factory() {
    private val MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8")

    companion object {
        fun create():FastJsonConverterFactory{

            return FastJsonConverterFactory()
        }
    }
   /* <*> = <out Any?>
    <*> = <in nothing>*/    //
    override fun responseBodyConverter(type: Type, annotations: Array<Annotation>, retrofit: Retrofit): Converter<ResponseBody,out Any ?>? {

        return ResponseBodyConverter(type)
    }

    override fun requestBodyConverter(type: Type, parameterAnnotations: Array<Annotation>, methodAnnotations: Array<Annotation>, retrofit: Retrofit): Converter<out Any ?, RequestBody>? {
        return RequestBodyConverter()
    }

    internal class ResponseBodyConverter<T>(private val type: Type) : Converter<ResponseBody, T> {
        @Throws(IOException::class)
        override fun convert(value: ResponseBody): T? {
            val source = Okio.buffer(value.source())
            val data = source.readUtf8()
            source.close()
            return JSON.parseObject<T>(data, type)
        }
    }

    internal inner class RequestBodyConverter<T> : Converter<T, RequestBody> {

        override fun convert(value: T): RequestBody? {
            return RequestBody.create(MEDIA_TYPE, JSON.toJSONBytes(value))
        }
    }
}