package question1;

import java.util.*;

public class Ensemble<T> extends AbstractSet<T> {

	protected java.util.Vector<T> table = new java.util.Vector<T>();

	public int size() {
		return table.size();
	}

	public Iterator<T> iterator() {
		return table.iterator();
	}

	public boolean add(T t) {
		if (!this.contains(t)) {
            return table.add(t);            
        }
		return false;
	}

	public Ensemble<T> union(Ensemble<? extends T> e) {
		 Ensemble<T> inner = new Ensemble();
        inner.addAll(this);
        inner.addAll(e);
        return inner;
	}

	public Ensemble<T> inter(Ensemble<? extends T> e) {
		   Ensemble<T> inner = new Ensemble();
        inner.addAll(this);
        inner.retainAll(e);
        return inner;}

	public Ensemble<T> diff(Ensemble<? extends T> e) {
		 Ensemble<T> inner = new Ensemble();
        inner.addAll(this);
        inner.removeAll(e);
        return inner;
	}

	Ensemble<T> diffSym(Ensemble<? extends T> e) {
		  return union(e).diff(inter(e));
	}
	
}
