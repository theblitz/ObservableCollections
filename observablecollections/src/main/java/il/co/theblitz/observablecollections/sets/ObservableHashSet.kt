package il.co.theblitz.observablecollections.sets

import il.co.theblitz.observablecollections.abstracts.ObservableSet
import java.io.Serializable
import java.util.*
import kotlin.collections.HashSet

open class ObservableHashSet<X>: ObservableSet<X, HashSet<X>>(), Serializable {

    init {
        collection = HashSet<X>()
    }

    override fun cloneCollection() = collection!!.clone() as HashSet<X>?
}