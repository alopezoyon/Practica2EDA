package alumnos.src;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UnorderedDoubleLinkedListTest {
	
	private UnorderedDoubleLinkedList<String> lista;
	
	@Before
	public void setUp() throws Exception {
		this.lista = new UnorderedDoubleLinkedList<String>();
	}

	@After
	public void tearDown() throws Exception {
		this.lista = null;
	}

	@Test
	public void testAddToFront() {
		assertEquals(null, this.lista.first());
		assertEquals(null, this.lista.last());
		assertEquals(0, this.lista.size());
		
		//Lista vacia y se añade null
		this.lista.addToFront(null);
		assertEquals(null, this.lista.first());
		assertEquals(null, this.lista.last());
		assertEquals(0, this.lista.size());
		
		//Lista vacia y se añade un elemento
		this.lista.addToFront("a");
		assertEquals("a", this.lista.first());
		assertEquals("a", this.lista.last());
		assertEquals(1, this.lista.size());
		
		//Lista con a y se añade b
		this.lista.addToFront("b");
		assertEquals("b", this.lista.first());
		assertEquals("a", this.lista.last());
		assertEquals(2, this.lista.size());
		
		//Lista con b, a y se añade c
		this.lista.addToFront("c");
		assertEquals("c", this.lista.first());
		assertEquals("a", this.lista.last());
		assertEquals(3, this.lista.size());
		
		//Lista con c, b, a y se añade null
		this.lista.addToFront(null);
		assertEquals("c", this.lista.first());
		assertEquals("a", this.lista.last());
		assertEquals(3, this.lista.size());
	}

	@Test
	public void testAddToRear() {
		assertEquals(null, this.lista.first());
		assertEquals(null, this.lista.last());
		assertEquals(0, this.lista.size());
		
		//Lista vacia y se añade null
		this.lista.addToRear(null);
		assertEquals(null, this.lista.first());
		assertEquals(null, this.lista.last());
		assertEquals(0, this.lista.size());
				
		//Lista vacia y se añade un elemento
		this.lista.addToRear("a");
		assertEquals("a", this.lista.first());
		assertEquals("a", this.lista.last());
		assertEquals(1, this.lista.size());
				
		//Lista con a y se añade b
		this.lista.addToRear("b");
		assertEquals("a", this.lista.first());
		assertEquals("b", this.lista.last());
		assertEquals(2, this.lista.size());
				
		//Lista con a, b y se añade c
		this.lista.addToRear("c");
		assertEquals("a", this.lista.first());
		assertEquals("c", this.lista.last());
		assertEquals(3, this.lista.size());
				
		//Lista con a, b, c y se añade null
		this.lista.addToRear(null);
		assertEquals("a", this.lista.first());
		assertEquals("c", this.lista.last());
		assertEquals(3, this.lista.size());
	}

	@Test
	public void testAddAfter() {
		assertEquals(null, this.lista.first());
		assertEquals(null, this.lista.last());
		assertEquals(0, this.lista.size());
		
		//Lista vacia y elem es null y taget también
		this.lista.addAfter(null, null);
		assertEquals(null, this.lista.first());
		assertEquals(null, this.lista.last());
		assertEquals(0, this.lista.size());
		
		//Lista vacia y elem es a y target es b
		this.lista.addAfter("a", "b");
		assertEquals(null, this.lista.first());
		assertEquals(null, this.lista.last());
		assertEquals(0, this.lista.size());
		
		//Lista vacia y elem es null y target es b
		this.lista.addAfter(null, "b");
		assertEquals(null, this.lista.first());
		assertEquals(null, this.lista.last());
		assertEquals(0, this.lista.size());
		
		//Lista con b y elem es null y target es b
		this.lista.addToFront("b");
		assertEquals(1, this.lista.size());
		
		this.lista.addAfter(null, "b");
		assertEquals("b", this.lista.first());
		assertEquals("b", this.lista.last());
		assertEquals(1, this.lista.size());
		
		//Lista con b y elem es a y target es null
		this.lista.addAfter("a", null);
		assertEquals("b", this.lista.first());
		assertEquals("b", this.lista.last());
		assertEquals(1, this.lista.size());
		
		//Lista con b y elem es a y target es b
		this.lista.addAfter("a", "b");
		assertEquals("b", this.lista.first());
		assertEquals("a", this.lista.last());
		assertEquals(2, this.lista.size());
		
		
		this.lista = new UnorderedDoubleLinkedList<String>();
		this.lista.addToRear("a");
		this.lista.addToRear("b");
		assertEquals("a", this.lista.first());
		assertEquals("b", this.lista.last());
		assertEquals(2, this.lista.size());
		
		//Lista con a, b y elem es c y target es d 
		this.lista.addAfter("c", "d");
		assertEquals("a", this.lista.first());
		assertEquals("b", this.lista.last());
		assertEquals(2, this.lista.size());
		
		//Lista con a, b y elem es c y target es b
		this.lista.addAfter("c", "b");
		assertEquals("a", this.lista.first());
		assertTrue(this.lista.contains("b"));
		assertEquals("c", this.lista.last());
		assertEquals(3, this.lista.size());
		
		
		this.lista = new UnorderedDoubleLinkedList<String>();
		this.lista.addToRear("a");
		this.lista.addToRear("b");
		assertEquals("a", this.lista.first());
		assertEquals("b", this.lista.last());
		assertEquals(2, this.lista.size());
		
		//Lista con a, b y elem es c y target es a
		this.lista.addAfter("c", "a");
		assertEquals("a", this.lista.first());
		assertTrue(this.lista.contains("c"));
		assertEquals("b", this.lista.last());
		assertEquals(3, this.lista.size());
	}

}
