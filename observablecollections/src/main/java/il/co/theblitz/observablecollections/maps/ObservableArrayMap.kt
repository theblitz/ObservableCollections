package il.co.theblitz.observablecollections.maps

import androidx.collection.ArrayMap
import il.co.theblitz.observablecollections.abstracts.ObservableMap
import java.io.Serializable

open class ObservableArrayMap<X, Y>: ObservableMap<X, Y, ArrayMap<X, Y>>(), Serializable {

    init {
        map = ArrayMap<X, Y>()
    }

}