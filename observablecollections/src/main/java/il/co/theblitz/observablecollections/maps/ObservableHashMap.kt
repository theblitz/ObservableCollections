package il.co.theblitz.observablecollections.maps

import il.co.theblitz.observablecollections.abstracts.ObservableMap
import java.io.Serializable

open class ObservableHashMap<X, Y>: ObservableMap<X, Y, HashMap<X, Y>>(), Serializable {

    init {
        map = HashMap<X, Y>()
    }

}