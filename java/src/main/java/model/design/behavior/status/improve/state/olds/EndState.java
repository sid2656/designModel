package model.design.behavior.status.improve.state.olds;

import model.design.behavior.status.improve.Machine;
import model.design.behavior.status.improve.state.State;

/**
 * <p>描述:  结束状态
 * 日期:  2019-02-12 17:37
 *
 * @author yesong
 * @version 1.0.0
 * @program: apesay
 * @since 1.0.0
 */
public class EndState implements State {

    private int state = 5;

    public EndState (Machine machine){
    }

    @Override
    public void insertCoin() {
        System.out.println("结束状态不允许投入硬币！");
    }

    @Override
    public void turnCrank() {
        System.out.println("");
    }

    @Override
    public void pushButton() {
        System.out.println("已抓取完成，不允许按动按钮");
    }

    @Override
    public void printState() {
        System.out.println("当前娃娃机状态是："+state);
    }
}