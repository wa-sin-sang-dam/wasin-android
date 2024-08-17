package com.wasin.data.work_manager

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class WasinWorkManager (
    appContext: Context,
    workParams: WorkerParameters
): Worker(appContext, workParams) {

    override fun doWork(): Result {
        while(true) {
            // 뭔가 작업
            Thread.sleep(1000)
        }
        return Result.success()
    }

}
