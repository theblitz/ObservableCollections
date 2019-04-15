package il.co.theblitz.observablecollections.queues

import il.co.theblitz.observablecollections.abstracts.ObservableDeque
import java.io.Serializable
import java.util.*

open class ObservableArrayDeque<X>: ObservableDeque<X, ArrayDeque<X>>(), Serializable {
    init {
        collection = ArrayDeque<X>()
    }
}