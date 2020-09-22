package il.co.theblitz.observablecollections.maps

import il.co.theblitz.observablecollections.abstracts.ObservableMap
import java.io.Serializable
import java.util.*

open class ObservableTreeMap<X, Y>(skipCurrentValueCall: Boolean = false): ObservableMap<X, Y, TreeMap<X, Y>>(skipCurrentValueCall), Serializable {

    init {
        map = TreeMap<X, Y>()
    }

}