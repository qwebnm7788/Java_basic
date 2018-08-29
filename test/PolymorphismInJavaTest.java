import org.junit.Test;

public class PolymorphismInJavaTest {
    @Test
    public void getFileInfoTest() {
        GenericFile genericFile = new ImgaeFile();
        System.out.println(genericFile.getFileInfo());
    }
}

class GenericFile {
    public String getFileInfo() {
        return "Generic File Impl";
    }
}

class ImgaeFile extends GenericFile {
    @Override
    public String getFileInfo() {
        return "Image File Impl";
    }
}
