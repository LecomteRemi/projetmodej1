package controle;

import java.util.Comparator;

public class NbPointFilePropertyComparator implements Comparator<FileProperty>{

	@Override
	public int compare(FileProperty o1, FileProperty o2) {
		return o1.getNbPoint()-o2.getNbPoint();
	}

}
