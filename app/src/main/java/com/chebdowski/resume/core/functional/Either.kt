package com.chebdowski.resume.core.functional

sealed class Either<out L, out R> {

    /**
     * Represents the left side of [Either] class which by convention is a "Failure".
     * */
    data class Left<out L>(val a: L) : Either<L, Nothing>()

    /**
     *  Represents the right side of [Either] class which by convention is a "Success".
     */
    data class Right<out R>(val b: R) : Either<Nothing, R>()

    /**
     * Returns true if this is a Right, false otherwise.
     * @see Right
     */
    val isRight get() = this is Right<R>

    /**
     * Returns true if this is a Left, false otherwise.
     * @see Left
     */
    val isLeft get() = this is Left<L>

    /**
     * Applies fnL if this is a Left or fnR if this is a Right.
     * @See Left
     * @See Right
     */
    fun either(fnL: (L) -> Any, fnR: (R) -> Any): Any =
        when (this) {
            is Left -> fnL(a)
            is Right -> fnR(b)
        }
}