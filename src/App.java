import java.io.IOException;
import java.util.Arrays;

import entity.CustomAnnotationTester;
import entity.DiamondCustomer;
import entity.FileTester;
import entity.ObjectCloner;
import entity.ObjectStreamTester;
import entity.SafeVarArgsTester;
import entity.ShowRoomTester;
import jdbc.JDBCConnectionTester;
import model.DeepCloneTester;
import model.LambdaThread;
import model.ProductTester;
import model.ShallowCloneTester;
import utility.Tester;

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

    public static void testObjectStream() {
        ObjectStreamTester objectStreamTester = new ObjectStreamTester();
        objectStreamTester.test();
    }

    public static void testObjectCloner() {
        ObjectCloner cloner = new ObjectCloner();
        cloner.test();
    }

    public static void testShallowClone() throws CloneNotSupportedException {
        ShallowCloneTester cloneTester = new ShallowCloneTester();
        cloneTester.test();
    }

    public static void testDeepClone() throws CloneNotSupportedException {
        DeepCloneTester cloneTester = new DeepCloneTester();
        cloneTester.test();
    }

    public static void testJDBCConnection() throws ClassNotFoundException {
        JDBCConnectionTester connectionTester = new JDBCConnectionTester();
        connectionTester.test();
    }

    public static void testShape() {
        tester.testShape();
    }

    public static void testLambda() {
        ProductTester.test();
    }

    public static final Tester tester = new Tester();

    public static void testThread() throws InterruptedException {
        LambdaThread.testNew();
        LambdaThread.testOld();
        LambdaThread.testMultiple();
    }

    public static void testPredicate() {
        Tester.testProducts();
    }

    public static void testStreams() {
        Tester.testStreams();
    }

    public static void testStreams2() {
        Tester.testStreams2();
    }

    public static void testParallelStreams() {
        Tester.testParallelStreams();
    }

    public static void testStreamEfficiency() {
        Tester.testStreamTime();
        Tester.testChatGPT();
    }

    public static void testOptional() {
        Tester.testOptional();
    }

    public static void testOptionalObject() {
        Tester.testOptionalObject();
    }

    public static void testOptionalStream() {
        Tester.testOptionalStream();
    }

    public static void main(String[] args) throws Exception {
        int test = 27;
        switch (test) {
            case 27:
                Tester.testThreadGroup();
                break;
            case 26:
                Tester.testMultipleThreads();
                break;
            case 25:
                Tester.testThreadSleep();
                break;
            case 24:
                Tester.testRunnable();
                break;
            case 23:
                Tester.testThread();
                break;
            case 22:
                testOptionalStream();
                break;
            case 21:
                testOptionalObject();
                break;
            case 20:
                testOptional();
                break;
            case 19:
                testStreamEfficiency();
                break;
            case 18:
                testParallelStreams();
                break;
            case 17:
                testStreams2();
                break;
            case 16:
                testStreams();
                break;
            case 15:
                testPredicate();
                break;
            case 14:
                testThread();
                break;
            case 13:
                testLambda();
                break;
            case 12:
                testShape();
                break;
            case 11:
                testJDBCConnection();
                break;
            case 10:
                testDeepClone();
                break;
            case 9:
                testShallowClone();
                break;
            case 8:
                testObjectCloner();
                break;
            case 7:
                testObjectStream();
                break;
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
