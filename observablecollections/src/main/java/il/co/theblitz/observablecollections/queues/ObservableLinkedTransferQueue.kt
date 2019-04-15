package il.co.theblitz.observablecollections.queues

import android.annotation.TargetApi
import il.co.theblitz.observablecollections.abstracts.ObservableTransferQueue
import java.io.Serializable
import java.util.concurrent.LinkedTransferQueue

@TargetApi (21)
open class ObservableLinkedTransferQueue<X>(): ObservableTransferQueue<X, LinkedTransferQueue<X>>(), Serializable {

    init {
        collection = LinkedTransferQueue<X>()
    }

    constructor(inCollection: MutableCollection<X>): this() {
        collection = LinkedTransferQueue<X>(inCollection)
    }

}