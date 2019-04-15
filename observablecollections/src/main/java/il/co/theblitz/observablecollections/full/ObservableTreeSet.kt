package il.co.theblitz.observablecollections.full

import il.co.theblitz.observablecollections.abstracts.ObservableAbstractSet
import java.io.Serializable
import java.util.*

open class ObservableTreeSet<X>: ObservableAbstractSet<X, TreeSet<X>>(), Serializable {

    init {
        collection = TreeSet<X>()
    }
}