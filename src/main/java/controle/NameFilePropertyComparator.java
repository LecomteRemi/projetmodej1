package controle;

import java.util.Comparator;

public class NameFilePropertyComparator implements Comparator<FileProperty>{

	@Override
	public int compare(FileProperty o1, FileProperty o2) {
		return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
	}

}
