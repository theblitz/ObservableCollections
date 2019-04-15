package il.co.theblitz.observablecollections.maps

import il.co.theblitz.observablecollections.abstracts.ObservableMap
import java.io.Serializable
import java.util.concurrent.ConcurrentHashMap

open class ObservableConcurrentHashMap<X, Y>: ObservableMap<X, Y, ConcurrentHashMap<X, Y>>(), Serializable {

    init {
        map = ConcurrentHashMap<X, Y>()
    }

}