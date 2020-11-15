package iterator;

import java.util.Vector;

import domain.Event;

public class ExtendedIteratorEvents implements ExtendedIterator<Event>{
	Vector<Event> events;
	int position=0;

	public ExtendedIteratorEvents(Vector<Event> events) {
		super();
		this.events = events;
	}
	
	@Override
	public boolean hasNext() {
		return position<events.size();
	}

	@Override
	public Event next() {
		return events.get(position++);
	}

	@Override
	public Event previous() {
		return events.get(position--);
	}

	@Override
	public boolean hasPrevious() {
		return position>-1;
	}

	@Override
	public void goFirst() {
		position=0;
	}

	@Override
	public void goLast() {
		position=events.size()-1;
	}

}
