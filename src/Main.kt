import java.util.*

fun main()
{
    val alpha = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЬЫЪЭЮЯ"
    intArrayOf(21, 13, 4, 20, 22, 1, 25, 12, 24, 14, 2, 28, 9, 23, 3, 29, 6, 16, 15, 11, 26, 5, 30, 27, 8, 18, 10, 33, 31, 32, 19, 7, 17)

    print("Введите 'шифровать' или 'дешифровать': ")
    val act = readLine()?.lowercase(Locale.getDefault())

    print("Введите ключевое слово: ")
    val key = readLine()?.uppercase(Locale.getDefault()) ?: ""

    print("Введите текст: ")
    val text = readLine()?.uppercase(Locale.getDefault()) ?: ""

    if (act == "шифровать")
    {
        val encryptedText = encrypt(text, key, alpha)
        println("Зашифрованный текст: $encryptedText")
    }

    else if (act == "дешифровать")
    {
        val decryptedText = decrypt(text, key, alpha)
        println("Расшифрованный текст: $decryptedText")
    }

    else
    {
        println("Некорректное действие.")
    }
}

fun encrypt(text: String, keyword: String, alphabet: String): String
{
    val keyN = keyword.map { alphabet.indexOf(it) + 1 }
    val encrT = StringBuilder()

    for ((i, char) in text.withIndex())
    {
        val shift = keyN[i % keyN.size]
        val index = alphabet.indexOf(char)
        val newIndex = (index + shift - 1) % alphabet.length
        encrT.append(alphabet[newIndex])
    }

    return encrT.toString()
}

fun decrypt(text: String, keyword: String, alphabet: String): String
{
    val keyN = keyword.map { alphabet.indexOf(it) + 1 }
    val decrT = StringBuilder()

    for ((i, char) in text.withIndex())
    {
        val shift = keyN[i % keyN.size]
        val index = alphabet.indexOf(char)
        val newIndex = (index - shift + 1 + alphabet.length) % alphabet.length
        decrT.append(alphabet[newIndex])
    }

    return decrT.toString()
}