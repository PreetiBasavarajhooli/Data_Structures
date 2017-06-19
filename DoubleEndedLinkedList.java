
public class DoubleEndedLinkedList {

	Neighbor firstLink;
	Neighbor lastLink;

	public void insertInFirstPosition(String homeOwnerName, int houseNumber) {

		Neighbor theNewLink = new Neighbor(homeOwnerName, houseNumber);

		if (isEmpty()) {

			lastLink = theNewLink;

		} else {

			firstLink.previous = theNewLink;

		}

		theNewLink.next = firstLink;

		firstLink = theNewLink;

	}

	public void insertInLastPosition(String homeOwnerName, int houseNumber) {

		Neighbor theNewLink = new Neighbor(homeOwnerName, houseNumber);

		if (isEmpty()) {

			firstLink = theNewLink;

		} else {

			lastLink.next = theNewLink;

			theNewLink.previous = lastLink; // FOR DOUBLY LINKED LIST

		}

		lastLink = theNewLink;

	}

	public boolean insertAfterKey(String homeOwnerName, int houseNumber, int key) {

		Neighbor theNewLink = new Neighbor(homeOwnerName, houseNumber);

		Neighbor currentNeighbor = firstLink;

		while (currentNeighbor.houseNumber != key) {

			currentNeighbor = currentNeighbor.next;

			if (currentNeighbor == null) {

				return false;

			}

		}

		if (currentNeighbor == lastLink) {

			// Assign the new Neighbor as the last link

			theNewLink.next = null;
			lastLink = theNewLink;

		} else {

			theNewLink.next = currentNeighbor.next;
			currentNeighbor.next.previous = theNewLink;

		}

		theNewLink.previous = currentNeighbor;
		currentNeighbor.next = theNewLink;
		return true;

	}

	public static void main(String[] args) {

		DoubleEndedLinkedList theLinkedList = new DoubleEndedLinkedList();

		theLinkedList.insertInFirstPosition("ABC", 7);
		theLinkedList.insertInFirstPosition("DEF", 9);
		theLinkedList.insertInFirstPosition("GHI", 6);
		theLinkedList.insertInLastPosition("JKL", 4);

		theLinkedList.display();

		theLinkedList.insertAfterKey("Preeti", 2, 6);

		theLinkedList.display();

		System.out.println("\n");

		NeighborIterator neighbors = new NeighborIterator(theLinkedList);

		neighbors.currentNeighbor.display();

		System.out.println(neighbors.hasNext());

		neighbors.next();

		neighbors.currentNeighbor.display();

		neighbors.remove();

		neighbors.currentNeighbor.display();

	}

	public boolean isEmpty() {

		return (firstLink == null);

	}

	public void insertInOrder(String homeOwnerName, int houseNumber) {

		Neighbor theNewLink = new Neighbor(homeOwnerName, houseNumber);

		Neighbor previousNeighbor = null;

		Neighbor currentNeighbor = firstLink;

		// there are still Neighbors and the new houseNumber
		// is greater than the current focused houseNumber
		// Change the > to < for opposite sort

		while ((currentNeighbor != null) && (houseNumber > currentNeighbor.houseNumber)) {

			previousNeighbor = currentNeighbor;
			currentNeighbor = currentNeighbor.next; // Get the next Neighbor

		}

		if (previousNeighbor == null) {

			// Save new Neighbor in the first position

			firstLink = theNewLink;

		} else {

			// Assign the new Neighbor as the value for next

			previousNeighbor.next = theNewLink;

		}

		// Assign the value of next to the next Neighbor

		theNewLink.next = currentNeighbor;

	}

	public void display() {

		Neighbor theLink = firstLink;

		while (theLink != null) {

			theLink.display();

			System.out.println("Next Link: " + theLink.next);

			theLink = theLink.next;

			System.out.println();

		}

	}

}

class Neighbor {

	public String homeOwnerName;
	public int houseNumber;

	public Neighbor next;

	public Neighbor previous; // Used with Doubly Linked List

	public Neighbor(String homeOwnerName, int houseNumber) {

		this.homeOwnerName = homeOwnerName;
		this.houseNumber = houseNumber;

	}

	public void display() {

		System.out.println(homeOwnerName + ": " + houseNumber + " Privet Drive");

	}

	public String toString() {

		return homeOwnerName;

	}

}

class NeighborIterator {

	Neighbor currentNeighbor; // The current focus Neighbor
	Neighbor previousNeighbor; // The previous Neighbor

	DoubleEndedLinkedList theNeighbors;

	NeighborIterator(DoubleEndedLinkedList theNeighbors) {

		this.theNeighbors = theNeighbors;

		currentNeighbor = theNeighbors.firstLink;
		previousNeighbor = theNeighbors.lastLink;

	}

	public boolean hasNext() {

		if (currentNeighbor.next != null) {

			return true;

		}

		return false;

	}

	public Neighbor next() {

		if (hasNext()) {

			previousNeighbor = currentNeighbor;
			currentNeighbor = currentNeighbor.next;

			return currentNeighbor;

		}

		return null;

	}

	public void remove() {

		// If at the beginning of the list

		if (previousNeighbor == null) {

			theNeighbors.firstLink = currentNeighbor.next;

		} else {

			previousNeighbor.next = currentNeighbor.next;

			// If at end of list

			if (currentNeighbor.next == null) {

				// Assign first link as the current link

				currentNeighbor = theNeighbors.firstLink;
				previousNeighbor = null;

			} else {

				currentNeighbor = currentNeighbor.next;

			}

		}

	}

}