package il.co.theblitz.observablecollections.abstracts

import java.io.Serializable
import java.util.concurrent.TransferQueue

open class ObservableTransferQueue<X, Y: TransferQueue<X>>(): ObservableBlockingQueue<X, Y>(), Serializable