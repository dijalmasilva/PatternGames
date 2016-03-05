package dijalmasilva.businesspattern.interfaces;

/**
 * Interface que deve ser implementada por qualquer objeto que deseja adicionar
 * observadores para seus eventos. Observadores, por sua vez, devem implementar
 * {@link Observer}
 * 
 * @author Dijalma Silva <dijalmacz@gmail.com>
 * @see Observer
 */
public interface Observable {
	
	/**
	 * Método para adicionar um novo observador
	 * @param newObserver
	 */
	void addObserver(Observer newObserver);
	
	/**
	 * Método para remover um observador
	 * @param observer
	 */
	void removeObserver(Observer observer);
	
	void notifyObservers();

}
