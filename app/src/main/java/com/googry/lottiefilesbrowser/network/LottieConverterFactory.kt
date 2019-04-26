package com.googry.lottiefilesbrowser.network

import com.googry.lottiefilesbrowser.network.model.LottieInfoResponse
import okhttp3.RequestBody
import okhttp3.ResponseBody
import org.jsoup.Jsoup
import retrofit2.Converter
import retrofit2.Retrofit
import java.lang.reflect.Type

class LottieConverterFactory : Converter.Factory() {
    override fun responseBodyConverter(type: Type?, annotations: Array<out Annotation>?, retrofit: Retrofit?): Converter<ResponseBody, *> {
        return STRING_RESPONSE
    }

    override fun requestBodyConverter(type: Type?, parameterAnnotations: Array<out Annotation>?, methodAnnotations: Array<out Annotation>?, retrofit: Retrofit?): Converter<*, RequestBody> {
        throw IllegalStateException("It doesn't make request body")
    }

    companion object {
        val STRING_RESPONSE = Converter<ResponseBody, List<LottieInfoResponse>> {
             Jsoup.parse(it.string())
                .select(".maingrid .maingrid_item")
                .map {
                    var id: String
                    var title: String?
                    var dataUrl: String
                    var author: String?
                    var authorProfile: String?
                    it.select(".preview_box")
                        .apply {
                            id = attr("id")
                            dataUrl = attr("data-filename")
                        }
                    title = it.select(".item-title").select("a").text()
                    it.select(".item-author").select("a")
                        .apply {
                            author = text()
                            authorProfile = attr("href")
                        }
                    LottieInfoResponse(id, dataUrl, title, author, authorProfile)
                }
        }

    }
}