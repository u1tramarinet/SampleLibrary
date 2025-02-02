package io.github.u1tramarinet.samplelibrary.lib

import android.util.Log

/**
 * サンプルログクラス.
 */
object SampleLogger {
    /**
     * デバッグログを出力する.
     *
     * @param tag ログのタグ.
     * @param message ログのメッセージ.
     */
    fun d(tag: String, message: String) = Log.d(tag, message)
}