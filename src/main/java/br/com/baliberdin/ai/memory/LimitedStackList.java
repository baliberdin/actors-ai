package br.com.baliberdin.ai.memory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LimitedStackList<E> implements List<E> {
	
	private List<E> itens = new ArrayList<E>();
	private Integer maxItens;
	
	public LimitedStackList(int size) {
		maxItens = size;
	}
	
	@Override
	public int size() {
		return itens.size();
	}

	@Override
	public boolean isEmpty() {
		return itens.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return itens.contains(o);
	}

	@Override
	public Iterator<E> iterator() {
		return itens.iterator();
	}

	@Override
	public Object[] toArray() {
		return itens.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return itens.toArray(a);
	}

	@Override
	public boolean add(E e) {
		if(itens.size() < maxItens) {
			return itens.add(e);
		}else {
			itens.remove(0);
			return itens.add(e);
		}
	}

	@Override
	public boolean remove(Object o) {
		return itens.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return itens.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return itens.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return itens.retainAll(c);
	}

	@Override
	public void clear() {
		itens.clear();
	}

	@Override
	public E get(int index) {
		return itens.get(index);
	}

	@Override
	public E set(int index, E element) {
		if(index < maxItens) {
			return itens.set(index, element);
		}else {
			return null;
		}
	}

	@Override
	public void add(int index, E element) {
		if(index < maxItens) {
			if(itens.size() < maxItens) {
				itens.add(index, element);
			}else {
				itens.remove(0);
				itens.add(index, element);
			}
		}
		
	}

	@Override
	public E remove(int index) {
		if(index < maxItens) {
			return itens.remove(index);
		}else {
			return null;
		}
	}

	@Override
	public int indexOf(Object o) {
		return itens.indexOf(o);
	}

	@Override
	public int lastIndexOf(Object o) {
		return itens.lastIndexOf(o);
	}

	@Override
	public ListIterator<E> listIterator() {
		return itens.listIterator();
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		return itens.listIterator(index);
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		if(fromIndex < maxItens && toIndex < maxItens) {
			return itens.subList(fromIndex, toIndex);
		}else {
			return null;
		}
	}

}
