package il.co.theblitz.observablecollections.maps

import il.co.theblitz.observablecollections.abstracts.ObservableMap
import java.io.Serializable
import java.util.*

open class ObservableWeakHashMap<X, Y>(skipCurrentValueCall: Boolean = false): ObservableMap<X, Y, WeakHashMap<X, Y>>(skipCurrentValueCall), Serializable {

    init {
        map = WeakHashMap<X, Y>()
    }

}