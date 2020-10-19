package il.co.theblitz.observablecollections.queues

import il.co.theblitz.observablecollections.abstracts.ObservableBlockingQueue
import il.co.theblitz.observablecollections.abstracts.ObservableCollection
import java.io.Serializable
import java.util.ArrayDeque
import java.util.concurrent.ArrayBlockingQueue

open class ObservableArrayBlockingQueue<X>(skipCurrentValueCall: Boolean = false): ObservableBlockingQueue<X, ArrayBlockingQueue<X>>(skipCurrentValueCall), Serializable {

    init {
        collection = ArrayBlockingQueue<X>(1)
    }

    constructor(capacity: Int, fair: Boolean, inCollection: MutableCollection<X>): this() {
        collection = ArrayBlockingQueue<X>(capacity, fair, inCollection)
    }

    constructor(capacity: Int, fair: Boolean): this() {
        collection = ArrayBlockingQueue<X>(capacity, fair)
    }

    constructor(capacity: Int): this() {
        collection = ArrayBlockingQueue<X>(capacity)
    }

}