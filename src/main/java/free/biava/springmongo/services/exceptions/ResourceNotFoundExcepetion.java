package free.biava.springmongo.services.exceptions;

public class ResourceNotFoundExcepetion extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundExcepetion(String id) {
		super("Resource not found! Id " + id);
	}
}
