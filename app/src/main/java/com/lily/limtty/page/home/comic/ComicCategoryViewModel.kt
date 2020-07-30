package com.lily.limtty.page.home.comic

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.lily.limtty.repository.comic.ComicCategoryRepository
import kotlinx.coroutines.launch
import com.lily.limtty.ExtensionFunction.md5
import com.lily.limtty.LogTool
import com.lily.limtty.model.comic.ComicInfo

/**
 * Created by Werif
 * Created on 2020/7/29
 * PackageName com.lily.limtty.page.home.comic
 *
 */
class ComicCategoryViewModel(private val comicCategoryRepository: ComicCategoryRepository) :
    ViewModel() {

    fun requestComicCategory(onData: (ComicInfo) -> Unit) {

        var cParam = initMap()

        cParam["format"] = "comic"
        cParam["formatType"] = "comic"
        cParam["collaborators"] = "Stan Lee"

        launch({
            onData(comicCategoryRepository.getComicCategory(cParam))
        }, {

        })
    }

    fun requestComicCreators() {
        var cParam = initMap()
        cParam["nameStartsWith"]="St L"
//        cParam["lastName"]="Stan"
        launch({
            comicCategoryRepository.getComicCategory(cParam)
        }, {

        })
    }


    private fun launch(block: suspend () -> Unit, error: suspend (Throwable) -> Unit) =
        viewModelScope.launch {
            try {
                block()
            } catch (e: Throwable) {
                error(e)
            }
        }

    private fun initMap() = let {
        var ts = System.currentTimeMillis()

        var publicKey = "6014905cbbab5b3735917bdce6e7c73c"
        var privateKey = "666545ab5dff2b36d88aeaa92642acc02f7749d2"

        var cParam = mutableMapOf<String, Any>()
        cParam["ts"] = ts
        cParam["apikey"] = publicKey
        cParam["hash"] = "$ts$privateKey$publicKey".md5()
        cParam["limit"] = 10
        cParam["offset"] = 0
        cParam
    }
}