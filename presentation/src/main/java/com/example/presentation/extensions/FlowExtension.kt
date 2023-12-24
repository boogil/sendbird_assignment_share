@file:Suppress("UNCHECKED_CAST")

package com.example.presentation.extensions

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.zip

suspend fun <A : Any?> Flow<A?>.collectLatestNotNull(observer: suspend (A) -> Unit) {
    collectLatest {
        if (it != null) observer.invoke(it)
    }
}

suspend fun <A, B> collectLatest(flow1: Flow<A>, flow2: Flow<B>, observer: (A?, B?) -> Any) {
    flow1.zip(flow2) { f1, f2 ->
        Pair(f1, f2)
    }.collectLatest { (f1, f2) ->
        observer.invoke(f1, f2)
    }
}

suspend fun <A, B> collectLatestNotNull(flow1: Flow<A>, flow2: Flow<B>, observer: (A, B) -> Any) {
    flow1.zip(flow2) { f1, f2 ->
        Pair(f1, f2)
    }.collectLatest { (f1, f2) ->
        withNotNull(f1, f2) { notNullF1, notNullF2 ->
            observer.invoke(notNullF1, notNullF2)
        }
    }
}

suspend fun <A, B, C> collectLatest(flow1: Flow<A>, flow2: Flow<B>, flow3: Flow<C>, observer: (A?, B?, C?) -> Any) {
    flow1.zip(flow2) { f1, f2 ->
        Pair(f1, f2)
    }.zip(flow3) { (f1, f2), f3 ->
        listOf(f1, f2, f3)
    }.collectLatest {
        observer.invoke(it.first() as? A, it[1] as? B, it[2] as? C)
    }
}

suspend fun <A, B, C> collectLatestNotNull(flow1: Flow<A>, flow2: Flow<B>, flow3: Flow<C>, observer: (A, B, C) -> Any) {
    flow1.zip(flow2) { f1, f2 ->
        Pair(f1, f2)
    }.zip(flow3) { (f1, f2), f3 ->
        listOf(f1, f2, f3)
    }.collectLatest {
        val isAllNotEmpty = it.filterNotNull().size == 3
        if (isAllNotEmpty) {
            observer.invoke(it.first() as A, it[1] as B, it[2] as C)
        }
    }
}

suspend fun <A, B, C, D> collectLatest(flow1: Flow<A>, flow2: Flow<B>, flow3: Flow<C>, flow4: Flow<D>, observer: (A?, B?, C?, D?) -> Any) {
    flow1.zip(flow2) { f1, f2 ->
        Pair(f1, f2)
    }.zip(flow3) { (f1, f2), f3 ->
        Pair(Pair(f1, f2), f3)
    }.zip(flow4) { (pair1, f3), f4 ->
        listOf(pair1.first, pair1.second, f3, f4)
    }.collectLatest {
        observer.invoke(it.first() as? A, it[1] as? B, it[2] as? C, it[3] as? D)
    }
}

suspend fun <A, B, C, D, E> collectLatest(flow1: Flow<A>,
                                          flow2: Flow<B>,
                                          flow3: Flow<C>,
                                          flow4: Flow<D>,
                                          flow5: Flow<E>,
                                          observer: (A?, B?, C?, D?, E?) -> Any) {
    flow1.zip(flow2) { f1, f2 ->
        Pair(f1, f2)
    }.zip(flow3) { (f1, f2), f3 ->
        Pair(Pair(f1, f2), f3)
    }.zip(flow4) { (pair1, f3), f4 ->
        Triple(pair1, f3, f4)
    }.zip(flow5) { (pair1, f3, f4), f5 ->
        listOf(pair1.first, pair1.second, f3, f4, f5)
    }.collectLatest {
        observer.invoke(it[0] as? A, it[1] as? B, it[2] as? C, it[3] as? D, it[4] as? E)
    }
}

suspend fun <A, B, C, D, E> collectLatestNotNull(flow1: Flow<A>,
                                                 flow2: Flow<B>,
                                                 flow3: Flow<C>,
                                                 flow4: Flow<D>,
                                                 flow5: Flow<E>,
                                                 observer: (A, B, C, D, E) -> Any) {
    flow1.zip(flow2) { f1, f2 ->
        Pair(f1, f2)
    }.zip(flow3) { (f1, f2), f3 ->
        Pair(Pair(f1, f2), f3)
    }.zip(flow4) { (pair1, f3), f4 ->
        Triple(pair1, f3, f4)
    }.zip(flow5) { (pair1, f3, f4), f5 ->
        listOf(pair1.first, pair1.second, f3, f4, f5)
    }.collectLatest {
        val isAllNotEmpty = it.filter { it != null }.size == 5
        if (isAllNotEmpty) {
            observer.invoke(it[0] as A, it[1] as B, it[2] as C, it[3] as D, it[4] as E)
        }
    }
}

suspend fun <A, B, C, D, E, F> collectLatest(flow1: Flow<A>,
                                             flow2: Flow<B>,
                                             flow3: Flow<C>,
                                             flow4: Flow<D>,
                                             flow5: Flow<E>,
                                             flow6: Flow<F>,
                                             observer: (A?, B?, C?, D?, E?, F?) -> Any) {
    flow1.zip(flow2) { f1, f2 ->
        Pair(f1, f2)
    }.zip(flow3) { (f1, f2), f3 ->
        Pair(Pair(f1, f2), f3)
    }.zip(flow4) { (pair1, f3), f4 ->
        Triple(pair1, f3, f4)
    }.zip(flow5) { (pair1, f3, f4), f5 ->
        listOf(pair1.first, pair1.second, f3, f4, f5)
    }.zip(flow6) { list, f6 ->
        ArrayList<Any?>().apply { addAll(list); add(f6) }
    }.collectLatest {
        observer.invoke(it[0] as? A, it[1] as? B, it[2] as? C, it[3] as? D, it[4] as? E, it[5] as? F)
    }
}

suspend fun <A, B, C, D, E, F, G> collectLatest(flow1: Flow<A>,
                                                flow2: Flow<B>,
                                                flow3: Flow<C>,
                                                flow4: Flow<D>,
                                                flow5: Flow<E>,
                                                flow6: Flow<F>,
                                                flow7: Flow<G>,
                                                observer: (A?, B?, C?, D?, E?, F?, G?) -> Any) {
    flow1.zip(flow2) { f1, f2 ->
        Pair(f1, f2)
    }.zip(flow3) { (f1, f2), f3 ->
        Pair(Pair(f1, f2), f3)
    }.zip(flow4) { (pair1, f3), f4 ->
        Triple(pair1, f3, f4)
    }.zip(flow5) { (pair1, f3, f4), f5 ->
        listOf(pair1.first, pair1.second, f3, f4, f5)
    }.zip(flow6) { list, f6 ->
        ArrayList<Any?>().apply { addAll(list); add(f6) }
    }.zip(flow7) { list, f7 ->
        ArrayList<Any?>().apply { addAll(list); add(f7) }
    }.collectLatest {
        observer.invoke(it[0] as? A, it[1] as? B, it[2] as? C, it[3] as? D, it[4] as? E, it[5] as? F, it[6] as? G)
    }
}

suspend fun <A, B, C, D, E, F> collectLatestNotNull(flow1: Flow<A>,
                                                    flow2: Flow<B>,
                                                    flow3: Flow<C>,
                                                    flow4: Flow<D>,
                                                    flow5: Flow<E>,
                                                    flow6: Flow<F>,
                                                    observer: (A, B, C, D, E, F) -> Any) {
    flow1.zip(flow2) { f1, f2 ->
        Pair(f1, f2)
    }.zip(flow3) { (f1, f2), f3 ->
        Pair(Pair(f1, f2), f3)
    }.zip(flow4) { (pair1, f3), f4 ->
        Triple(pair1, f3, f4)
    }.zip(flow5) { (pair1, f3, f4), f5 ->
        listOf(pair1.first, pair1.second, f3, f4, f5)
    }.zip(flow6) { list, f6 ->
        ArrayList<Any?>().apply { addAll(list); add(f6) }
    }.collectLatest {
        val isAllNotEmpty = it.filter { it != null }.size == 6
        if (isAllNotEmpty) {
            observer.invoke(it[0] as A, it[1] as B, it[2] as C, it[3] as D, it[4] as E, it[5] as F)
        }
    }
}

suspend fun <A, B, C, D, E, F, G> collectLatestNotNull(flow1: Flow<A>,
                                                       flow2: Flow<B>,
                                                       flow3: Flow<C>,
                                                       flow4: Flow<D>,
                                                       flow5: Flow<E>,
                                                       flow6: Flow<F>,
                                                       flow7: Flow<G>,
                                                       observer: (A, B, C, D, E, F, G) -> Any) {
    flow1.zip(flow2) { f1, f2 ->
        Pair(f1, f2)
    }.zip(flow3) { (f1, f2), f3 ->
        Pair(Pair(f1, f2), f3)
    }.zip(flow4) { (pair1, f3), f4 ->
        Triple(pair1, f3, f4)
    }.zip(flow5) { (pair1, f3, f4), f5 ->
        listOf(pair1.first, pair1.second, f3, f4, f5)
    }.zip(flow6) { list, f6 ->
        ArrayList<Any?>().apply { addAll(list); add(f6) }
    }.zip(flow7) { list, f7 ->
        ArrayList<Any?>().apply { addAll(list); add(f7) }
    }.collectLatest {
        val isAllNotEmpty = it.filter { it != null }.size == 7
        if (isAllNotEmpty) {
            observer.invoke(it[0] as A, it[1] as B, it[2] as C, it[3] as D, it[4] as E, it[5] as F, it[6] as G)
        }
    }
}

suspend fun <A, B, C, D, E, F, G, H> collectLatestNotNull(flow1: Flow<A>,
                                                          flow2: Flow<B>,
                                                          flow3: Flow<C>,
                                                          flow4: Flow<D>,
                                                          flow5: Flow<E>,
                                                          flow6: Flow<F>,
                                                          flow7: Flow<G>,
                                                          flow8: Flow<H>,
                                                          observer: (A, B, C, D, E, F, G, H) -> Any) {
    flow1.zip(flow2) { f1, f2 ->
        Pair(f1, f2)
    }.zip(flow3) { (f1, f2), f3 ->
        Pair(Pair(f1, f2), f3)
    }.zip(flow4) { (pair1, f3), f4 ->
        Triple(pair1, f3, f4)
    }.zip(flow5) { (pair1, f3, f4), f5 ->
        listOf(pair1.first, pair1.second, f3, f4, f5)
    }.zip(flow6) { list, f6 ->
        ArrayList<Any?>().apply { addAll(list); add(f6) }
    }.zip(flow7) { list, f7 ->
        ArrayList<Any?>().apply { addAll(list); add(f7) }
    }.zip(flow8) { list, f8 ->
        ArrayList<Any?>().apply { addAll(list); add(f8) }
    }.collectLatest {
        val isAllNotEmpty = it.filter { it != null }.size == 8
        if (isAllNotEmpty) {
            observer.invoke(it[0] as A, it[1] as B, it[2] as C, it[3] as D, it[4] as E, it[5] as F, it[6] as G, it[7] as H)
        }
    }
}