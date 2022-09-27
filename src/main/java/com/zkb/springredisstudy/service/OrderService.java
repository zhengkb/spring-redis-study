package com.zkb.springredisstudy.service;


import com.zkb.springredisstudy.event.springevent.OrderSuccessEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

@Service
public class OrderService {

    @Autowired
    private ApplicationContext applicationContext;

    @Transactional(timeout = 6000, rollbackFor = Exception.class)
    public void order() {
        System.out.println("下单成功");
        applicationContext.publishEvent(new OrderSuccessEvent(this));
        System.out.println("main线程结束");
    }

    public static void main(String[] args) {
        String str = "gmt_create=2022-09-15 16:25:07, charset=UTF-8, seller_email=bianshenwangluo@sina.com, subject=10钻石, sign=SXyBJZWxvXj61/5eAthTGp7lFECd+8wzjK5t4eimMcj21CEAMLQygj8ExwSRXgBsEjUBgxXKUwfATC6yXkC53EnK4nofhGheRZywJ1E9BB/oMXiXuCxP7hpEzT21kdD1Rup7aYIRRHJz4lyKO/7c1kx4BbQs6W9N1HoVUNE9hVa1CdUq5lav/MvksxJfcAkHxqixzwUqzwZde00/TSLNql5JP3CWLGDyor+QwBVubcSjhz0CuJnVFZmAGL5VkmEBaaJcmuLMol95wYYs09151U7Wq1SYANcShKGuJo1GrY/5/bidafjN+Q2W6+qljOL5eObkIA2BSelDMLjapTRFUA==, body=test, buyer_id=2088332355565960, invoice_amount=1.00, notify_id=2022091500222162508065961442758651, fund_bill_list=[{\"amount\":\"1.00\",\"fundChannel\":\"ALIPAYACCOUNT\"}], notify_type=trade_status_sync, trade_status=TRADE_SUCCESS, receipt_amount=1.00, app_id=2021003143628797, buyer_pay_amount=1.00, sign_type=RSA2, seller_id=2088631031942478, gmt_payment=2022-09-15 16:25:07, notify_time=2022-09-15 16:25:08, version=1.0, out_trade_no=20220915162458E2D32AE0, total_amount=1.00, trade_no=2022091522001465961426039150, auth_app_id=2021003143628797, buyer_logon_id=189****5834, point_amount=0.00";
        String[] split = str.split(",");
        StringBuilder sb = new StringBuilder();
        for (String s : split) {
            String[] split1 = s.split("=");
            sb.append("\"" + split1[0] + "\":");
            sb.append("\"" + split1[1] + "\",");
        }
        System.out.println(sb.toString());
    }
}
