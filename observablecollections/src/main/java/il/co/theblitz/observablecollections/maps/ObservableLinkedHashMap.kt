package il.co.theblitz.observablecollections.maps

import java.io.Serializable

open class ObservableLinkedHashMap<X, Y>: ObservableHashMap<X, Y>(), Serializable {

    init {
        map = LinkedHashMap<X, Y>()
    }

}