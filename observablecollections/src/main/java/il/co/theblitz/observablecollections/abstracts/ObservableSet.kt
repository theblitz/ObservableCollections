package il.co.theblitz.observablecollections.abstracts

import java.util.*

abstract class ObservableSet<X, T : MutableSet<X>>(skipCurrentValueCall: Boolean = false) : ObservableCollection<X, T>(skipCurrentValueCall)