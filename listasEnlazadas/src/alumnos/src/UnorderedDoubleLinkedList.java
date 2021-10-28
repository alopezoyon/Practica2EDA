package alumnos.src;

public class UnorderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements UnorderedListADT<T> {
	
	public UnorderedDoubleLinkedList() {
		super();
	}
	
	public void addToFront(T elem) {
		//PRE: un elemento de tipo T
		//POST: se añade el elemento al inicio
		//Coste: O(1) constante porque todo son asignaciones de variables y atributos
		
		Node<T> ultimo = super.last;
		Node<T> nuevo = new Node<T>(elem);
		
		if(ultimo != null) {
			nuevo.prev = ultimo;
			nuevo.next = ultimo.next;
			ultimo.next.prev = nuevo;
			ultimo.next = nuevo;
		}else {
			nuevo.next = nuevo;
			nuevo.prev = nuevo;
			super.last = nuevo;
		}
	}

	public void addToRear(T elem) {
		//PRE: un elemento de tipo T
		//POST: se añade el elemento al final
		//Coste: O(1) constante porque todo son asignaciones de variables y atributos
		
		Node<T> ultimo = super.last;
		Node<T> nuevo = new Node<T>(elem);
		
		if(ultimo != null) {
			nuevo.prev = ultimo;
			nuevo.next = ultimo.next;
			ultimo.next.prev = nuevo;
			ultimo.next = nuevo;
			super.last = nuevo;
			
		}else {
			nuevo.next = nuevo;
			nuevo.prev = nuevo;
			super.last = nuevo;
		}
	}
	
	public void addAfter(T elem, T target) {
		//PRE: el elemento a añadir y el target tras el cual hay que añadirlo
		//POST: se ha añadido el elemento después del target
		//Coste: O(n) en el peor de los casos (no se encuntra target). Porque hay que recorrer la lista
		//		 buscando target y el resto de las instrucciones son asignaciones y o llamadas a métodos con coste constante.
		
		Node<T> act = super.last;
		boolean encontrado = false;
		
		if(act == null) return;
		else if(act.data.equals(target)) {
			//addAfter después del último
			this.addToRear(elem);
			encontrado = true;
		}else {
			act = act.next;
			while(act != super.last && !encontrado) {
				if(act.equals(target)) {
					Node<T> nuevo = new Node<T>(elem);
					nuevo.prev = act;
					nuevo.next = act.next;
					act.next.prev = nuevo;
					act.next = nuevo;
					
					encontrado = true;
				}
				act = act.next;
			}
		}
		
	}

}
