package il.co.theblitz.observablecollections.maps

import il.co.theblitz.observablecollections.abstracts.ObservableMap
import java.io.Serializable
import java.util.concurrent.ConcurrentHashMap

open class ObservableConcurrentHashMap<X, Y>(skipCurrentValueCall: Boolean = false): ObservableMap<X, Y, ConcurrentHashMap<X, Y>>(skipCurrentValueCall), Serializable {

    init {
        map = ConcurrentHashMap<X, Y>()
    }

}