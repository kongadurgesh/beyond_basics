import java.io.IOException;
import java.util.Arrays;

import entity.CustomAnnotationTester;
import entity.DiamondCustomer;
import entity.FileTester;
import entity.SafeVarArgsTester;
import entity.ShowRoomTester;

public class App {

    @SuppressWarnings("all")
    public static void testPhones() {
        ShowRoomTester roomTester = new ShowRoomTester();
        roomTester.test();
    }

    public static void testSafeVarArgs() {
        SafeVarArgsTester argsTester = new SafeVarArgsTester();
        argsTester.test(Arrays.asList("Laptop", "iPad"));
    }

    public static void testOverrirde() {
        DiamondCustomer customer = new DiamondCustomer();
        customer.calculatAmount(12);
    }

    public static void testCustomAnnotation() throws Exception {
        CustomAnnotationTester tester = new CustomAnnotationTester();
        tester.test();
    }

    public static void testFileReaderWriter() throws IOException {
        FileTester fileTester = new FileTester();
        fileTester.test();
    }

    public static void testFileTryWithResource() {
        FileTester fileTester = new FileTester();
        fileTester.test2();
    }

    public static void main(String[] args) throws Exception {
        int test = 6;
        switch (test) {
            case 6:
                testFileTryWithResource();
                break;
            case 5:
                testFileReaderWriter();
                break;
            case 1:
                testPhones();
                break;
            case 2:
                testSafeVarArgs();
                break;
            case 3:
                testOverrirde();
                break;
            case 4:
                testCustomAnnotation();
                break;
            default:
                break;
        }
    }
}
