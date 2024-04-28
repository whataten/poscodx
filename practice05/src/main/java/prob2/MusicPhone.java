package prob2;

public class MusicPhone extends Phone{
    public void execute ( String function ) {
        if (function.equals("음악") ) {
            playMusic();
            return;
        }
        
        super.execute( function );
  }
  
    protected void playMusic(){
      System.out.print("다운로드해서 음악실행");
    }
  
}
