package observer;

import states.GameState;
import states.NewBestState;
import states.State;

public class ObserverPanel implements Observer{

    private GameState subject;
    private NewBestState panel;
    private boolean dead;

    public ObserverPanel(GameState subject){
        this.subject = subject;
        registerObserver();
    }

    @Override
    public void update(boolean dead){
        this.dead = dead;
        if(isDead()){
            panel = new NewBestState(subject.getScoreData());
            State.changeState(panel);
        }
    }

    private void registerObserver(){
        subject.register(this);
    }

    private boolean isDead(){
        return dead;
    }
}
