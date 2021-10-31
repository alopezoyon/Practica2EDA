package alumnos.src;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DoubleLinkedListTest {
	
	
	private UnorderedDoubleLinkedList<String> l1; //Lista Vacía
	private UnorderedDoubleLinkedList<String> l2; //Lista de un sólo elemento
	private UnorderedDoubleLinkedList<String> l3; //Lista con 3 elementos
	

	@Before
	public void setUp() throws Exception {
		this.l1 = new UnorderedDoubleLinkedList<String>();
		this.l2 = new UnorderedDoubleLinkedList<String>();
		this.l3 = new UnorderedDoubleLinkedList<String>();
		this.l2.addToFront("elem1");
		this.l3.addToRear("elem1");
		this.l3.addToRear("elem2");
		this.l3.addToRear("elem3");
	}

	@After
	public void tearDown() throws Exception {
		this.l1 = null;
		this.l2 = null;
		this.l3 = null;
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
		this.l1.removeFirst();
		assertEquals(0,this.l1.size());
		//Lista de un elemento
		this.l2.removeFirst();
		assertEquals(0,this.l2.size());
		assertEquals(false,this.l2.contains("elem1"));
		assertEquals(null,this.l2.first());
		//Lista de tres elementos
		l3.removeFirst();
		assertEquals(2,this.l3.size());
		assertEquals(false,this.l3.contains("elem1"));
		assertEquals(true,this.l3.contains("elem2"));
		assertEquals(true,this.l3.contains("elem3"));
		assertEquals("elem2",this.l3.first());
		assertEquals("elem3",this.l3.last());
	}

	@Test
	public void testRemoveLast() {
		//Lista vacía
		this.l1.removeLast();
		assertEquals(0,this.l1.size());
		//Lista de un elemento
		this.l2.removeLast();
		assertEquals(0,this.l2.size());
		assertEquals(false,this.l2.contains("elem1"));
		assertEquals(null,this.l2.last());
		//Lista de tres elementos
		this.l3.removeLast();
		assertEquals(2,this.l3.size());
		assertEquals(false,this.l3.contains("elem3"));
		assertEquals(true,this.l3.contains("elem1"));
		assertEquals(true,this.l3.contains("elem2"));
		assertEquals("elem1",this.l3.first());
		assertEquals("elem2",this.l3.last());
	}

	@Test
	public void testRemove() {
		//Elemento nulo
		this.l3.remove(null);
		assertEquals(true,this.l3.contains("elem1"));
		assertEquals(true,this.l3.contains("elem2"));
		assertEquals(true,this.l3.contains("elem3"));
		assertEquals(3,this.l3.size());
		assertEquals("elem1",this.l3.first());
		assertEquals("elem3",this.l3.last());
		//Lista vacía
		this.l1.remove("elem1");
		assertEquals(0,this.l1.size());
		//Lista de un elemento
		this.l2.remove("elem1");
		assertEquals(0,this.l2.size());
		assertEquals(false,this.l2.contains("elem1"));
		assertEquals(null,this.l2.first());
		this.l2.addToFront("elem2");
		assertEquals(false,this.l2.contains("elem1"));
		assertEquals(true,this.l2.contains("elem2"));
		assertEquals("elem2",this.l2.last());
		//Lista de tres elementos
		this.l3.remove("elem1");
		assertEquals(false,this.l3.contains("elem1"));
		assertEquals(2,this.l3.size());
		assertEquals("elem2",this.l3.first());
		assertEquals("elem3",this.l3.last());
		this.l3.addToFront("elem1");
		this.l3.remove(null);
		assertEquals(true,this.l3.contains("elem1"));
		assertEquals(true,this.l3.contains("elem2"));
		assertEquals(true,this.l3.contains("elem3"));
		assertEquals(3,this.l3.size());
		this.l3.remove("elem3");
		assertEquals(true,this.l3.contains("elem1"));
		assertEquals(true,this.l3.contains("elem2"));
		assertEquals(false,this.l3.contains("elem3"));
		assertEquals(2,this.l3.size());
		assertEquals("elem1",this.l3.first());
		assertEquals("elem2",this.l3.last());
		this.l3.addToRear("elem3");
		this.l3.remove("elem2");
		assertEquals(true,this.l3.contains("elem1"));
		assertEquals(true,this.l3.contains("elem3"));
		assertEquals(false,this.l3.contains("elem2"));
		assertEquals(2,this.l3.size());
		assertEquals("elem1",this.l3.first());
		assertEquals("elem3",this.l3.last());
	}

	@Test
	public void testFirst() {
		//Lista vacía
		this.l1.remove("elem1");
		assertEquals(null,this.l1.first());
		//Lista de un elemento
		this.l2.remove("elem1");
		assertEquals(null,this.l2.first());
		this.l2.addToFront("elem2");
		assertEquals("elem2",this.l2.first());
		//Lista de tres elementos
		this.l3.remove("elem1");
		assertEquals("elem2",this.l3.first());
		this.l3.addToFront("elem1");
		this.l3.remove("elem3");
		assertEquals("elem1",this.l3.first());
		this.l3.addToRear("elem3");
		this.l3.remove("elem2");
		this.l3.remove("elem1");
		assertEquals("elem3",this.l3.first());
		this.l3.addToFront("elem2");
		this.l3.addToFront("elem1");
		this.l3.remove("elem1");
		this.l3.remove("elem2");
		this.l3.remove("elem3");
		assertEquals(null,this.l3.first());
	}

	@Test
	public void testLast() {
		//Lista vacía
		this.l1.remove("elem1");
		assertEquals(null,this.l1.last());
		//Lista de un elemento
		this.l2.remove("elem1");
		assertEquals(null,this.l2.last());
		this.l2.addToFront("elem2");
		assertEquals("elem2",this.l2.last());
		//Lista de tres elementos
		this.l3.remove("elem1");
		assertEquals("elem3",this.l3.last());
		this.l3.addToFront("elem1");
		this.l3.remove("elem3");
		assertEquals("elem2",this.l3.last());
		this.l3.addToRear("elem3");
		this.l3.remove("elem2");
		this.l3.remove("elem1");
		assertEquals("elem3",this.l3.last());
		this.l3.addToFront("elem2");
		this.l3.addToFront("elem1");
		this.l3.remove("elem1");
		this.l3.remove("elem2");
		this.l3.remove("elem3");
		assertEquals(null,this.l3.last());
	}

	@Test
	public void testContains() {
		//Elemento nulo
		assertEquals(false,this.l1.contains(null));
		assertEquals(false,this.l2.contains(null));
		//Lista vacía
		assertEquals(false,this.l1.contains("elem1"));
		//Lista de un elemento
		assertEquals(true,this.l2.contains("elem1"));
		this.l2.removeFirst();
		assertEquals(false,this.l2.contains("elem1"));
		this.l2.addToFront("elem2");
		assertEquals(false,this.l2.contains("elem1"));
		assertEquals(true,this.l2.contains("elem2"));
		//Lista de tres elementos
		assertEquals(true,this.l3.contains("elem1"));
		assertEquals(true,this.l3.contains("elem2"));
		assertEquals(true,this.l3.contains("elem3"));
		this.l3.remove("elem1");
		assertEquals(false,this.l3.contains("elem1"));
		assertEquals(true,this.l3.contains("elem2"));
		assertEquals(true,this.l3.contains("elem3"));
		this.l3.addToFront("elem1");
		this.l3.remove("elem3");
		assertEquals(true,this.l3.contains("elem1"));
		assertEquals(true,this.l3.contains("elem2"));
		assertEquals(false,this.l3.contains("elem3"));
		this.l3.addToRear("elem3");
		this.l3.remove("elem2");
		assertEquals(true,this.l3.contains("elem1"));
		assertEquals(true,this.l3.contains("elem3"));
		assertEquals(false,this.l3.contains("elem2"));	
	}

	@Test
	public void testFind() {
		//Elemento nulo
		assertEquals(null,this.l1.find(null));
		assertEquals(null,this.l2.find(null));
		//Lista vacía
		assertEquals(null,this.l1.find("elem1"));
		//Lista de un elemento
		assertEquals("elem1",this.l2.find("elem1"));
		this.l2.removeFirst();
		assertEquals(null,this.l2.find("elem1"));
		this.l2.addToFront("elem2");
		assertEquals(null,this.l2.find("elem1"));
		assertEquals("elem2",this.l2.find("elem2"));
		//Lista de tres elementos
		assertEquals("elem1",this.l3.find("elem1"));
		assertEquals("elem2",this.l3.find("elem2"));
		assertEquals("elem3",this.l3.find("elem3"));
		this.l3.remove("elem1");
		assertEquals(null,this.l3.find("elem1"));
		assertEquals("elem2",this.l3.find("elem2"));
		assertEquals("elem3",this.l3.find("elem3"));
		this.l3.addToFront("elem1");
		this.l3.remove("elem3");
		assertEquals("elem1",this.l3.find("elem1"));
		assertEquals("elem2",this.l3.find("elem2"));
		assertEquals(null,this.l3.find("elem3"));
		this.l3.addToRear("elem3");
		this.l3.remove("elem2");
		assertEquals("elem1",this.l3.find("elem1"));
		assertEquals("elem3",this.l3.find("elem3"));
		assertEquals(null,this.l3.find("elem2"));	
	}

	@Test
	public void testIsEmpty() {
		//No hay que testear
	}

	@Test
	public void testSize() {
		//Elemento nulo
		this.l3.remove(null);
		assertEquals(3,this.l3.size());
		//Lista vacía
		assertEquals(0,this.l1.size());
		//Lista de un elemento
		assertEquals(1,this.l2.size());
		this.l2.remove("elem1");
		assertEquals(0,this.l2.size());
		this.l2.addToFront("elem2");
		assertEquals(1,this.l2.size());
		//Lista de tres elementos
		assertEquals(3,this.l3.size());
		this.l3.remove("elem1");
		assertEquals(2,this.l3.size());
		this.l3.addToFront("elem1");
		assertEquals(3,this.l3.size());
		this.l3.remove("elem3");
		assertEquals(2,this.l3.size());
		this.l3.remove("elem2");
		assertEquals(1,this.l3.size());
		this.l3.remove("elem1");
		assertEquals(0,this.l3.size());
	}

	@Test
	public void testIterator() {
		//Lista vacía
		this.l1.iterator();
		assertEquals(false,this.l1.iterator().hasNext());
		//Lista de un elemento
		this.l2.iterator();
		assertEquals(true,this.l2.iterator().hasNext());
		assertEquals("elem1",this.l2.iterator().next());
		this.l2.remove("elem1");
		assertEquals(false,this.l2.iterator().hasNext());
		//Lista de tres elementos
		this.l3.iterator();
		assertEquals(true,this.l3.iterator().hasNext());
		assertEquals("elem1",this.l3.iterator().next());
		this.l3.removeFirst();
		assertEquals(true,this.l3.iterator().hasNext());
		assertEquals("elem2",this.l3.iterator().next());
		this.l3.removeFirst();
		assertEquals(true,this.l3.iterator().hasNext());
		assertEquals("elem3",this.l3.iterator().next());
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
