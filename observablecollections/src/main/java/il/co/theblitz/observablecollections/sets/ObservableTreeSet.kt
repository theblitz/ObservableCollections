package il.co.theblitz.observablecollections.sets

import il.co.theblitz.observablecollections.abstracts.ObservableSet
import java.io.Serializable
import java.util.*

open class ObservableTreeSet<X>(skipCurrentValueCall: Boolean = false): ObservableSet<X, TreeSet<X>>(skipCurrentValueCall), Serializable {

    init {
        collection = TreeSet<X>()
    }
}