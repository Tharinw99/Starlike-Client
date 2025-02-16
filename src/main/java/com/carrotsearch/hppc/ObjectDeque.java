package com.carrotsearch.hppc;

import java.util.Deque;
import java.util.Iterator;

import com.carrotsearch.hppc.cursors.ObjectCursor;
import com.carrotsearch.hppc.predicates.ObjectPredicate;
import com.carrotsearch.hppc.procedures.ObjectProcedure;

/**
 * A linear collection that supports element insertion and removal at both ends.
 *
 * @see Deque
 */
@com.carrotsearch.hppc.Generated(date = "2024-06-04T15:20:17+0200", value = "KTypeDeque.java")
public interface ObjectDeque<KType> extends ObjectCollection<KType> {
	/** Inserts the specified element at the front of this deque. */
	public void addFirst(KType e);

	/** Inserts the specified element at the end of this deque. */
	public void addLast(KType e);

	/** Applies a <code>procedure</code> to all elements in tail-to-head order. */
	public <T extends ObjectProcedure<? super KType>> T descendingForEach(T procedure);

	/**
	 * Applies a <code>predicate</code> to container elements as long, as the
	 * predicate returns <code>
	 * true</code>. The iteration is interrupted otherwise.
	 */
	public <T extends ObjectPredicate<? super KType>> T descendingForEach(T predicate);

	/**
	 * @return An iterator over elements in this deque in tail-to-head order.
	 */
	public Iterator<ObjectCursor<KType>> descendingIterator();

	/**
	 * Retrieves the first element of this deque but does not remove it.
	 *
	 * @return the head of this deque.
	 */
	public KType getFirst();

	/**
	 * Retrieves the last element of this deque but does not remove it.
	 *
	 * @return the head of this deque.
	 */
	public KType getLast();

	/**
	 * Retrieves and removes the first element of this deque.
	 *
	 * @return the head (first) element of this deque.
	 */
	public KType removeFirst();

	/**
	 * Removes the first element that equals <code>e</code>.
	 *
	 * @return The deleted element's index or <code>-1</code> if the element was not
	 *         found.
	 */
	public int removeFirst(KType e);

	/**
	 * Retrieves and removes the last element of this deque.
	 *
	 * @return the tail of this deque.
	 */
	public KType removeLast();

	/**
	 * Removes the last element that equals <code>e</code>.
	 *
	 * @return The deleted element's index or <code>-1</code> if the element was not
	 *         found.
	 */
	public int removeLast(KType e);
}
