package model.design.behavior.status.improve.state.olds;

import model.design.behavior.status.improve.Machine;
import model.design.behavior.status.improve.state.State;
import model.design.behavior.status.improve.state.news.SellOutState;

/**
 * <p>描述:  运行状态
 * 日期:  2019-02-12 17:37
 *
 * @author yesong
 * @version 1.0.0
 * @program: apesay
 * @since 1.0.0
 */
public class RunningState implements State {

    private int state = 4;
    Machine machine;

    public RunningState (Machine machine){
        this.machine = machine;
    }

    @Override
    public void insertCoin() {
        System.out.println("运行过程中不允许投入硬币！");
    }

    @Override
    public void turnCrank() {
        System.out.println("");
    }

    @Override
    public void pushButton() {
        System.out.println("正在抓取娃娃！");
        machine.setState(new EndState(machine));
        dispense();
    }

    /**
     * 发放娃娃行为
     */
    private void dispense(){
        double random = Math.random();
        boolean has = random >0.8d;
        machine.printState();
        System.out.println(has?"抓到娃娃！":"未抓到娃娃！");
        if (has) {
            machine.subCount();
        }
        if (machine.getCount()<=0){
            machine.setState(new SellOutState(machine));
        }else if (machine.getCoinCount()>0){
            machine.setState(new HasCoinState(machine));
        }else {
            machine.setState(new OnReadyState(machine));
        }
    }

    @Override
    public void printState() {
        System.out.println("当前娃娃机状态是："+state);
    }
}