package il.co.theblitz.observablecollections.maps

import il.co.theblitz.observablecollections.abstracts.ObservableMap
import java.io.Serializable

open class ObservableHashMap<X, Y>(skipCurrentValueCall: Boolean = false): ObservableMap<X, Y, HashMap<X, Y>>(skipCurrentValueCall), Serializable {

    init {
        map = HashMap<X, Y>()
    }

}