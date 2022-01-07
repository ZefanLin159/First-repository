package com.lzf.demo01;

public class Proxy implements Rent {
    //    代理房东，把房东当作隐私对象拿过来
    private Host host;

    public Proxy(Host host) {
        this.host = host;
    }

    @Override
    public void rent() {
        seeHouse();
        fare();
        contract();
        host.rent();
    }

    //    看房
    public void seeHouse() {
        System.out.println("中介带你看房");
    }


    //  收中介费
    public void fare() {
        System.out.println("收中介费");
    }

    //  签合同
    public void contract() {
        System.out.println("签租赁合同");
    }
}
