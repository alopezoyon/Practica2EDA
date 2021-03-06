package alumnos.src;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleLinkedList<T> implements ListADT<T> {

	// Atributos
	protected Node<T> last;  // apuntador al �ltimo
	protected String descr;  // descripci�n
	protected int count;

	// Constructor
	public DoubleLinkedList() {
        last = null;
		descr = "";
		count = 0;
	}
	
	public void setDescr(String nom) {
	  descr = nom;
	}

	public String getDescr() {
	  return descr;
	}

	public T removeFirst() {
	// Elimina el primer elemento de la lista
        // Precondici�n: La lista no es vac�a. Hay, al menos, un elemento.
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		//Coste:O(1). Coste constante ya que son todo asignaciones y comprobaciones de coste constante.
		T eliminado = this.first();
		if(this.first() == null) return null;
		if(this.first().equals(last.data)) {last = null; this.count --;}
		else {
			Node <T> primero = last.next;
			primero = primero.next;
			primero.prev = last;
			last.next = primero;
			this.count --;
		}
		return eliminado;
	}

	public T removeLast() {
	// Elimina el �ltimo elemento de la lista
        // Precondici�n: La lista no es vac�a. Hay, al menos, un elemento.
			// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		//Coste:O(1). Coste constante ya que son todo asignaciones y comprobaciones de coste constante.
		T eliminado = this.last();
		if(this.first() == null) return null;
		if(this.first().equals(last.data)) {last = null; this.count --;}
		else {
			Node <T> ultimo = last;
			ultimo.next.prev = last.prev;
			ultimo.prev.next = last.next;
			last = ultimo.prev;
			this.count --;
		}
		return eliminado;
	}
		

	public T remove(T elem) {
	//Elimina un elemento concreto de la lista
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		//El resto de operaciones de coste constante.
		if(last == null) return null;
		else if(!this.contains(elem)) return null;
		else {
			if(elem.equals(this.first())) {
				this.removeFirst();
			}
			else if(elem.equals(this.last())) {
				this.removeLast();
			}
			else {
				Node<T> act = last;
				boolean enc = false;
				act = act.next;
				while(act != last && !enc) {
					if(act.data.equals(elem)) {
						act.next.prev = act.prev;
						act.prev.next = act.next;
						enc = true;
						this.count --;
					}
					act = act.next;
				}
			}
		}
		return elem;
	}

	public T first() {
	//Da acceso al primer elemento de la lista
	      if (isEmpty())
	          return null;
	      else return last.next.data;
	}

	public T last() {
	//Da acceso al �ltimo elemento de la lista
	      if (isEmpty())
	          return null;
	      else return last.data;
	}

	public boolean contains(T elem) {
	//Determina si la lista contiene un elemento concreto
		      if (isEmpty())
		          return false;
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		//Coste:O(n). Coste lineal ya que en el peor de los casos, el iterador mira todos los elementos de la lista.
		      T act = null;
		      Iterator<T> itr = this.iterator();
		      boolean enc = false;
		      while(!enc && itr.hasNext()) {
					act = itr.next();
					if(act.equals(elem)) enc = true;
				}
		      return enc;
		   }

	public T find(T elem) {
	//Determina si la lista contiene un elemento concreto, y develve su referencia, null en caso de que no est�
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		//Coste:O(n). Coste lineal ya que en el peor de los casos, el iterador mira todos los elementos de la lista.
		if(elem == null) return elem;
		Iterator<T> itr = this.iterator();
		T objetivo = null;
		boolean enc = false;
		
		while(!enc && itr.hasNext()) {
			objetivo = itr.next();
			if(objetivo.equals(elem)) enc = true;
		}
		if(enc == false) return null;
		
		return objetivo;
	}

	public boolean isEmpty() 
	//Determina si la lista est� vac�a
	{ return last == null;};
	
	public int size() 
	//Determina el n�mero de elementos de la lista
	{ return count;};
	
	/** Return an iterator to the stack that iterates through the items . */ 
	public Iterator<T> iterator() { return new ListIterator(); } 

	   // an iterator, doesn't implement remove() since it's optional 
	   private class ListIterator implements Iterator<T> {
			// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		   //Coste:O(n). Coste lineal ya que el iterador comprueba por todos los elementos de la lista(n = n�elementos de la lista). 
		   	private Node<T> current;
		   	boolean primero;
		   	
		   	private ListIterator(){
		   		if(last == null) current = last;
		   		else current = last.next;
		   	}
		   	
			@Override
			public boolean hasNext() {

				if(primero && current == last.next) current = null;
				
				return current != null;
			}
	
			@Override
			public T next() {
				if(!hasNext()) throw new NoSuchElementException();
				if(!primero) primero = true;
				T elem = current.data;
				current = current.next;
				return elem;
			} 
			public void remove() {throw new UnsupportedOperationException();}
		
	   public void visualizarNodos() {
		   System.out.println(this.toString());
	   }

		@Override
		public String toString() {
			String result = new String();
			Iterator<T> it = iterator();
			while (it.hasNext()) {
				T elem = it.next();
				result = result + "[" + elem.toString() + "] \n";
			}	
			return "DoubleLinkedList " + result + "]";
		}

}
}
	   
