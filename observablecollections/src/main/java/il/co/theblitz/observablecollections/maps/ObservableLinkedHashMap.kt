package il.co.theblitz.observablecollections.maps

import java.io.Serializable

open class ObservableLinkedHashMap<X, Y>(skipCurrentValueCall: Boolean = false): ObservableHashMap<X, Y>(skipCurrentValueCall), Serializable {

    init {
        map = LinkedHashMap<X, Y>()
    }

}