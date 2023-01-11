package delivery.prj.infra;

import delivery.prj.domain.*;
import delivery.prj.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class HistoryViewHandler {

    @Autowired
    private HistoryRepository historyRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderPlaced_then_CREATE_1 (@Payload OrderPlaced orderPlaced) {
        try {

            if (!orderPlaced.validate()) return;

            // view 객체 생성
            History history = new History();
            // view 객체에 이벤트의 Value 를 set 함
            history.setUserId(orderPlaced.getUserId());
            history.setStoreId(orderPlaced.getStoreId());
            history.setMenuId(orderPlaced.getMenuId());
            history.setQty(orderPlaced.getQty());
            history.setOrderId(orderPlaced.getId());
            history.setOrderStatus("주문완료");
            // view 레파지 토리에 save
            historyRepository.save(history);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderCanceled_then_UPDATE_1(@Payload OrderCanceled orderCanceled) {
        try {
            if (!orderCanceled.validate()) return;
                // view 객체 조회

                List<History> historyList = historyRepository.findByOrderId(orderCanceled.getId());
                for(History history : historyList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    history.setOrderStatus("주문취소");
                // view 레파지 토리에 save
                historyRepository.save(history);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenAccepted_then_UPDATE_2(@Payload Accepted accepted) {
        try {
            if (!accepted.validate()) return;
                // view 객체 조회

                List<History> historyList = historyRepository.findByOrderId(accepted.getOrderId());
                for(History history : historyList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    history.setStoreStatus("주문수락");
                // view 레파지 토리에 save
                historyRepository.save(history);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenRejected_then_UPDATE_3(@Payload Rejected rejected) {
        try {
            if (!rejected.validate()) return;
                // view 객체 조회

                List<History> historyList = historyRepository.findByOrderId(rejected.getOrderId());
                for(History history : historyList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    history.setStoreStatus("주문거절");
                // view 레파지 토리에 save
                historyRepository.save(history);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCookStarted_then_UPDATE_4(@Payload CookStarted cookStarted) {
        try {
            if (!cookStarted.validate()) return;
                // view 객체 조회

                List<History> historyList = historyRepository.findByOrderId(cookStarted.getOrderId());
                for(History history : historyList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    history.setStoreStatus("요리시작");
                // view 레파지 토리에 save
                historyRepository.save(history);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCookFinished_then_UPDATE_5(@Payload CookFinished cookFinished) {
        try {
            if (!cookFinished.validate()) return;
                // view 객체 조회

                List<History> historyList = historyRepository.findByOrderId(cookFinished.getOrderId());
                for(History history : historyList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    history.setStoreStatus("요리완료");
                // view 레파지 토리에 save
                historyRepository.save(history);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryStarted_then_UPDATE_6(@Payload DeliveryStarted deliveryStarted) {
        try {
            if (!deliveryStarted.validate()) return;
                // view 객체 조회

                List<History> historyList = historyRepository.findByOrderId(deliveryStarted.getOrderId());
                for(History history : historyList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    history.setDeliveryStatus("배달시작");
                // view 레파지 토리에 save
                historyRepository.save(history);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderFinished_then_UPDATE_7(@Payload OrderFinished orderFinished) {
        try {
            if (!orderFinished.validate()) return;
                // view 객체 조회

                List<History> historyList = historyRepository.findByOrderId(orderFinished.getOrderId());
                for(History history : historyList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    history.setDeliveryStatus("배달완료");
                // view 레파지 토리에 save
                historyRepository.save(history);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }


}

