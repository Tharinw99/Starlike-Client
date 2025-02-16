package com.carrotsearch.hppc;

import java.util.Deque;
import java.util.Iterator;

import com.carrotsearch.hppc.cursors.LongCursor;
import com.carrotsearch.hppc.predicates.LongPredicate;
import com.carrotsearch.hppc.procedures.LongProcedure;

/**
 * A linear collection that supports element insertion and removal at both ends.
 *
 * @see Deque
 */
@com.carrotsearch.hppc.Generated(date = "2024-06-04T15:20:17+0200", value = "KTypeDeque.java")
public interface LongDeque extends LongCollection {
	/** Inserts the specified element at the front of this deque. */
	public void addFirst(long e);

	/** Inserts the specified element at the end of this deque. */
	public void addLast(long e);

	/** Applies a <code>procedure</code> to all elements in tail-to-head order. */
	public <T extends LongProcedure> T descendingForEach(T procedure);

	/**
	 * Applies a <code>predicate</code> to container elements as long, as the
	 * predicate returns <code>
	 * true</code>. The iteration is interrupted otherwise.
	 */
	public <T extends LongPredicate> T descendingForEach(T predicate);

	/**
	 * @return An iterator over elements in this deque in tail-to-head order.
	 */
	public Iterator<LongCursor> descendingIterator();

	/**
	 * Retrieves the first element of this deque but does not remove it.
	 *
	 * @return the head of this deque.
	 */
	public long getFirst();

	/**
	 * Retrieves the last element of this deque but does not remove it.
	 *
	 * @return the head of this deque.
	 */
	public long getLast();

	/**
	 * Retrieves and removes the first element of this deque.
	 *
	 * @return the head (first) element of this deque.
	 */
	public long removeFirst();

	/**
	 * Removes the first element that equals <code>e</code>.
	 *
	 * @return The deleted element's index or <code>-1</code> if the element was not
	 *         found.
	 */
	public int removeFirst(long e);

	/**
	 * Retrieves and removes the last element of this deque.
	 *
	 * @return the tail of this deque.
	 */
	public long removeLast();

	/**
	 * Removes the last element that equals <code>e</code>.
	 *
	 * @return The deleted element's index or <code>-1</code> if the element was not
	 *         found.
	 */
	public int removeLast(long e);
}
