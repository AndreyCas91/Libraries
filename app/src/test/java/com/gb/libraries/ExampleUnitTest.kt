package com.gb.libraries

import io.reactivex.rxjava3.core.Observable
import org.junit.Test
import java.util.concurrent.TimeUnit


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        println("проверка")
        val obs = Observable.just(3, 6)
            .switchMap { count ->
                Observable.interval(100, TimeUnit.MILLISECONDS)
                    .map { "из события номер $count счетчик $it" }
                    .take(count.toLong())
            }

        /*
        * switchMap предоставляет нам элементы последнего события, пригодится когда промежуточные данные не нужны.
        * */

        obs
            .map { it }
            .doOnSubscribe { println("Начало выполнения") }
            .subscribe({
                println("пришли данные = $it")
            }, {
                    println("error")
               }, {
                println("поток завершился") }
            )

        Thread.sleep(100000)
    }


}



