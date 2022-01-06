package controle;

import java.util.Comparator;

public class NbFaceFilePropertyComparator implements Comparator<FileProperty>{

	@Override
	public int compare(FileProperty o1, FileProperty o2) {
		return o1.getNbFace()-o2.getNbFace();
	}

}
