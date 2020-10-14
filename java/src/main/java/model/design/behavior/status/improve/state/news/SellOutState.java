package model.design.behavior.status.improve.state.news;

import model.design.behavior.status.improve.Machine;
import model.design.behavior.status.improve.state.State;

/**
 * <p>描述:  售罄状态
 * 日期:  2019-02-12 17:37
 *
 * @author yesong
 * @version 1.0.0
 * @program: apesay
 * @since 1.0.0
 */
public class SellOutState implements State {

    private int state = 6;

    public SellOutState (Machine machine){
    }

    @Override
    public void insertCoin() {
        System.out.println("售罄状态不允许投入硬币");
    }

    @Override
    public void turnCrank() {
        System.out.println("售罄状态不允许转动操作杆！");
    }

    @Override
    public void pushButton() {
        System.out.println("售罄状态，不允许按动按钮");
    }


    @Override
    public void printState() {
        System.out.println("当前娃娃机状态是："+state);
    }
}