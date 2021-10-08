package bug

import java.lang.reflect.Constructor
import java.lang.reflect.Executable
import java.lang.reflect.Method
import java.lang.reflect.Parameter
import kotlin.reflect.KFunction
import kotlin.reflect.KParameter
import kotlin.reflect.jvm.kotlinFunction

fun Parameter.kotlinParameter(): KParameter? {
    val executable = this.declaringExecutable
    val index = executable.parameters.indexOf(this)
    val kotlinFunction = executable.kotlinFunction()
    val parameters = kotlinFunction?.parameters ?: return null
    val isFirstNotAValue = parameters[0].kind != KParameter.Kind.VALUE
    val kotlinIndex: Int = if (isFirstNotAValue) index + 1 else index
    return parameters.get(kotlinIndex)
}

fun Executable.kotlinFunction(): KFunction<*>? {
    if (this is Method) return this.kotlinFunction
    if (this is Constructor<*>) return this.kotlinFunction
    return null
}
