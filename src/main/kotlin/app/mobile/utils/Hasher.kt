package app.mobile.utils

import java.math.BigInteger
import java.security.MessageDigest
import java.security.SecureRandom
import kotlin.random.Random


fun hashPassword(password: String, salt: String): String {
    val md = MessageDigest.getInstance("SHA-512")
    val messageDigest = md.digest((salt+password).toByteArray())
    val no = BigInteger(1, messageDigest)
    var hashtext = no.toString(16)
    while (hashtext.length < 50) {
        hashtext = "0$hashtext"
    }
    return hashtext
}

fun getSalt(): String {
    val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
    return (1..16)
        .map { allowedChars.random() }
        .joinToString("")
}