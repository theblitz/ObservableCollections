package il.co.theblitz.observablecollections.queues

import il.co.theblitz.observablecollections.abstracts.ObservableDeque
import java.io.Serializable
import java.util.*

open class ObservableArrayDeque<X>(skipCurrentValueCall: Boolean = false): ObservableDeque<X, ArrayDeque<X>>(skipCurrentValueCall), Serializable {
    init {
        collection = ArrayDeque<X>()
    }

}