package il.co.anykey.apps.mutablelivedatacollections.full

import il.co.anykey.apps.mutablelivedatacollections.abstracts.ObservableDeque
import java.io.Serializable
import java.util.*

open class ObservableArrayDeque<X>: ObservableDeque<X, ArrayDeque<X>>(), Serializable {
    init {
        collection = ArrayDeque<X>()
    }
}