package bug

import annotations.Size
import kotlin.reflect.KFunction
import kotlin.reflect.jvm.kotlinFunction

fun main() {

    val function: KFunction<*> = MyClass::class.java.getMethod("aFunction", String::class.java).kotlinFunction!!
    val firstArgParameter = function.parameters[1]!!
    val sizeAnnotation: Size = firstArgParameter.type?.annotations?.get(0) as Size

    // Should print 0 but throws:
    // KotlinReflectionInternalError: Method is not supported: public abstract int tagging.Size.min() (args: [])
    println(sizeAnnotation.min)
}

class MyClass {
    fun aFunction(aString: @Size(5) String) {
    }
}

