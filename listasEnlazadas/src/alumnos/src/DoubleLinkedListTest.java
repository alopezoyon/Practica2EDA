package alumnos.src;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DoubleLinkedListTest<T> {
	
	
	private UnorderedDoubleLinkedList<T> l1; //Lista Vacía
	private UnorderedDoubleLinkedList<T> l2; //Lista de un sólo elemento
	private UnorderedDoubleLinkedList<T> l3; //Lista con 4 elementos
	
	private T elem1;
	private T elem2;
	private T elem3;
	

	@Before
	public void setUp() throws Exception {
		l2.addToFront(elem1);
		l3.addToRear(elem1);
		l3.addToRear(elem2);
		l3.addToRear(elem3);
	}

	@After
	public void tearDown() throws Exception {
		l1 = null;
		l2 = null;
		l3 = null;
		elem1 = null;
		elem2 = null;
		elem3 = null;
	}

	@Test
	public void testDoubleLinkedList() {
		//No hay que implementarla
	}

	@Test
	public void testSetDescr() {
		//No hay que testear
	}

	@Test
	public void testGetDescr() {
		//No hay que testear
	}

	@Test
	public void testRemoveFirst() {
		//Lista vacía
		l1.removeFirst();
		assertEquals(0,l1.size());
		//Lista de un elemento
		l2.removeFirst();
		assertEquals(0,l2.size());
		assertEquals(false,l2.contains(elem1));
		assertEquals(null,l2.first());
		//Lista de tres elementos
		l3.removeFirst();
		assertEquals(2,l3.size());
		assertEquals(false,l3.contains(elem1));
		assertEquals(true,l3.contains(elem2));
		assertEquals(true,l3.contains(elem3));
		assertEquals(elem2,l3.first());
		assertEquals(elem3,l3.last());
	}

	@Test
	public void testRemoveLast() {
		//Lista vacía
		l1.removeLast();
		assertEquals(0,l1.size());
		//Lista de un elemento
		l2.removeLast();
		assertEquals(0,l2.size());
		assertEquals(false,l2.contains(elem1));
		assertEquals(null,l2.last());
		//Lista de tres elementos
		l3.removeLast();
		assertEquals(2,l3.size());
		assertEquals(false,l3.contains(elem3));
		assertEquals(true,l3.contains(elem1));
		assertEquals(true,l3.contains(elem2));
		assertEquals(elem1,l3.first());
		assertEquals(elem2,l3.last());
	}

	@Test
	public void testRemove() {
		//Elemento nulo
		l3.remove(null);
		assertEquals(true,l3.contains(elem1));
		assertEquals(true,l3.contains(elem2));
		assertEquals(true,l3.contains(elem3));
		assertEquals(3,l3.size());
		assertEquals(elem1,l3.first());
		assertEquals(elem3,l3.last());
		//Lista vacía
		l1.remove(elem1);
		assertEquals(0,l1.size());
		//Lista de un elemento
		l2.remove(elem1);
		assertEquals(0,l2.size());
		assertEquals(false,l2.contains(elem1));
		assertEquals(null,l2.first());
		l2.addToFront(elem2);
		assertEquals(false,l2.contains(elem1));
		assertEquals(true,l2.contains(elem2));
		assertEquals(elem2,l2.last());
		//Lista de tres elementos
		l3.remove(elem1);
		assertEquals(false,l3.contains(elem1));
		assertEquals(2,l3.size());
		assertEquals(elem2,l3.first());
		assertEquals(elem3,l3.last());
		l3.addToFront(elem1);
		l3.remove(null);
		assertEquals(true,l3.contains(elem1));
		assertEquals(true,l3.contains(elem2));
		assertEquals(true,l3.contains(elem3));
		assertEquals(3,l3.size());
		l3.remove(elem3);
		assertEquals(true,l3.contains(elem1));
		assertEquals(true,l3.contains(elem2));
		assertEquals(false,l3.contains(elem3));
		assertEquals(2,l3.size());
		assertEquals(elem1,l3.first());
		assertEquals(elem2,l3.last());
		l3.addToRear(elem3);
		l3.remove(elem2);
		assertEquals(true,l3.contains(elem1));
		assertEquals(true,l3.contains(elem3));
		assertEquals(false,l3.contains(elem2));
		assertEquals(2,l3.size());
		assertEquals(elem1,l3.first());
		assertEquals(elem3,l3.last());
	}

	@Test
	public void testFirst() {
		//Lista vacía
		l1.remove(elem1);
		assertEquals(null,l1.first());
		//Lista de un elemento
		l2.remove(elem1);
		assertEquals(null,l2.first());
		l2.addToFront(elem2);
		assertEquals(elem2,l2.first());
		//Lista de tres elementos
		l3.remove(elem1);
		assertEquals(elem2,l3.first());
		l3.addToFront(elem1);
		l3.remove(elem3);
		assertEquals(elem1,l3.first());
		l3.addToRear(elem3);
		l3.remove(elem2);
		l3.remove(elem1);
		assertEquals(elem3,l3.first());
		l3.addToFront(elem2);
		l3.addToFront(elem1);
		l3.remove(elem1);
		l3.remove(elem2);
		l3.remove(elem3);
		assertEquals(null,l3.first());
	}

	@Test
	public void testLast() {
		//Lista vacía
		l1.remove(elem1);
		assertEquals(null,l1.last());
		//Lista de un elemento
		l2.remove(elem1);
		assertEquals(null,l2.last());
		l2.addToFront(elem2);
		assertEquals(elem2,l2.last());
		//Lista de tres elementos
		l3.remove(elem1);
		assertEquals(elem3,l3.last());
		l3.addToFront(elem1);
		l3.remove(elem3);
		assertEquals(elem2,l3.last());
		l3.addToRear(elem3);
		l3.remove(elem2);
		l3.remove(elem1);
		assertEquals(elem3,l3.last());
		l3.addToFront(elem2);
		l3.addToFront(elem1);
		l3.remove(elem1);
		l3.remove(elem2);
		l3.remove(elem3);
		assertEquals(null,l3.last());
	}

	@Test
	public void testContains() {
		//Elemento nulo
		assertEquals(true,l1.contains(null));
		assertEquals(false,l2.contains(null));
		//Lista vacía
		assertEquals(false,l1.contains(elem1));
		//Lista de un elemento
		assertEquals(true,l2.contains(elem1));
		l2.removeFirst();
		assertEquals(false,l2.contains(elem1));
		l2.addToFront(elem2);
		assertEquals(false,l2.contains(elem1));
		assertEquals(true,l2.contains(elem2));
		//Lista de tres elementos
		assertEquals(true,l3.contains(elem1));
		assertEquals(true,l3.contains(elem2));
		assertEquals(true,l3.contains(elem3));
		l3.remove(elem1);
		assertEquals(false,l3.contains(elem1));
		assertEquals(true,l3.contains(elem2));
		assertEquals(true,l3.contains(elem3));
		l3.addToFront(elem1);
		l3.remove(elem3);
		assertEquals(true,l3.contains(elem1));
		assertEquals(true,l3.contains(elem2));
		assertEquals(false,l3.contains(elem3));
		l3.addToRear(elem3);
		l3.remove(elem2);
		assertEquals(true,l3.contains(elem1));
		assertEquals(true,l3.contains(elem3));
		assertEquals(false,l3.contains(elem2));	
	}

	@Test
	public void testFind() {
		//Elemento nulo
		assertEquals(null,l1.find(null));
		assertEquals(null,l2.find(null));
		//Lista vacía
		assertEquals(null,l1.find(elem1));
		//Lista de un elemento
		assertEquals(elem1,l2.find(elem1));
		l2.removeFirst();
		assertEquals(null,l2.find(elem1));
		l2.addToFront(elem2);
		assertEquals(null,l2.find(elem1));
		assertEquals(elem2,l2.find(elem2));
		//Lista de tres elementos
		assertEquals(elem1,l3.find(elem1));
		assertEquals(elem2,l3.find(elem2));
		assertEquals(elem3,l3.find(elem3));
		l3.remove(elem1);
		assertEquals(null,l3.find(elem1));
		assertEquals(elem2,l3.find(elem2));
		assertEquals(elem3,l3.find(elem3));
		l3.addToFront(elem1);
		l3.remove(elem3);
		assertEquals(elem1,l3.find(elem1));
		assertEquals(elem2,l3.find(elem2));
		assertEquals(null,l3.find(elem3));
		l3.addToRear(elem3);
		l3.remove(elem2);
		assertEquals(elem1,l3.find(elem1));
		assertEquals(elem3,l3.find(elem3));
		assertEquals(null,l3.find(elem2));	
	}

	@Test
	public void testIsEmpty() {
		//No hay que testear
	}

	@Test
	public void testSize() {
		//Elemento nulo
		l3.remove(null);
		assertEquals(3,l3.size());
		//Lista vacía
		assertEquals(0,l1.size());
		//Lista de un elemento
		assertEquals(1,l2.size());
		l2.remove(elem1);
		assertEquals(0,l2.size());
		l2.addToFront(elem2);
		assertEquals(1,l2.size());
		//Lista de tres elementos
		assertEquals(3,l3.size());
		l3.remove(elem1);
		assertEquals(2,l3.size());
		l3.addToFront(elem1);
		assertEquals(3,l3.size());
		l3.remove(elem3);
		assertEquals(2,l3.size());
		l3.remove(elem2);
		assertEquals(1,l3.size());
		l3.remove(elem1);
		assertEquals(0,l3.size());
	}

	@Test
	public void testIterator() {
		//Lista vacía
		l1.iterator();
		assertEquals(false,l1.iterator().hasNext());
		assertEquals(null,l1.iterator().next());
		//Lista de un elemento
		l2.iterator();
		assertEquals(false,l2.iterator().hasNext());
		assertEquals(elem1,l2.iterator().next());
		l2.remove(elem1);
		assertEquals(false,l2.iterator().hasNext());
		assertEquals(null,l2.iterator().next());
		//Lista de tres elementos
		l3.iterator();
		assertEquals(true,l3.iterator().hasNext());
		assertEquals(elem1,l3.iterator().next());
		l3.iterator().next();
		assertEquals(true,l3.iterator().hasNext());
		assertEquals(elem2,l3.iterator().next());
		l3.iterator().next();
		assertEquals(false,l3.iterator().hasNext());
		assertEquals(elem3,l3.iterator().next());
	}

	@Test
	public void testVisualizarNodos() {
		//No hay que implementar
	}

	@Test
	public void testToString() {
		//No hay que implementar
	}

}
