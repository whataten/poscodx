package prob2;

public class SmartPhone extends MusicPhone {
    public void execute ( String function ) {
        if (function.equals("앱") ) {
            execApp();
            return;
        }
        
        super.execute( function );
  }
  
    protected void execApp(){
      System.out.print("앱실행");
    }
}
