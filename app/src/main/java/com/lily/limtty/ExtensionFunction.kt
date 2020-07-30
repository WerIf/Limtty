package com.lily.limtty

import java.security.MessageDigest

/**
 * Created by Werif
 * Created on 2020/7/29
 * PackageName com.lily.limtty
 *
 */
object ExtensionFunction {

    fun String.md5(): String {
        val bytes = MessageDigest.getInstance("MD5").digest(this.toByteArray())
        return bytes.hex()
    }

    fun ByteArray.hex(): String {
        return joinToString("") { "%02x".format(it) }
    }
}