package il.co.theblitz.observablecollections.sets

import il.co.theblitz.observablecollections.abstracts.ObservableSet
import java.io.Serializable
import java.util.*

open class ObservableTreeSet<X>: ObservableSet<X, TreeSet<X>>(), Serializable {

    init {
        collection = TreeSet<X>()
    }
}