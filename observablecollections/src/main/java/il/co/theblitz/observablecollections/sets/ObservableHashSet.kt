package il.co.theblitz.observablecollections.sets

import il.co.theblitz.observablecollections.abstracts.ObservableSet
import java.io.Serializable

open class ObservableHashSet<X>: ObservableSet<X, HashSet<X>>(), Serializable {

    init {
        collection = HashSet<X>()
    }
}