package il.co.theblitz.observablecollections.maps

import il.co.theblitz.observablecollections.abstracts.ObservableMap
import java.io.Serializable
import java.util.*

open class ObservableTreeMap<X, Y>: ObservableMap<X, Y, TreeMap<X, Y>>(), Serializable {

    init {
        map = TreeMap<X, Y>()
    }

}