package FalconCore;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * Created by ShenYuSun.
 * This is junit logic.
 */
public class Retry implements TestRule{

    private int retryCount;

    public Retry(int retryCount){
        this.retryCount = retryCount;
    }

    @Override
    public Statement apply(Statement base, Description description) {
        return statement(base, description);
    }

    // This is going to retry a test before is actually failing it X number of time.
    // It is define by Retry. It is goign to retry x amount of time, and then when it reaches the X.
    // It will fail it.
    private Statement statement(final Statement base, final Description description){
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                Throwable throwable = null;
                for(int i = 0; i < retryCount; i++){
                    try{
                        base.evaluate();
                        return;
                    }catch(Throwable e){
                        throwable = e;
                    }
                }
                System.out.println("Giving up after " + retryCount + "fails");
                throw throwable;
            }
        };
    }
}
