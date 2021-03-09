package entity;

import java.lang.StringBuilder;

public class LinList<T> {
	private T value;
	private LinList<T> next;

	public LinList() {
	}

	public LinList(T value) {
		this.value = value;
	}

	public LinList(T value, LinList<T> next) {
		this.value = value;
		this.next = next;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public void setNext(LinList<T> next) {
		this.next = next;
	}

	public T getValue() {
		return this.value;
	}

	public LinList<T> getNext() {
		return next;
	}

	@Override
	public String toString() {
		LinList<T> ll = this;

		var sb = new StringBuilder();
		
		while(ll != null) {
			sb.append(ll.getValue());
			ll = ll.getNext();
		}
		return sb.toString();

	}
}
