package iam.thevoid.rxe

object RxErrorHandler {

    internal var handler : ((Throwable) -> Unit) = { it.printStackTrace() }

    fun setDefault(handler : ((Throwable) -> Unit)) {
        this.handler = handler
    }
}