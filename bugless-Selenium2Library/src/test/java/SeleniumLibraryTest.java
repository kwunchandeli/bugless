import org.junit.Test;

import com.kun.bugless.core.factory.LibraryFactory;

public class SeleniumLibraryTest {

	@Test
	public void TestLibraryFactory() {
		LibraryFactory lf = new LibraryFactory("bugless-core.properties");
		for (int i = 0; i < lf.getLibaryNames().length; i++) {
			String libraryNameString = lf.getLibaryNames()[i];
			System.out.println(libraryNameString);
			System.out.println(lf.getLibrary(libraryNameString).getLibraryClasString());
		}
		for (int i = 0; i < lf.getKeywordNames().length; i++) {
			System.out.println(lf.getKeywordNames()[i]);
		}
	}
}
