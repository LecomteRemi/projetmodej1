package controle;

import modele.Modele;
import utilitaire.Observer;
import utilitaire.Subject;

public class HorlogeControleur implements Observer, Runnable{
	protected int compteur;
	protected Modele modele;
	
	public HorlogeControleur(Modele modele) {
		compteur=0;
		this.modele=modele;
		modele.attach(this);
	}

	@Override
	public void update(Subject subj) {
		compteur=0;
		
	}

	@Override
	public void update(Subject subj, Object data) {
		compteur=0;
	}

	@Override
	public void run() {
		long sleepTime=1000;
		double degree=5;
		while(true) {
			try {
				Thread.sleep(sleepTime);
				compteur++;
				if(compteur==10) {
					modele.turnOnXAxis(degree);
					modele.notifyObservers();
				}
			} catch (InterruptedException e) {}
			catch (Exception e) {}
			
		}
	}
}
