
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import puissancefun.*;


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
        
        //test bien rempli
        for(int i = 0; i < tab.largeur; i++){
            for(int j = 0; j < tab.longueur; j++){
                assertEquals(tab.plateau[i][j],0,2);
            }
        }
        
        //fail forced
        
         for(int i = 0; i < tab.largeur; i++){
            for(int j = 0; j < tab.longueur; j++){
                assertEquals(tab.plateau[i][j],8,8);
            }
        }
         
        Pions joueur1 = new Pions();
        
        //test bonne apparence
        assertEquals(joueur1.apparence,'*');
        
        Pions joueur2 = new Pions('/');
        
        assertEquals(joueur2.apparence,'/');
        
        //fail forced
        
        assertEquals(joueur2.apparence,'O');
    }
}
