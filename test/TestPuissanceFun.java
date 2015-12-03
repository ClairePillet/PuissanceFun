
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import puissancefun.Plateau;


public class TestPuissanceFun {
    
    public TestPuissanceFun() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @org.junit.Test
    public void testMethodes(){
        
        Plateau tab = new Plateau();
        
        tab.initialisation();
        
        
        for(int i = 0; i < Plateau.largeur; i++){
            for(int j = 0; j < Plateau.longueur; j++){
                assertEquals(tab.plateau[i][j],0,2);
            }
        }
    }
}
