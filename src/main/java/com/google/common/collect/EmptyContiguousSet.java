/*
 * Copyright (C) 2011 The Guava Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
*/
package com.google.common.collect;

import java.io.Serializable;
import java.util.NoSuchElementException;
import java.util.Set;

import javax.annotation.Nullable;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;

/**
 * An empty contiguous set.
 *
 * @author Gregory Kick
 */
@GwtCompatible(emulated = true)
@SuppressWarnings("unchecked") // allow ungenerified Comparable types
final class EmptyContiguousSet<C extends Comparable> extends ContiguousSet<C> {
	@GwtIncompatible("serialization")
	private static final class SerializedForm<C extends Comparable> implements Serializable {
		private static final long serialVersionUID = 0;

		private final DiscreteDomain<C> domain;

		private SerializedForm(DiscreteDomain<C> domain) {
			this.domain = domain;
		}

		private Object readResolve() {
			return new EmptyContiguousSet<C>(domain);
		}
	}

	EmptyContiguousSet(DiscreteDomain<C> domain) {
		super(domain);
	}

	@Override
	public ImmutableList<C> asList() {
		return ImmutableList.of();
	}

	@Override
	@GwtIncompatible("NavigableSet")
	ImmutableSortedSet<C> createDescendingSet() {
		return new EmptyImmutableSortedSet<C>(Ordering.natural().reverse());
	}

	@GwtIncompatible("NavigableSet")
	@Override
	public UnmodifiableIterator<C> descendingIterator() {
		return Iterators.emptyIterator();
	}

	@Override
	public boolean equals(@Nullable Object object) {
		if (object instanceof Set) {
			Set<?> that = (Set<?>) object;
			return that.isEmpty();
		}
		return false;
	}

	@Override
	public C first() {
		throw new NoSuchElementException();
	}

	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	ContiguousSet<C> headSetImpl(C toElement, boolean inclusive) {
		return this;
	}

	@GwtIncompatible("not used by GWT emulation")
	@Override
	int indexOf(Object target) {
		return -1;
	}

	@Override
	public ContiguousSet<C> intersection(ContiguousSet<C> other) {
		return this;
	}

	@Override
	public boolean isEmpty() {
		return true;
	}

	@Override
	boolean isPartialView() {
		return false;
	}

	@Override
	public UnmodifiableIterator<C> iterator() {
		return Iterators.emptyIterator();
	}

	@Override
	public C last() {
		throw new NoSuchElementException();
	}

	@Override
	public Range<C> range() {
		throw new NoSuchElementException();
	}

	@Override
	public Range<C> range(BoundType lowerBoundType, BoundType upperBoundType) {
		throw new NoSuchElementException();
	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	ContiguousSet<C> subSetImpl(C fromElement, boolean fromInclusive, C toElement, boolean toInclusive) {
		return this;
	}

	@Override
	ContiguousSet<C> tailSetImpl(C fromElement, boolean fromInclusive) {
		return this;
	}

	@Override
	public String toString() {
		return "[]";
	}

	@GwtIncompatible("serialization")
	@Override
	Object writeReplace() {
		return new SerializedForm<C>(domain);
	}
}
