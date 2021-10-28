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
		if(this.first() == null) {};
		if(this.first().equals(last)) {last = null;}
		else {
			Node <T> primero = last.next;
			primero = primero.next;
			last.next = primero;
		};
		return this.first();
	}

	public T removeLast() {
	// Elimina el �ltimo elemento de la lista
        // Precondici�n: La lista no es vac�a. Hay, al menos, un elemento.
			// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		if(this.first() == null) {};
		if(this.first().equals(last)) {last = null;}
		else {
			Node <T> ultimo = last;
			ultimo = ultimo.prev;
			ultimo.next = last.next;
			last = ultimo;
		};
		return this.last();
	}
		

	public T remove(T elem) {
	//Elimina un elemento concreto de la lista
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		if(last == null) {};
		if(!this.contains(elem)) {};
		if(this.contains(elem)) {
			if(elem.equals(this.first())) {
				this.removeFirst();
			}
			if(elem.equals(this.last)) {
				this.removeLast();
			}
			else {
				Node<T> elemento = this.last;
				while(elemento.equals(elem)) {
					elemento = elemento.prev;
				}
				elemento.prev.next = elemento.next;
				elemento.next.prev = elemento.prev;
			}
		};
		return this.last();
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
		      Boolean enc = false;
		      T elemento = this.last();
		      while(!enc) {
		    	  Iterator<T> itr = this.iterator();
		    	  if(elemento.equals(elem)) {
		    		  enc = true;
		    	  }
		    	  else {
		    		  elemento = itr.next();
		    	  }
		      }
		      return enc;
		   }

	public T find(T elem) {
	//Determina si la lista contiene un elemento concreto, y develve su referencia, null en caso de que no est�
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE

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



	   } // private class
		
		
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
