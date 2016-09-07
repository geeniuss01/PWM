package me.samen.pwm.common

import java.io.UnsupportedEncodingException
import java.security.InvalidAlgorithmParameterException
import java.security.InvalidKeyException
import java.security.NoSuchAlgorithmException
import java.security.spec.InvalidKeySpecException
import java.security.spec.InvalidParameterSpecException
import javax.crypto.*
import javax.crypto.spec.SecretKeySpec
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class EncryptionUtil @Inject constructor(@Named("encKey") val password: String) {

    @Throws(NoSuchAlgorithmException::class, InvalidKeySpecException::class)
    fun generateKey(): SecretKey {
        return SecretKeySpec(password.toByteArray(), "AES")
    }

    @Throws(NoSuchAlgorithmException::class, NoSuchPaddingException::class, InvalidKeyException::class, InvalidParameterSpecException::class, IllegalBlockSizeException::class, BadPaddingException::class, UnsupportedEncodingException::class)
    fun encryptMsg(message: String): ByteArray = encryptMsg(message, generateKey())

    @Throws(NoSuchAlgorithmException::class, NoSuchPaddingException::class, InvalidKeyException::class, InvalidParameterSpecException::class, IllegalBlockSizeException::class, BadPaddingException::class, UnsupportedEncodingException::class)
    fun encryptMsg(message: String, secret: SecretKey): ByteArray {
        /* Encrypt the message. */
        var cipher: Cipher? = null
        cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
        cipher!!.init(Cipher.ENCRYPT_MODE, secret)
        val cipherText = cipher!!.doFinal(message.toByteArray(charset("UTF-8")))
        return cipherText
    }

    @Throws(NoSuchPaddingException::class, NoSuchAlgorithmException::class, InvalidParameterSpecException::class, InvalidAlgorithmParameterException::class, InvalidKeyException::class, BadPaddingException::class, IllegalBlockSizeException::class, UnsupportedEncodingException::class)
    fun decryptMsg(cipherText: ByteArray): String = decryptMsg(cipherText, generateKey())

    @Throws(NoSuchPaddingException::class, NoSuchAlgorithmException::class, InvalidParameterSpecException::class, InvalidAlgorithmParameterException::class, InvalidKeyException::class, BadPaddingException::class, IllegalBlockSizeException::class, UnsupportedEncodingException::class)
    fun decryptMsg(cipherText: ByteArray, secret: SecretKey): String {

        /* Decrypt the message, given derived encContentValues and initialization vector. */
        var cipher: Cipher? = null
        cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
        cipher!!.init(Cipher.DECRYPT_MODE, secret)

        val decryptString = String(cipher!!.doFinal(cipherText), charset = charset("UTF-8"))
        return decryptString
    }

}