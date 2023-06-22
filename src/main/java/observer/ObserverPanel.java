package observer;

import states.GameState;
import states.NewBestState;
import states.State;

public class ObserverPanel implements Observer{

    private GameState subject;
    private NewBestState panel;
    private boolean finish;

    public ObserverPanel(GameState subject){
        this.subject = subject;
        registerObserver();
    }

    @Override
    public void update(boolean finish){
        this.finish = finish;
        if(isFinish()){
            panel = new NewBestState(subject.getScoreData());
            State.changeState(panel);
        }
    }

    private void registerObserver(){
        subject.register(this);
    }

    private boolean isFinish(){
        return finish;
    }
}