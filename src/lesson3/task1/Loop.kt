@file:Suppress("UNUSED_PARAMETER")
package lesson3.task1
import java.lang.Math.*
import lesson1.task1.sqr



/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result = result * i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    for (m in 2..Math.sqrt(n.toDouble()).toInt()) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n/2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
    when {
          n == m -> 1
          n < 10 -> 0
          else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
    }

/**
 * Тривиальная
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 */
fun digitNumber(n: Int): Int {
    var sum = 0
    var current = n
    do {
        sum++
        current /= 10
    } while (current != 0)
    return (sum)
}

/**
 * Простая
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int {
    var first = 1
    var second = 1
    var count = first + second
    for (i in 4..n) {
        first = second
        second = count
        count = first + second
    }
    if (n <= 2) return 1
    else return count
}

/**
 * Простая
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int {
    var a = n
    var b = m
    while (a != b) {
        if (a > b) a -= b
        else b -= a
    }
    return m * n / a
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    var d = 1
    do {
        d = d + 1
    } while (n % d != 0)
    return d
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int {
    var d = n
    do {
        d = d - 1
    } while (n % d != 0)
    return d
}


/**
 * Простая
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean {
    val x = (m * n / lcm(m, n))
    return x == 1
}

/**
 * Простая
 *
 * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
 * то есть, существует ли такое целое k, что m <= k*k <= n.
 * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
 */
fun squareBetweenExists(m: Int, n: Int): Boolean {
    for (i in sqrt(m.toDouble()).toInt()..sqrt(n.toDouble()).toInt()) {
        if (sqr2(i) in m..n) return true
    }
    return false
}

    /**
     * Средняя
     *
     * Для заданного x рассчитать с заданной точностью eps
     * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
     * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
     */
fun sin(x: Double, eps: Double): Double {
    var result = 0.0
    val f = x % (2 * PI)
    var n = 1.0
    var m = 1.0
    while (abs(pow(f, m)) / factorial(m.toInt()) >= eps) {
        val z = pow(f, m) * n  / factorial(m.toInt())
        m += 2
        n *= -1
        result += z
    }
    return result
}

    /**
     * Средняя
     *
     * Для заданного x рассчитать с заданной точностью eps
     * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
     * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
     */
fun cos(x: Double, eps: Double): Double {
    var result = 1.0
    val f = x % (2 * PI)
    var n = -1.0
    var m = 2.0
    while (abs(pow(f, m)) / factorial(m.toInt()) >= eps) {
        val z = pow(f, m) * n  / factorial(m.toInt())
        m += 2
        n *= -1
        result += z
    }
    return result
}


/**
     * Средняя
     *
     * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
     * Не использовать строки при решении задачи.
     */
fun revert(n: Int): Int {
    var revertNumber = 0
    var current = n
    do {
        val x = current % 10
        revertNumber = revertNumber * 10 + x
        current /= 10
    } while (current != 0)
    return revertNumber
}

    /**
     * Средняя
     *
     * Проверить, является ли заданное число n палиндромом:
     * первая цифра равна последней, вторая -- предпоследней и так далее.
     * 15751 -- палиндром, 3653 -- нет.
     */
fun isPalindrome(n: Int): Boolean {
    return revert(n) == n
}

    /**
     * Средняя
     *
     * Для заданного числа n определить, содержит ли оно различающиеся цифры.
     * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
     */
fun hasDifferentDigits(n: Int): Boolean {
    var current = n
    var x = n % 10
    val count = n % 10
    do {
        if (current % 10 != count) {
            x = current % 10
        }
        current /= 10
    } while (current != 0)
    return x != count
}

    /**
     * Сложная
     *
     * Найти n-ю цифру последовательности из квадратов целых чисел:
     * 149162536496481100121144...
     * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
     */
fun squareSequenceDigit(n: Int): Int {
    var x = 0
    var y = 0
    do {
        x++
        y += digitNumber(sqr2(x))
    } while (y < n)
    var r = sqr2(x)
    for (i in 1..y - n) {
        r /= 10
    }
    return r % 10
}

    /**
     * Сложная
     *
     * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
     * 1123581321345589144...
     * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
     */
fun fibSequenceDigit(n: Int): Int {
    var x = 0
    var y = 0
    do {
        x++
        y += digitNumber(fib(x))
    } while (y < n)
    var r = fib(x)
    for (i in 1..y - n) {
        r /= 10
    }
    return r % 10
}

fun sqr2(n: Int) = n * n


