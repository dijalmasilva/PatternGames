package dijalmasilva.businesspattern.interfaces;

/**
 * Interface que deve ser implementada por todos os observadores para os tipos
 * {@link Observable}.
 * 
 * @author Dijalma Silva <dijalmacz@gmail.com>
 * @see Observable
 */
public interface Observer<T> {
	
	void update(T object);
}