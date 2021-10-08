package bug

import annotations.Size

fun main() {

    val method = MyClass::class.java.getMethod("aFunction", String::class.java)
    val firstParameter = method.parameters[0]
    val kParameter = firstParameter.kotlinParameter()

    val sizeAnnotation : Size = kParameter?.type?.annotations?.get(0) as Size

    // Should print 0 but throws:
    // KotlinReflectionInternalError: Method is not supported: public abstract int tagging.Size.min() (args: [])
    println(sizeAnnotation.min)
}

class MyClass {
    fun aFunction(aString: @Size(5) String) {
    }
}

