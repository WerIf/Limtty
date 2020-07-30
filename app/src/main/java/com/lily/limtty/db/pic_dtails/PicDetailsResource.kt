package com.lily.limtty.db.pic_dtails

import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.google.gson.Gson
import com.lily.limtty.model.pic_details.Vertical
import com.lily.limtty.net.LyNetwork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Created by Werif
 * Created on 2020/7/29
 * PackageName com.lily.limtty.db.pic_dtails
 *
 */
class PicDetailsResource(var pId: String) : PageKeyedDataSource<Int, Vertical>() {

    var lyNetwork = LyNetwork.getInstance()

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Vertical>
    ) {
        loadData {
            Log.v("Tag_____","pic details :${Gson().toJson(it)}")
            callback.onResult(it, null, 2)
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Vertical>) {
        loadData(params.key) {
            callback.onResult(it, params.key + 1)
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Vertical>) {
        loadData(params.key) {
            callback.onResult(it, params.key - 1)
        }
    }

    private fun loadData(pageIndex: Int = 1, onBackData: (List<Vertical>) -> Unit) {

        Log.v("Tag_____","is running step 2")
        var start = (pageIndex - 1) * 30 + 30
        var skip = (start - 1) + 30
        GlobalScope.launch {
            var data = requestPicDetails(start, skip)

            Log.v("Tag_____","is running step 3: ${data.res.vertical==null}  ${data==null}")

            onBackData(data.res.vertical)
        }
    }

    private suspend fun requestPicDetails(start: Int, skip: Int) = withContext(Dispatchers.IO) {
        lyNetwork.fetchPicDetailsList(pId, start, skip)
    }
}