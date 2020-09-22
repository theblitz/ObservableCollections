package il.co.theblitz.observablecollections.sets

import il.co.theblitz.observablecollections.abstracts.ObservableSet
import java.io.Serializable
import java.util.*
import kotlin.collections.HashSet

open class ObservableHashSet<X>(skipCurrentValueCall: Boolean = false): ObservableSet<X, HashSet<X>>(skipCurrentValueCall), Serializable {

    init {
        collection = HashSet<X>()
    }

}